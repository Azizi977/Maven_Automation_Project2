package ActionItems;

import Reusable_Library.ReusableLibrary.Reusable_Actions_Loggers;
import Reusable_Library.ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class AI_6 extends ReusableAnnotations {



    @Test(priority = 1)
    public void navigateToPage() throws InterruptedException {
        driver.navigate().to("https://www.us.hsbc.com/online-banking/");
        Thread.sleep(2000);
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='header-search-button va-search']", logger,"Search");
        Thread.sleep(2000);
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='q']", "Bank To Bank Transfers", logger,"Search Input");
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='header-search-button va-search']", logger, "Search");
            //sleep
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "Successfully navigated to page");
        driver.close();
    }//test 1

    @Test(priority = 2)
    public void loginAsUser() throws InterruptedException {
        driver.navigate().to("https://www.us.hsbc.com/online-banking/");
        //sleep
        Thread.sleep(2000);
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='selected-item login-button only-one-link']", logger, "Sign in");
        Thread.sleep(2000);
        logger.log(LogStatus.PASS,"Successfully clicked on Sign in button");
        Thread.sleep(2000);
        driver.close();
    }//end of test 2

    @Test(priority = 3)
    public void clickRegister() throws InterruptedException {
        driver.navigate().to("https://www.us.hsbc.com/online-banking/");
        //sleep
        Thread.sleep(2000);
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='link one-word']", logger,"Register");
        Thread.sleep(2000);
        //agree to terms 1
        Reusable_Actions_Loggers.clickAction(driver, "//*[@name='TermsAndCondition1']", logger,"Agree");
        Thread.sleep(2000);
        //agree to terms 2
        Reusable_Actions_Loggers.clickAction(driver, "//*[@name='TermsAndCondition2']", logger,"Agree");
        Thread.sleep(2000);
        //click continue
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='btnContinue']", logger,"Continue");
        Thread.sleep(2000);
        logger.log(LogStatus.PASS,"Successfully clicked on Register button");
        driver.close();
    }//end of test 3

    @Test(priority = 4)
    public void typeToChat() throws InterruptedException {
        driver.navigate().to("https://www.us.hsbc.com/online-banking/");
        //sleep
        Thread.sleep(2000);
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='LPMcontainer LPMoverlay']", logger,"Chat");
        Thread.sleep(2000);
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@aria-label='Type your message']", "Hello", logger,"Chat");
        Thread.sleep(2000);
        //hit enter to send messgae
        Reusable_Actions_Loggers.clickAction(driver, "//*[@aria-label='Send']", logger,"Send");
        Thread.sleep(2000);
        logger.log(LogStatus.PASS,"Successfully typed in chat");

    }//end of test 4

}//end of class
