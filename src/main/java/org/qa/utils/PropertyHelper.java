package org.qa.utils;

import com.fasterxml.jackson.databind.PropertyName;
import org.qa.environment.Environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {

    static Properties properties;
    static InputStream inputStream;
    static String propFile = Environment.propertyFileLocation;


    public PropertyHelper(){
        properties = new Properties();
        try {
            inputStream = new FileInputStream(propFile);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPropertyValue(String propName){
        String propValue = properties.getProperty(propName);
        if(propValue!=null) return propValue;
        else throw new RuntimeException(propName+" not found in property file");
    }

}
