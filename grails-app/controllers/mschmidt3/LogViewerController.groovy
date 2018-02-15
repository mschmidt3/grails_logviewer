package mschmidt3

class LogViewerController {
    def logViewerService

    def index() {
        def list = logViewerService.listFiles()
        render "${list.join('<br>')}"
    }

    def show(String f) {
        log.debug "index: $params, $f"
        def result = "- no file specified -"
        if(f){
            result = logViewerService.getContent(f)
        }
        render "<pre>${result}</pre>"
    }
}
