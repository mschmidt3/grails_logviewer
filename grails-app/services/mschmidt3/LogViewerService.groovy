package mschmidt3

import grails.gorm.transactions.Transactional

@Transactional
class LogViewerService {
    String logDirectory
    ArrayList<String> hideFiles

    def listFiles() {
        log.debug("listFiles ${logDirectory}, ${hideFiles}")

        def filelist = []
        new File(logDirectory).eachFile {
            if( hideFiles.contains( it.name ) ){
                log.debug "file '$it' is hidden"
            } else {
                filelist << it.name
            }
        }

        return filelist
    }

    String getContent(String fname){
        String result = "file '${fname}' not found"

        if( hideFiles.contains( fname ) ){ return result }

        File logfile = new File(logDirectory + '/'+ fname)
        if(logfile.exists()){
            result = logfile.text
        }
        return result
    }
}
