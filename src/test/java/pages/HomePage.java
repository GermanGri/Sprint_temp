package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.locators.HomePageLocators;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage implements HomePageLocators {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public List<String> getQuestionHeaderLabels() {
        LOG.info("Trying to get Question Header Labels");
        List<String> headerLabelsList = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath(accordionHeaderLabelsListXpath))) {
          headerLabelsList.add(element.getText());
        }
        return headerLabelsList;
    }

    public List<String> getAnswerLabels() {
        LOG.info("Trying to get Answers List Labels");
        List<String> answerLabelsList = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath(accordionDescriptionListXpath))) {
            answerLabelsList.add(element.getText());
        }
        return answerLabelsList;
    }

    public void clickOnOrder(boolean isTopButton) throws InterruptedException {
        if (isTopButton) {
            clickToTopOrderButton();
        } else {
            clickToBottomOrderButton();
        }
    }


    public void clickToTopOrderButton() {
        LOG.info("Trying to click on top Order button");
        clickWithDefaultTimeout(driver, getElement(topOrderButton));
    }

    public void clickToBottomOrderButton() throws InterruptedException {
        LOG.info("Trying to click on bottom Order button");
        scrollToElement(getElement(bottomOrderButton));
        clickWithDefaultTimeout(driver, getElement(bottomOrderButton));
    }
}
