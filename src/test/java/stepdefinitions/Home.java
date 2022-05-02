package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import testbase.TestBase;


public class Home extends TestBase {
    pages.HomePage homePage;

    public pages.HomePage getHomePage()
    {
        if(homePage==null)
            homePage=new pages.HomePage();
        return homePage;
    }
    @Given("i am authorized user")
    public void iAmAuthorizedUser() {
        System.out.println("i am authorized user");
    }

    @When("i access home page")
    public void iAccessHomePage() throws InterruptedException
    {
        Assert.assertTrue("Couldn't Access Home Page", getHomePage().ViewHomePage());
    }

    @When("i access home page differently")
    public void iAccessHomePageDifferently() throws InterruptedException
    {
        Assert.assertTrue("Couldn't Access Home Page", getHomePage().ViewHomePage2());
        logger.info("Home Page Accessed");
        Assert.assertTrue("Clicking English link unsuccessful", getHomePage().ClickLanguage());
        logger.info("Clicking English link successful");

        Assert.assertTrue("Couldn't Access Home Page", getHomePage().GoToHomePage(url));
        logger.info("Home Page Accessed");

        Assert.assertTrue("Search failed",getHomePage().search("Nagercoil"));
        logger.info("search successful");

        getHomePage().GetTableData();


    }

    @Then("system should display Home Page")
    public void systemShouldDisplayHomePage()
    {
        System.out.println("system should display Home Page");
    }

}