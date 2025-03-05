package com.aryan;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Path to your feature files directory
        glue = "com.aryan"         // Package containing your step definition classes
//        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}

