package org.qa.utils;

import org.qa.environment.Environment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ReportHelper {

    public static PrintStream getLogger(){

        PrintStream log = null;
        try {
            log = new PrintStream(new FileOutputStream(Environment.logOutputDirectory+Environment.logFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return log;

    }
}
