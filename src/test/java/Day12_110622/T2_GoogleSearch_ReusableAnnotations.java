package Day12_110622;

import Reusable_Library.ReusableLibrary.Reusable_Actions_Loggers;
import Reusable_Library.ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotations extends ReusableAnnotations {

    @Test
    public void searchForBmw(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']", "BMW",logger, "Search Field");
        //hit submit on google search button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBmw")
    public void captureSearchNumber(){
        //capture the search resykts text
        String results = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='result-stats']", logger, "Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html report by using log info
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
    }//end of test 2


}//end of class
