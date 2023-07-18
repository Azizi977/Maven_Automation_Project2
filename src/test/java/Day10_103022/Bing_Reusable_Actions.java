package Day10_103022;

import Reusable_Library.ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;

public class Bing_Reusable_Actions {
    public static void main(String[] args) {
        WebDriver driver = ReusableActions.setUpDriver();
        //navigate
        driver.navigate().to("https://www.bing.com");

        //enter a keyword in search field using reusable method
        ReusableActions.sendKeysAction(driver,"//*[@name='q']","soccer","Search Field");

        //click on search icon using reusable method
        ReusableActions.clickAction(driver,"//*[@id='search_icon']","Search Icon");

        //capture the result and extract out the number
        String result = ReusableActions.getTextAction(driver,"//*[@class='sb_count']","Search Results");
        System.out.println("Result is " + result);
    }//end of main
}//end of class
