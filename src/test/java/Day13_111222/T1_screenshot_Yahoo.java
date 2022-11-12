package Day13_111222;

import ReusableLibrary.Reusabale_Actions_Loggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_screenshot_Yahoo extends ReusableAnnotations {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        //this will fail because the xpath is incorrect (screenshot should be attached to the report
        Reusabale_Actions_Loggers.clickAction(driver, "//*[@class = '_yb_1933eyyyy']", logger, "Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
//ouo
    @Test(priority = 2)
    public void tc001_verifyYahooSignInText() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com");
        //define our expected string variable
        String actualYahooSignInButtonText = Reusabale_Actions_Loggers.getTextAction(driver, "//*[@class = '_yb_1933eyyyy']", logger, "Sign In");
        //define expected string text
        String expectedYahooSignInButtonText = "Sign In";
        Reusabale_Actions_Loggers.compareExpectedAndActualText(expectedYahooSignInButtonText, actualYahooSignInButtonText,logger);
    }//end of test 2
}//end of class
