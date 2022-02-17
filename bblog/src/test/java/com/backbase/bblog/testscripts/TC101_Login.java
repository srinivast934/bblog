package com.backbase.bblog.testscripts;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.backbase.bblog.pages.HomePage;
import com.backbase.bblog.pages.LoginPage;
import com.backbase.bblog.utils.CommonUtils;
import com.backbase.bblog.utils.Constant;

public class TC101_Login {
	
	public static WebDriver driver;	

	public static void main(String[] args) throws Exception		{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constant.path_chromeDriver);
		driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + Constant.path_authenticationExe);
		Thread.sleep(10);
		
		String uname = CommonUtils.readTestData("user_name");
		String pwd = CommonUtils.readTestData("password");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(uname, pwd);
//		loginPage.login(CommonUtils.readTestData("user_name"), EncryptUtils.decrypt(CommonUtils.readTestData("password")));
		HomePage homePage = new HomePage(driver);
		homePage.logout();		
	}	
	


}
