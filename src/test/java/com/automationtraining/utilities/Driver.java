package com.automationtraining.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Using the singleton design pattern to ensure each thread has its own browser
public class Driver {

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    private Driver(){ }

    /**
     * Return obj with only one WebDriver instance
     * @return same WebDriver if exists , new one if null
     */
    public static WebDriver getDriver(){
        // reading the wanted browser type from properties file
        String browserName = ConfigReader.read("browser") ;

        // get method from InheritableThreadLocal will check if we have an object in this thread or not
        // if not it will return null
        if(driverPool.get() == null){

            // according to browser type set up driver correctly
            switch (browserName ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set( new FirefoxDriver());
                    break;
                // other browsers omitted
                default:
                    driverPool.set(null);
//                    obj = null ;
                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
            }
            return driverPool.get() ;


        }else{

            return driverPool.get();

        }

    }

    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quited driver
     */
    public static void closeBrowser(){

        // check if we have WebDriver instance or not and making it null
        if(driverPool.get() != null ){
            driverPool.get().quit();
            driverPool.set(null);     //

        }

    }
}
