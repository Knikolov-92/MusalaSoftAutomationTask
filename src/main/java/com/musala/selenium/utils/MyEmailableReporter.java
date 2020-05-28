package com.musala.selenium.utils;

import org.testng.ISuite;
import org.testng.reporters.EmailableReporter;
import org.testng.xml.XmlSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyEmailableReporter extends EmailableReporter {
    @Override
    public void generateReport(java.util.List<XmlSuite> xmlSuites,
                               java.util.List<ISuite> suites,
                               java.lang.String outputDirectory) {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
        String formattedDate = dateFormat.format(date);
        String timestamp = formattedDate;
        //outputDirectory = System.getProperty("user.dir") + "\\TestReports\\";

        super.generateReport(xmlSuites, suites, outputDirectory + "/" + timestamp);
    }
}
