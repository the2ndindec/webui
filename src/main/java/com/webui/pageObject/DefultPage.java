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
* @throws IOException
*/
public Locator userName_1() throws IOException
 {
   Locator locator=getLocator("userName_1");
   return locator;
 }

/***
* 登陆用户的名称
* @throws IOException
*/
public Locator userName() throws IOException
 {
   Locator locator=getLocator("userName");
   return locator;
 }

/***
* 退出按钮
* @throws IOException
*/
public Locator logout_btn() throws IOException
 {
   Locator locator=getLocator("logout_btn");
   return locator;
 }

/***
* 安全风险分级管控
* @throws IOException
*/
public Locator aqfxfjgk_menu() throws IOException
 {
   Locator locator=getLocator("aqfxfjgk_menu");
   return locator;
 }

/***
* 年度风险管理-list
* @throws IOException
*/
public Locator ndfxgl_list() throws IOException
 {
   Locator locator=getLocator("ndfxgl_list");
   return locator;
 }

/***
* 矿风险清单
* @throws IOException
*/
public Locator reportDangerList() throws IOException
 {
   Locator locator=getLocator("reportDangerList");
   return locator;
 }

/***
* 风险审核
* @throws IOException
*/
public Locator reviewDangerList() throws IOException
 {
   Locator locator=getLocator("reviewDangerList");
   return locator;
 }

/***
* 部门风险清单
* @throws IOException
*/
public Locator departReportDangerList() throws IOException
 {
   Locator locator=getLocator("departReportDangerList");
   return locator;
 }

/***
* 年度辨识报告
* @throws IOException
*/
public Locator yearIdentifyReport() throws IOException
 {
   Locator locator=getLocator("yearIdentifyReport");
   return locator;
 }

/***
* 基础数据管理-list
* @throws IOException
*/
public Locator jcsjgl_li() throws IOException
 {
   Locator locator=getLocator("jcsjgl_li");
   return locator;
 }

/***
* 岗位管理
* @throws IOException
*/
public Locator postList() throws IOException
 {
   Locator locator=getLocator("postList");
   return locator;
 }

/***
* 作业活动管理
* @throws IOException
*/
public Locator activityList() throws IOException
 {
   Locator locator=getLocator("activityList");
   return locator;
 }

/***
* 危险源管理
* @throws IOException
*/
public Locator hazardList() throws IOException
 {
   Locator locator=getLocator("hazardList");
   return locator;
 }

/***
* 辅助管理
* @throws IOException
*/
public Locator fzgl() throws IOException
 {
   Locator locator=getLocator("fzgl");
   return locator;
 }

/***
* 职业卫生
* @throws IOException
*/
public Locator zyws() throws IOException
 {
   Locator locator=getLocator("zyws");
   return locator;
 }

/***
* 职工个人基本信息
* @throws IOException
*/
public Locator employeeInfoList() throws IOException
 {
   Locator locator=getLocator("employeeInfoList");
   return locator;
 }
}