package tutorialsNinjaTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Reports.ExtentReport;
import tutorialsNinjaWebPages.HomePage;
import tutorialsNinjaWebPages.LoginPage;
import tutorialsNinjaWebPages.MyAccountPage;
import tutorialsNinjaWebPages.RegisterPage1;

public class RegisterTest  extends TutorBaseClass 
{  
	ExtentSparkReporter expSpa=new ExtentSparkReporter("./Reports/"+this.getClass().getSimpleName()+"/Report.html");

	
	 Object data[]=new Object[]  {p.getProperty("firstname"),p.getProperty("lastname"),p.getProperty("EmailID")
				,p.getProperty("Telephone")
				,p.getProperty("password"),p.getProperty("confirm")};


//-----------------------------------------------registerWithValidCredentials----//1-----------	
	@Test
	public  void registerWithValidCredentials() throws InterruptedException 	{
		System.out.println("-----------Reached registerWithValidCredentials test -------------" );
		HomePage	hp=	new HomePage();
		RegisterPage1	rp=(RegisterPage1)hp.clickOnRegisterTab();
		
		assertTrue(rp.regBreadCrumbDisplayed());
String[] str=new String[] {"Zahir","yadwad","Saadiqa"+getTimeStamp()+""+"@gmail.com","454545","1234","1234"};	
rp.EnterDetails(str);

MyAccountPage ma=(MyAccountPage)rp.submit();

assertFalse(ma==null);
	
	}
//----------------------BEFORE METHOD----------------------------------------------------------	
	@BeforeMethod
	public void bm() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{System.out.println( " Entered before method");
getClassName(this.getClass().getName());
		
		
	}
//--------------------------------------------registerWithInValidCredentials-------------------2--------------------	
	
	@Test(dataProvider = "DataProvider")
	public void registerWithInValidCredentials(Object[] str) throws InterruptedException
	{
		HomePage	hp=	new HomePage();
		RegisterPage1	rp=(RegisterPage1)hp.clickOnRegisterTab();
		
		assertTrue(rp.regBreadCrumbDisplayed());
rp.EnterDetails(str);

MyAccountPage ma=(MyAccountPage)rp.submit();

assertFalse(ma==null);
	
	}

	
	
//----------------------------------------------registerWithRegisteredEmailID---------------------------------------------3-----
	@Test 
	public void registerWithRegisteredEmailID() throws InterruptedException
	{
		HomePage	hp=	new HomePage();
		RegisterPage1	rp=(RegisterPage1)hp.clickOnRegisterTab();
		
		assertTrue(rp.regBreadCrumbDisplayed());
rp.EnterDetails(data);

MyAccountPage ma=(MyAccountPage)rp.submit();

assertFalse(ma==null);
	
	}
//----------------------------------------------------------registerWithNoCredentials-----------4----
	@Test()
	public void registerWithNoCredentials() throws InterruptedException
	{HomePage	hp=	new HomePage();
	RegisterPage1	rp=(RegisterPage1)hp.clickOnRegisterTab();
	
	assertTrue(rp.regBreadCrumbDisplayed());
rp.EnterDetails(new Object[] {});

MyAccountPage ma=(MyAccountPage)rp.submit();

assertFalse(ma==null);


	}
	
	

//---------------------------------------RegisterWithOutName-----------------------------5----------------------------	
	
	@Test()
	public void RegisterWithOutName() throws InterruptedException
	{
		
        data[0]=""; 
		data[1]="";
		data[2]="gaffy"+getTimeStamp()+"@gmail.com";
		HomePage	hp=	new HomePage();
		RegisterPage1	rp=(RegisterPage1)hp.clickOnRegisterTab();
		
		assertTrue(rp.regBreadCrumbDisplayed());
rp.EnterDetails(data);

MyAccountPage ma=(MyAccountPage)rp.submit();

assertFalse(ma==null);
	
	}
	

	
	
	
	
	
	
	
	//-----------------------DATAPROVIDER --------------------------------------------------------
	
	
	
@DataProvider(name="DataProvider")
	public Object[][] dp() throws IOException
	{
		FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\RegisterExcel.xlsx")
		);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet st=wb.getSheet("sheet1");
		
		Object data[][]=new Object[(st.getLastRowNum())+1][(st.getRow(0).getLastCellNum())];

		for(int i=0;i<(st.getLastRowNum());i++) {
			
			for(int j=0;j<(st.getRow(i).getLastCellNum());j++)
			{
				
				data[i][j]=st.getRow(i+1).getCell(j);
		}
			}
		fis.close();
		wb.close();
		return data;
	}
//----------------------------BEFORESUITE-------------------------------------------
@BeforeSuite
public void bs()
{
ext.attachReporter(expSpa);

}
	
}
