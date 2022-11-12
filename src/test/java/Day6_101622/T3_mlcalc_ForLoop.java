package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_mlcalc_ForLoop {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        //       options.addArguments("start-maximized","incognito");
        options.addArguments("start-fullscreen");
        //       options.addArguments("headless");
        //for windows use "start-maximized
        //       options.addArguments("start-maximized");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> purchasePrice, downPayment, interestRate;
        purchasePrice = new ArrayList<>();
        purchasePrice.add("350000");
        purchasePrice.add("370000");
        purchasePrice.add("380000");

        //down payment arrayList
        downPayment = new ArrayList<>();
        downPayment.add("25");
        downPayment.add("30");
        downPayment.add("35");

        //interestRate
        interestRate = new ArrayList<>();
        interestRate.add("3.4");
        interestRate.add("4.1");
        interestRate.add("2.8");

        // for loop
        for (int i=0; i < interestRate.size(); i++) {

            //go to google page
            driver.navigate().to("https://www.mlcalc.com");
            //wait a few seconds
            Thread.sleep(3000);

            //clear and enter a new value on down payment
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            //clear the purchase price
            pPrice.clear();
            //type new value in purchase price
            pPrice.sendKeys(purchasePrice.get(i));

            //clear and enter new value for down payment
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            //clear the down payment
            dPayment.clear();
            //type new value in down payment
            dPayment.sendKeys(downPayment.get(i));

            //clear and enter new value for int rate
            WebElement intRate = driver.findElement(By.xpath("//*[@name='ir']"));
            //clear the int rate
            intRate.clear();
            //type new value in interest rate
            intRate.sendKeys(interestRate.get(i));

            //click on calculate button
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            //sleep
            Thread.sleep(2000);

            //capture and print monthly payment value
            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment: " + mntPayment);


        }//end of for loop

        //quit driver
        driver.quit();

    }//end of main
}//end of class
