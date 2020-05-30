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
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = dateFormat.format(date);
        String timestamp = formattedDate;
        String suite = xmlSuites.get(0).getName();

        super.generateReport(xmlSuites, suites, outputDirectory + "/" + suite + "_" + timestamp);
    }
}
