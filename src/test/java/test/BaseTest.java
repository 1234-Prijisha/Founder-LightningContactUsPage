package test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseTest {
	public WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+ "reports"+"AutomationReport.html");
		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("AutomationTest Report For Contact US Application");
		htmlReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Report Genrated BY", "Automation Execution");
	}

	@BeforeMethod
	@Parameters(value= {"browserName"})
	public void beforeMethod(String browserName , Method testMethod) {
		test = report.createTest(testMethod.getName());
		System.out.println("Before Method");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "driver"+"chromedriver");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.founderandlightning.com/contact");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

}
