package util;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	WebDriver driver;
	public SuiteListener(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String fileName = System.getProperty("user.dir")+ "screenshots"+iTestResult.getMethod().getMethodName();
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}    	
	}


	@Override
	public void transform(ITestAnnotation iTestAnnotation, Class iClass, Constructor iConstructor, Method iMethods) {
		iTestAnnotation.setRetryAnalyzer(RetryTest.class);
	}

}
