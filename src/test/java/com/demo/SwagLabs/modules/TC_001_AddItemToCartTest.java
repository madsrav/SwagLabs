package com.demo.SwagLabs.modules;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.SwagLabs.generic.BaseClass;

import objectRepository.Home_Page;
import objectRepository.Your_Cart;

public class TC_001_AddItemToCartTest extends BaseClass 
{
	@Test
	public void addItemToCartTest() throws InterruptedException
	{
		Home_Page hp = new Home_Page(driver);
		hp.getAddShirt().click();//clicking shirt to cart
		hp.getClickCart().click();//click on cart image
		Your_Cart yc= new Your_Cart(driver);
		yc.taskpage();//checkout,first&lastname&pincode,continuecart,finish

		String checkout=driver.findElement(By.xpath("//span[@class='title']")).getText();	
		Assert.assertEquals(checkout, "CHECKOUT: COMPLETE!","not verified");
	}
}
