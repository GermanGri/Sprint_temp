package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;

public class BasePage {

    private static final Logger LOG = LogManager.getLogger(BasePage.class);

    private final WebDriver driver;
    private final int ONE_SEC_IN_MILL = 1000;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void fillText(String locator, String text) {
        LOG.info(format("Trying to fill: %s", text));
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public WebElement getElement(String locator) {
        LOG.info(format("Trying to get Element: %s", locator));
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> getElements(String locator) {
        LOG.info("Trying to get Elements");
        return driver.findElements(By.xpath(locator));
    }

    public void scrollToElement(String locator) throws InterruptedException {
        LOG.info("Trying to scroll to Elements");
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(ONE_SEC_IN_MILL);
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        LOG.info("Trying to scroll to Elements");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(ONE_SEC_IN_MILL);
    }

    public void clickWithDefaultTimeout(WebDriver driver, WebElement element) {
        LOG.info("Trying to click on Elements");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        try {
            Thread.sleep(ONE_SEC_IN_MILL);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Timeout interrupted", e);
        }
    }

    public void clickWithDefaultTimeout(WebDriver driver, By locator) {
        LOG.info("Trying to click on Elements");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(ONE_SEC_IN_MILL));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

}
