package org.qa.cucumber.options;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/org/qa/features",
                 glue = "org/qa/stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
