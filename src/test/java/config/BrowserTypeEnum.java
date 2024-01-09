package config;

import lombok.Getter;

@Getter
public enum BrowserTypeEnum {
    CHROME("chrome"),
    FIREFOX ("firefox"),
    IE("ie"),
    EDGE("edge"),
    SAFARI("safari");

    private final String getBrowserName;

    BrowserTypeEnum(String value) {
        this.getBrowserName = value;
    }
}
