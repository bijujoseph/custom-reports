#!/bin/sh
rm -rf soap-reports/*
cd out/production/
rm custom-reports.jar
jar cvf  custom-reports.jar -C custom-reports .
cp custom-reports.jar /Applications/SoapUI-5.3.0.app/Contents/java/app/lib/custom-reports.jar
cd /Applications/SoapUI-5.3.0.app/Contents/java/app/bin/
./testrunner.sh -sqs_smoketest_prototype -cquality_spr_measures -r -j -ehttp://localhost:3000 -f/Users/bijujoseph/workspace/Grails/custom-reports/soap-reports /Users/bijujoseph/workspace/CMS/references/qpp-scoring-engines/soapui/SmoketestProject-soapui-project.xml
cd /Users/bijujoseph/workspace/Grails/custom-reports