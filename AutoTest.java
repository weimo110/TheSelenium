package com.gcsoft.autots.domain;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AutoTest {
	private WebDriver driver;
	private String webDriverKey = "WEBDRIVER-";
	private String serverUrlKey = "SERVER-URL-";

	private String configFilePath = "conf\\OnlineAutoTest.conf";
	
	private Map<String, String> configMap;

	private String browserType = null;
	private String packageName = null;
	private String sourceName = null;
	private String URL = null;

	private Robot robot;
//	private int browserHeaderHeight = 120;
	private int robotTime = 3000;

	@Before
	public void setUp() throws Exception {
		this.readConfigFile();
		this.robotTime = Integer.parseInt(this.configMap.get("ROBOT-TIME"));
		String[] parameters = this.readParameters();

		while (this.checkParameters(parameters)) {
			parameters = this.readParameters();
		}
		
		this.browserType = parameters[1];
		this.packageName = parameters[2];
		this.sourceName = parameters[3];
		this.URL = this.configMap.get(this.serverUrlKey + parameters[0]);
		
		if ("I".equals(this.browserType)) {
			System.setProperty("webdriver.ie.driver",
					this.configMap.get(this.webDriverKey + this.browserType));
			this.driver = new InternetExplorerDriver();
		} else if ("E".equals(this.browserType)) {
			this.driver = new EdgeDriver();
		} else if ("C".equals(this.browserType)) {
			System.setProperty("webdriver.chrome.driver",
					this.configMap.get(this.webDriverKey + this.browserType));
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			options.addArguments("--disable-infobars");
			this.driver = new ChromeDriver(options);
		}

	    this.driver.get(this.URL);
		this.robot = new Robot();
		this.robot.setAutoDelay(this.robotTime);

		this.robot.keyPress(KeyEvent.VK_F11);
		this.robot.keyRelease(KeyEvent.VK_F11);
//		this.driver.manage().window().setPosition(new Point(this.windowsLeft, this.windowsTop));
//		this.driver.manage().window().setSize(new Dimension(this.windowsWidth, this.windowsHeight));
	}

	@After
	public void tearDown() {
		this.robot.keyPress(KeyEvent.VK_F11);
		this.robot.keyRelease(KeyEvent.VK_F11);
		this.endOperation();
		this.driver.close();
		this.driver.quit();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void doTest() throws Exception {
		
		try {
			Class testClass = Class.forName("com.gcsoft.autots.script." + this.packageName + "." + this.sourceName);
			Object testObj = testClass.newInstance();
			Method method = testClass.getMethod("doTest", WebDriver.class, Robot.class, String.class, String.class);
			method.invoke(testObj, this.driver, this.robot, this.URL, this.browserType);
		} catch (Exception e) {
			System.err.println("実行結果： NG");
			throw e;
		}

		System.out.println("実行結果： OK");
	}

	private String[] readParameters() {
		this.showParameterMsg();
		Console console = System.console();
		if (console == null) {
			return new String[0];
		}

		String parameterStr = console.readLine();
		String[] parameters = parameterStr.split(" ");
		
		for (int i = 0; i < parameters.length; i++) {
			if (i < 2) {
				parameters[i] = parameters[i].toUpperCase();
			}
		}
		
		return parameters;
	}

	private boolean checkParameters(String[] parameters) {
		boolean errorFlg = false;
		if (parameters.length != 4
				|| !("OLD".equals(parameters[0])
						|| "NEW".equals(parameters[0]))
				|| !("I".equals(parameters[1])
						|| "E".equals(parameters[1])
						|| "C".equals(parameters[1]))) {
			errorFlg = true;
		}

		return errorFlg;
	}

	private void showParameterMsg() {

		System.err.println("下記のように引数を正しく入力ください！");
		System.err.println("一番目引数：現新環境区分（OLD:現環境、NEW:新環境)");
		System.err.println("二番目引数：ブラウザ区分（I:internet explorer 11、E:Microsoft Edge、C:Google Chrome)");
		System.err.println("三番目引数：パッケージ（シナリオ）名");
		System.err.println("四番目引数：ソース名");
	}

	private void readConfigFile() throws Exception {
		this.configMap = new HashMap<String, String>();
		File file = new File(this.configFilePath);
		if (!file.exists()) {
			throw new Exception("設定ファイル「" + this.configFilePath + "」が存在しません！");
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String lineStr = null;
			while((lineStr = reader.readLine()) != null) {
				String[] configs = lineStr.split("=");
				this.configMap.put(configs[0].toUpperCase(), configs[1]);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	private void endOperation() {

		System.out.println("実行完了しました、ブラウザを閉じるにはEnterキーを押してください . . .");

		Console console = System.console();
		if (console == null) {
			return;
		}

		console.readLine();
		return;
	}
}