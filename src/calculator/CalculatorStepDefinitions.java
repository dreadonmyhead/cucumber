package calculator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepDefinitions {

    private CalculatorPage page = new CalculatorPage();

    @Given("the user is on Swedbank loan calculator page")
    public void navigate() {
        page.goToPage();
    }

    @When("the user inserts \"([^\"]*)\" amount to desirable loan field")
    public void insertAmount(String amount) {
        page.insertFirstAmount(amount);
    }

    @And("the user presses Calculate button")
    public void clickCalculate() {
        page.calculate();
    }

    @Then("\"([^\"]*)\" message is shown")
    public void checkMessage(String message) {
        page.assertMessage(message);
    }
}
