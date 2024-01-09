package config;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ConfigReader {

    private static final Logger LOG = LogManager.getLogger(ConfigReader.class);

    private final static String PROPERTY_PATH = "/test.settings.properties";

    private String url;
    private String browserType;
    private String browserMode;
    private String pageLoadTimeOutInSec;
    private String elementLoadTimeOutInSec;
    private String pageLoadTimeOutInMillSec;
    private String elementLoadTimeOutInMillSec;

    public ConfigReader() {
        Properties properties = loadProperties();

        if (properties != null) {
            LOG.info("Trying to read properties field");

            url = properties.getProperty("url");
            browserType = properties.getProperty("browserType");
            browserMode = properties.getProperty("browserMode");
            pageLoadTimeOutInSec = properties.getProperty("pageLoadTimeOut");
            elementLoadTimeOutInSec = properties.getProperty("elementTimeOut");
            pageLoadTimeOutInMillSec = properties.getProperty("pageLoadTimeOutInMillSec");
            elementLoadTimeOutInMillSec = properties.getProperty("elementLoadTimeOutInMillSec");

        } else {
            LOG.error("Failed to load properties.");
        }
    }


    private Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream input = getClass().getResourceAsStream(PROPERTY_PATH)) {
            if (input == null) {
                LOG.error("test.settings.properties not found.");
                return null;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return properties;
    }
}
