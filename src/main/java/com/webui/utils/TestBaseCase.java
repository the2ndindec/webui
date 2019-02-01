package com.webui.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.qameta.allure.Step;

public class TestBaseCase {

    public static WebDriver driver;
    public static String description;
    public Log log = new Log(this.getClass().getSuperclass());

    @BeforeSuite(description = "初始化浏览器配置，加载访问地址")
    @Parameters({"driver","url"})
    public void loadConfiguration(String driver,String url) {
        log.info("------------------开始执行测试---------------");
        try {
            TestBaseCase.driver = setDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestBaseCase.driver.manage().window().maximize();
        TestBaseCase.driver.get(url);
        TestBaseCase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        TestBaseCase.driver.quit();
        log.info("-------------结束测试，并关闭退出浏览器-------------");
    }

    String downloadFilepath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\autoDownload";
    @Step(value = "初始化浏览器driver")
    private WebDriver setDriver(String browsername) {
        switch (browsername) {
            case "FirefoxDriver":
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.folderList", 2); //设置成0 代表下载到浏览器默认下载路径；设置成2 则可以保存到指定目录。
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false); //设置成0 代表下载到浏览器默认下载路径；设置成2 则可以保存到指定目录。
                firefoxProfile.setPreference("browser.download.dir",downloadFilepath );   //用于指定你所下载文件的目录。
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel"); //指定要下载页面的Content-type 值，“application/octet-stream”为文件的类型
                TestBaseCase.driver = new FirefoxDriver(firefoxProfile);
                break;
            case "ChromeDriver":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drives/chromeDriver2.45/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                // ----设置chrome加载flash插件
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.plugins", 1);
                prefs.put("profile.default_content_setting_values.plugins", 1);
                prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
                prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
                prefs.put("PluginsAllowedForUrls", "https://arlo.netgear.com");
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", downloadFilepath);
                options.setExperimentalOption("prefs", prefs);
                // ----设置chrome加载flash插件结束
                options.addArguments("disable-infobars");
                options.addArguments("--test-type");

                TestBaseCase.driver = new ChromeDriver(options);
                break;
            default:
                TestBaseCase.driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
