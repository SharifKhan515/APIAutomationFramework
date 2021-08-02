package org.qa.environment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Environment {

    public static final String propertyFileLocation = System.getProperty("user.dir") +"\\src\\main\\resources\\application.properties";
    public static final String logOutputDirectory = System.getProperty("user.dir") +"\\reports\\logs\\";
    public static String fileSuffix = new SimpleDateFormat("yyyy-dd-M--HH-mm-ss").format(new Date());


    public static String logFileName = "application-"+fileSuffix+".log";
}
