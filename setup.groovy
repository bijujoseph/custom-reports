def groovyUtils=new  com.eviware.soapui.support.GroovyUtils(context)
def projectPath = groovyUtils.projectPath
def testCase = testRunner.testCase;
def fileName = testCase.getPropertyValue("input_file")
def outputFileName = testCase.getPropertyValue("output_file")

def folder = new File(projectPath)
def file = new File(folder, fileName)
def outputFile = new File(folder, outputFileName)

// open a file reader in context.filereader
context.fileReader = new BufferedReader(new FileReader(file))
context.fileWriter = new BufferedWriter(new FileWriter(outputFile))

// read headers into context.headers and trim them
context.curLine = 0
line = context.fileReader.readLine()?.trim()
context.fileWriter.writeLine("STATUS\t${line}")

context.headers = line != null ? line.split("\t") : []
//context.headers.eachWithIndex{h, i -> log.info "Header[${i}]: ${h}" }
// read first line
context.curLine = 1
line = context.fileReader.readLine()?.trim()
log.info "Read line: " + line

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
    log.info "Line 1: ${m}"
}