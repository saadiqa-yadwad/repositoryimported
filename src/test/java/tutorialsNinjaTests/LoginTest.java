package tutorialsNinjaTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Reports.ExtentReport;
import tutorialsNinjaWebPages.HomePage;
import tutorialsNinjaWebPages.LoginPage;
import tutorialsNinjaWebPages.MyAccountPage;
public class LoginTest  extends TutorBaseClass implements ITestListener
{
	
	//public ExtentReports extLog=new ExtentReports();
	
 ExtentSparkReporter expSpa=new ExtentSparkReporter("./Reports/"+this.getClass().getSimpleName()+"/Report.html");
//----------------------------------------------LoginWithUnregisteredEmailAndPassword-----------------	
@Test(priority =  1)	
public void	LoginWithUnregisteredEmailAndPassword () throws InterruptedException
	{
	
	HomePage hp=new HomePage();
	LoginPage lp=(LoginPage)hp.clickOnLoginTab();
	assertFalse(lp.equals(null),"Login tab is not visible");
	lp.EnterDetails("2345@gmail.com", "1234");
	MyAccountPage ma=(MyAccountPage)lp.submit();
	System.out.println(ma +"value of ma");
	
	assertFalse(ma==null);
	ext.addTestRunnerOutput("can register with unregistered email");
	
		
	}



		
	
//------------------------------------------------BEFORESUITE----------------------------------------
@BeforeSuite
public void bs()
{
	ext.attachReporter(expSpa);
	
}
//---------------------------------AFTERSUITE---------------------------------------
@AfterTest
public void at()
{
	//driver.quit();
	
}
//--------------------------------------BEFOREMETHOD------------------------------------------
@BeforeMethod
public void bm() throws InstantiationException, IllegalAccessException, ClassNotFoundException
{System.out.println( " Entered before method");
getClassName(this.getClass().getName());
	
	
}



//---------------------------------------------------LoginWithValidEmailAndPassword-----------------


@Test(priority = 2)	
public void	LoginWithValidEmailAndPassword () throws InterruptedException
	{
	HomePage hp=new HomePage();
	LoginPage lp=(LoginPage)hp.clickOnLoginTab();
	assertFalse(lp.equals(null));
	lp.EnterDetails(p.getProperty("EmailID"), p.getProperty("password"));
	MyAccountPage ma=(MyAccountPage)lp.submit();
	
		assertFalse(ma==null); 
	}
//---------------------------------------------------LoginWithBlankEmailValidPassword-----------------
@Test(priority = 3)	
public void	LoginWithBlankEmailValidPassword () throws InterruptedException
	{
	HomePage hp=new HomePage();
	LoginPage lp=(LoginPage)hp.clickOnLoginTab();
	assertFalse(lp.equals(null));
	lp.EnterDetails("", p.getProperty("password"));
	MyAccountPage ma=(MyAccountPage)lp.submit();
	
		assertFalse(ma==null); 
	}
	


//---------------------------------LoginWithOutCredentials-------------------------------------------
@Test(priority = 4)	
public void	LoginWithOutCredentials () throws InterruptedException
	{
	HomePage hp=new HomePage();
	LoginPage lp=(LoginPage)hp.clickOnLoginTab();
	assertFalse(lp==null);
	lp.EnterDetails("","");
	MyAccountPage ma=(MyAccountPage)lp.submit();
	
		assertFalse(ma==null); 
	}
	
}
