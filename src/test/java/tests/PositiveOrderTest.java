package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import pages.OrderPage;
import pages.locators.OderPageLocaator;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PositiveOrderTest extends BaseTest {

    private String name;
    private String lastName;
    private String address;
    private String subwayStation;
    private String phoneNumber;
    private String deliveryDate;
    private String rentDate;
    private String colorScooter;
    private String comment;
    private String statusOrder;
    private boolean isTopButton;


    private HomePage homePage;
    private OrderPage orderPage;

    public PositiveOrderTest(String name, String lastName,
                             String address, String subwayStation,
                             String phoneNumber,
                             String deliveryDate,
                             String rentDate,
                             String colorScooter,
                             String comment,
                             String statusOrder,
                             boolean isTopButton) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentDate = rentDate;
        this.colorScooter = colorScooter;
        this.comment = comment;
        this.statusOrder = statusOrder;
        this.isTopButton = isTopButton;
    }

    @Before
    public void setUp() {
        driver.get(configReader.getUrl());
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data2() {
        return Arrays.asList(new Object[][]{
                // Rent date cases
                {"Герман", "Грибанов", "Москва", "Бульвар Рокоссовского", "+79371171717",
                        "10.01.2099", "сутки", "чёрный жемчуг", "комментарий", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "двое суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "трое суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "четверо суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "пятеро суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "шестеро суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "семеро суток", "чёрный жемчуг", "комментарий22", "Заказ оформлен", true},
                 // Color scooter cases
                {"Герман", "Грибанов", "Москва", "Бульвар Рокоссовского", "+79371171717",
                        "10.01.2099", "сутки", "серая безысходность", "комментарий", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "двое суток", "серая безысходность", "комментарий22", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "трое суток", "серая безысходность", "комментарий22", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "четверо суток", "серая безысходность", "комментарий22", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "пятеро суток", "серая безысходность", "комментарий44", "Заказ оформлен", false},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "шестеро суток", "серая безысходность", "комментарий22", "Заказ оформлен", true},
                {"Иван", "Иванов", "Йошкар-Ола", "Сокольники", "+99371171717",
                        "10.01.2033", "семеро суток", "серая безысходность", "комментарий44", "Заказ оформлен", false},
                // without scooter color
                {"Герман", "Грибанов", "Москва", "Бульвар Рокоссовского", "+79371171717",
                        "10.01.2099", "сутки", "нет цвета", "комментарий", "Заказ оформлен", true},
                // without scooter color
                {"Герман", "Грибанов", "Москва", "Бульвар Рокоссовского", "+79371171717",
                        "10.01.2099", "сутки", "все цвета", "комментарий", "Заказ оформлен", false},
        });
    }

    @Test
    public void positiveOrderScenario() throws InterruptedException {
        homePage.clickOnOrder(isTopButton);
        Assert.assertTrue(orderPage.isElementPresent(OderPageLocaator.headerXpath));
        orderPage.fillText(OderPageLocaator.nameInputXpath, name);
        orderPage.fillText(OderPageLocaator.lastInputXpath, lastName);
        orderPage.fillText(OderPageLocaator.addressInputXpath, address);
        orderPage.setSubwayStation(subwayStation);
        orderPage.fillText(OderPageLocaator.phoneNumberInputXpath, phoneNumber);
        orderPage.clickOnContinueButton();
        orderPage.setDeliveryDate(deliveryDate);
        orderPage.selectRentDate(rentDate);
        orderPage.selectScooterColor(colorScooter);
        orderPage.fillText(OderPageLocaator.commentsInputXpath, comment);
        orderPage.confirmOrderButton();
        Assert.assertTrue(orderPage.getOrderStatus().contains(statusOrder));
    }
}
