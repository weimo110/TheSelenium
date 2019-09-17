public void setUp() {
    System.setProperty("webdriver.chrome.driver","F:\\svn\\chromedriver.exe");
    driver = new ChromeDriver();
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
// 页面初始化设置    
driver.manage().window().maximize();
WebDriverWait wait = new WebDriverWait(driver, 20);
driver.get("http://172.17.4.124/Pd_0001/");

//页面重置及进入
driver.switchTo().defaultContent();
driver.switchTo().frame("xxx");

//弹出页面捕获
vars.put("root", driver.getWindowHandle());
………………
vars.put("XXX", waitForWindow(2000));
vars.put("root", driver.getWindowHandle());
driver.switchTo().window(vars.get("XXX").toString());

//Robot操作：准确模拟鼠标键盘操作
//https://blog.csdn.net/scholar_man/article/details/48035251
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_F11);
robot.keyRelease(KeyEvent.VK_F11);
mouseOver(X, X);//移动鼠标，定义见下
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

//点击
driver.findElement(By.id("XXX")).click();
driver.findElement(By.id("XXX")).sendKeys(Keys.ENTER);
Actions action = new Actions(driver);
action.contextClick(driver.findElement(By.id("XXX"))).perform();
action.doubleClick(driver.findElement(By.id("XXX"))).perform();

//弹出框
assertThat(driver.switchTo().alert().getText(), is("XXX"));
driver.switchTo().alert().accept();

//等待
Thread.sleep(2000);
//效率低，必须等待（单位毫秒）
CommonUtil.waitForElement(driver, By.id("XXX"));
//wait至找到相关元素，见CommonUtil

//截图
screen.getScreenshot(driver, "D:\\Image\\"+ browserType +"2_XXX.PNG", null);
//见Screenshot，见AutoTest

//xpath，cssSelector
