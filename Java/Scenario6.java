package domain;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.CommonUtil;
import utils.ScreenshotUtil;
public class Scenario6 {
    private Map<String, Object> vars;

    JavascriptExecutor js;

    private String outputFolder;

    private String browserName;

    private String browserVersion;

    private String evidenceType;

    private String scenario = "シナリオ06";

    private int stepNum = 1;

    private String handleEvidenceName(String stepName) {
        return this.outputFolder + "\\" + this.scenario + "-" + stepName + "-"
            + this.browserName + "-" + this.browserVersion + "-"
            + (this.stepNum++) + "." + this.evidenceType;
    }

    public String waitForWindow(WebDriver driver, int timeout) {
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

    public void doTest(WebDriver driver, Robot robot, String browserType,
        Map<String, String> configMap)
        throws InterruptedException, IOException, AWTException {

        js = (JavascriptExecutor)driver;
        vars = new HashMap<String, Object>();
        outputFolder = configMap.get("outputFolder");
        browserName = configMap.get("BROWSER-NAME");
        browserVersion = configMap.get("BROWSER-VERSION");
        evidenceType = configMap.get("EVIDENCE-TYPE");

        Actions action = new Actions(driver);
        int generalTime = Integer
            .parseInt(configMap.get("GENERAL-TIME").toString());
        int specialTime = Integer
            .parseInt(configMap.get("SPECIAL-TIME").toString());
        // case6 prepare
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        ScreenshotUtil.getScreenshot(driver,
            handleEvidenceName("admin登録(フォルダ新規作成)"), null, false);
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_DocMngBar");
        CommonUtil.waitForElement(driver, By.id("BtnFolderMng"));
        driver.findElement(By.id("BtnFolderMng")).sendKeys(Keys.ENTER);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("フォルダ新規作成(初期)"),
            null, false);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_DocMngMain");
        driver.switchTo().frame("F_FoldMngMain");
        driver.switchTo().frame("F_FoldMngFuncBar");
        vars.put("window_handles", driver.getWindowHandles());
        CommonUtil.waitForElement(driver, By.id("BtnCreateFolder"));
        driver.findElement(By.id("BtnCreateFolder")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        vars.put("win1854", waitForWindow(driver, 2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win1854").toString());
        CommonUtil.waitForElement(driver, By.id("TxtFoldName"));
        driver.findElement(By.id("TxtFoldName")).click();
        driver.findElement(By.id("TxtFoldName")).sendKeys("シナリオ7-6");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("フォルダ新規作成"),
            null, false);
        driver.findElement(By.id("ImgBtnRegNew")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        Thread.sleep(generalTime);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("フォルダ新規作成画面"),
            null, false);
        driver.findElement(By.cssSelector(".ImgBtn")).click();

        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-test");
        driver.findElement(By.id("Password")).sendKeys("gc-test");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("gc-test登録"),
            null, false);
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        CommonUtil.waitForElement(driver, By.id("BtnRegReqest"));
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("WorkFlow選択"),
            null, false);
        driver.findElement(By.id("BtnRegReqest")).sendKeys(Keys.ENTER);
        vars.put("window_handles", driver.getWindowHandles());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WorkFlowApplyMain");
        driver.switchTo().frame("F_WorkFlowApply");
        CommonUtil.waitForElement(driver, By.id("ImgBtnAplyDocRegist"));
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("登録申請画面(初期)"),
            null, false);
        driver.findElement(By.id("ImgBtnAplyDocRegist")).sendKeys(Keys.ENTER);
        vars.put("win2554", waitForWindow(driver, 2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win2554").toString());
        driver.switchTo().frame(1);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("登録文書指定画面(初期)"),
            null, false);
        driver.findElement(By.id("DrpLstRegistFileType")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//option[. = 'カスタムテンプレート登録']")).click();
        vars.put("window_handles", driver.getWindowHandles());
        CommonUtil.waitForElement(driver, By.id("ImgBtnTmpltSelect"));
        driver.findElement(By.id("ImgBtnTmpltSelect")).sendKeys(Keys.ENTER);
        vars.put("win9182", waitForWindow(driver, 2000));
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("参照(初期)"), null,
            false);
        driver.switchTo().window(vars.get("win9182").toString());
        driver.findElement(By.cssSelector("option:nth-child(1)")).click();
        CommonUtil.waitForElement(driver, By.id("imgBtnEdit"));
        driver.findElement(By.id("imgBtnEdit")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("ImgBtnSave"));
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("変更"), null,
            false);
        driver.findElement(By.id("ImgBtnSave")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("詳細画面(初期)"),
            null, false);
        action
            .doubleClick(
                driver.findElement(By.xpath("//*[@id=\"toolitem1\"]/td[2]")))
            .perform();
        driver.switchTo().defaultContent();
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("詳細画面"), null,
            false);
        driver.findElement(By.id("ImgBtnSave")).sendKeys(Keys.ENTER);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("参照"), null,
            false);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("win2554").toString());
        Thread.sleep(generalTime);
        driver.switchTo().frame(1);
        driver.findElement(By.id("TxtDocName")).sendKeys("シナリオ6-文書登録-01");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("ImgBtnFolder")).sendKeys(Keys.ENTER);
        vars.put("win4950", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win4950").toString());
        driver.findElement(By.linkText("シナリオ7-6")).sendKeys(Keys.ENTER);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("格納場所"), null,
            false);
        driver.findElement(By.id("OkBtn")).click();
        driver.switchTo().window(vars.get("win2554").toString());
        driver.switchTo().frame(1);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("登録文書指定画面"),
            null, false);
        driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().alert().accept();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        CommonUtil.waitForElement(driver, By.id("TxtSbjName"));
        driver.findElement(By.id("TxtSbjName")).sendKeys("カスタム文書登録01");
        driver.findElement(By.id("TxtAplyLimitY")).sendKeys("2019");
        driver.findElement(By.id("TxtAplyLimitM")).sendKeys("9");
        driver.findElement(By.id("TxtAplyLimitD")).sendKeys("30");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.id("ImgBtnAdd1")).sendKeys(Keys.ENTER);
        vars.put("win8501", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win8501").toString());
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("追加管理ユーザー(初期)"),
            null, false);
        driver.switchTo().frame(1);
        driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)"))
            .sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver,
            By.id("RptSelectDocList_ctl03_LblVersionName"));
        driver.findElement(By.id("RptSelectDocList_ctl03_LblVersionName"))
            .click();
        driver.findElement(By.id("ImgBtnUsrAdd")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        driver.findElement(By.id("RptSelectDocList_ctl00_LblVersionName"))
            .click();
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("追加管理ユーザー"),
            null, false);
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
        vars.put("win4952", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win4952").toString());
        Thread.sleep(specialTime);
        driver.switchTo().frame(1);
        Thread.sleep(generalTime);
        driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)"))
            .sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver,
            By.id("RptSelectDocList_ctl04_LblVersionName"));
        driver.findElement(By.id("RptSelectDocList_ctl04_LblVersionName"))
            .click();
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("選択実施者"), null,
            false);
        driver.findElement(By.id("OkBtn")).click();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        driver.switchTo().frame(1);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("登録申請画面"), null,
            false);
        driver.findElement(By.id("ImgBtnSubmit")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        CommonUtil.waitForElement(driver, By.id("BtnOK"));
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("登録申請OK"), null,
            false);
        driver.findElement(By.id("BtnOK")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ImgBtn")).click();

        driver.switchTo().defaultContent();
        CommonUtil.waitForElement(driver, By.id("UserName"));
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("admin登録"),
            null, false);
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("WorkFlow(初期)"),
            null, false);
        driver.findElement(By.id("TxtSearchChara")).sendKeys("カスタム文書登録01");
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
        robot.mouseMove(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(440, 150);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("レビュー/承認"),
            null, false);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win7911", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win7911").toString());
        vars.put("window_handles", driver.getWindowHandles());
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("レビュー画面を表示"),
            null, false);
        driver.findElement(By.id("BtnApprove")).sendKeys(Keys.ENTER);
        vars.put("win6120", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win6120").toString());
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin");
        driver.findElement(By.id("Password")).sendKeys("gc-admin");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("署名画面"), null,
            false);
        driver.findElement(By.id("CompBtn")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("BtnClose"));
        driver.findElement(By.id("BtnClose")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("WorkFlow"),
            null, false);
        driver.findElement(By.cssSelector(".ImgBtn")).click();
        driver.switchTo().defaultContent();
        CommonUtil.waitForElement(driver, By.id("UserName"));
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin2");
        driver.findElement(By.id("Password")).sendKeys("gc-admin2");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("admin2登録"),
            null, false);
        driver.findElement(By.id("LoginBtn")).sendKeys(Keys.ENTER);
        Thread.sleep(generalTime);
        driver.switchTo().frame("F_AppLancher");
        CommonUtil.waitForElement(driver, By.id("BtnWorkFlow"));
        driver.findElement(By.id("BtnWorkFlow")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        ScreenshotUtil.getScreenshot(driver,
            handleEvidenceName("WorkFlow(初期)2"), null, false);
        driver.findElement(By.id("TxtSearchChara")).sendKeys("カスタム文書登録01");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("F_WorkFlowMain");
        driver.switchTo().frame("F_WkFlwList");
        driver.switchTo().frame("F_WFFoldPath");
        driver.findElement(By.id("BtnWorkFlowSearch")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        vars.put("window_handles", driver.getWindowHandles());
        robot.mouseMove(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(440, 150);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("レビュー/承認2"),
            null, false);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win8930", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win8930").toString());
        vars.put("window_handles", driver.getWindowHandles());
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("レビュー画面を表示2"),
            null, false);
        driver.findElement(By.id("BtnApprove")).sendKeys(Keys.ENTER);
        vars.put("win2252", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win2252").toString());
        driver.findElement(By.id("UserName")).click();
        driver.findElement(By.id("UserName")).sendKeys("gc-admin2");
        driver.findElement(By.id("Password")).sendKeys("gc-admin2");
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("署名画面2"), null,
            false);
        driver.findElement(By.id("CompBtn")).sendKeys(Keys.ENTER);
        CommonUtil.waitForElement(driver, By.id("BtnClose"));
        driver.findElement(By.id("BtnClose")).sendKeys(Keys.ENTER);
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("WorkFlow2"),
            null, false);
        driver.findElement(By.id("BtnDocMng")).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("F_AppArea");
        driver.switchTo().frame("Iframe1");
        driver.switchTo().frame("F_FoldTree");
        driver.switchTo().frame("F_TreeField");
        driver.findElement(By.linkText("シナリオ7-6")).sendKeys(Keys.ENTER);
        vars.put("window_handles", driver.getWindowHandles());
        robot.mouseMove(360, 137);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(440, 150);
        ScreenshotUtil.getScreenshot(driver,
            handleEvidenceName("DOCUMENT MANAGER"), null, false);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        vars.put("win5526", waitForWindow(driver, 2000));
        driver.switchTo().window(vars.get("win5526").toString());
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("文書表示"), null,
            false);
        driver.findElement(By.id("ImgBtnOk")).click();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ImgBtn")).click();
        ScreenshotUtil.getScreenshot(driver, handleEvidenceName("ログアウト"), null,
            false);
    }
}
