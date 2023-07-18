package ActionItems;

import Reusable_Library.ReusableLibrary.ReusableActions;
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
        driver = ReusableActions.setUpDriver();
    }//end of suite


    @Test()
    public void tc001_NavigateToSite() throws InterruptedException {
        //navigate to uhc
        driver.navigate().to("https://www.uhc.com/find-a-doctor");
        //sleep
        Thread.sleep(3000);
        //handle popup
        try {
            WebElement weValueYourFeedback = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
            if (weValueYourFeedback.isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='ip-no']")).click();
            }//end of if condition
        } catch (Exception e) {
            System.out.println("Unable to find pop up window " + e);
        }//end of pop up window exception
        //click on find a doctor
        ReusableActions.clickAction(driver, "//*[@id = 'mobile-icon-find-doctor']", "Find a doctor");
        //scroll to view by find a dentist
        ReusableActions.scrollByView(driver, "//*[text()='Find a dentist]", "Find a dentist");
        //click on find a dentist
        ReusableActions.clickAction(driver, "//*[text()='Find a dentist']", "Find a dentist");
        //switch to new tab
        ReusableActions.switchToTabByIndex(driver, 1, "switch to new tab");
        //click on Employer and Individual Plan
        ReusableActions.clickActionByIndex(driver, "//*[@class='imgBox']", 0, "Click on employer and individual Plan");
    }//end of test 1

    @Test()
    public void tc002_zipCode() throws InterruptedException {
        //click on search
        ReusableActions.clickAction(driver, "//*[@id='location']", "Click on search box");
        //sleep
        Thread.sleep(2000);
        //enter a zip code
        ReusableActions.sendKeysAction(driver, "//*[@id='location']", "11004", "Entering zipcode");
        //click on first zipcode option from the list
        ReusableActions.clickAction(driver, "//*[@class='link result truncated ally-focus-within active']", "Click on search box");
        //click on continue
        ReusableActions.clickAction(driver, "//*[contains(@class,'action-btn')]", "Click on continue");
        Thread.sleep(2000);
        //click on national option PPO 30
        ReusableActions.clickAction(driver, "//*[@data-ui-element-name='*National Options PPO 30']", "Click on national options PPO 30");
        //sleep
        Thread.sleep(3000);
        //refresh driver
        driver.navigate().refresh();
        //sleep
        Thread.sleep(3000);
        //change location
        ReusableActions.clickAction(driver, "//*[@class='location']", "Click on location");
        //reenter zip
        ReusableActions.sendKeysAction(driver, "//*[@id='location']", "11004", "Entering zipcode");
        //click on first zip
        ReusableActions.clickAction(driver, "//*[@class='link result truncated ally-focus-within active']", "Click on search box");
        //click update
        ReusableActions.clickAction(driver, "//*[@class='action-btn dialog-btn']", "Click on update box");
        //click on general dentist
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-jgPyTC gXqeMb']", 0, "Click on General Dentist");
    }//end of test 2

    @Test()
    public void tc003_captureAddress() throws InterruptedException {
        //select a mile from the dropdown
        ReusableActions.selectByText(driver, "//*[contains(@id,'radius-miles-dropdown')]", "Within 20 Miles", "Select Mile Radius");
        //sleep
        Thread.sleep(3000);
        //click on first doctor name you see on the list
        ReusableActions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "Click");
        //click on save button
        ReusableActions.clickAction(driver, "//*[contains(@class,'cta-header-button action-btn saved')]", "Click on save button");
        //capture info
        //capture address
        String addressValue = ReusableActions.getTextAction(driver, "//*[@id='label__selectedLocation0']", "Capture address");
        //capture miles
        String milesValue = ReusableActions.getTextAction(driver, "//*[@data-test-id='distance-away']", "Capture miles");
        //capture network
        String networkValues = ReusableActions.getTextAction(driver, "//*[@value='::location.inNetwork']", "Capture network");
        //print out the values of address, miles, network
        System.out.println("Address: " + addressValue + "\n" + "Miles: " + milesValue + "\n" + "Network: " + networkValues);
        //close tab
        driver.close();
    }//end of test 3

    @Test()
    public void tc004_result() {
        //switch to default tab
        ReusableActions.switchToTabByIndex(driver, 0, "switch to tab");
        //click on search field
        ReusableActions.clickAction(driver, "//*[id='search-desktop']", "Click on search field");
        //enter "doctor" on search field
        ReusableActions.sendKeysAction(driver, "//*[@id='search-desktop']", "doctor", "Enter keyword in search field");
        //click on search
        ReusableActions.clickAction(driver, "//*[@id='search__button-desktop']", "Click on search button");
        //capture the search result
        String capture = ReusableActions.getTextAction(driver, "//*[@id='search-results-count__header']", "Capture the search result");
        //extract only first 3 values from search result
        String[] splitCapture = capture.split(" ");
        System.out.println("The search result for doctor: " + splitCapture[0] + " " + splitCapture[1] + " " + splitCapture[2]);
    }//end of test 4

    @AfterSuite
    public void QuitTheSession() {
        driver.quit();
    }//end of after suite and quit session

}//end of class
