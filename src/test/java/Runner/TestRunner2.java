package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * This class execute the cucumber test suit with mention tags.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Runner
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@Rerun/rerun1.txt"},
        glue = "StepDefinations",
        monochrome = true,
        plugin = { "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:Rerun/rerun2.txt" })

public class TestRunner2 {

}
