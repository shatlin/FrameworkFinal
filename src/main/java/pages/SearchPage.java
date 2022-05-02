package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v99.storage.model.InterestGroupAccessed;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import java.security.interfaces.ECKey;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPage extends PageBase {



    @FindBy(id = "header_logo")
    public WebElement divHeaderLogo;

    @FindBy(id = "search_query_top")
    public WebElement tbxSearch;

    @FindBy(name = "submit_search")
    public WebElement btnSubmitSearch;

    @FindBy(css = "#center_column > h1")
    public WebElement h1SearchResultHeader;


    public boolean GoToHomePage(String url) throws InterruptedException {

        driver.get(url);
        var element = seleniumutils.waitForElementToBeVisible(divHeaderLogo);
        return element!=null;
    }

    public boolean PerformSearch(String searchInput) throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(tbxSearch);
        element.clear();
        element.sendKeys(searchInput);
        element = seleniumutils.waitForElementToBeVisible(btnSubmitSearch);
        element.click();
        element = seleniumutils.waitForElementToBeVisible(h1SearchResultHeader);
        return element!=null;
    }


    public boolean CheckSearchResults(int expectedCount) throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(h1SearchResultHeader);
        var searchResultText=element.getText();

        String ResultSet=searchResultText.split("\n")[1];
        int actualCount=Integer.parseInt( ResultSet.split(" ")[0]);
        return actualCount==expectedCount;

    }

}
