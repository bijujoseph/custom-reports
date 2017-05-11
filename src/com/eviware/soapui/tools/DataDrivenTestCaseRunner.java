package com.eviware.soapui.tools;

import com.eviware.soapui.report.JUnitSecurityReportCollector;
import com.eviware.soapui.reports.DataDrivenJUnitReportCollector;

public class DataDrivenTestCaseRunner extends SoapUITestCaseRunner {
    @Override
    protected JUnitSecurityReportCollector createJUnitSecurityReportCollector() {
        return new DataDrivenJUnitReportCollector();
    }


    public static void main(String[] args) throws Exception {
//        String[] myargs = new String[]{
//                "-sqs_smoketest_prototype",
//                "-cquality_spr_measures" ,
//                "-r",
//                "-j",
//                "-ehttp://localhost:3000",
//                "-f/Users/bijujoseph/workspace/Grails/custom-reports/soap-reports",
//                "/Users/bijujoseph/workspace/CMS/references/qpp-scoring-engines/soapui/SmoketestProject-soapui-project.xml"
//        };

        System.exit((new DataDrivenTestCaseRunner()).runFromCommandLine(args));
    }

}
