package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 作业活动管理页面
 * @author the2n
 */
public class ActivityManagePage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   ActivityManagePage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 作业活动管理页面iframe标记
* @throws IOException
*/
public Locator iframe_activity() throws IOException
 {
   Locator locator=getLocator("iframe_activity");
   return locator;
 }

/***
* 录入/编辑数据部分iframe标记
* @throws IOException
*/
public Locator iframe_addOrUpdate() throws IOException
 {
   Locator locator=getLocator("iframe_addOrUpdate");
   return locator;
 }

/***
* 查看关联关系部分iframe标记
* @throws IOException
*/
public Locator iframe_seeRiskList() throws IOException
 {
   Locator locator=getLocator("iframe_seeRiskList");
   return locator;
 }

/***
* 导入按钮
* @throws IOException
*/
public Locator ImportXls_Button() throws IOException
 {
   Locator locator=getLocator("ImportXls_Button");
   return locator;
 }

/***
* 导出按钮
* @throws IOException
*/
public Locator ExportXls_Button() throws IOException
 {
   Locator locator=getLocator("ExportXls_Button");
   return locator;
 }

/***
* 查看按钮
* @throws IOException
*/
public Locator detail_Button() throws IOException
 {
   Locator locator=getLocator("detail_Button");
   return locator;
 }

/***
* 录入按钮
* @throws IOException
*/
public Locator add_Button() throws IOException
 {
   Locator locator=getLocator("add_Button");
   return locator;
 }

/***
* 编辑按钮
* @throws IOException
*/
public Locator update_Button() throws IOException
 {
   Locator locator=getLocator("update_Button");
   return locator;
 }

/***
* 查询按钮
* @throws IOException
*/
public Locator search_Button() throws IOException
 {
   Locator locator=getLocator("search_Button");
   return locator;
 }

/***
* 重置按钮
* @throws IOException
*/
public Locator searchReset_Btn() throws IOException
 {
   Locator locator=getLocator("searchReset_Btn");
   return locator;
 }

/***
* 查询条件--作业活动名称
* @throws IOException
*/
public Locator activityName_search_area() throws IOException
 {
   Locator locator=getLocator("activityName_search_area");
   return locator;
 }

/***
* 录入部分：作业活动名称输入框
* @throws IOException
*/
public Locator activityName_area() throws IOException
 {
   Locator locator=getLocator("activityName_area");
   return locator;
 }

/***
* 重复作业信息时，提示信息
* @throws IOException
*/
public Locator activity_tip() throws IOException
 {
   Locator locator=getLocator("activity_tip");
   return locator;
 }

/***
* 删除部分：确定按钮
* @throws IOException
*/
public Locator del_confirm() throws IOException
 {
   Locator locator=getLocator("del_confirm");
   return locator;
 }

/***
* 删除部分：取消按钮
* @throws IOException
*/
public Locator del_cancel() throws IOException
 {
   Locator locator=getLocator("del_cancel");
   return locator;
 }

/***
* 数据列表
* @throws IOException
*/
public Locator data_tbody() throws IOException
 {
   Locator locator=getLocator("data_tbody");
   return locator;
 }

/***
* 底部信息--数据总量
* @throws IOException
*/
public Locator data_num() throws IOException
 {
   Locator locator=getLocator("data_num");
   return locator;
 }

/***
* 底部信息--每页显示数量
* @throws IOException
*/
public Locator data_pagelist() throws IOException
 {
   Locator locator=getLocator("data_pagelist");
   return locator;
 }

/***
* 底部信息--首页按钮
* @throws IOException
*/
public Locator data_firstPage() throws IOException
 {
   Locator locator=getLocator("data_firstPage");
   return locator;
 }

/***
* 底部信息--上一页按钮
* @throws IOException
*/
public Locator data_prevPage() throws IOException
 {
   Locator locator=getLocator("data_prevPage");
   return locator;
 }

/***
* 底部信息--下一页按钮
* @throws IOException
*/
public Locator data_nexttPage() throws IOException
 {
   Locator locator=getLocator("data_nexttPage");
   return locator;
 }

/***
* 底部信息--尾页按钮
* @throws IOException
*/
public Locator data_lastPage() throws IOException
 {
   Locator locator=getLocator("data_lastPage");
   return locator;
 }

/***
* 弹窗--最小化按钮
* @throws IOException
*/
public Locator min_ui() throws IOException
 {
   Locator locator=getLocator("min_ui");
   return locator;
 }

/***
* 弹窗--最大化按钮
* @throws IOException
*/
public Locator max_ui() throws IOException
 {
   Locator locator=getLocator("max_ui");
   return locator;
 }

/***
* 弹窗--关闭按钮
* @throws IOException
*/
public Locator close_ui() throws IOException
 {
   Locator locator=getLocator("close_ui");
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
* 关闭按钮
* @throws IOException
*/
public Locator close_btn() throws IOException
 {
   Locator locator=getLocator("close_btn");
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