package com.vinod.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/cucumber-reports.html", "rerun:target/rerun.txt", "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
//        plugin = { "html:target/cucumber-reports/test1.html",
//                "rerun:target/rerun.txt"},//plugin = {"pretty", "html:target/cucumber-reports/test1.html"},
        features = "src/test/resources/features",
        glue = "com/vinod/step_definitions",
        dryRun = false,
        tags = "@dataTables and @listMap",
        publish = false //generating a report with public link
)

public class TestRunner {}
