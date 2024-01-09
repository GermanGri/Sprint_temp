package tests;

import config.BrowserModeEnum;
import config.BrowserTypeEnum;
import config.ConfigReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static java.lang.String.format;

public class BaseTest {

    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    private static final String HEADLESS = "headless";
    static ConfigReader configReader;

    static ChromeOptions chromeOptions = new ChromeOptions();
    static FirefoxOptions firefoxOptions = new FirefoxOptions();
    static EdgeOptions edgeOptions = new EdgeOptions();

    static WebDriver driver;

    @Before
    public void setup() {
        configReader = new ConfigReader();
        LOG.info(configReader.getUrl());
        LOG.info(configReader.getBrowserType());
        LOG.info(configReader.getBrowserMode());
        selectBrowserMode();
        selectWebDriver();
    }


    @After
    public void cleanUp() {
        driver.quit();
    }


    private void selectWebDriver() {
        LOG.info("Trying to setup web driver...");
        String browserType = configReader.getBrowserType();
        if (StringUtils.isBlank(browserType) || browserType.equalsIgnoreCase(BrowserTypeEnum.CHROME.getGetBrowserName())) {
            browserTypeLogFormatter(BrowserTypeEnum.CHROME.getGetBrowserName());
            driver = new ChromeDriver(chromeOptions);
        } else if (browserType.equalsIgnoreCase(BrowserTypeEnum.FIREFOX.getGetBrowserName())) {
            browserTypeLogFormatter(BrowserTypeEnum.FIREFOX.getGetBrowserName());
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browserType.equalsIgnoreCase(BrowserTypeEnum.IE.getGetBrowserName())) {
            browserTypeLogFormatter(BrowserTypeEnum.IE.getGetBrowserName());
            driver = new InternetExplorerDriver();
            LOG.warn("IE supported only UI mode");
        } else if (browserType.equalsIgnoreCase(BrowserTypeEnum.EDGE.getGetBrowserName())) {
            browserTypeLogFormatter(BrowserTypeEnum.EDGE.getGetBrowserName());
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase(BrowserTypeEnum.SAFARI.getGetBrowserName())) {
            browserTypeLogFormatter(BrowserTypeEnum.SAFARI.getGetBrowserName());
            driver = new SafariDriver();
            LOG.warn("Safari supported only UI mode");
        } else {
            LOG.info("Invalid browser type: Using Chrome as default.");
            driver = new ChromeDriver(chromeOptions);
        }
    }

    private void selectBrowserMode() {
        LOG.info("Trying to setup web browser type...");
        String browserMode = configReader.getBrowserMode();
        if (StringUtils.isBlank(browserMode) || browserMode.equalsIgnoreCase(BrowserModeEnum.UI.getGetBrowserType())) {
            LOG.info(String.format("Using: '%s' web-driver mode", BrowserModeEnum.UI.getGetBrowserType()));
        } else {
            LOG.info(String.format("Using: '%s' web-driver mode", browserMode));
            chromeOptions.addArguments(HEADLESS);
            firefoxOptions.addArguments("-headless");
            edgeOptions.addArguments(HEADLESS);
        }
    }

    private void browserTypeLogFormatter(String browserName) {
        LOG.info(format("Using: '%s' web-driver", browserName));
    }
}


