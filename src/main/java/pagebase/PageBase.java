package pagebase;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.JavascriptUtils;
import utils.SeleniumUtils;

public class PageBase {

    protected WebDriver driver;
    protected SeleniumUtils seleniumutils;
    protected JavascriptUtils javascriptutils;

    protected boolean isSuccessful = false;

    public PageBase()
    {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        seleniumutils =new SeleniumUtils(driver);
        javascriptutils=new JavascriptUtils(driver);
    }
}
