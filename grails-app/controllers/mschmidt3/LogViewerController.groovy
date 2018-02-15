package mschmidt3

class LogViewerController {
    def logViewerService

    def index() {
        log.debug "index"

        def list = logViewerService.listFiles()
        def result = ""
        list.each {
            result += "<a href = \"${ createLink(action:'show', params:[f:it]) }\"> $it </a><br/>\n"
        }
        render "${result}"
    }

    def show(String f) {
        log.debug "show $f"

        def result = "- no file specified -"
        if(f){
            result = logViewerService.getContent(f)
        }
        render "<pre>${result}</pre>"
    }
}
