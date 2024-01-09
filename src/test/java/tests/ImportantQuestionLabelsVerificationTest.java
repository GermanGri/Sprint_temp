package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.locators.HomePageLocators;
import pages.HomePage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class ImportantQuestionLabelsVerificationTest extends BaseTest {

    private HomePage homePage;

    private String input;
    private int index;
    private String questionAnswer;


    public ImportantQuestionLabelsVerificationTest(String input, int index, String questionAnswer) {
        this.input = input;
        this.index = index;
        this.questionAnswer = questionAnswer;
    }



    @Before
    public void setUp() {
        driver.get(configReader.getUrl());
        homePage = new HomePage(driver);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сколько это стоит? И как оплатить?", 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }


    @Test
    public void importantQuestionLabelsVerificationTest() throws InterruptedException {

        List<String> listActualQuestionLabelsHeader = homePage.getQuestionHeaderLabels();
        Assert.assertEquals(input, listActualQuestionLabelsHeader.get(index));
        homePage.scrollToElement(HomePageLocators.accordionContainer);
        homePage.clickWithDefaultTimeout(driver, homePage.getElements(HomePageLocators.accordionHeaderLabelsListXpath).get(index));

        String answerText = homePage.getElements(HomePageLocators.accordionDescriptionListXpath).get(index).getText();
        Assert.assertEquals(questionAnswer, answerText);
    }



    
    
}
