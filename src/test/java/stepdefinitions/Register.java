package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserModel;
import org.junit.Assert;
import pages.RegisterPage;
import pages.SearchPage;
import testbase.TestBase;
import utils.Constants;

import java.lang.reflect.Type;
import java.util.List;

import models.UserModel;

public class Register extends TestBase {

    RegisterPage registerPage;

    public RegisterPage getRegisterPage() {
        if (registerPage == null) registerPage = new RegisterPage();
        return registerPage;
    }

    @When("I click on Sign-in link")
    public void iClickOnSignInLink() {

        testSuccessMsg = Constants.NOT_IMPLEMENTED_SUCCESS;
        testFailedMsg = Constants.NOT_IMPLEMENTED_FAIL;
        try {
            Assert.assertTrue(testFailedMsg, getRegisterPage().openSignInPage());
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Then("I should see authentication page")
    public void iShouldSeeAuthenticationPage() {

        isTestSuccessful = true;
    }

    @When("I enter email address and click Create Account")
    public void iEnterEmailAddressAndClickCreateAccount(DataTable dataTable) {

        String email = dataTable.rows(0).column(0).get(0);

        testSuccessMsg = Constants.NOT_IMPLEMENTED_SUCCESS;
        testFailedMsg = Constants.NOT_IMPLEMENTED_FAIL;
        try {
            Assert.assertTrue(testFailedMsg, getRegisterPage().openCreateAccountPage(email));
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("system should display create Account Page")
    public void systemShouldDisplayCreateAccountPage() {
        isTestSuccessful = true;
    }

    @Then("I populate all user fields and Register")
    public void iPopulateAllUserFieldsAndRegister(DataTable dataTable) {
        var row = dataTable.rows(1);

        UserModel.UserRecord userRecord = new UserModel.UserRecord(
                row.column(0).get(0),
                row.column(1).get(0),
                row.column(2).get(0),
                row.column(3).get(0),
                row.column(4).get(0),
                row.column(5).get(0),
                row.column(6).get(0),
                row.column(7).get(0),
                row.column(8).get(0),
                row.column(9).get(0),
                row.column(10).get(0),
                row.column(11).get(0),
                row.column(12).get(0),
                row.column(13).get(0),
                row.column(14).get(0),
                row.column(15).get(0),
                row.column(16).get(0),
                row.column(17).get(0),
                row.column(18).get(0)
        );

        testSuccessMsg = Constants.NOT_IMPLEMENTED_SUCCESS;
        testFailedMsg = Constants.NOT_IMPLEMENTED_FAIL;
        try {
            Assert.assertTrue(testFailedMsg, getRegisterPage().PerformRegistration(userRecord));
            isTestSuccessful = true;

        } catch (InterruptedException e) {
            logger.error(testFailedMsg + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
