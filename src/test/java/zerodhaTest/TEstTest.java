package zerodhaTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import zerodha.Zerodha.login;
import zerodha.Zerodha.pin;

@Listeners(zerodhaTest.TestListenerTest.class)

public class TEstTest {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter reporter;
	login z;
	pin z1;
	Properties prob;
	FileInputStream ld;
	
	@BeforeMethod
	public void tc1() throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium support\\New folder\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	    prob=new Properties();
	    ld=new FileInputStream("E:\\Selenium support\\Home\\Zerodha\\base.properties");
		prob.load(ld);
		z=new login(driver);
		z1=new pin(driver);
		String path = System.getProperty("user.dir")+"//reports//extent.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation");
		reporter.config().setReportName("TestDacuments");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "subhash");
		
	}
	
	@Test
	public void tc2() throws InterruptedException {
		driver.get(prob.getProperty("url"));
		String ID = prob.getProperty("id");
		String PAS = prob.getProperty("pas");
		String PIN = prob.getProperty("pin");
		z.setid(ID);
		z.setPAs(PAS);
		z.clickLogin();
	
		z1.setPin(PIN);
		z1.clickSubmit();
		
		
	}

}
