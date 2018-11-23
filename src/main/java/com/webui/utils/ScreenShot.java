package com.webui.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {

	public WebDriver driver;
	private String screenName;
	Log log = new Log(this.getClass());

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void takeScreenshot() {
		String screenName = this.screenName + ".jpg";
		File dir = new File("test-output\\snapshot");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		String screenPath = dir.getAbsolutePath() + "\\" + screenName;
//		delAllFile(screenPath);
		
		this.takeScreenshot(screenPath);
	}

	private void takeScreenshot(String screenPath) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(screenPath));
			log.error("错误截图：" + screenPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean delAllFile(String path) {
	       boolean flag = false;
	       File file = new File(path);
	       if (!file.exists()) {
	         return flag;
	       }
	       if (!file.isDirectory()) {
	         return flag;
	       }
	       String[] tempList = file.list();
	       File temp = null;
	       for (int i = 0; i < tempList.length; i++) {
	          if (path.endsWith(File.separator)) {
	             temp = new File(path + tempList[i]);
	          } else {
	              temp = new File(path + File.separator + tempList[i]);
	          }
	          if (temp.isFile()) {
	             temp.delete();
	          }
	          if (temp.isDirectory()) {
	             delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
	            
	             flag = true;
	          }
	       }
	       return flag;
	     }

}
