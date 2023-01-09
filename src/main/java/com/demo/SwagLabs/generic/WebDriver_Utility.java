package com.demo.SwagLabs.generic;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	WebDriver driver;
	Select select;


	public WebDriver_Utility(WebDriver driver)
	{
		this.driver= driver;
	}

	public void closeBrowser()
	{
		driver.close();
	}

	public void maximizewindow()
	{
		driver.manage().window().maximize();
	}

	public void waitForPageLoad()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void dropDownByIndex(WebElement element, int index)
	{
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void dropDownByValue(WebElement element, String value)
	{
		select.selectByValue(value);
	}

	public void dropDownByValue( String text,WebElement element)
	{
		select.selectByVisibleText(text);
	}

	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}

	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();		
	}

	public void switchtowindow(String windowid)
	{
		driver.switchTo().window(windowid);
	}
	public void switchtoFrame(int index)
	{
		driver.switchTo().frame(index);
	}

	public void jseExecutor(String jseScript)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript(jseScript);
	}
	public void SwitchToWindow(String title)
	{
		String currentwindow= driver.getWindowHandle();
		for(String childId : driver.getWindowHandles())
		{
			if(!currentwindow.equals(childId))
			{
				driver.switchTo().window(childId);
				if(title.contains(driver.getTitle())) 
				{
					break;
				}
				else
				{
					throw new NoSuchWindowException(title+"window not availble");
				}
			}

		}
	}
}
