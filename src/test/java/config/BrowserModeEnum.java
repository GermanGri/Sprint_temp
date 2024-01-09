package config;

import lombok.Getter;

@Getter
public enum BrowserModeEnum {
    UI("ui"),
    HEADLESS ("headless");

    private final String getBrowserType;

    BrowserModeEnum(String value) {
        this.getBrowserType = value;
    }
}
