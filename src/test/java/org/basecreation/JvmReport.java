package org.basecreation;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	public static void generateJvmReport(String json) {
	//Step 1. File Location
		File loc = new File("F:\\Java Files\\Workspace\\TargetInCucumber\\src\\test\\resources\\Reports\\JVMReports");

    //Step 2. Configuration(You need Cucumber Report dependency)
		Configuration con = new Configuration(loc, "TargetWebsite");
		con.addClassifications("BrowserName","Chrome");
		con.addClassifications("OS","Windows");
		con.addClassifications("Os Version","11");
		con.addClassifications("Sprint","12");
    //Step3. Generating Report
		List<String> jsonFiles = new LinkedList<>();
		jsonFiles.add(json);
		ReportBuilder r = new ReportBuilder(jsonFiles, con);
		r.generateReports();
		
	}

}
