Testing some different Github Action workflow and steps, Pages

Issues Encountered:

1. Issue: Build failing, Tests failing
     Focus 1: SessionNotCreatedException w/ Response code 500.
       Debug-Attempt 1: Add steps to install Chrome dependencies and set-up remote Chrome driver
         Result: Error. Unable to locate packages required for dependecy
           Focus 1.1: Maven compiler plugin 3.8 not compatible with Java 17 Thanks, Google. No need for Chrome set-up after all...
             Solution: Downgraded from Java 17 to Java 11. Removed Chrome dependency and remote driver steps.

2. Issue: Build successful, but Tests failing
     Focus 1: SessionNotCreatedException w/ Response code 500 again. Confused because Maven build succeeded. Server error? 
     Debug-Attempt 1: Re-added steps to install Chrome dependencies and set-up remote Chrome driver
       Result: Still getting SessionNotCreatedException.
         Focus 1.1: Possibly some issue with one of the build cycle phases? Create distinct Smoke Test step to compare logs.   
     Debug-Attempt 2: Copy the build from another project to test if there is something I'm missing.
       Result: Still getting error.......actually build is giving me additional errors.....also realized I am not displaying Cucumber reports.
         Focus 2.1: Goal from copied build is causing additional error... "Failed to execute goal net.masterthought:maven-cucumber-      
           reporting:5.0.0:generate (execution)"
           Debug-Attempt 2.1: Change settings in execution goal to match settings on local machine.
             Result: |
                     net.masterthought.cucumber.ReportParser parseForFeature
                     INFO: File {0} does not contain features
                     net.masterthought.cucumber.ReportParser parseJsonFiles
                     INFO: File '/home/runner/work/bbb/bbb/target/cucumber.json' contains 0 features
               Realized Getting way off task. While I would like to fix this, I don't think it's necessary. Backstep.
       Debug-Attempt 3: Server Error...no.........check localtestsettings.config file
         Solution: headless = true

 3. Issue: Deploy Pages step error. "The directory you're trying to deploy named /home/runner/work/bbb/bbb/test-output/JSON doesn't exist."
      Solution: Update with the correct name of the directory.

 4. Issue: Pages displays 404 Error.
      Solution: Use different steps. 
         
   

