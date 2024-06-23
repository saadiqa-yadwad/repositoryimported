package tutorialsNinjaWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import tutorialsNinjaTests.TutorBaseClass;

public class HomePage  extends TutorBaseClass
{  
	public HomePage()
	{System.out.println("------------------------");
	 
	
		   System.out.println("Reached HomePage Constructor");
		   	
		PageFactory.initElements(driver,this );
		System.out.println("----------Coming out of the HomePage Constructor--------------");
		 
		
	}
	@FindBy(xpath="//a[@title='My Account']")
	 private WebElement MyAccountDropDown;
	
	@FindBy(xpath="//a[text()='Login']")
	 private WebElement LoginTab;
	
	
	@FindBy(linkText="Register")
    private WebElement RegisterTab;
	
	public RegisterPage1 clickOnRegisterTab()
	{
		System.out.println("Reached clickOnRegisterTab method State of driver :"+driver.getCurrentUrl());
		System.out.println("MyAccountDropDown" +MyAccountDropDown);

		
		if(MyAccountDropDown.isDisplayed())
		{
		MyAccountDropDown.click();
		System.out.println("clicked on MyAccountDropDown ");
		RegisterTab.click();
		System.out.println("clicked on RegisterTab ");
		
		}
		return new RegisterPage1();
	}
	
	
	public LoginPage clickOnLoginTab()
	{
		//System.out.println("Reached clickOnLoginTab method State of driver :"+driver.getCurrentUrl());
		//System.out.println("MyAccountDropDown" +MyAccountDropDown);

		
		if(MyAccountDropDown.isDisplayed())
		{
		MyAccountDropDown.click();
		//System.out.println("clicked on MyAccountDropDown ");
		LoginTab.click();
		System.out.println("clicked on LoginTab ");
		
		}
		return new LoginPage();
	}
	
	
	
}
