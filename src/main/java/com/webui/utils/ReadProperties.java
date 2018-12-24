package com.webui.utils;

import java.io.*;
import java.util.Properties;

/**
 * @author the2n
 * @Description:读取配置信息方法
 * @Data 2018/12/24 11:22
 */
public class ReadProperties {

    public String readPropertiesFile(String propertiesFilePath, String key) throws FileNotFoundException {
        Properties properties = new Properties();
        InputStreamReader fileInputStream = null;
        InputStream is = new BufferedInputStream(new FileInputStream(propertiesFilePath));
        try {
            fileInputStream = new InputStreamReader(is, "utf-8");
            properties.load(fileInputStream);
            if (properties.containsKey(key)) {
                return properties.getProperty(key);
            } else {
                System.out.println("传入的Key值不存在！");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
