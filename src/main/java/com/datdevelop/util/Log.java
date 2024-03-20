package com.datdevelop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static final Logger LOGGER = LoggerFactory.getLogger("la-frozen");
    public static void log(String _text){
        LOGGER.info(_text);
    }

}
