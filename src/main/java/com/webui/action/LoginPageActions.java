package com.webui.action;

import java.io.*;
import java.util.Date;
import java.util.Set;

import com.webui.pageObject.LoginPage;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

public class LoginPageActions extends TestBaseCase {

	ElementAction ea = new ElementAction();
	LoginPage lp = new LoginPage();

	@Step("用户名:{0}/密码:{1}")
	public void signInInit(String username, String password) throws IOException {
		ea.type(lp.userName_Text(), username);
		ea.type(lp.password_Text(), password);
		ea.click(lp.login_btn());
//		wtriteC();
	}

	/**
	 * 不输入用户名密码
	 * @throws IOException
	 */
	public void loginExcludeNameAndPwd() throws IOException {
		ea.click(lp.login_btn());
	}

	/**
	 * 不输入密码
	 * @param username
	 * @throws IOException
	 */
	public void loginExcludePwd(String username) throws IOException {
		ea.type(lp.userName_Text(), username);
		ea.click(lp.login_btn());
	}

	/**
	 * 用户名和密码不匹配
	 * @param username
	 * @param password
	 * @throws IOException
	 */
	public void loginIncorrectPwd(String username, String password) throws IOException {
		ea.type(lp.userName_Text(), username);
		ea.type(lp.password_Text(), password);
		ea.click(lp.login_btn());
	}

	public void testCookies(){
		driver.manage().deleteAllCookies();
		File file = new File("D:/dev/IdeaProjects/webui/src/test/resources/TestCookies.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line=br.readLine())!= null){
				String [] sz = line.split(";");
				String doman =  sz[0].trim();
				String name = sz[1].trim();
				String value = sz[2].trim();
				String path = sz[3].trim();
				Date date = null;
				if (!(sz[4].equals("null"))){
					date = new Date(sz[4]);
				}
				Boolean bl = Boolean.valueOf(sz[5]);
				Cookie ck = new Cookie(name,value,doman,path,date,bl);
				driver.manage().addCookie(ck);
				System.out.println("=======");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		driver.get("http://192.168.3.194:8080/sdzk/");
		driver.navigate().refresh();
		System.out.println("====debug===");
		System.out.println(driver.getTitle());
		ea.sleep(10);
	}


	public void wtriteC(){
		File file = new File("D:/dev/IdeaProjects/webui/src/test/resources/TestCookies.txt");
		Set<Cookie> s = driver.manage().getCookies();
		if (file.exists()){
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cookie c:s){
				bw.write(c.getDomain()+";"+c.getName()+";"+c.getValue()+";"+c.getPath()+";"+c.getExpiry()+";"+c.isSecure());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
