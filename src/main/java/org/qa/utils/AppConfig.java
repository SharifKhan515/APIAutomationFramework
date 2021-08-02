package org.qa.utils;

public class AppConfig {

    public static PropertyHelper propertyHelper= new PropertyHelper();

    public static String getBaseUrl() {
        return propertyHelper.getPropertyValue("base.url");
    }
}
