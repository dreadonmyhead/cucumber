package asos;

import helper.InitializeWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AsosPage {

    private WebDriver driver = InitializeWebDriver.driver;

    public void goToPage() {
        driver.get("http://www.asos.com/");
    }

    public void selectDefaultCurrency(String defaultCurrency) {
        WebElement currencyArrow = driver.findElement(By.cssSelector(".menu-arrow"));
        currencyArrow.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.menu")));

        Select currencyDropDown = new Select(driver.findElement(By.id("currencyList")));
        WebElement neededCCY = driver.findElement(By.xpath("//option[@data-label='" + defaultCurrency + "']"));
        currencyDropDown.selectByVisibleText(neededCCY.getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".selected-currency"), defaultCurrency));
    }

    public void search(String searchItem) {
        WebElement searchField = driver.findElement(By.id("txtSearch"));
        WebElement searchIcon = driver.findElement(By.cssSelector(".go"));
        searchField.sendKeys(searchItem);
        searchIcon.click();
    }

    public void sortFromHighToLow() {
        Select sortDropDown = new Select(driver.findElement(By.id("sortBy")));
        sortDropDown.selectByValue("pricedesc");
    }

    public void selectFirstResult() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("sortBy"), "Price high to low"));

        WebElement resultTable = driver.findElement(By.cssSelector("div.results.three-grid"));
        List<WebElement> allResults = resultTable.findElements(By.cssSelector(".product-container.interactions"));
        allResults.get(0).findElement(By.cssSelector(".product.product-link")).click();
    }

    public void addToBag() {
        WebElement addToBagButton = driver.findElement(By.cssSelector(".add-item"));
        addToBagButton.click();
    }

    public void checkItemInBag(char bagCurrency) {
        WebElement actualBagCurrency = driver.findElement(By.cssSelector(".bag-link-price"));
        Assert.assertEquals("Currencies does not match!", bagCurrency, actualBagCurrency.getText().charAt(0));
    }
}
