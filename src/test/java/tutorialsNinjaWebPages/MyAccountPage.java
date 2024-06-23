package tutorialsNinjaWebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tutorialsNinjaTests.TutorBaseClass;

public class MyAccountPage  extends TutorBaseClass
{
//----------------------------Constructor---------------------------------------------------------------
	public MyAccountPage() 
	{
		
	PageFactory.initElements(driver, this);
	}
//----------------------------Page Elements---------------------------------------------------------------
	@FindBy(xpath="//a[text()='Edit Account']")
	WebElement EditAccountButton;
	
	public EditInformationPage clickOnEditInformation()
	{
		if(EditAccountButton.isDisplayed()) 
		{
		EditAccountButton.click();
		return new  EditInformationPage();
		}
		else
			return null;
	}

}
