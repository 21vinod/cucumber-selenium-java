package com.vinod.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
//        plugin = {"pretty", "html:target/cucumber-reports/test1.html"},
        features = "src/test/resources/features/android/real_device_with_apk.feature",//"src/test/resources/features/android",///real_device_with_apk.feature
        glue = "com/vinod/step_definitions",
        dryRun = false,
        tags = "",
        publish = false //generating a report with public link
)

public class AndroidWebTestRunner {}
