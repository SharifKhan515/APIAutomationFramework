package org.qa.cucumber.options;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/org/qa/features",
                 glue = "org/qa/stepDefinitions",
                plugin = "json:target/jsonReports/cucumber-report.json"
               //tags = "@DeletePlace"
                  )
public class TestRunner extends AbstractTestNGCucumberTests {

}
