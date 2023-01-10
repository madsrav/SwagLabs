package com.demo.SwagLabs.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.SwagLabs.generic.BaseClass;

public class TC_002_Print_All_Products_Test extends BaseClass {
	@Test(groups="regression")
	public void print_All_Products_Test()
	{
		List<WebElement> elements= driver.findElements(By.xpath("//div[@class='inventory_item_description']/div/a"));
		for(WebElement allelements : elements) 
		{
			System.out.println(allelements.getText());
		}
	}
}
