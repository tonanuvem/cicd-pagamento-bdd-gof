package bddgof;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","json:target/cucumber.json","html:target/site/cucumber-pretty"})
public class RunCucumberTest {
    
}
