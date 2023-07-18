package Day12_110622;

import Reusable_Library.ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_YahooScenario_ReusableAnnotations extends ReusableAnnotations {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = '_yb_1933e']")).click();
        logger.log(LogStatus.PASS,"Successfully clicked on Sign in button");

        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
//hviyvi
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click on check box to uncheck it
        driver.findElement(By.xpath("//*[@class= 'stay-signed-in checkbox-container']")).click();
        logger.log(LogStatus.PASS,"Successfully unchecked on checkbox");

        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 2
}
