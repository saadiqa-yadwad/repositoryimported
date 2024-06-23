package tutorialsNinjaWebPages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Reports.ExtentReport;
import tutorialsNinjaTests.TutorBaseClass;

public class Listeners extends TutorBaseClass implements ITestListener
{
	public static String  path=null;
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		String browserName=p.getProperty("BrowserName");
		switch(browserName)
		{
		case "chrome":driver=new ChromeDriver();
		break;
		case "FireFox":driver=new FirefoxDriver();
		break;
		case "edge":driver=new EdgeDriver();
		System.out.println("edge browser initiated 1");
		break;
		default :driver=new EdgeDriver();
		System.out.println("edge browser initiated 2");
		
		
		break;
		
		}
		System.out.println(" Came  out of switch block in bt ");
		  
		driver.get(p.getProperty("URL"));
		System.out.println("-----------Reached URL -------------" +driver.getCurrentUrl());
		 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		System.out.println("-----------Reached driver page Implicitly WAIT -------------" );
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		System.out.println("-----------Reached PageLoadtimeout -------------" );
		
		driver.manage().window().maximize();
		System.out.println("-----------Reached Window Maximized -------------" );
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Executed Successfully");
		
		try
		{
	path=takeScreenShot(result.getName(),result.getStatus());
	System.out.println("took ss ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				ext.createTest(result.getName()).addScreenCaptureFromPath(path).log(Status.PASS, "Test Passed").pass("Test is Passed")
		;
				driver.quit();	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		try
		{
	path=takeScreenShot(result.getName(),result.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ext.createTest(result.getName()).addScreenCaptureFromPath(path).log(Status.FAIL,"").fail(result.getThrowable())
		;
		driver.quit();;
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ext.createTest(result.getName()).log(Status.SKIP, "").skip(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context)
	{
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ext.flush();
	}

	
	
	
	
	
	
	
	
}
