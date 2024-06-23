package tutorialsNinjaWebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tutorialsNinjaTests.TutorBaseClass;

public class LoginPage  extends TutorBaseClass
{
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);
		
	}
	@FindBy (xpath="//ul[@class='breadcrumb']/li/a[text()='Login']")
	WebElement LoginBreadCrumb;
	
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement EmailField;
	
	@FindBy (id=("input-password"))
	WebElement PasswordField;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement WarningMessage;
	
	
	
	public  void EnterDetails(String UserName,String Password) throws InterruptedException
	{
		
		
EmailField.sendKeys(UserName);
PasswordField.sendKeys(Password);


		}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccountBreadCrumb;
	
	public  MyAccountPage submit()
	{
		LoginButton.click();
		if(MyAccountBreadCrumb.isDisplayed())
return new MyAccountPage();
		else
			return null;
	}
	}

