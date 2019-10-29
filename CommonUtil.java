package utils;

import java.io.Console;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {

    public static void waitForElement(WebDriver driver, By by) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
    }

    public static void waitForOperation() {

        System.out.println("暂停，等待其他处理。（请在其他处理完成后输入“处理完成”。");

        Console console = System.console();
        String result = console.readLine();
        while ("处理完成".equals(result)) {
            System.out.println("暂停");
            console = System.console();
            result = console.readLine();
        }
    }

    public static String waitForWindow(WebDriver driver, int timeout,
        Map<String, Object> vars) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        @SuppressWarnings("unchecked")
        Set<String> whThen = (Set<String>)vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

}
