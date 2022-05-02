package stepdefinitions;

import io.cucumber.java.*;


import java.io.IOException;

import  testbase.TestBase;

public class Hooks extends TestBase{


    @Before
    public void before(Scenario scenario) throws IOException {

        try {
            GetTestBase().beforeScenario(scenario.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @After
    public void after(Scenario scenario) throws IOException {

        GetTestBase().afterScenario(scenario.getName());

    }

    @BeforeStep
    public void BeforeStep() throws IOException {
    }

    @AfterStep
    public void afterStep() throws IOException {
        GetTestBase().afterTestStep();
    }

}