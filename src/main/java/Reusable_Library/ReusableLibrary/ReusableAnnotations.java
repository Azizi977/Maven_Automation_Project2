package Reusable_Library.ReusableLibrary;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotations {
    //this need to get inherited to your test class but in order to do that
    //it must public st
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;
    @BeforeSuite
    public void setTheDriver(){
        driver = ReusableActions.setUpDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html", true);
    }//end of before suite

    @BeforeMethod
    public void captureTestName(Method testName){
        //before every test this method will be called and take the name of your test
        //it will add your test method name to the html report
        logger = reports.startTest(testName.getName());
    }//end of before method

    @AfterMethod
    public void endLogger(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
        //writing back to one html report
        reports.flush();
    }//end of after suite
}//end of class
