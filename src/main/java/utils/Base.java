package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class Base {

    public WebDriver driver;
    public ConfigReader config;

    public Base(){
        this.config = ConfigFactory.create(ConfigReader.class);
    }

    public WebDriver getDriverInstance(){

        String browserName = "Chrome";//config.browser();
        System.out.println(config.browser());
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.getInstance(CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox","--disable-gpu","--disable-extensions","--headless");
            driver = new ChromeDriver(options);
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.getInstance(FIREFOX).setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;

    }


}
