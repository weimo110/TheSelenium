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

		System.out.println("�ꎞ��~�A���̏�����҂��܂��B�i���̏���������������ŁA�u���������v����͂��������B");

		Console console = System.console();
		String result  = console.readLine();
		while ("��������".equals(result)) {
			System.out.println("�ꎞ��~��...");
			console = System.console();
			result = console.readLine();
		}
	}
}
