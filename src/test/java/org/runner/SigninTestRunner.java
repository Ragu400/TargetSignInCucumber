package org.runner;

import org.basecreation.JvmReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Features\\signin.feature",
                 glue="org.signinstepdef",
                 plugin= {"pretty",
                		 "html:F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Reports",
                		 "json:F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Reports\\jsonReport.json",
                         "junit:F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Reports\\junitReport.xml"},
                          monochrome=true)
public class SigninTestRunner {
	@AfterClass
	public static void report() {
         JvmReport.generateJvmReport("F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Reports\\jsonReport.json");
         System.out.println("-----Report Generated------");
	}
	

}
