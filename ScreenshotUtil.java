package com.gcsoft.autots.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import sun.misc.BASE64Decoder;

public class ScreenshotUtil {

    public static void getScreenshot(WebDriver driver, String fileName,
        String num, Boolean alertExists)
        throws InterruptedException, IOException, AWTException {

        if (alertExists) {
            alertScreenshot(driver, fileName);
        } else if (num == null || "".equals(num)) {
            screenshot(driver, fileName);
        } else {
            screenshotChildren(driver, fileName, num);
        }
    }

    private static void screenshot(WebDriver driver, String fileName)
        throws InterruptedException, IOException {
        String js1 = "return document.documentElement.clientHeight.toString()";
        String js1_result = ((JavascriptExecutor)driver).executeScript(js1)
            + "";
        String real_scroll_exist_body = "return document.documentElement.scrollHeight > (window.innerHeight || document.documentElement.clientHeight);";
        Boolean real_scroll_exist_body_b = (Boolean)((JavascriptExecutor)driver)
            .executeScript(real_scroll_exist_body);
        int height = Integer.parseInt(js1_result);
        List<String> files = new ArrayList<String>();
        int last_t = 0;
        try {
            if (real_scroll_exist_body_b) {
                for (int i = 0; i < 20; i++) {
                    int currentHeight = (i * height);
                    String js = "window.scrollTo(0," + currentHeight + ");";
                    ((JavascriptExecutor)driver).executeScript(js);
                    js1 = "return document.documentElement.scrollHeight.toString()+','+document.documentElement.scrollTop.toString()";
                    js1_result = ((JavascriptExecutor)driver).executeScript(js1)
                        + "";
                    int real_top = Integer.parseInt(js1_result.split(",")[1]);
                    if (real_top == currentHeight) {
                        files.add(screenshot(driver).getAbsolutePath());
                        last_t = real_top;
                    } else {
                        if (real_top != last_t) {
                            last_t = real_top;
                            files.add(screenshot(driver).getAbsolutePath());
                            break;
                        } else {
                            files.add(screenshot(driver).getAbsolutePath());
                            break;
                        }
                    }
                }
            } else {
                files.add(screenshot(driver).getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        merge(files.toArray(new String[] {}), "jpeg", fileName);

    }

    private static void screenshotChildren(WebDriver driver, String fileName,
        String num) throws InterruptedException, IOException {
        String js1 = "return document.body.children[" + num
            + "].clientHeight.toString()";
        String js1_result = ((JavascriptExecutor)driver).executeScript(js1)
            + "";
        String real_scroll_exist_children = "return document.body.children["
            + num + "].scrollHeight > document.body.children[" + num
            + "].clientHeight";
        Boolean real_scroll_exist_children_b = (Boolean)((JavascriptExecutor)driver)
            .executeScript(real_scroll_exist_children);
        int height = Integer.parseInt(js1_result);
        List<String> files = new ArrayList<String>();
        int last_t = 0;
        try {
            if (real_scroll_exist_children_b) {
                for (int i = 0; i < 20; i++) {
                    int currentHeight = (i * height);
                    String js = "document.body.children[" + num
                        + "].scrollTo(0," + currentHeight + ");";
                    ((JavascriptExecutor)driver).executeScript(js);
                    js1 = "return document.body.children[" + num
                        + "].scrollHeight.toString()+','+document.body.children["
                        + num + "].scrollTop.toString()";
                    js1_result = ((JavascriptExecutor)driver).executeScript(js1)
                        + "";
                    int real_top = Integer.parseInt(js1_result.split(",")[1]);
                    if (real_top == currentHeight) {
                        files.add(screenshot(driver).getAbsolutePath());
                        last_t = real_top;
                    } else {
                        if (real_top != last_t) {
                            last_t = real_top;
                            files.add(screenshot(driver).getAbsolutePath());
                            break;
                        } else {
                            files.add(screenshot(driver).getAbsolutePath());
                            break;
                        }
                    }
                }
            } else {
                files.add(screenshot(driver).getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        merge(files.toArray(new String[] {}), "jpeg", fileName);
    }

    private static void alertScreenshot(WebDriver driver, String fileName)
        throws AWTException {
        BufferedImage image = new Robot().createScreenCapture(
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        try {
            ImageIO.write(image, "jpeg", new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static File screenshot(WebDriver driver)
        throws InterruptedException, IOException {
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        byte[] imageBytes = (byte[])((RemoteWebDriver)driver)
            .getScreenshotAs(new OutputType<Object>() {
                public Object convertFromBase64Png(String s) {
                    try {
                        return (new BASE64Decoder()).decodeBuffer(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                public Object convertFromPngBytes(byte[] bytes) {
                    return bytes;
                }
            });
        ByteArrayInputStream bytes = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(bytes);
        File file = File.createTempFile((new Random()).nextInt() + "", "jpeg");
        ImageIO.write(image, "jpeg", file);
        return file;
    }

    /**
     * @param pics
     * @param type
     * @param dst_pic
     * @return
     */
    private static boolean merge(String[] pics, String type, String dst_pic) {

        int len = pics.length;
        if (len < 1) {
            System.out.println("pics len < 1");
            return false;
        }
        File[] src = new File[len];
        BufferedImage[] images = new BufferedImage[len];
        int[][] ImageArrays = new int[len][];
        for (int i = 0; i < len; i++) {
            try {
                src[i] = new File(pics[i]);
                images[i] = ImageIO.read(src[i]);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            int width = images[i].getWidth();
            int height = images[i].getHeight();
            ImageArrays[i] = new int[width * height];
            ImageArrays[i] = images[i].getRGB(0, 0, width, height,
                ImageArrays[i], 0, width);
        }

        int dst_height = 0;
        int dst_width = images[0].getWidth();
        for (int i = 0; i < images.length; i++) {
            dst_width = dst_width > images[i].getWidth() ? dst_width
                : images[i].getWidth();

            dst_height += images[i].getHeight();
        }
        if (dst_height < 1) {
            System.out.println("dst_height < 1");
            return false;
        }

        try {
            BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,
                BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            for (int i = 0; i < images.length; i++) {
                ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),
                    ImageArrays[i], 0, dst_width);
                height_i += images[i].getHeight();
            }

            File outFile = new File(dst_pic);
            ImageIO.write(ImageNew, type, outFile);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            for (String tempFile : pics) {
                File t = new File(tempFile);
                t.delete();
            }
        }

        return true;
    }
}
