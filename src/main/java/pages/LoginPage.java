package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagebase.PageBase;

public class LoginPage extends PageBase {



    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//*[@id='new_login']/input")
    private WebElement Continue;


    public boolean login() throws InterruptedException {

        seleniumutils.waitForElementToBeVisible(username).sendKeys("client_trade");
        seleniumutils.waitForElementToBeVisible(password).sendKeys("client_trade");
        Thread.sleep(3000);
        System.out.println("Login Page accessed");
        return true;
    }
}
