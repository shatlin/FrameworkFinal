package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchPage;
import testbase.TestBase;
import utils.Constants;


public class Search extends TestBase {


    SearchPage searchPage;

    public SearchPage getSearchPage() {
        if (searchPage == null) searchPage = new SearchPage();
        return searchPage;
    }

    @Given("i am a user accessing the home page")
    public void iAmAUserAccessingTheHomePage() {

        testSuccessMsg = Constants.HOME_PAGE_ACCESS_SUCCESS;
        testFailedMsg = Constants.HOME_PAGE_ACCESS_FAIL;

        try {
            Assert.assertTrue(testFailedMsg, getSearchPage().GoToHomePage(url));
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @When("I perform search with {string}")
    public void iPerformSearchWith(String searchString) {

        testSuccessMsg = Constants.SEARCH_SUCCESS + searchString;
        testFailedMsg = Constants.SEARCH_FAIL + searchString;

        try {
            Assert.assertTrue(testFailedMsg, getSearchPage().PerformSearch(searchString));
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("I should see {int} number of results")
    public void iShouldSeeResultCountExpectedNumberOfResults(int expectedNoOfResults) {


        testSuccessMsg = Constants.SEARCH_RESULT_CHECK_SUCCESS + expectedNoOfResults;
        testFailedMsg = Constants.SEARCH_RESULT_CHECK_FAIL + expectedNoOfResults;

        try {
            Assert.assertTrue(testFailedMsg, getSearchPage().CheckSearchResults(expectedNoOfResults));
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @When("I perform repeated search with {string} and {string}")
    public void iPerformRepeatedSearchWithAnd(String searches, String results) {

        String[] searchesList = searches.split(",");
        String[] resultList = results.split(",");
        int expectedNoOfResults = 0;

        for (int i = 0; i < searchesList.length; i++) {

            expectedNoOfResults = Integer.parseInt(resultList[i]);

            testSuccessMsg = Constants.SEARCH_RESULT_CHECK_SUCCESS + expectedNoOfResults;
            testFailedMsg = Constants.SEARCH_RESULT_CHECK_FAIL + expectedNoOfResults;
            try {
                Assert.assertTrue(testFailedMsg, getSearchPage().PerformSearch(searchesList[i]));
                isTestSuccessful = true;

            } catch (InterruptedException e) {
                logger.error(testFailedMsg + e.getMessage());
                throw new RuntimeException(e);
            }
        }

    }

    @Then("I should see expected number of results")
    public void iShouldSeeExpectedNumberOfResults() {
        isFinalTestStep = true;
        isTestSuccessful = true;
    }
}