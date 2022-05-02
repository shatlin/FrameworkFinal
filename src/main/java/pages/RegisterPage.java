package pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import io.cucumber.java.eo.Se;
import models.UserModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pagebase.PageBase;

public class RegisterPage extends PageBase {

    @FindBy(className = "login")
    public WebElement lnkSignIn;

    @FindBy(id = "email_create")
    public WebElement tbxEmailId;

    @FindBy(id = "SubmitCreate")
    public WebElement btnCreate;

    @FindBy(id = "id_gender1")
    public WebElement radTitleMr;

    @FindBy(id = "id_gender2")
    public WebElement radTitleTMrs;

    @FindBy(id = "customer_firstname")
    public WebElement txtCustFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement txtCustLastName;

    @FindBy(id = "passwd")
    public WebElement txtPassword;

    @FindBy(id = "days")
    public WebElement selDays;

    @FindBy(id = "months")
    public WebElement selMonths;


    @FindBy(id = "years")
    public WebElement selYears;

    @FindBy(id = "newsletter")
    public WebElement chkNewsletter;

    @FindBy(id = "days")
    public WebElement chkOptIn;

    @FindBy(id = "firstname")
    public WebElement txtFirstName;


    @FindBy(id = "lastname")
    public WebElement txtLastName;

    @FindBy(id = "company")
    public WebElement selCompany;

    @FindBy(id = "address1")
    public WebElement txtAddress1;

    @FindBy(id = "address2")
    public WebElement txtAddress2;

    @FindBy(id = "city")
    public WebElement txtCity;


    @FindBy(id = "id_state")
    public WebElement selState;

    @FindBy(id = "postcode")
    public WebElement txtPostCode;

    @FindBy(id = "other")
    public WebElement txtAdditionalInfo;

    @FindBy(id = "phone")
    public WebElement txtPhone;

    @FindBy(id = "phone_mobile")
    public WebElement txtMobilePhone;


    @FindBy(id = "submitAccount")
    public WebElement btnSubmitAccount;
    public boolean openSignInPage() throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(lnkSignIn);
        element.click();
        return true;
    }

    public boolean openCreateAccountPage(String email) throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(tbxEmailId);
        element.sendKeys(email);
        element = seleniumutils.waitForElementToBeVisible(btnCreate);
        element.click();
        return true;
    }


    public boolean PerformRegistration(UserModel.UserRecord userRecord) throws InterruptedException {


        Actions hover=new Actions(driver);
        hover.moveToElement(radTitleMr).build().perform();
        if (userRecord.Title().equals("Mr."))
            seleniumutils.waitForElementToBeVisible(radTitleMr).click();
        if (userRecord.Title().equals("Mrs."))
            seleniumutils.waitForElementToBeVisible(radTitleTMrs).click();
        seleniumutils.waitForElementToBeVisible(txtCustFirstName).sendKeys(userRecord.FirstName());

        hover.moveToElement(txtCustFirstName).build().perform();
        seleniumutils.waitForElementToBeVisible(txtCustLastName).sendKeys(userRecord.LastName());

        hover.moveToElement(txtPassword).build().perform();
        seleniumutils.waitForElementToBeVisible(txtPassword).sendKeys(userRecord.Password());
        new Select(selDays).selectByValue(userRecord.DateOfBirth());
        new Select(selMonths).selectByVisibleText(userRecord.MonthOfBirth()+" ");
        new Select(selYears).selectByValue(userRecord.YearOfBirth());
        javascriptutils.scrollIntoView(chkNewsletter);
        chkNewsletter.click();
        chkOptIn.click();
        javascriptutils.scrollIntoView(txtFirstName);
        hover.moveToElement(txtFirstName).build().perform();

        seleniumutils.waitForElementToBeVisible(txtFirstName).sendKeys(userRecord.FirstName());
        seleniumutils.waitForElementToBeVisible(txtLastName).sendKeys(userRecord.LastName());
        seleniumutils.waitForElementToBeVisible(selCompany).sendKeys(userRecord.Company());
        javascriptutils.scrollIntoView(selCompany);
        seleniumutils.waitForElementToBeVisible(txtAddress1).sendKeys(userRecord.Address1());
        seleniumutils.waitForElementToBeVisible(txtAddress2).sendKeys(userRecord.Address2());
        seleniumutils.waitForElementToBeVisible(txtCity).sendKeys(userRecord.City());
        javascriptutils.scrollIntoView(txtCity);
        hover.moveToElement(txtCity).build().perform();
        new Select(selState).selectByVisibleText(userRecord.State());
        seleniumutils.waitForElementToBeVisible(txtPostCode).sendKeys(userRecord.Zip());
        seleniumutils.waitForElementToBeVisible(txtAdditionalInfo).sendKeys(userRecord.Additional_Information());
        seleniumutils.waitForElementToBeVisible(txtPhone).sendKeys(userRecord.HomePhone());
        seleniumutils.waitForElementToBeVisible(txtMobilePhone).sendKeys(userRecord.MobilePhone());
        javascriptutils.scrollIntoView(txtMobilePhone);

        seleniumutils.waitForElementToBeVisible(btnSubmitAccount).click();

        return true;
    }

}
