package tests;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.locators.HomePageLocators;

import static org.junit.Assert.assertTrue;

public class HomePageVerificationTest extends BaseTest {

    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    public void pageVerificationTest() {
        driver.get(configReader.getUrl());
        assertTrue("Yandex link is not exist", homePage.isElementPresent(HomePageLocators.yandexHomeLinkXpath));
        assertTrue("Yandex image is not exist", homePage.isElementPresent(HomePageLocators.yandexImageXpath));
        assertTrue("Scooter link is not exist", homePage.isElementPresent(HomePageLocators.scooterHomeLinkXpath));
        assertTrue("Scooter image is not exist", homePage.isElementPresent(HomePageLocators.scooterImageXpath));
        assertTrue("Trainig simulator image is not exist", homePage.isElementPresent(HomePageLocators.trainingSimulatorLabeleXpath));
        assertTrue(homePage.isElementPresent(HomePageLocators.homeHeaderLabelXpath));
        assertTrue(homePage.isElementPresent(HomePageLocators.homeSubHeaderLabelXpath));
        assertTrue(homePage.isElementPresent(HomePageLocators.topOrderButton));
        assertTrue(homePage.isElementPresent(HomePageLocators.topOrderStatusButton));
        assertTrue(homePage.isElementPresent(HomePageLocators.bottomOrderButton));
    }

}
