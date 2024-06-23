package Reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tutorialsNinjaTests.TutorBaseClass;

public class ExtentReport  extends TutorBaseClass
{
	
	
	public String takeScreenShot(String Tname,int status) throws IOException
	{ 
		
	
	
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File f=ts.getScreenshotAs(OutputType.FILE);
	if(status==1)
	{
	  FileUtils.copyFile(f, new 
File(System.getProperty("user.dir")+"/ScreenshotsOfTutorialsNinja/"+ClassName+"/PassedTests/"+Tname+"_"+getTimeStamp()+".png"));
String path=System.getProperty("user.dir")+"/ScreenshotsOfTutorialsNinja/"+ClassName+"/PassedTests/"+Tname+"_"+getTimeStamp()+".png";
	return path;
	}
	if(status>1)
	{
	  FileUtils.copyFile(f, new 
File(System.getProperty("user.dir")+"/ScreenshotsOfTutorialsNinja/"+ClassName+"/FailedTests/"+Tname+"_"+getTimeStamp()+".png"));
	String path=System.getProperty("user.dir")+"/ScreenshotsOfTutorialsNinja/"+ClassName+"/FailedTests/"+Tname+"_"+getTimeStamp()+".png";
	return path;
	}
	else return null;

			}
//--------------------------DEMO ERASE IT LATER--------------------------------------------------
	/*@Test
	public void m2() {
	 System.out.println("Entered into m2 test");
	}	
	@BeforeMethod
	public void bm() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{System.out.println( " Entered before method");
	
	String n=this.getClass().getName();
String cname=getClassName(this.getClass().getName());
	System.out.println( " printing cname :"+cname);	
System.out.println(" after getname method :"+n);		
	}
	@BeforeTest
	public void bt()
	{
System.out.println("Entered into before test");	
	}
	@AfterTest
	public void at()
	{
		System.out.println("Entered into After test" +ClassName);	

	}*/
}
