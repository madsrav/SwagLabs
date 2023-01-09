package com.demo.SwagLabs.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import objectRepository.Home_Page;
import objectRepository.Login_Page;

public class BaseClass {
	public WebDriver driver;
	public WebDriver_Utility utils;
	@BeforeClass
	public void launchingBrowser()
	{	
		driver=new ChromeDriver();
		utils = new WebDriver_Utility(driver);
		utils.waitForPageLoad();
		utils.maximizewindow();	
	}
	@BeforeMethod
	public void login() throws Throwable
	{
		ReadDataPropFile prop= new ReadDataPropFile();
		String url = prop.readDataPropFile("url");
		String un=	prop.readDataPropFile("un");
		String pwd= prop.readDataPropFile("pwd");
		driver.get(url);
		Login_Page lp = new Login_Page(driver);
		lp.Login(un, pwd);
	}
	@AfterMethod
	public void Logout()
	{
		Home_Page hp =new Home_Page(driver);
		hp.logout();
	}
	@AfterClass
	public void closingBrowser()
	{
		driver.close();
	}
}
