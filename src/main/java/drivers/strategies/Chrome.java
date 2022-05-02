package drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.FrameworkProperties;

import java.time.Duration;

public class Chrome implements DriverStrategy {
    public WebDriver setStrategy() {
        FrameworkProperties frameworkProperties=new FrameworkProperties();
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(frameworkProperties.getProperty("chromeBinary"));
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
}
