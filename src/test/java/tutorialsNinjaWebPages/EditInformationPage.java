package tutorialsNinjaWebPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import tutorialsNinjaTests.TutorBaseClass;

public class EditInformationPage  extends TutorBaseClass

{
//---------------------------------------Constructor-----------------------------------------------
public EditInformationPage() 
{
	PageFactory.initElements(driver,this);
	
}	
//-----------------------------Elements-------------------------------------------------------

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")

WebElement SuccessMessage;


@FindBy(xpath="//input[@type='submit']")

WebElement ContinueButton;


static int len1;
private static 	List<WebElement> EditInfoFields =new ArrayList();

//-----------------------------------------getElements----------------------------------------------
public  static List<WebElement> getElements(String name)
{
	 EditInfoFields=driver.findElements(By.xpath("//div[@class='col-sm-10']/input"));
	 
	
	 len1=EditInfoFields.size();
	   
	 
	 for(int i=0;i<(len1);i++)
	 {
		 EditInfoFields.add(driver.findElement(By.xpath
				 ("//div[@class='col-sm-10']/input[@name='"+EditInfoFields.get(i).getDomAttribute("name")+"']")));
		 
		 
	}
	 if(name.equalsIgnoreCase("EditInfoFields"))
	return EditInfoFields;
	
	else
		return null;
}

//---------------------------------------submitEditInfo-------------------------------------------------


public MyAccountPage submitEditInfo()
{
	 ContinueButton.click();
	 if( SuccessMessage.isDisplayed())
		{
		 return new MyAccountPage();

	}
	 return null;
	 }





//---------------------------------------------Erase it later--------------------------------------
//public  void enterEditDetails1(String attribute,String...str) throws InterruptedException
//{
//	List<WebElement>  e1=getElements("EditInfoFields");
//	int actLen=e1.size();
//	for(int i=0;i<(actLen);i++)
//	{
//		WebElement e=e1.get(i);
//	
//	if(attribute.equalsIgnoreCase("All"))
//			{
//		
//		System.out.println("------------------Entered into for loop---------------------------");
//		
//		System.out.println( "i value :"+i);
//		
//		System.out.println( "e.get(i) value :"+e.getAccessibleName());
//		
//			e.clear();
//			System.out.println("cleared textbox ");
//			e.sendKeys((str[i]).toString());
//			System.out.println("keys entered :"+ (str[i]).toString() +"value of i:"+i+"length of str :"+str.length);
//		
//			Thread.sleep(Duration.ofSeconds(1));
//			}
//			if(attribute.equalsIgnoreCase(e.getText()))
//			{
//			(e).sendKeys(str[i].toString());	
//			}
//		}
//
//		for(int i=0;i<(str.length);i++)
//		{
//		System.out.println("------------------Entered into for loop---------------------------");
//		
//		System.out.println( "i value :"+i);
//		
//		WebElement e=e1.get(i);
//		System.out.println( "e.get(i) value :"+e.getAccessibleName());
//		
//			e.clear();
//			System.out.println("cleared textbox ");
//			e.sendKeys((str[i]).toString());
//			System.out.println("keys entered :"+ (str[i]).toString() +"value of i:"+i+"length of str :"+str.length);
//		
//			Thread.sleep(Duration.ofSeconds(1));
//			
//			}
//
//
//}



//------------------------------------enterDetailsToEdit--------------------------------------------
public void enterDetailsToEdit(String...str) throws InterruptedException
{
	System.out.println("length of str :"+str.length);
	List<WebElement>  e1=getElements("EditInfoFields");
	int actLen=e1.size();
	System.out.println("got webelements ");
	int sendkeyscount=0;
	for(int i=0;i<(str.length);i++)
	{
		System.out.println("entered into for loop");
		for(int j=0;j<actLen;j++)
		{
		WebElement e2=(WebElement) e1.get(j);
		System.out.println("got an element in e1 ");
		//
		int endIndexOfAttribute=(str[i].indexOf("="));
		//int endIndexOfValue =(str[i].indexOf("="));
		String AttributeValue=
	
	str[i].substring((endIndexOfAttribute)+1);
		
		
		System.out.println("got an endindex of:"+str[i] +" as "+endIndexOfAttribute);
		
		String attribute=str[i].substring(0, endIndexOfAttribute);
		System.out.println("value of attribute :"+ attribute);
		
		if(e2.getDomAttribute("name").equalsIgnoreCase(attribute))
			
		{ 
			System.out.println("DomAAttribute matched with given attribute  ");
		
			e2.clear();
			e2.sendKeys(AttributeValue);
			//Thread.sleep(Duration.ofSeconds(100));
			sendkeyscount++;
			System.out.println("sendkeys :"+AttributeValue);
		break;	
		}
		
		}
		sendkeyscount=0;
	}
	}
		
}
