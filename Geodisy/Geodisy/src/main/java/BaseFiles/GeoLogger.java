package BaseFiles;

import Dataverse.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeoLogger {
    public Logger logger;
    private ExistingCallsToCheck efc;

    public GeoLogger(String className) {
        logger = LogManager.getLogger(className);
        efc = ExistingCallsToCheck.getExistingCallsToCheck();
    }

    public GeoLogger(Class classType){
        logger = LogManager.getLogger(classType);
        efc = ExistingCallsToCheck.getExistingCallsToCheck();

    }

    public void error(String message){
        logger.error(message);
    }


    public void info(String message, DataverseJavaObject djo, String loggerName){
        DataverseRecordInfo dri = new DataverseRecordInfo(djo, loggerName);
        if(!efc.hasRecord(djo.getDOI())){
            logger.info(message);
            efc.addOrReplaceRecord(dri);
        }else if(efc.isNewerRecord(dri))
        {
            logger.info("UPDATED RECORD: " + message);
            efc.addOrReplaceRecord(dri);
        }
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void debug(String message){
        logger.debug(message);
    }

    public String getName(){
        return logger.getName();
    }
}
