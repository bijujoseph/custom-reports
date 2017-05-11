// ${#TestCase#ColHeader}
testCase = testRunner.testCase;

context.curLine = context.curLine + 1
line = context.fileReader.readLine()?.trim()
//new File(context.outputFile).append(testCase.actual_line).append(“\t”).append(STATUS);

if (line != null) {
    testCase.setPropertyValue("actual_line",line)
    String[] cols = line.split("\t")
    def m = [:]
    context.headers.eachWithIndex{h, i ->
        if (i < cols.length) {
            testCase.setPropertyValue(context.headers[i],cols[i])
            m.put(context.headers[i],cols[i])

        }
    }
    log.info "Line ${context.curLine}: ${m}"
    // loop
    testRunner.gotoStep(0)
}
