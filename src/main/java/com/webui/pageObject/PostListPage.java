package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 岗位管理页面
 * @author the2n
 */
public class PostListPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   PostListPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 岗位管理页面iframe标记
* @throws IOException
*/
public Locator iframe_PostList() throws IOException
 {
   Locator locator=getLocator("iframe_PostList");
   return locator;
 }

/***
* 录入数据部分iframe标记
* @throws IOException
*/
public Locator iframe_goAdd() throws IOException
 {
   Locator locator=getLocator("iframe_goAdd");
   return locator;
 }

/***
* 编辑/查看部分iframe标记
* @throws IOException
*/
public Locator iframe_goUpdate() throws IOException
 {
   Locator locator=getLocator("iframe_goUpdate");
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
* 导出按钮
* @throws IOException
*/
public Locator ExportXls_Button() throws IOException
 {
   Locator locator=getLocator("ExportXls_Button");
   return locator;
 }

/***
* 导出风险按钮
* @throws IOException
*/
public Locator postRelDangerExportXls_Button() throws IOException
 {
   Locator locator=getLocator("postRelDangerExportXls_Button");
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
* 批量删除按钮
* @throws IOException
*/
public Locator deleteALLSelect_Button() throws IOException
 {
   Locator locator=getLocator("deleteALLSelect_Button");
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
* 查询条件--岗位名称
* @throws IOException
*/
public Locator postName_search_area() throws IOException
 {
   Locator locator=getLocator("postName_search_area");
   return locator;
 }

/***
* 录入岗位部分：岗位名称输入框
* @throws IOException
*/
public Locator add_postName_area() throws IOException
 {
   Locator locator=getLocator("add_postName_area");
   return locator;
 }

/***
* 编辑岗位部分：岗位名称输入框
* @throws IOException
*/
public Locator update_postName_area() throws IOException
 {
   Locator locator=getLocator("update_postName_area");
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