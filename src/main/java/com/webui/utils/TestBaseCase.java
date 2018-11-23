package com.webui.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.qameta.allure.Step;

public class TestBaseCase {

	public static WebDriver driver;
	public static String description;
	public Log log = new Log(this.getClass().getSuperclass());

	@BeforeSuite(description="初始化浏览器配置，加载访问地址")
	@Parameters({ "driver"})
	public void loadConfiguration(String driver) {
		log.info("------------------开始执行测试---------------");
		try {
			TestBaseCase.driver = setDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestBaseCase.driver.manage().window().maximize();
		TestBaseCase.driver.get("http://192.168.3.242:8080/sdzk-mine/");
		TestBaseCase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() {
		TestBaseCase.driver.quit();
		log.info("-------------结束测试，并关闭退出浏览器-------------");
	}

	@Step(value="初始化浏览器driver")
	private WebDriver setDriver(String browsername) {
		switch (browsername) {
		case "FirefoxDriver":
			TestBaseCase.driver = new FirefoxDriver();
			break;
		case "ChormeDriver":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drives/ChromeDriver 2.41/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// ----设置chrome加载flash插件
			Map<String, Object> prefs =new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.plugins", 1);
			prefs.put("profile.default_content_setting_values.plugins", 1);
		    prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		    prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
		    prefs.put("PluginsAllowedForUrls", "https://arlo.netgear.com");
		    options.setExperimentalOption("prefs", prefs);  
		    // ----设置chrome加载flash插件结束
			options.addArguments("disable-infobars");
			
			TestBaseCase.driver = new ChromeDriver(options);
			break;
		default:
			TestBaseCase.driver = new FirefoxDriver();
			break;
		}
		return driver;
	}
}
