package tutorialsNinjaWebPages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import tutorialsNinjaTests.TutorBaseClass;

public class RegisterPage1  extends TutorBaseClass
{ public static WebDriver rdriver;

//--------------------------------------CONSTRUCTOR-----------------------------------------
	public RegisterPage1()
	{System.out.println("------------------------");
	 
	
		   System.out.println("Reached RegisterPage Constructor");
		   rdriver=TutorBaseClass.driver;
		System.out.println("Value of rdriver After assignment :"+rdriver);
		 
		PageFactory.initElements(driver,this );
		System.out.println("----------Coming out of the RegisterPage Constructor--------------");
		 
		
	}
//------------------------------------------ELEMENTS----------------------------------------------------------
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li/a[text()='Register']")
    private WebElement RegisterBreadCrumb;

	@FindBy(xpath ="//div[@class='col-sm-10']/div[text()='First Name must be between 1 and 32 characters!']")
	 WebElement FirstNameWarning;
	 
	
	@FindBy(xpath = "//input[@type='checkbox']")
	 WebElement PrivacyCheck;
	 
	 @FindBy(xpath = "//div/input[@value='Continue']")
	 WebElement ContinueButton;
	 @FindBy(xpath="//a[text()='Success']")
	 WebElement SuccessBreadCrumb;
	 
	private static 	List<WebElement> RegisterFields =new ArrayList();
	private static 	 List<WebElement> RadioFields=new ArrayList();;

	private static 	List<WebElement> WarningFields=new ArrayList();
//------------------------------------------------METHODS----------------------------------------	
 public boolean regBreadCrumbDisplayed()
 { 
	 return  RegisterBreadCrumb.isDisplayed();

 }
 
 

 public  void EnterDetails(Object[] str) throws InterruptedException
 {
	List<WebElement>  e=getElements("RegisterFields");
	
if((str.length)==len1)
{
	for(int i=0;i<(str.length);i++)
	{
		WebElement e1=e.get(i);
		e1.sendKeys((str[i]).toString());
		
	}
	

	}}
 
 public MyAccountPage submit()
 {
	 PrivacyCheck.click();
	 ContinueButton.click();
	 if( SuccessBreadCrumb.isDisplayed())
		{
		 return new MyAccountPage();

	}
	 return null;
	 }

 
 
 public boolean isWarningDisplayed()
 {
	return  FirstNameWarning.isDisplayed();
 }
 
 
 public void clickOnContinueButton()
 {
	 ContinueButton.click();
 }
 
 
 
 
 static int len1,len2,len3;
public  static List<WebElement> getElements(String name)
{
	 RegisterFields=driver.findElements(By.xpath("//div[@class='col-sm-10']/input"));
	 RadioFields=driver.findElements(By.xpath("//div[@class='col-sm-10']/label/input"));
	 WarningFields=driver.findElements(By.xpath("//div[@class='col-sm-10']/div[@class='text-danger']"));
		
	
	 len1=RegisterFields.size();
	  len2=RadioFields.size();
	  len3=WarningFields.size();
		 
	 
	 for(int i=0;i<(len1);i++)
	 {
		 RegisterFields.add(driver.findElement(By.xpath
				 ("//div[@class='col-sm-10']/input[@name='"+RegisterFields.get(i).getDomAttribute("name")+"']")));
		 if(i<len2) 
	{
	RadioFields.add(driver.findElement(By.xpath
			 ("//div[@class='col-sm-10']/label/input[@value='"+RadioFields.get(i).getDomAttribute("value")+"']")));
	}
		 if(i<len3)
		 {
			 System.out.println("len 3 :"+len3);
			 WarningFields.add(driver.findElement(By.xpath
					 
					 ("//div[@class='col-sm-10']/div[text()='"+WarningFields.get(i).getText()+"']")));
			
		 }
	}
	 if(name.equalsIgnoreCase("RegisterFields"))
	return RegisterFields;
	else if(name.equalsIgnoreCase("RadioFields"))
		return RadioFields;
	else if(name.equalsIgnoreCase("WarningFields"))
		return WarningFields;
	else
		return null;
}






 
public  static List<WebElement> getWarningFields()
{
	//private static 	List<WebElement> WarningFields=new ArrayList();
	System.out.println("Entered into getWarningFields method");
	WarningFields=driver.findElements(By.xpath("//div[@class='col-sm-10']/div[@class='text-danger']"));
	
	 len1=WarningFields.size();
	  //len2=RadioFields.size();
	 System.out.println("size of warning fields :"+WarningFields.size()  +" len1 :"+len1);
		
	 System.out.println(WarningFields.get(0).getText());
		
		
		 
	 for(int i=0;i<(len1);i++)
	 {
		 System.out.println("--------------------------------------------------");

System.out.println("entered into for loop");
		 WarningFields.add(driver.findElement(By.xpath
				 
				 ("//div[@class='col-sm-10']/div[text()='"+WarningFields.get(i).getText()+"']")));
		System.out.println("text with lastindex :"+WarningFields.get(i).getText()+"  :"+WarningFields.lastIndexOf(WarningFields));
	
	}
	 System.out.println("came out of for loop  with size :"+len1);
		
	 return WarningFields;
}





}

