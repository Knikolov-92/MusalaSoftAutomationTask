package com.musala.selenium.utils;

import org.testng.ISuite;
import org.testng.reporters.jq.Main;
import org.testng.xml.XmlSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMainReporter extends Main {

    @Override
    public void generateReport(java.util.List<XmlSuite> xmlSuites,
                               java.util.List<ISuite> suites,
                               java.lang.String outputDirectory) {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
        String formattedDate = dateFormat.format(date);
        String timestamp = formattedDate;

        super.generateReport(xmlSuites, suites, outputDirectory + "/" + timestamp);
    }
}
