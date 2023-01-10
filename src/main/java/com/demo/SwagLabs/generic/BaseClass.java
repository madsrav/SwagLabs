package com.demo.SwagLabs.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import objectRepository.Home_Page;
import objectRepository.Login_Page;

public class BaseClass {
	
	
	public WebDriver driver;
	public WebDriver_Utility utils;
	@Parameters("browser")
	@BeforeClass(groups={"smoke","regression"})
//	public void launchingBrowser()
//	{	
//		driver=new ChromeDriver();
	public void LaunchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		
		utils = new WebDriver_Utility(driver);
		utils.waitForPageLoad();
		utils.maximizewindow();	
	}
	@BeforeMethod(groups={"smoke","regression"})
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
	@AfterMethod(groups={"smoke","regression"})
	public void Logout()
	{
		Home_Page hp =new Home_Page(driver);
		hp.logout();
	}
	@AfterClass(groups={"smoke","regression"})
	public void closingBrowser()
	{
		driver.close();
	}
}
