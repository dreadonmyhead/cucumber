package asos;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SunglassesStepDefinitions {

    private AsosPage page = new AsosPage();

    @Given("the user is on Asos home page")
    public void navigate() {
        page.goToPage();
    }

    @And("default currency is \"([^\"]*)\"$")
    public void selectDefaultCurrency(String defaultCurrency) {
        page.selectDefaultCurrency(defaultCurrency);
    }

    @When("the user searches for the \"([^\"]*)\"$")
    public void searchForItem(String searchItem) {
        page.search(searchItem);
    }

    @And("the user sorts search results from high to low")
    public void sort() {
        page.sortFromHighToLow();
    }

    @And("the user selects the first result")
    public void firstResultSelection() {
        page.selectFirstResult();
    }

    @And("the user add item to the bag")
    public void addItemToBag() {
        page.addToBag();
    }

    @Then("item with \"([^\"]*)\" is shown in the bag")
    public void itemIsInBag(char bagCurrency) {
        page.checkItemInBag(bagCurrency);
    }
}
