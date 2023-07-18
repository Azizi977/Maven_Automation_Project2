package Day13_111222;

import Reusable_Library.ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_StringComparison extends ReusableAnnotations {
    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://yahoo.com");
        //define our expected string variable
        String expectedTitle = "Yahoo..";
        //get page title
        String actualTitle = driver.getTitle();
        System.out.println("My actual title is: " + actualTitle);
        System.out.println("My exoected title is: " + expectedTitle);

        if(actualTitle.equals(expectedTitle)){
            logger.log(LogStatus.PASS, "Expected Result matches Actual Result");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Result does not match Actual Result");
        }
    }//end of test 1
}//end of class
