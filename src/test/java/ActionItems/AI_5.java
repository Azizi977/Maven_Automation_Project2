package ActionItems;

import ReusableLibrary.ReusabaleActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AI_5 {
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusabaleActions.setUpDriver();
    }//end of suite

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test()
    public void NavigateToSite() throws InterruptedException {
        //navigate to uhc
        driver.navigate().to("https://www.uhc.com");
        //sleep statement
        Thread.sleep(2000);
        //click on find a doctor
        ReusabaleActions.clickAction(driver, "//*[@id='mobile-icon-find-doctor']", "Find a Doctor");
        Thread.sleep(2000);

        //handle popup
        try {
            WebElement weValueYourFeedback = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
            if (weValueYourFeedback.isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='ip-no']")).click();
            }//end of if condition
        } catch (Exception e) {
            System.out.println("Unable to find pop up window " + e);
        }//end of pop up window exception

        //sleep
        Thread.sleep(2000);
        //scroll to view by find a dentist
        ReusabaleActions.scrollByView(driver, "//*[text()='Find a dentist]", "Find a dentist");
        //sleep
        Thread.sleep(2000);
        //click on find a dentist
        ReusabaleActions.clickAction(driver, "//*[text()='Find a dentist']", "Find a dentist");
        //sleep
        Thread.sleep(2000);

        //switch to new tab
        ReusabaleActions.switchToTabByIndex(driver, 1, "switch to new tab");

    }
}//end of class
