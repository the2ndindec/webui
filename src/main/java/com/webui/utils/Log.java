package com.webui.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Log {

    private final Class<?> clazz;
    private Logger logger;

    /**
     * 获取当前类
     * @param clazz
     */
    public Log(Class<?> clazz) {
        this.clazz = clazz;
        this.logger = Logger.getLogger(clazz);
        Log.initlog4j();
    }

    // 初始化log4j，设置log4j的配置文件log4j.Properties
    private static void initlog4j() {
        // 创建Propderties对象
        Properties properties = new Properties();
        properties.setProperty("log4j.rootLogger", "INFO,CONSOLE,E,F");
        properties.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender");
        properties.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern",
                "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

        String src = "test-output/log"; // 文件输出位置
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date()).toString();

        File dir = new File(src + "/" + date);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filePath = dir.getAbsolutePath() + "/" + "log_" + date + ".log";

        properties.setProperty("log4j.appender.E", "org.apache.log4j.FileAppender");
        properties.setProperty("log4j.appender.E.file", filePath);
        properties.setProperty("log4j.appender.E.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.E.layout.ConversionPattern",
                "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");
        properties.setProperty("log4j.appender.F", "org.apache.log4j.FileAppender");

        String filepathHtml = dir.getAbsolutePath() + "/" + "log_" + date + ".html";
        properties.setProperty("log4j.appender.F.file", filepathHtml);
        properties.setProperty("log4j.appender.F.layout", "org.apache.log4j.HTMLLayout");

        PropertyConfigurator.configure(properties);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }
}
