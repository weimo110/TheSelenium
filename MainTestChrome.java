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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private int bobotTime = 3000;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\chromedriver.exe");
//		System.setProperty("webdriver.ie.driver",
//				"F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\IEDriverServer.exe");
		driver = new ChromeDriver();
//		driver = new InternetExplorerDriver();
		try {
			robot = new Robot();
			robot.setAutoDelay(bobotTime);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js = (JavascriptExecutor) driver;
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
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test
	public void qerrweq() throws InterruptedException {
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("http://172.17.4.124/Pd_0001/");

		// Login
		driver.findElement(By.id("UserName")).click();
		driver.findElement(By.id("UserName")).sendKeys("pd-admin");
		driver.findElement(By.id("Password")).click();
		driver.findElement(By.id("Password")).sendKeys("pd-admin");
		driver.findElement(By.id("LoginBtn")).click();
		
		Actions action = new Actions(driver);

		// xiajibace
//		driver.switchTo().frame(1);
//		driver.switchTo().frame(1);
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
//		driver.findElement(By.linkText("weishuaishuai")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocList");
//		driver.switchTo().frame("F_DocLstTbl");
//		driver.findElement(By.cssSelector("#a199b08e-1dc0-4e63-843b-f07972227f58>.W_3:nth-child(6)")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocInfo");
//		driver.switchTo().frame("F_InfoBar");
//		driver.findElement(By.id("BtnVerTag")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocInfo");
//		driver.switchTo().frame("F_InfoField");
//		Actions action = new Actions(driver);
//		action.contextClick(driver.findElement(By.id("a199b08e-1dc0-4e63-843b-f07972227f58"))).perform();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("F_AppArea");
//		driver.switchTo().frame("F_DocMngMain");
//		driver.switchTo().frame("F_DocInfo");
//		driver.switchTo().frame("F_InfoField");
//		vars.put("window_handles", driver.getWindowHandles());
////		driver.findElement(By.xpath("//*[@id=\"ContextMenuSubMenu4\"]")).click();	
////		driver.findElement(By.id("ContextMenuSubMenu4")).click();
//		// ERROR: selenium.ElementNotInteractableException: element not interactable
//		driver.findElement(By.id("Menu31")).click();
//		vars.put("win8262", waitForWindow(2000));
//		vars.put("root", driver.getWindowHandle());
//		driver.switchTo().window(vars.get("win8262").toString());
//		driver.switchTo().frame(1);
//		driver.findElement(By.id("TxtPassScore")).click();
//		driver.findElement(By.id("TxtPassScore")).sendKeys("43");
//		driver.findElement(By.id("ImgBtnOK")).click();
//		assertThat(driver.switchTo().alert().getText(), is("更新します。よろしいですか？"));
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
//		driver.findElement(By.id("BtnRightNow")).click();
//		driver.findElement(By.cssSelector("label")).click();
//		driver.findElement(By.id("BtnOK")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(3);
//		driver.findElement(By.id("BtnOK")).click();
//		vars.put("window_handles", driver.getWindowHandles());
//		driver.switchTo().window(vars.get("root").toString());
//		vars.put("win9349", waitForWindow(2000));
//		driver.switchTo().window(vars.get("win9349").toString());
//		driver.findElement(By.id("ImgBtnCancel")).click();
//		driver.switchTo().window(vars.get("root").toString());

		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngBar");
		driver.findElement(By.id("BtnDocRegist")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngMain");
		driver.switchTo().frame("F_DocRegistMain");
		driver.switchTo().frame("F_DocRegistLeft");

		// Registration method
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("DrpLstRegistFileType")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//option[. = 'パッケージ文書登録']")).click();
		driver.findElement(By.id("DrpLstRegistFileType")).sendKeys(Keys.ENTER);
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("ImgBtnDocClsSelect")).sendKeys(Keys.ENTER);
		vars.put("win810", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win810").toString());
		driver.findElement(By.linkText("protect")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OkBtn")).sendKeys(Keys.ENTER);

		vars.put("win2061", waitForWindow(2000));
		driver.switchTo().window(vars.get("win2061").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("RptDocRegistAttrEdit_ctl01_TxtAttrValue")).click();
		driver.findElement(By.id("RptDocRegistAttrEdit_ctl01_TxtAttrValue")).sendKeys("wss");
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnModify")).sendKeys(Keys.ENTER);
		assertThat(driver.switchTo().alert().getText(), is("指定の文書属性を設定します。"));
		driver.switchTo().alert().accept();

		// Document name
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		vars.put("window_handles", driver.getWindowHandles());
		vars.put("win9366", waitForWindow(2000));
		driver.findElement(By.id("TxtDocName")).click();
		driver.findElement(By.id("TxtDocName")).sendKeys("wss");

		// Location
		driver.findElement(By.id("ImageButton1")).sendKeys(Keys.ENTER);
		vars.put("win8310", waitForWindow(2000));
		driver.switchTo().window(vars.get("win8310").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.linkText("111")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("333")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OkBtn")).click();

		// Access privilege
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("ImgBtnDocAxsRight")).click();
		vars.put("win2420", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win2420").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("selGrpLst7")).click();
		driver.findElement(By.id("selGrpLst7")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("btnDelGrp7")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnChgGrp7")).click();
		vars.put("win4660", waitForWindow(2000));
		driver.switchTo().window(vars.get("win4660").toString());
		driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)")).click();
		driver.findElement(By.id("OkBtn")).click();
		driver.switchTo().window(vars.get("win2420").toString());
		driver.findElement(By.id("DrpLstRole7")).click();
		driver.findElement(By.cssSelector("#DrpLstRole7 option[value='11']")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnModifyAcl")).click();
		assertThat(driver.switchTo().alert().getText(), is("指定の文書アクセス権を設定します。"));
		driver.switchTo().alert().accept();

		// Document attributes
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("ImgBtnDocAttribute")).click();

		vars.put("win4944", waitForWindow(2000));
		driver.switchTo().window(vars.get("win4944").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnModify")).click();
		assertThat(driver.switchTo().alert().getText(), is("指定の文書属性を設定します。"));
		driver.switchTo().alert().accept();
		driver.switchTo().window(vars.get("root").toString());

		// Storage expiry date
//		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.findElement(By.id("CheckBoxNoLimit")).click();
		driver.findElement(By.id("TxtYear")).click();
		driver.findElement(By.id("TxtYear")).sendKeys("2023");
		driver.findElement(By.id("TxtMonth")).click();
		driver.findElement(By.id("TxtMonth")).sendKeys("6");
		driver.findElement(By.id("TxtDay")).click();
		driver.findElement(By.id("TxtDay")).sendKeys("6");
		driver.findElement(By.cssSelector(".calendar-img")).click();
		driver.findElement(By.linkText("18")).click();
		Thread.sleep(2000);

		// FirstPageRightTest
		driver.findElement(By.id("ImgBtnPkgDownload")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.id("ImgBtnCancel")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.findElement(By.id("ImgBtnPkgRenDownload")).click();
		assertThat(driver.switchTo().alert().getText(), is("対象となるファイルがありません。"));
		driver.switchTo().alert().accept();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnSelectDoc_Sansyo")).click();
		vars.put("win7802", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win7802").toString());
		driver.switchTo().frame(2);
		driver.findElement(By.id("RptTMDocList_ctl06_chkSelect")).click();
		driver.findElement(By.id("imgBtnOK")).click();
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.findElement(By.id("DrpLstVerNo")).click();
		driver.findElement(By.id("DrpLstVerNo")).click();
		driver.findElement(By.id("BtnAddDoc")).click();
		action.contextClick(driver.findElement(By.cssSelector("a > span"))).perform();
		// Robot robot = new Robot();
		// robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		// robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		driver.switchTo().window(vars.get("root").toString());
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("div#jstree-contextmenu > div:nth-child(5)")).click();
		driver.switchTo().alert().accept();

		// DoubleClick
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppLancher");
		driver.findElement(By.id("BtnManagement")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		driver.findElement(By.id("BtnGrpMng")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		driver.findElement(By.id("BtnGrpListView")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_MngMain");
		driver.switchTo().frame("F_UsrGrpMngMain");
		driver.switchTo().frame("F_GrpMngList");
		driver.switchTo().frame("F_GrpMngListTbl");
		vars.put("root", driver.getWindowHandle());
		vars.put("window_handles", driver.getWindowHandles());
		action.doubleClick(driver.findElement(By.cssSelector(".ItemValue:nth-child(2)"))).perform();
		vars.put("グループ情報変更", waitForWindow(2000));
		vars.put("window_handles", driver.getWindowHandles());
		driver.switchTo().window(vars.get("グループ情報変更").toString());
		driver.findElement(By.id("BtnGrpReg")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(vars.get("root").toString());

		// MouseMove
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppLancher");
		driver.findElement(By.id("BtnDocMng")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngMain");
		driver.switchTo().frame("F_DocList");
		driver.switchTo().frame("F_DocLstTbl");
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);
		mouseOver(280, 200);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(40, 195);
		robot.mouseMove(60, 192);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);

		// PageChange*4
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngMain");
		driver.switchTo().frame("F_DocList");
		driver.switchTo().frame("F_DocLstTbl");
		vars.put("root", driver.getWindowHandle());
		vars.put("window_handles", driver.getWindowHandles());
		action.contextClick(driver.findElement(By.id("85b775fc-0443-417b-b423-9fd3cfcf1fa6"))).perform();
		action.click(driver.findElement(By.id("Menu10"))).perform();
		vars.put("文書情報", waitForWindow(1000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("文書情報").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnUrlDisp")).click();
		Thread.sleep(1000);
		vars.put("URL表示", waitForWindow(1000));
		driver.switchTo().window(vars.get("URL表示").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("btnAddMailTo")).click();
		Thread.sleep(1000);
		vars.put("ユーザー", waitForWindow(1000));
		driver.switchTo().window(vars.get("ユーザー").toString());
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("NRIシステム管理者グループ(nri-admin)")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.id("RptSelectDocList_ctl01_LblVersionName")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ImgBtnUsrAdd")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		driver.findElement(By.id("RptSelectDocList_ctl00_LblVersionName")).click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("URL表示").toString());
		driver.findElement(By.id("PnlDispContents")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("DrpLstVersion")).click();
		Thread.sleep(1000);
		WebElement dropdown2 = driver
				.findElement(By.cssSelector("#DrpLstVersion option[value='a8adeab1-1cba-4d05-b232-e67fb3f88b94']"));
		dropdown2.click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("文書情報").toString());
		driver.findElement(By.cssSelector(".DocInfo")).click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("URL表示").toString());
		driver.findElement(By.id("PnlDispContents")).click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("ユーザー").toString());
		driver.switchTo().frame(3);
		driver.findElement(By.id("FrmAddLst")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ImgBtnOK")).click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("URL表示").toString());
		driver.findElement(By.id("ImgBtnCancel")).click();
		Thread.sleep(1000);
		driver.switchTo().window(vars.get("文書情報").toString());
		driver.findElement(By.id("BtnClose")).click();
		driver.switchTo().window(vars.get("root").toString());
		
		// PageChangeSecond(gcsoft 124)
		driver.switchTo().frame("F_AppLancher");
		driver.findElement(By.id("BtnWorkFlow")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
	    driver.switchTo().frame("F_WorkFlowBar");
		driver.findElement(By.id("BtnRegReqest")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
	    driver.switchTo().frame("F_WorkFlowMain");
	    driver.switchTo().frame("F_WorkFlowApplyMain");
	    driver.switchTo().frame("F_WorkFlowApply");
		vars.put("window_handles", driver.getWindowHandles());
		Thread.sleep(2000);
		driver.findElement(By.id("ImgBtnAplyDocRegist")).sendKeys(Keys.ENTER);
		vars.put("win321", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win321").toString());
		driver.switchTo().frame(1);
		driver.findElement(By.id("DrpLstRegistFileType")).click();
		driver.findElement(By.xpath("//option[. = 'カスタムテンプレート登録']")).click();
		vars.put("window_handles", driver.getWindowHandles());
		Thread.sleep(2000);
		driver.findElement(By.id("ImgBtnDocClsSelect")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		vars.put("win6222", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win6222").toString());
		driver.findElement(
				By.cssSelector("#\\{5623d178-0173-4989-afb1-b1f133bd014c\\}>.webfx-tree-row>.webfx-tree-item-label"))
				.click();
		driver.findElement(By.id("OkBtn")).sendKeys(Keys.ENTER);
		vars.put("win7581", waitForWindow(2000));
		driver.switchTo().window(vars.get("win7581").toString());
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnModify")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		assertThat(driver.switchTo().alert().getText(), is("指定の文書属性を設定します。"));
		driver.switchTo().alert().accept();
		driver.switchTo().window(vars.get("win321").toString());
		driver.switchTo().frame(1);
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("ImgBtnTmpltSelect")).sendKeys(Keys.ENTER);;
		vars.put("win2514", waitForWindow(2000));
		driver.switchTo().window(vars.get("win2514").toString());
		driver.findElement(By.cssSelector("option")).click();
		driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);;
		driver.switchTo().window(vars.get("win321").toString());
		driver.switchTo().frame(1);
		driver.findElement(By.id("TxtDocName")).sendKeys("テストファイル");
		driver.findElement(By.id("ImgBtnOK")).sendKeys(Keys.ENTER);
		assertThat(driver.switchTo().alert().getText(), is("文書の登録を行います。よろしいですか？"));
		driver.switchTo().alert().accept();
	}

	private void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 3000000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
	}

	private void getScreenshot(String filename) {
		try {
			File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
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
