package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends PageBase {



    @FindBy(xpath = "//*[@id=\"www-wikipedia-org\"]/div[1]/h1/strongs")
    public WebElement HomePageText;

    @FindBy(xpath = "//*[@id=\"www-wikipedia-org\"]/div[1]/h1/strong")
    public WebElement HomePageText2;

    @FindBy(id = "js-link-box-en")
    public WebElement englishLink;

    @FindBy(id = "mp-welcome")
    public WebElement welcomeText;

    @FindBy(id = "searchInput")
    public WebElement search;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button")
    public WebElement searchButton;

    @FindBy(id = "BooksAuthorsTable")
    public WebElement BooksAuthorsTable;

    @FindBy(tagName = "tr")
    public List<WebElement> tableRows;

    @FindBy(tagName = "td")
    public List<WebElement> rowCells;




    public boolean ViewHomePage() throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(HomePageText);

        System.out.println("Accessed Home Page");

        return true;
    }

    public boolean ViewHomePage2() throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(HomePageText2);

        var result = element.getText().equals("The Free Encyclopedia");

        return result;
    }


    public boolean search(String searchText) throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(search);
        element.sendKeys(searchText);
        element = seleniumutils.waitForElementToBeVisible(searchButton);
        element.click();
        return true;
    }

    public boolean GoToHomePage(String url) throws InterruptedException {
        driver.get(url);
        return ViewHomePage2();
    }

    public boolean ClickLanguage() throws InterruptedException {

        var element = seleniumutils.waitForElementToBeVisible(englishLink);
        element.click();

        element = seleniumutils.waitForElementToBeVisible(welcomeText);
        String expectedText = "Welcome to Wikipedia,";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Implicit wait completed");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(welcomeText));

        System.out.println("explicit wait completed");

        Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);


        fluentWait.until(ExpectedConditions.visibilityOf(welcomeText));

        System.out.println("fluent wait completed");

        element = seleniumutils.waitForElementToBeVisible(welcomeText);

        System.out.println("Generalised wait completed");

        var result = element.getText().equals(expectedText);
        return result;
    }

    public boolean GetTableData() throws InterruptedException {


        driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");


        var element = seleniumutils.waitForElementToBeVisible(BooksAuthorsTable);

        tableRows = element.findElements(By.tagName("tr"));



        System.out.println("started ");
        for(WebElement row : tableRows)
        {
            rowCells = row.findElements(By.tagName("td"));

            for(WebElement cell : rowCells)
                System.out.print(cell.getText() +"\t");
            System.out.println("\n");

        }

        return true;
    }

}
