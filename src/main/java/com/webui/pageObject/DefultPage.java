package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 首页
 * @author the2n
 */
public class DefultPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   DefultPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 登陆用户的名称
* @return
* @throws IOException
*/
public Locator userName_1() throws IOException
 {
   Locator locator=getLocator("userName_1");
   return locator;
 }

/***
* 登陆用户的名称
* @return
* @throws IOException
*/
public Locator userName() throws IOException
 {
   Locator locator=getLocator("userName");
   return locator;
 }

/***
* 退出按钮
* @return
* @throws IOException
*/
public Locator logout_btn() throws IOException
 {
   Locator locator=getLocator("logout_btn");
   return locator;
 }

/***
* 安全风险分级管控
* @return
* @throws IOException
*/
public Locator aqfxfjgk_menu() throws IOException
 {
   Locator locator=getLocator("aqfxfjgk_menu");
   return locator;
 }

/***
* 年度风险辨识-list
* @return
* @throws IOException
*/
public Locator ndfxbs_list() throws IOException
 {
   Locator locator=getLocator("ndfxbs_list");
   return locator;
 }

/***
* 本矿风险汇总
* @return
* @throws IOException
*/
public Locator reportDangerList() throws IOException
 {
   Locator locator=getLocator("reportDangerList");
   return locator;
 }

/***
* 风险审核
* @return
* @throws IOException
*/
public Locator reviewDangerList() throws IOException
 {
   Locator locator=getLocator("reviewDangerList");
   return locator;
 }

/***
* 部门风险上报
* @return
* @throws IOException
*/
public Locator departReportDangerList() throws IOException
 {
   Locator locator=getLocator("departReportDangerList");
   return locator;
 }
}