package domain;

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

import utils.CommonUtil;
import com.google.common.io.Files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import java.util.*;

@SuppressWarnings("unused")
public class WCaseTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	private Robot robot;
	private int windowsHeight = 900;
	private int windowsWidth = 1440;

	private int browserHeaderHeight = 120;
	private int bobotTime = 500;

	@Before
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver",
//				"F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.ie.driver",
				"F:\\svn\\03_Work\\02_方式設計\\自動化テストツール\\00.Soft\\ReplayEXE\\Java\\01.環境構築\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
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
		driver.findElement(By.id("UserName")).sendKeys("gctest");
		driver.findElement(By.id("Password")).click();
		driver.findElement(By.id("Password")).sendKeys("gctest");
		driver.findElement(By.id("LoginBtn")).click();

		Actions action = new Actions(driver);

		robot.keyPress(KeyEvent.VK_F11);// D
		robot.keyRelease(KeyEvent.VK_F11);// D

		// OK:Copy
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngMain");
		driver.switchTo().frame("F_DocList");
		driver.switchTo().frame("F_DocLstTbl");
		mouseOver(835, 157);
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		mouseOver(900, 255);
		mouseOver(1020, 255);
		mouseOver(1020, 275);
		vars.put("window_handles", driver.getWindowHandles());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		vars.put("win5639", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win5639").toString());
		driver.findElement(By.id("TxtShtCutName")).click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_ALT);
		driver.findElement(By.id("TxtShtCutName")).sendKeys("wza");
		driver.findElement(By.id("BtnOk")).click();
		assertThat(driver.switchTo().alert().getText(), is("コピーします。よろしいですか？"));
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.switchTo().window(vars.get("root").toString());

		// OK:Drag
		mouseOver(300, 259);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(40, 195);
		robot.mouseMove(75, 315);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		mouseOver(150, 323);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		driver.switchTo().alert().accept();

		// OK:check da gou
		mouseOver(80, 315);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(3000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		mouseOver(245, 175);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.id("BtnOK")).click();

		// OK:Click into page
		driver.switchTo().defaultContent();
		driver.switchTo().frame("F_AppArea");
		driver.switchTo().frame("F_DocMngMain");
		driver.switchTo().frame("F_DocList");
		driver.switchTo().frame("F_DocLstTbl");
		vars.put("window_handles", driver.getWindowHandles());
		mouseOver(835, 178);
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		mouseOver(910, 240);
		mouseOver(1060, 240);
		mouseOver(1060, 260);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		vars.put("win3971", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win3971").toString());
		driver.switchTo().frame(0);
		driver.findElement(By.id("ucLinkReviewDoc_fileLinkDoc")).sendKeys("D:\\Test.txt");
		driver.findElement(By.id("RdoVerLockType_1")).click();
		driver.findElement(By.id("RdoVerLockType_0")).click();
		driver.findElement(By.id("RdoVerLockType_2")).click();
		driver.findElement(By.id("ImgBtnPkgDownload")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.id("ImgBtnCancel")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.id("ImgBtnPkgRenDownload")).click();
		assertThat(driver.switchTo().alert().getText(), is("対象となるファイルがありません。"));
		driver.switchTo().alert().accept();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.id("BtnSelectDoc_Sansyo")).click();
		vars.put("win2307", waitForWindow(2000));
		driver.switchTo().window(vars.get("win2307").toString());
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("stackFold")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.linkText("stackFold1")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.linkText("stackFold10")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.linkText("stackFold100")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.id("ImgBtnChkAll")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.id("RptTMDocList_ctl01_chkSelect")).click();
		mouseOver(434, 284);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		driver.findElement(By.id("imgBtnOK")).sendKeys(Keys.ENTER);
		driver.switchTo().window(vars.get("win3971").toString());
		driver.switchTo().frame(0);
		driver.findElement(By.id("TxtAliasName")).click();
		driver.findElement(By.id("TxtAliasName")).sendKeys("Test");
		driver.findElement(By.id("BtnAddDoc")).sendKeys(Keys.ENTER);
		CommonUtil.waitForElement(driver, By.id("BtnOK"));
		driver.findElement(By.id("BtnOK")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.id("RptChkInMsg_ctl01_ucDocProtectDocument_RdoPDFNonCreate")).click();
		driver.findElement(By.id("RptChkInMsg_ctl01_ucDocRendition_RdoRenditionNonCreate")).click();
		driver.findElement(By.id("ChkSendMail")).click();
		driver.findElement(By.id("BtnOK")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.id("BtnOK")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.switchTo().window(vars.get("root").toString());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		//Error:Can't switch to this page
//		vars.put("window_handles", driver.getWindowHandles());
//		driver.switchTo().window(vars.get("root").toString());
//		vars.put("win1061", waitForWindow(2000));
//		driver.switchTo().window(vars.get("win1061").toString());
//		CommonUtil.waitForElement(driver, By.id("ImgBtnCancel"));
//		driver.findElement(By.id("ImgBtnCancel")).sendKeys(Keys.ENTER);
		
//		String agent = request.getHeader("User-Agent").toLowerCase();
//		String browserType = getBrowserName(agent);
//		if(browserType == "C") {
//		mouseOver(880, 853);
//		} else if(browserType == "I") {
			mouseOver(777, 763);
//		} else {
//			mouseOver(777, 793);
//		}
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		driver.switchTo().window(vars.get("root").toString());
		robot.keyPress(KeyEvent.VK_F11);// D
		robot.keyRelease(KeyEvent.VK_F11);// D
	}

	private void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30000);
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
