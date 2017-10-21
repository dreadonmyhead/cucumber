package calculator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private WebDriver driver = InitializeWebDriver.driver;

    public void goToPage() {
        driver.get("https://www.swedbank.lt/lt/spreadsheets/consumer2");
    }

    public void insertFirstAmount(String amount) {
        WebElement firstInput = driver.findElement(By.id("SpreadsheetRequestedLoanAmount"));
        firstInput.clear();
        firstInput.sendKeys(amount);
    }

    public void calculate() {
        WebElement buttonSubmit = driver.findElement(By.id("SpreadsheetHasOutstandingLoan1"));
        buttonSubmit.submit();
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#consumerResults")));
    }

    public void assertMessage(String msg) {
        waitForPageLoad();
        WebElement errorMsg = driver.findElement(By.xpath("//span[contains(@class, 'consumer-invalid-txt')]"));
        Assert.assertEquals("Text message was change", msg, errorMsg.getText());
    }
}
