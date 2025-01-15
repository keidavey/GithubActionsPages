package hooks;

import com.cicd.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.cicd.utils.CucumberLogUtils;
import com.cicd.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void start(Scenario scenario) throws Exception {
        CucumberLogUtils.scenario = scenario;
        WebDriverUtils.setUp();
        PageInitializer.initializeAllPages();
    }

    @After
    public void end() throws Exception {
        WebDriverUtils.tearDown();
    }

    @AfterStep
    public void afterStepSS() {
            CucumberLogUtils.logScreenShot();
        }
    }