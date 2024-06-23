package tutorialsNinjaTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
public class TutorBaseClass  implements ITestListener
{
	public static  WebDriver driver;
	public static Capabilities capies;
	static int a=0;
public	static Properties p;
	 public static final  int implicitWait=5;
	 public static final  int pageLoadWait=5;
	public static  LocalDateTime ldt=	LocalDateTime.now();
	public static 	DateTimeFormatter d=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	public static String Time =getTimeStamp();
	public static String ClassName;
public static ExtentReports ext=new  ExtentReports();

 
	public TutorBaseClass() 
	{
		
a++;
if(a<=1)
{
System.out.println(" Reached BaseClass Constructor");
  
p=new Properties();
File f=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\tutorialsNinjaConfig\\tutorialsNinja.properties");
try {
System.out.println(f.exists());
FileInputStream fis=new  FileInputStream(f);

p.load(fis);

System.out.println("properties file loaded");
}
catch(Exception e)
{
e.printStackTrace();	
}

		
		
}	  
	} 
	
	
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
	
	
	
	
	
/*	@BeforeTest
	public void bt()
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
		return ;
	}
	//@BeforeMethod
	
	@AfterTest
	public void at()
	{
		System.out.println("-----------Reached After test  -------------" );
	System.out.println(LogForFail);
		driver.quit();
		System.out.println(LogForFail);
		
		System.out.println("-----------Driver quitted");
		
	}
	*/
	public String getClassName(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	 Object o=  Class.forName(name).newInstance();
	return ClassName=o.getClass().getSimpleName();
	}
	
	public static String getTimeStamp()
	{
		return ldt.now().format(d).replace(" ","_").replace("-","_");
	}

	
	
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
			 capies=	((RemoteWebDriver)driver).getCapabilities();
			
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
					ext.createTest(result.getName()).assignAuthor("SAADIQA").addScreenCaptureFromPath(path).log(Status.PASS, result.getName()+" test Passed").pass("Test is Passed")
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
			
			
			ext.createTest(result.getName()).assignAuthor("SAADIQA").addScreenCaptureFromPath(path).log(Status.FAIL,result.getName()+" Test Failed").fail(result.getThrowable())
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
			ext.setSystemInfo("Operating System :", System.getProperty("os.name"));
			ext.setSystemInfo("Browser  Name:", capies.getBrowserName());
			ext.setSystemInfo("Browser Version :", capies.getBrowserVersion());
			ext.setSystemInfo("Java Version : :", System.getProperty("java.version"));
			Platform p=capies.getPlatformName();
			ext.setSystemInfo("platform :", 
				p.getCurrent().toString());
			ext.flush();
		}

		
		
		
		
		
		
		
		
	

}
