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
**进入网页**  
```
driver.get("http://www.baidu.com/"); 
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
### 元素定位
```
// .click();
// .sendKeys(Keys.ENTER);
driver.findElement(By.id("XXX"));
driver.findElement(By.cssSelector(".XXX")).click();
driver.findElement(By.xpath("XXX']"))；
driver.findElement(By.linkText("XXX ")).click();
```
**下拉框**  
```
driver.findElement(By.xpath("//option[.='内容']")).click();
```
**根据JS定位页面元素**
```
Stringexe="window.curId='TR|u4';";
exe+="document.querySelector('#tblDocSelecttbodytr:nth-child(4)').click();";
js.executeScript(exe);
```
**页面内部frame重置及进入**
```
driver.switchTo().defaultContent(); 
driver.switchTo().frame("xxx");
```
**xpath**  
![](images/xPath.png)  
**cssSelector**  
![](images/css_selector.png)
### 窗口操作    
**最大化** 
```
driver.manage().window().maximize();` 
```
**弹出页面捕获**
```
vars.put("root", driver.getWindowHandle());
// 上为捕获当前页面，此处为如何调出新页面，之后为捕获新页面
vars.put("XXX(网页名称)", waitForWindow(driver, 2000));
driver.switchTo().window(vars.get("XXX").toString());
// 中间页面操作，下为切到根页面
driver.switchTo().window(vars.get("root").toString());
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
**截图：** 函数见[Screenshot](https://github.com/weimo110/TheSelenium/blob/master/ScreenshotUtil.java)，配置见[AutoTest]()
```
ScreenshotUtil.getScreenshot(driver,"XXX",null, false);
```

**关闭Chrome自动化测试提示**
```
ChromeOptionsoptions=newChromeOptions();
Map<String,Object>prefs=newHashMap<String,Object>();
prefs.put("credentials_enable_service",false);
prefs.put("profile.password_manager_enabled",false);
prefs.put("profile.default_content_setting_values.notifications",2);
options.setExperimentalOption("prefs",prefs);
options.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
options.addArguments("--disable-infobars");
driver=newChromeDriver(options);
```
