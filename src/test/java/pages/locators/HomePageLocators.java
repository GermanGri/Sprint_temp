package pages.locators;

public interface HomePageLocators {

    String yandexHomeLinkXpath = "//a[@class='Header_LogoYandex__3TSOI']";
    String yandexImageXpath = yandexHomeLinkXpath + "/img";

    String scooterHomeLinkXpath = "//a[@class='Header_LogoScooter__3lsAR']";
    String scooterImageXpath = scooterHomeLinkXpath + "/img";

    String trainingSimulatorLabeleXpath = "//div[@class='Header_Disclaimer__3VEni']";

    String homeHeaderLabelXpath = "//div[@class='Home_Header__iJKdX']";
    String homeSubHeaderLabelXpath = homeHeaderLabelXpath +  "//div[@class='Home_SubHeader__zwi_E']";
    String homeBluePrintImgXpath = "//div[@class='Home_BluePrint__TGX2n']//img";

    String topOrderButton = "//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']";
    String bottomOrderButton = "//div[@class='Home_FinishButton__1_cWm']//button";
    String topOrderStatusButton = "//div[@class='Header_Nav__AGCXC']//button[@class='Header_Link__1TAG7']";

    String modelHeaderContainerXpath = "//div[@class='Home_Table__2kPxP']";
    String modelHeaderLabelXpath = modelHeaderContainerXpath + "//div[@class='Home_Row__jdQW2']//div[@class='Home_Column__xlKDK']";
    String modelHeaderSeparatorXpath = modelHeaderContainerXpath + "//div[@class='Home_Table__2kPxP']//div[@class='Home_Separator__3cWAk']"; // should be two separators

    String homeRoadMapConitainer = "//div[@class='Home_RoadMap__2tal_']";
    String homeStatusBrick = homeRoadMapConitainer + "//div[@class='Home_StatusBrick__1PsW9']";
    String homeStatusCircleListXpath = homeStatusBrick + "//div[@class='Home_StatusCircle__3_aTp']";
    String homeStatusListXpath = homeStatusBrick + "//div[@class='Home_Status__YkfmH']";
    String homeStatusDescriptionListXpath = homeStatusBrick + "//div[@class='Home_StatusDescription__3WGl5']";

    String ImportantQuestionLabelXpath = "//div[@class='Home_FourPart__1uthg']//div[@class='Home_SubHeader__zwi_E']";

    String accordionContainer = "//div[@class='Home_FAQ__3uVm4']";
    String accordionHeaderLabelsListXpath = accordionContainer + "//div[@data-accordion-component='AccordionItemButton']";
    String accordionDescriptionListXpath = accordionContainer + "//div[@data-accordion-component='AccordionItemPanel']/p";


    String flexiblePath = "//div[@class='class']//[text()='%s']";

}
