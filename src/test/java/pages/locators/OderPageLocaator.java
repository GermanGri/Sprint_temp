package pages.locators;

public interface OderPageLocaator {

    String headerXpath = "//div[text()='Для кого самокат']";

    String nameInputXpath = "//input[@placeholder='* Имя']";
    String lastInputXpath = "//input[@placeholder='* Фамилия']";
    String addressInputXpath = "//input[@placeholder='* Адрес: куда привезти заказ']";
    String subwayStationInputXpath = "//input[@placeholder='* Станция метро']";

    String phoneNumberInputXpath = "//input[@placeholder='* Телефон: на него позвонит курьер']";
    String dateOfDeliveryInputXpath = "//input[@placeholder='* Когда привезти самокат']";
    String rentDateInputXpath = "//div[@class='Dropdown-arrow-wrapper']//span[@class='Dropdown-arrow']";

    String rentDateValuesList = "//div[@class='Dropdown-menu']/div";

    String scooterColorCheckboxList = "//div[contains(@class, 'Order_Checkboxes__3lWSI')]//label//input[@type='checkbox']";

    String commentsInputXpath = "//input[@placeholder='Комментарий для курьера']";

    String continueButtonXpath = "//button[text()='Далее']";
    String orderButtonXpath = "//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']";
    String backButtonXpath = "//button[text()='Назад']";

    String modalHeader = "//div[@class='Order_ModalHeader__3FDaJ']";
    String confirmButton = "//button[text()='Да']";
    String rejectButton = "//button[text()='Нет']";
    String orderStatusLabel = "//div[@class='Order_ModalHeader__3FDaJ']";
    String checkStatusButton = "//button[text()='Посмотреть статус']";
}
