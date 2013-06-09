package com.compiler.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Roman
 * Date: 09.06.13
 */
public class LoggerUtils extends SecurityManager {
    public static Logger getLogger()
    {
        String className = new LoggerUtils().getClassName();
        Logger logger = LoggerFactory.getLogger(className);
        return logger;
    }

    private  String getClassName()
    {
        return getClassContext()[2].getName();
    }

}
