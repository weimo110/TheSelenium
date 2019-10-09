package com.gcsoft.autots.domain;

// Selenium
// cmd
// F:\svn\03_Work\02_方式設計\自動化テストツール\Selenium利用手順\00.環境構築\02.Replay\OnlineAutoTest
// screenshot
// F:\svn\03_Work\02_方式設計\自動化テストツール\Selenium利用手順\02.ReplayEXE-Src\OnlineAutoTest\online-auto-test\src\java\com\gcsoft\autots
// System.setProperty("webdriver.edge.driver", "XXXXXXX\\MicrosoftWebDriver.exe");
//driver = new EdgeDriver();
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gcsoft.autots.utils.CommonUtil;
import com.gcsoft.autots.utils.ScreenshotUtil;
import com.google.common.io.Files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import java.util.*;

@SuppressWarnings("unused")
public class MainTestChrome {
    private WebDriver driver;

    private Map<String, Object> vars;

    JavascriptExecutor js;

    private Robot robot;

    private int windowsHeight = 900;

    private int windowsWidth = 1440;

    private int browserHeaderHeight = 120;

    private int bobotTime = 2000;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
            "F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\chromedriver.exe");
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);

//        System.setProperty("webdriver.ie.driver",
//            "F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
//		driver = new EdgeDriver();

        try {
            robot = new Robot();
            robot.setAutoDelay(bobotTime);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        js = (JavascriptExecutor)driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
//		driver.quit();
    }

    public String waitForWindow(int timeout) {
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

    @Test
    public void qerrweq()
        throws InterruptedException, IOException, AWTException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("http://172.17.4.124/Pd_0001/");
        String browserType = "I";

        // case6 prepare
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_DocMngBar");
        CommonUtil.waitForElement(driver, By.id("BtnFolderMng"));
        driver.findElement(By.id("BtnFolderMng")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_DocMngMain");
        driver.switchTo().frame("F_FoldMngMain");
        driver.switchTo().frame("F_FoldMngFuncBar");
        vars.put("window_handles", driver.getWindowHandles());
        CommonUtil.waitForElement(driver, By.id("BtnCreateFolder"));
        driver.findElement(By.id("BtnCreateFolder")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        vars.put("win1854", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win1854").toString());
        CommonUtil.waitForElement(driver, By.id("TxtFoldName"));
        driver.findElement(By.id("TxtFoldName")).click();
        driver.findElement(By.id("TxtFoldName")).sendKeys("シナリオ7-6-1");

        driver.findElement(By.id("ImgBtnRegNew")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        Thread.sleep(1234);
        driver.findElement(By.cssSelector(".ImgBtn")).click();

        // case6 main
        robot.keyPress(KeyEvent.VK_F11);// D
        robot.keyRelease(KeyEvent.VK_F11);// D
        Actions action = new Actions(driver);
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-test");
        driver.findElement(By.id("Password")).sendKeys("gc-test");
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        CommonUtil.waitForElement(driver, By.id("BtnRegReqest"));
        driver.findElement(By.id("BtnRegReqest")).sendKeys(Keys.ENTER);
        vars.put("window_handles", driver.getWindowHandles());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WorkFlowApplyMain");
        driver.switchTo().frame("F_WorkFlowApply");
        CommonUtil.waitForElement(driver, By.id("ImgBtnAplyDocRegist"));
        driver.findElement(By.id("ImgBtnAplyDocRegist")).sendKeys(Keys.ENTER);
        vars.put("win2554", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win2554").toString());
        driver.switchTo().frame(1);
        driver.findElement(By.id("DrpLstRegistFileType")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//option[. = 'カスタムテンプレート登録']")).click();
        vars.put("window_handles", driver.getWindowHandles());
        CommonUtil.waitForElement(driver, By.id("ImgBtnTmpltSelect"));
        driver.findElement(By.id("ImgBtnTmpltSelect")).sendKeys(Keys.ENTER);
        vars.put("win9182", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9182").toString());
        driver.findElement(By.cssSelector("option:nth-child(1)")).click();
        CommonUtil.waitForElement(driver, By.id("imgBtnEdit"));
        driver.findElement(By.id("imgBtnEdit")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("ImgBtnSave"));
        driver.findElement(By.id("ImgBtnSave")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        action
            .doubleClick(
                driver.findElement(By.xpath("//*[@id=\"toolitem1\"]/td[2]")))
            .perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("ImgBtnSave")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("win2554").toString());
        driver.switchTo().frame(1);
        driver.findElement(By.id("TxtDocName")).sendKeys("シナリオ6-文書登録-01-wI2");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("ImgBtnFolder")).sendKeys(Keys.ENTER);
        vars.put("win4950", waitForWindow(2000));
        driver.switchTo().window(vars.get("win4950").toString());
        driver.findElement(By.linkText("シナリオ7-6")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("OkBtn")).click();
        driver.switchTo().window(vars.get("win2554").toString());
        driver.switchTo().frame(1);
        driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        driver.switchTo().alert().accept();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        CommonUtil.waitForElement(driver, By.id("TxtSbjName"));
        driver.findElement(By.id("TxtSbjName")).sendKeys("カスタム文書登録01-wI2");
        driver.findElement(By.id("TxtAplyLimitY")).sendKeys("2019");
        driver.findElement(By.id("TxtAplyLimitM")).sendKeys("9");
        driver.findElement(By.id("TxtAplyLimitD")).sendKeys("29");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("ImgBtnAdd1")).sendKeys(Keys.ENTER);
        vars.put("win8501", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8501").toString());
        driver.switchTo().frame(1);
        driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver, By.id("tblDocSelect"));
        String exe = "window.curId='TR|u4';";
        exe += "document.querySelector('#tblDocSelect tbody tr:nth-child(4)').click();";
        js.executeScript(exe);
        driver.findElement(By.id("ImgBtnUsrAdd")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        driver.findElement(By.id("RptSelectDocList_ctl00_LblVersionName"))
            .click();
        driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        vars.put("window_handles", driver.getWindowHandles());
        driver
            .findElement(By.id("RepRootTableDocLast_ctl01_ImgBtnSansyoDocEdit"))
            .sendKeys(Keys.ENTER);
        vars.put("win4952", waitForWindow(2000));
        driver.switchTo().window(vars.get("win4952").toString());
        Thread.sleep(4321);
        driver.switchTo().frame(1);
        Thread.sleep(1234);
        driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)"))
            .sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver,
            By.id("RptSelectDocList_ctl04_LblVersionName"));
        driver.findElement(By.id("RptSelectDocList_ctl04_LblVersionName"))
            .click();
        driver.findElement(By.id("OkBtn")).click();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.findElement(By.id("ImgBtnSubmit")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver, By.id("BtnOK"));
        driver.findElement(By.id("BtnOK")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ImgBtn")).click();

        driver.switchTo().defaultContent();
        CommonUtil.waitForElement(driver, By.id("UserName"));
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        driver.findElement(By.id("TxtSearchChara")).sendKeys("カスタム文書登録01-wI2");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlowSearch"));
        driver.findElement(By.id("BtnWorkFlowSearch")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        vars.put("window_handles", driver.getWindowHandles());
        mouseOver(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        mouseOver(440, 150);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win7911", waitForWindow(2000));
        driver.switchTo().window(vars.get("win7911").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("BtnApprove")).sendKeys(Keys.ENTER);
        vars.put("win6120", waitForWindow(2000));
        driver.switchTo().window(vars.get("win6120").toString());
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        driver.findElement(By.id("CompBtn")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("BtnClose"));
        driver.findElement(By.id("BtnClose")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ImgBtn")).click();
        driver.switchTo().defaultContent();
        CommonUtil.waitForElement(driver, By.id("UserName"));
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin2");
        driver.findElement(By.id("Password")).sendKeys("gc-admin2");
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        driver.findElement(By.id("TxtSearchChara")).sendKeys("カスタム文書登録01-wI2");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        driver.findElement(By.id("BtnWorkFlowSearch")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        vars.put("window_handles", driver.getWindowHandles());
        mouseOver(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        mouseOver(440, 150);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win8930", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8930").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("BtnApprove")).sendKeys(Keys.ENTER);
        vars.put("win2252", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2252").toString());
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin2");
        driver.findElement(By.id("Password")).sendKeys("gc-admin2");
        driver.findElement(By.id("CompBtn")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("BtnClose"));
        driver.findElement(By.id("BtnClose")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        driver.findElement(By.id("BtnDocMng")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("Iframe1");
        driver.switchTo().frame("F_FoldTree");
        driver.switchTo().frame("F_TreeField");
        driver.findElement(By.linkText("シナリオ7-6")).sendKeys(Keys.ENTER);
        vars.put("window_handles", driver.getWindowHandles());
        mouseOver(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        mouseOver(440, 150);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win5526", waitForWindow(2000));
        driver.switchTo().window(vars.get("win5526").toString());
        driver.findElement(By.id("ImgBtnOk")).click();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ImgBtn")).click();
        Thread.sleep(1234);
        robot.keyPress(KeyEvent.VK_F11);// D
        robot.keyRelease(KeyEvent.VK_F11);// D

        // case3
//        driver.findElement(By.id("UserName")).click();
//        driver.findElement(By.id("UserName")).sendKeys("pd-admin");
//        driver.findElement(By.id("Password")).click();
//        driver.findElement(By.id("Password")).sendKeys("pd-admin");
//        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
//        Thread.sleep(1234);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(0);
//        driver.switchTo().frame(1);
//        driver.findElement(By.cssSelector(
//            "#\\{b106a5ec-2865-4775-a2dd-dd89b901c3bf\\}>.webfx-tree-row>.webfx-tree-expand-icon"))
//            .click();
//        Thread.sleep(1234);
//        driver.findElement(By.cssSelector(
//            "#\\{b106a5ec-2865-4775-a2dd-dd89b901c3bf\\}>.webfx-tree-row>.webfx-tree-expand-icon"))
//            .click();
//        driver.findElement(By.linkText("シナリオ3")).click();
//        
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(4);
//        driver.findElement(By.id("BtnDocInfo")).click();
//        driver.findElement(By.id("BtnDocInfo")).click();
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(2);
//        driver.switchTo().frame(1);
//        driver.findElement(By.id("DivIdDocName")).click();
//        vars.put("window_handles", driver.getWindowHandles());
//        driver.findElement(By.id("Menu5")).click();
//        vars.put("win2421", waitForWindow(2000));
//        vars.put("root", driver.getWindowHandle());
//        driver.switchTo().window(vars.get("win2421").toString());
//        driver.findElement(By.id("BtnDicAclCancel")).click();
//        driver.switchTo().window(vars.get("root").toString());
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(2);
//        driver.switchTo().frame(0);
//        vars.put("window_handles", driver.getWindowHandles());
//        driver.findElement(By.id("ImgServer")).click();
//        vars.put("win8934", waitForWindow(2000));
//        driver.switchTo().window(vars.get("win8934").toString());
//        driver.findElement(By.id("BtnAddFavourites")).click();
//        driver.switchTo().window(vars.get("root").toString());
//        driver.switchTo().frame(0);
//        driver.findElement(By.cssSelector(".ImgBtn")).click();

        // case1 测版
//      driver.findElement(By.id("UserName")).click();
//      driver.findElement(By.id("UserName")).sendKeys("gc-ws");
//      driver.findElement(By.id("Password")).click();
//      driver.findElement(By.id("Password")).sendKeys("gctest");
//      driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
//      driver.findElement(By.id("Password")).click();
//      driver.findElement(By.id("Password")).sendKeys("gctest");
//      driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
//      driver.findElement(By.id("Password")).click();
//      driver.findElement(By.id("Password")).sendKeys("gctest");
//      driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
//  
        driver.findElement(By.id("UserName")).click();
//      robot.keyPress(KeyEvent.VK_CONTROL);
//      robot.keyPress(KeyEvent.VK_A);
//      robot.keyRelease(KeyEvent.VK_CONTROL);
//      robot.keyRelease(KeyEvent.VK_A);
        driver.findElement(By.id("UserName")).sendKeys("pd-admi");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys("pd-admin");
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(1234);

        // 看锁
        driver.switchTo().frame("F_AppLancher");
        driver.findElement(By.id("BtnManagement")).sendKeys(Keys.ENTER);

        // 解锁
        driver.switchTo().defaultContent();
        vars.put("window_handles", driver.getWindowHandles());
        js.executeScript(
            "document.querySelector('form#FrmUsrMngListTable table.ListTable tr:nth-child(2)').click();");
//      if("I".equals(browserType)) {
//          mouseOver(72, 362);
//          robot.mousePress(InputEvent.BUTTON1_MASK);
//          robot.mouseRelease(InputEvent.BUTTON1_MASK);
//      } else {
//          driver.switchTo().frame(1);
//          driver.switchTo().frame(1);
//          driver.switchTo().frame(1);
//          driver.switchTo().frame(2);
//          driver.switchTo().frame(0);
//          driver.findElement(By.cssSelector("#\\31 013 input")).click();
//      }
//      vars.put("win4821", waitForWindow(2000));
//      vars.put("root", driver.getWindowHandle());
//      driver.switchTo().window(vars.get("win4821").toString());
//      driver.findElement(By.id("TxtPassword")).sendKeys("gc-ws1");
//      driver.findElement(By.id("TxtRePassword")).click();
//      driver.findElement(By.id("TxtRePassword")).sendKeys("gc-ws1");
//      driver.findElement(By.id("BtnPasswdReg")).click();
//      driver.switchTo().alert().accept();

        // 放大镜
//      driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame("F_AppArea");
        Thread.sleep(1234);
        driver.switchTo().frame("F_MngMain");
        driver.switchTo().frame("F_UsrGrpMngMain");
        driver.switchTo().frame("F_UsrMngList");
        driver.switchTo().frame("F_UsrListTbl");
        driver.findElement(By.id("BtnDispChange")).sendKeys(Keys.ENTER);

        // 检查征集
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_MngCtlBar");
        driver.findElement(By.id("BtnAdiTrilMng")).sendKeys(Keys.ENTER);

        // 年月
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_MngMain");
        driver.switchTo().frame("F_AdtTrlMngMain");
        driver.switchTo().frame("F_AdtTrlDispSrch");
        driver.findElement(By.id("TxtSelectYMYear")).clear();
        driver.findElement(By.id("TxtSelectYMYear")).sendKeys("2019");
        driver.findElement(By.id("TxtSelectYMMonth")).clear();
        driver.findElement(By.id("TxtSelectYMMonth")).sendKeys("9");

        // 检查征集检索
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_MngMain");
        driver.switchTo().frame("F_AdtTrlMngMain");
        driver.switchTo().frame("F_AdtTrlSubBar");
        driver.findElement(By.id("BtnAuditTrailDisp")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_MngMain");
        driver.switchTo().frame("F_AdtTrlMngMain");
        driver.switchTo().frame("F_AdtTrlDispSrch");
        if ("I".equals(browserType)) {
            driver.findElement(By.id("BtnAdtTrlDispSrch")).sendKeys(Keys.ENTER);
        } else {
            driver.findElement(By.id("BtnAdtTrlDispSrch")).click();
        }
        Thread.sleep(4321);

        // サイト管理
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        driver.findElement(By.id("BtnSiteSetMng")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        driver.findElement(By.id("BtnSituation")).sendKeys(Keys.ENTER);

        // セキュリティ
        driver.findElement(By.id("BtnSecuritySet")).sendKeys(Keys.ENTER);

        // ログアウト
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppLancher");
        driver.findElement(By.cssSelector(".ImgBtn")).click();

        // case1 初版
//        ScreenshotUtil screen = new ScreenshotUtil();
////        driver.findElement(By.id("UserName")).click();
////        driver.findElement(By.id("UserName")).sendKeys("gc-ws");
////        driver.findElement(By.id("Password")).click();
////        driver.findElement(By.id("Password")).sendKeys("gctest");
////        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
////        driver.findElement(By.id("Password")).click();
////        driver.findElement(By.id("Password")).sendKeys("gctest");
////        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
////        driver.findElement(By.id("Password")).click();
////        driver.findElement(By.id("Password")).sendKeys("gctest");
////        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
////        screen.getScreenshot(driver, "D:\\Image\\"+ browserType +"_1_验证密码.PNG", null, null, browserType, null);
////    
////        driver.findElement(By.id("UserName")).click();
////        robot.keyPress(KeyEvent.VK_CONTROL);
////        robot.keyPress(KeyEvent.VK_A);
////        robot.keyRelease(KeyEvent.VK_CONTROL);
////        robot.keyRelease(KeyEvent.VK_A);
////        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
////        driver.findElement(By.id("Password")).click();
////        driver.findElement(By.id("Password")).sendKeys("gc-admin");
////        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
////        Thread.sleep(1000);
////        driver.switchTo().frame("F_AppLancher");
////        driver.findElement(By.id("BtnManagement")).sendKeys(Keys.ENTER);
////		screen.getScreenshot(driver, "D:\\Image\\"+ browserType +"_2_锁.PNG", null, null, browserType, null);
//
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("F_AppArea");
//        Thread.sleep(1000);
//        driver.switchTo().frame("F_MngMain");
//        driver.switchTo().frame("F_UsrGrpMngMain");
//        driver.switchTo().frame("F_UsrMngList");
//        driver.switchTo().frame("F_UsrListTbl");
//        driver.findElement(By.id("BtnDispChange")).sendKeys(Keys.ENTER);
//        screen.getScreenshot(driver, "D:\\Image\\" + browserType + "_3_检索.PNG",
//            null, null, browserType, null);
//
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("F_AppArea");
//        driver.switchTo().frame("F_MngCtlBar");
//        driver.findElement(By.id("BtnAdiTrilMng")).sendKeys(Keys.ENTER);
//
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("F_AppArea");
//        driver.switchTo().frame("F_MngMain");
//        driver.switchTo().frame("F_AdtTrlMngMain");
//        driver.switchTo().frame("F_AdtTrlDispSrch");
//        vars.put("window_handles", driver.getWindowHandles());
//        driver.findElement(By.id("BtnFolderPlace")).sendKeys(Keys.ENTER);
//        vars.put("win2942", waitForWindow(2000));
//        vars.put("root", driver.getWindowHandle());
//        driver.switchTo().window(vars.get("win2942").toString());
//        driver.switchTo().frame("F_DocSelectFoldTree");
//        driver.findElement(By.linkText("weishuaishuai")).click();
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("F_DocSelectDocList");
//        driver.findElement(By.id("RptSelectDocList_ctl05_LblVersionName"))
//            .click();
//        driver.findElement(By.id("OkBtn")).sendKeys(Keys.ENTER);
//        driver.switchTo().window(vars.get("root").toString());
//        screen.getScreenshot(driver,
//            "D:\\Image\\" + browserType + "_4_文件选择.PNG", null, null,
//            browserType, null);
//
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.findElement(By.id("RdoPeriod4")).click();
//        driver.findElement(By.id("TxtSelectYMYear")).click();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_A);
//        driver.findElement(By.id("TxtSelectYMYear")).sendKeys("9999");
//        driver.findElement(By.id("TxtSelectYMMonth")).click();
//        driver.findElement(By.id("TxtSelectYMMonth")).click();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_A);
//        driver.findElement(By.id("TxtSelectYMMonth")).sendKeys("99");
//        driver.findElement(By.id("TxtSelectYMYear")).click();
//        screen.getScreenshot(driver, "D:\\Image\\" + browserType + "_5_日期.PNG",
//            null, null, browserType, null);
//
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("BtnSiteSetMng")).sendKeys(Keys.ENTER);
//        screen.getScreenshot(driver,
//            "D:\\Image\\" + browserType + "_6_サイト管理.PNG", null, null,
//            browserType, null);
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("BtnSituation")).sendKeys(Keys.ENTER);
//        driver.findElement(By.id("BtnSecuritySet")).click();
//        screen.getScreenshot(driver,
//            "D:\\Image\\" + browserType + "_7_セキュリティ設定.PNG", null, null,
//            browserType, null);
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(1);
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("BtnUsrGrpMng")).sendKeys(Keys.ENTER);
//        screen.getScreenshot(driver,
//            "D:\\Image\\" + browserType + "_8_ユーザー管理.PNG", null, null,
//            browserType, null);
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("F_AppLancher");
//        driver.findElement(By.cssSelector(".ImgBtn")).click();

        // Login
//		driver.findElement(By.id("UserName")).click();
//		driver.findElement(By.id("UserName")).sendKeys("gctest");
//		driver.findElement(By.id("Password")).click();
//		driver.findElement(By.id("Password")).sendKeys("gctest");
//		driver.findElement(By.id("LoginBtn")).click();
//
//		Actions action = new Actions(driver);
//	
//		mouseOver(1417, 95);//D
//		robot.mousePress(InputEvent.BUTTON1_MASK);//D
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);//D
//		robot.keyPress(KeyEvent.VK_F11);//D
//		robot.keyRelease(KeyEvent.VK_F11);//D

        // OK:Copy
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocList");
//		driver.switchTo().frame("F_DocLstTbl");
//		action.contextClick(driver.findElement(By.id("599d741a-305f-4a1f-b7ce-842aa4f2ad29"))).perform();
//		mouseOver(900, 255);
//		mouseOver(1020, 255);
//		mouseOver(1020, 275);
//		vars.put("window_handles", driver.getWindowHandles());
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);
//		vars.put("win5639",waitForWindow(2000));
//		vars.put("root",driver.getWindowHandle());
//		driver.switchTo().window(vars.get("win5639").toString());
//		driver.findElement(By.id("TxtShtCutName")).click();
//		driver.findElement(By.id("PnlDispContents")).click();
//		robot.keyPress(KeyEvent.VK_CONTROL); 
//		robot.keyPress(KeyEvent.VK_A);  
//      robot.keyRelease(KeyEvent.VK_CONTROL);  
//      robot.keyRelease(KeyEvent.VK_ALT);  
//		driver.findElement(By.id("TxtShtCutName")).sendKeys("wss");
//		driver.findElement(By.id("BtnOk")).click();
//		assertThat(driver.switchTo().alert().getText(),is("コピーします。よろしいですか？"));
//		driver.switchTo().alert().accept();
//		Thread.sleep(5000);
//		driver.switchTo().window(vars.get("root").toString());

        // OK:Drag
//		mouseOver(300, 259);
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseMove(40, 195);
//		robot.mouseMove(60, 295);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);
//		mouseOver(90, 303);
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);		
//		assertThat(driver.switchTo().alert().getText(),is("コピーします。よろしいですか？"));
//		driver.switchTo().alert().accept();

        // OK:da gou
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_FoldTree");
//		driver.switchTo().frame("F_TreeField");
//		driver.findElement(By.linkText("weishuaishuai")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocList");
//		driver.switchTo().frame("F_DocLstTbl");
//		driver.findElement(By.id("RptEffectListTable_ctl03_ImgBtnChkOut1")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
//		driver.findElement(By.id("BtnOK")).click();	

        // OK:Click into page
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocList");
//		driver.switchTo().frame("F_DocLstTbl");
//		vars.put("window_handles", driver.getWindowHandles());
//		mouseOver(835, 178);
//		robot.mousePress(InputEvent.BUTTON3_MASK);
//		robot.mouseRelease(InputEvent.BUTTON3_MASK);
//		mouseOver(910, 240);
//		mouseOver(1060, 240);
//		mouseOver(1060, 260);
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);
//		
//		vars.put("win3971", waitForWindow(2000));
//		vars.put("root", driver.getWindowHandle());
//		driver.switchTo().window(vars.get("win3971").toString());
//		driver.switchTo().frame(0);
//		driver.findElement(By.id("ucLinkReviewDoc_fileLinkDoc")).sendKeys("D:\\Test.txt");
//		driver.findElement(By.id("ucLinkReviewDoc_fileLinkDoc")).sendKeys(Keys.ENTER);
//		driver.findElement(By.id("RdoVerLockType_1")).click();
//		driver.findElement(By.id("RdoVerLockType_0")).click();
//		driver.findElement(By.id("RdoVerLockType_2")).click();
//		driver.findElement(By.id("ImgBtnPkgDownload")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(1);
//		driver.findElement(By.id("ImgBtnCancel")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(0);
//		driver.findElement(By.id("ImgBtnPkgRenDownload")).click();
//		assertThat(driver.switchTo().alert().getText(), is("対象となるファイルがありません。"));
//		driver.switchTo().alert().accept();
//		vars.put("window_handles", driver.getWindowHandles());
//		driver.findElement(By.id("BtnSelectDoc_Sansyo")).click();
//		vars.put("win2307", waitForWindow(2000));
//		driver.switchTo().window(vars.get("win2307").toString());
//		driver.switchTo().frame(1);
//		driver.findElement(By.linkText("stackFold")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("stackFold1")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("stackFold10")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("stackFold100")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(0);
//		driver.findElement(By.id("ImgBtnChkAll")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
//		driver.findElement(By.id("RptTMDocList_ctl01_chkSelect")).click();
//		driver.findElement(By.id("imgBtnOK")).click();
//		driver.switchTo().window(vars.get("win3971").toString());
//		driver.switchTo().frame(0);
//		driver.findElement(By.id("TxtAliasName")).click();
//		driver.findElement(By.id("TxtAliasName")).sendKeys("Test");
//		driver.findElement(By.id("BtnAddDoc")).click();
//		driver.findElement(By.id("BtnOK")).click();
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(1);
//		driver.findElement(By.id("RptChkInMsg_ctl01_ucDocProtectDocument_RdoPDFNonCreate")).click();
//		driver.findElement(By.id("ChkSendMail")).click();
//		driver.findElement(By.id("BtnOK")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
//		driver.findElement(By.id("BtnOK")).click();
//		vars.put("window_handles", driver.getWindowHandles());
//		driver.switchTo().window(vars.get("root").toString());
//		Thread.sleep(3000);
//	    driver.switchTo().alert().accept();
//	    vars.put("window_handles", driver.getWindowHandles());
//		driver.switchTo().window(vars.get("root").toString());
//		vars.put("win1061", waitForWindow(2000));
//		driver.switchTo().window(vars.get("win1061").toString());
//		CommonUtil.waitForElement(driver, By.id("ImgBtnCancel"));
//		driver.findElement(By.id("ImgBtnCancel")).sendKeys(Keys.ENTER);
//		driver.switchTo().window(vars.get("root").toString());
//		robot.keyPress(KeyEvent.VK_F11);//D
//		robot.keyRelease(KeyEvent.VK_F11);//D
    }

    private void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
    }

    private void getScreenshot(String filename) {
        try {
            File scrFile = ((RemoteWebDriver)driver)
                .getScreenshotAs(OutputType.FILE);
            Files.copy(scrFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mouseOver(int pX, int pY) {
        if (pY < browserHeaderHeight) {
            robot.mouseMove(windowsWidth, windowsHeight);
        }
        robot.mouseMove(pX, pY);
    }
}
