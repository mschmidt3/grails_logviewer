package mschmidt3

import grails.gorm.transactions.Transactional

@Transactional
class LogViewerService {
    String logDirectory

    def listFiles() {
        log.debug("listFiles ${logDirectory}")
        def filelist = []
        new File(logDirectory).eachFile {
            filelist << it.name
        }

        return filelist
    }

    String getContent(String fname){
        String result = "file '${fname}' not found"
        File logfile = new File(logDirectory + '/'+ fname)
        if(logfile.exists()){
            result = logfile.text
        }
        return result
    }
}
