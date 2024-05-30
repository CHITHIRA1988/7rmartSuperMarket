package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait wait;
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 20;

	public void waitForButtonToBeClickable(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitButtonToBeVisisble(WebDriver driver, String Xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
	}
	public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
	      wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	      wait.until(ExpectedConditions.invisibilityOf(element));
	  }
	  public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
	      wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	      wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	  }
	  public void waitForAttributeValue(WebDriver driver, WebElement element, String attribute, String value) {
	      wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	      wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	  }
	  
}
