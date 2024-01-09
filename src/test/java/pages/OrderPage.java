package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.locators.OderPageLocaator;

import static java.lang.String.format;

public class OrderPage extends HomePage implements OderPageLocaator {
    private static final Logger LOG = LogManager.getLogger(OrderPage.class);

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setSubwayStation(String stationName) {
        LOG.info(format("Trying to set Subway: %s station", stationName));
        clickWithDefaultTimeout(driver, getElement(subwayStationInputXpath));
        fillText(subwayStationInputXpath, stationName);
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(subwayStationInputXpath), Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build().perform();
    }

    public void clickOnContinueButton() {
        LOG.info("Trying to click on continue  button");
        clickWithDefaultTimeout(driver, getElement(continueButtonXpath));
    }

    public void clickOnOrderButton() {
        LOG.info("Trying to click on order  button");
        clickWithDefaultTimeout(driver, getElement(orderButtonXpath));

    }

    public void clickOnconfirmOrderButton() {
        LOG.info("Trying to click on confirm button");
        clickWithDefaultTimeout(driver, getElement(confirmButton));
    }

    public void confirmOrderButton() {
        clickOnOrderButton();
        clickOnconfirmOrderButton();
    }

    public void selectRentDate(String rentDate) throws InterruptedException {
        LOG.info(format("Trying to select: %s rent date", rentDate));
        clickWithDefaultTimeout(driver, getElement(rentDateInputXpath));
        for (WebElement element: getElements(rentDateValuesList)) {
            if (element.getText().equalsIgnoreCase(rentDate)) {
                scrollToElement(element);
                element.click();
                break;
            }
        }
    }

    public void setDeliveryDate(String date) {
        LOG.info(format("Trying to set delivery date: %s rent date", date));
        fillText(dateOfDeliveryInputXpath, date);
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(dateOfDeliveryInputXpath))
                .sendKeys(Keys.ENTER).build().perform();
    }

    public void selectScooterColor(String color) {
        LOG.info(format("Trying to set scooter color: %s rent date", color));
        if (color.equals("чёрный жемчуг")) {
            getElements(scooterColorCheckboxList).get(0).click();
        } else if (color.equals("серая безысходность")) {
            getElements(scooterColorCheckboxList).get(1).click();
        } else if (color.equals("все цвета")) {
            getElements(scooterColorCheckboxList).get(0).click();
            getElements(scooterColorCheckboxList).get(1).click();
        }
        else {
            System.out.printf("Color selection not necessary");
        }
    }

    public void confirmOrder() {
        LOG.info("Trying to confirm order");
        isElementPresent(modalHeader);
        clickWithDefaultTimeout(driver, getElement(confirmButton));
        clickWithDefaultTimeout(driver, getElement(checkStatusButton));
    }

    public String getOrderStatus() {
        LOG.info("Trying to get order status");
        return getElement(orderStatusLabel).getText();
    }
}
