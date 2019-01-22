package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 登录页面
 * @author the2n
 */
public class LoginPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   LoginPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 用户名
* @throws IOException
*/
public Locator userName_Text() throws IOException
 {
   Locator locator=getLocator("userName_Text");
   return locator;
 }

/***
* 密码
* @throws IOException
*/
public Locator password_Text() throws IOException
 {
   Locator locator=getLocator("password_Text");
   return locator;
 }

/***
* 登录
* @throws IOException
*/
public Locator login_btn() throws IOException
 {
   Locator locator=getLocator("login_btn");
   return locator;
 }

/***
* 用户名密码为空时提示
* @throws IOException
*/
public Locator error_tip() throws IOException
 {
   Locator locator=getLocator("error_tip");
   return locator;
 }

/***
* 密码为空时提示
* @throws IOException
*/
public Locator tipWithoutPassword() throws IOException
 {
   Locator locator=getLocator("tipWithoutPassword");
   return locator;
 }

/***
* 确定按钮
* @throws IOException
*/
public Locator confirm_btn() throws IOException
 {
   Locator locator=getLocator("confirm_btn");
   return locator;
 }

/***
* 取消按钮
* @throws IOException
*/
public Locator cancel_btn() throws IOException
 {
   Locator locator=getLocator("cancel_btn");
   return locator;
 }
}