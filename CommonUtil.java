package com.gcsoft.autots.utils;

import java.io.Console;

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

		System.out.println("暂停，等待其他处理。（请在其他处理完成后输入“处理完成”。）");

		Console console = System.console();
		String result  = console.readLine();
		while ("处理完了".equals(result)) {
			System.out.println("暂时中止...");
			console = System.console();
			result = console.readLine();
		}
	}
}
