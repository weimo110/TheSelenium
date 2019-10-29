### Driver路径配置
```
public void setUp() {
    System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
    driver = new ChromeDriver();
    // System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
    // driver = new InternetExplorerDriver();
    // driver = new EdgeDriver();
    js = (JavascriptExecutor) driver;
	vars = new HashMap<String, Object>();
    
    // Robot
    try {
		robot = new Robot();
		robot.setAutoDelay(bobotTime);
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
```
### 等待元素
1.显性等待:[函数](https://github.com/weimo110/TheSelenium/blob/master/CommonUtil.java)    
```
CommonUtil.waitForElement(driver, By.id("XXX"));
```
2.页面等待配置
```
public String waitForWindow(WebDriver driver, int timeout) {
    try {
        Thread.sleep(timeout);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>)vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
        whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
}
```
* 应用 `vars.put("XXX", waitForWindow(driver, 2000));`  

3.强行等待（单位毫秒）`Thread.sleep(2000);`  

### 窗口操作    
**最大化** 
```
driver.manage().window().maximize();` 
```
**弹出页面捕获**
```
vars.put("root", driver.getWindowHandle());
// 上为捕获当前页面，此处为调出新页面操作，之后为捕获新页面
vars.put("XXX", waitForWindow(driver, 2000));
// vars.put("XXX", waitForWindow(2000));
vars.put("root", driver.getWindowHandle());
driver.switchTo().window(vars.get("XXX").toString());
```
**弹出框**
```
assertThat(driver.switchTo().alert().getText(), is("XXX"));// 强行弹出，正常不要
driver.switchTo().alert().accept();// 接受弹出框
```
### 鼠标键盘操作
**点击** 
```
driver.findElement(By.id("XXX")).click();
driver.findElement(By.id("XXX")).sendKeys(Keys.ENTER);
```
**[Robot操作](https://blog.csdn.net/scholar_man/article/details/48035251)：** 准确模拟鼠标键盘操作
```
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_F11);
robot.keyRelease(KeyEvent.VK_F11);
mouseOver(X, X);//移动鼠标，定义见下。用于拖拽
robot.mousePress(InputEvent.BUTTON1_MASK);//左键
robot.mouseMove(X, X);
robot.mouseMove(X, X);
robot.mouseRelease(InputEvent.BUTTON1_MASK);
// robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);//右键
robot.keyPress(KeyEvent.VK_F11);
robot.keyRelease(KeyEvent.VK_F11);

private void mouseOver(int pX, int pY) {
	if (pY < browserHeaderHeight) {
		robot.mouseMove(windowsWidth, windowsHeight);
	}
	robot.mouseMove(pX, pY);
}
```

**Action点击：** 模拟鼠标，IE不支持
```
Actions action = new Actions(driver);
action.contextClick(driver.findElement(By.id("XXX"))).perform();
action.doubleClick(driver.findElement(By.id("XXX"))).perform();
```
### 其他
**进入网页**  
```
driver.get("http://www.baidu.com/"); 
```
  
**页面内部frame重置及进入**
```
driver.switchTo().defaultContent(); 
driver.switchTo().frame("xxx");
```

**截图：** 函数见[Screenshot](https://github.com/weimo110/TheSelenium/blob/master/ScreenshotUtil.java)，配置见[AutoTest]()
```
ScreenshotUtil.getScreenshot(driver,"XXX",null, false);
```

**关闭Chrome自动化测试提示**
```
ChromeOptions options = new ChromeOptions();
Map<String, Object> prefs = new HashMap<String, Object>();
prefs.put("credentials_enable_service", false);
prefs.put("profile.password_manager_enabled", false);
prefs.put("profile.default_content_setting_values.notifications", 2);
options.setExperimentalOption("prefs", prefs);
options.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
options.addArguments("--disable-infobars");
driver = new ChromeDriver(options);
```

**xpath**  
![xPath](images/xPath.png)  
**cssSelector**  
![css_selector](images/css_selector.png)

https://www.cnblogs.com/captainmeng/p/7852044.html
