package tutorialsNinjaTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tutorialsNinjaWebPages.EditInformationPage;
import tutorialsNinjaWebPages.HomePage;
import tutorialsNinjaWebPages.LoginPage;
import tutorialsNinjaWebPages.MyAccountPage;
import tutorialsNinjaWebPages.RegisterPage1;

public class EditAccountTest extends TutorBaseClass
{
	ExtentSparkReporter expSpa=new ExtentSparkReporter("./Reports/"+this.getClass().getSimpleName()+"/Report.html");
	
	
//---------------------------------------------editUserName--------------------------------------
	@Test 
	public void editUserName() throws InterruptedException
	{
HomePage	hp=	new HomePage();
		
		RegisterPage1  rp=hp.clickOnRegisterTab();
		
		String[] str=new String[] {"zaara","inam","inam"+getTimeStamp()+""+"@gmail.com","454545","1234","1234"};	
		rp.EnterDetails(str);
MyAccountPage map=rp.submit();
assertFalse(map==null);
EditInformationPage eip=map.clickOnEditInformation();
assertFalse(eip==null);

eip.enterDetailsToEdit("firstname=Noor","lastname=mukadam");
map=eip.submitEditInfo();

assertFalse(map==null);

	
	}
//--------------------------------editWithRegisteredEmailID-----------------------------------------
	@Test 
	public void editWithRegisteredEmailID() throws InterruptedException
	{
		HomePage	hp=	new HomePage();
		
		RegisterPage1  rp=hp.clickOnRegisterTab();
		
		String[] str=new String[] {"zaara","inam","inam"+getTimeStamp()+""+"@gmail.com","454545","1234","1234"};	
		rp.EnterDetails(str);
		
MyAccountPage map=rp.submit();
assertFalse(map==null);
EditInformationPage eip=map.clickOnEditInformation();
assertFalse(eip==null);

eip.enterDetailsToEdit("lastname=zorawar","email=jimmy@gmail.com","telephone=6362239561");
map=eip.submitEditInfo();

assertFalse(map==null);

	
	}
	
	
	public void ttimecheck()
	{
		try {
			System.out.println(getTimeStamp());
			Thread.sleep(2000);
			System.out.println(getTimeStamp());
			Thread.sleep(2000);
			System.out.println(getTimeStamp());
			Thread.sleep(2000);
	
			System.out.println(getTimeStamp());
			Thread.sleep(2000);
	}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
//-----------------------------------------editWithRegisteredTelephone------------------------------
	@Test 
	public void editWithRegisteredTelephone() throws InterruptedException
	{
		HomePage	hp=	new HomePage();
		
		RegisterPage1  rp=hp.clickOnRegisterTab();
		
		String[] str=new String[] {"zaara","inam","inam"+getTimeStamp()+""+"@gmail.com","454545","1234","1234"};	
		rp.EnterDetails(str);
	
MyAccountPage map=rp.submit();
assertFalse(map==null);
EditInformationPage eip=map.clickOnEditInformation();
assertFalse(eip==null);

eip.enterDetailsToEdit("lastname=zorawar","email=jimmy"+getTimeStamp()+"@gmail.com","telephone="+p.getProperty("Telephone"));
map=eip.submitEditInfo();

assertFalse(map==null);

	
	}
	
	
// ----------------------------------------editAllFields--------------------------------------
	@Test 
	public void editAllFields() throws InterruptedException
	{
		HomePage	hp=	new HomePage();
		
		RegisterPage1  rp=hp.clickOnRegisterTab();
		
		String[] str=new String[] {"zaara","inam","inam"+getTimeStamp()+""+"@gmail.com","454545","1234","1234"};	
		rp.EnterDetails(str);
		
MyAccountPage map=rp.submit();
assertFalse(map==null);
EditInformationPage eip=map.clickOnEditInformation();
assertFalse(eip==null);

eip.enterDetailsToEdit("firstname=Ali","lastname=zafar","email=jimmy"+getTimeStamp()+"@gmail.com","telephone=4545454");
map=eip.submitEditInfo();

assertFalse(map==null);

	
	}
//-------------------------------------------BEFOREMETHOD---------------------------------------	
	@BeforeMethod
	public void bm() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
System.out.println( " Entered before method");
getClassName(this.getClass().getName());
		}
//---------------------------------------------BEFORESUITE--------------------------------------
	@BeforeSuite
	public void bs()
	{
	ext.attachReporter(expSpa);
	expSpa.config().setReportName("Edit Account Report");
	expSpa.config().setDocumentTitle("Edit Account Report");


	}
}
