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

		System.out.println("一時停止、他の処理を待ちます。（他の処理が完了した後で、「処理完了」を入力ください。");

		Console console = System.console();
		String result  = console.readLine();
		while ("処理完了".equals(result)) {
			System.out.println("一時停止中...");
			console = System.console();
			result = console.readLine();
		}
	}
}
