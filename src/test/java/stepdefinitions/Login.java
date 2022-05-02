package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {



    @Given("i am a user accessing the login page with {int}")
    public void i_am_a_user_accessing_the_login_page_with(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
            System.out.println("i am Formbay User for homepage testing with "+int1);
    }


//    @When("I enter username {string} and password {string}")
//    public void iEnterUserNameAndPassword(String username,String password) {
//    }




    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
    }

    @Then("system should authenticate me")
    public void system_should_authenticate_me() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("system should authenticate me");
    }


}