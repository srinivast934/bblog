package com.backbase.bblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.backbase.bblog.utils.CommonUtils;

public class HomePage {
	
WebDriver driver;

	@FindBy(xpath="(//a[text()='conduit'])[1]")
	WebElement lnk_title;
	
	@FindBy(xpath="//a[@routerlink='/settings']")
	WebElement lnk_settings;

    @FindBy(xpath="//button[text()=' Or click here to logout. ']")
    WebElement btn_logout;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement txt_password;    

    @FindBy(xpath="//button[text()=' Sign in ']")
    WebElement btn_signin; 
    
    @FindBy(xpath="//a[@routerlink='/editor']")
    WebElement lnk_newArticle;
    
    @FindBy(xpath="//a[text()=' Your Feed ']")
    WebElement lnk_yourFeed;
    
    @FindBy(xpath="//a[text()=' Global Feed ']")
    WebElement lnk_globalFeed;
    
    @FindBy(xpath="//p[text()='Popular Tags']")
    WebElement lbl_popularTags;
    
    @FindBy(xpath="//p[text()='Popular Tags']/following::a")
    WebElement lnk_tags;
	
	
    public HomePage(WebDriver driver){

        this.driver = driver;  
        PageFactory.initElements(driver, this);
    }
    
	public void logout() {
		
		lnk_settings.click();
		Reporter.log("Clicked on Settings link");
		CommonUtils.waitfor_Visibility_of_Element(btn_logout);
		btn_logout.click();
		Reporter.log("Clicked on logout button");
		driver.quit();
	}

}
