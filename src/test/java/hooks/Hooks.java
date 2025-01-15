package hooks;

import com.chromatech.Cucumber_BDD_Testing.appsCommon.PageInitializer;
import com.chromatech.utils.CucumberLogUtils;
import com.chromatech.utils.WebDriverUtils;
import com.chromatech.Cucumber_BDD_Testing.Constants.screenRecording.ScreenRecorderUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;

public class Hooks {

    @Before
    public void start(Scenario scenario) throws Exception {
        CucumberLogUtils.scenario = scenario;
        WebDriverUtils.setUp();
        PageInitializer.initializeAllPages();
        ScreenRecorderUtil.startRecording(scenario.getName());
    }

    @After
    public void end() throws Exception {
        ScreenRecorderUtil.stopRecording();

        String directoryFilePath = "./test-recordings/";

        File movieFile = ScreenRecorderUtil.getLastModified(directoryFilePath);
        if(movieFile != null) {
            String fileName = movieFile.getName();
            int dotIndex = fileName.lastIndexOf('.');
            String baseName = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
            String outputFilename = directoryFilePath + baseName + ".mp4";

            ScreenRecorderUtil.convertMovToMp4(movieFile.getAbsolutePath(), outputFilename);
        }

        WebDriverUtils.tearDown();
    }

    @AfterStep
    public void afterStepSS() {
        if (ScreenRecorderUtil.logAfterSteps()) {
            CucumberLogUtils.logScreenShot();
        }
    }
}