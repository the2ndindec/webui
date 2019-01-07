package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 新工作面风险评估页面
 * @author the2n
 */
public class XgzmPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   XgzmPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 新工作面风险评估页面iframe标记
* @throws IOException
*/
public Locator iframe_xgzm() throws IOException
 {
   Locator locator=getLocator("iframe_xgzm");
   return locator;
 }

/***
* 录入数据部分iframe标记
* @throws IOException
*/
public Locator iframe_add() throws IOException
 {
   Locator locator=getLocator("iframe_add");
   return locator;
 }

/***
* 编辑数据部分iframe标记
* @throws IOException
*/
public Locator iframe_update() throws IOException
 {
   Locator locator=getLocator("iframe_update");
   return locator;
 }

/***
* 选择辨识人员部分iframe标记
* @throws IOException
*/
public Locator iframe_userManySelectList() throws IOException
 {
   Locator locator=getLocator("iframe_userManySelectList");
   return locator;
 }

/***
* 上报按钮
* @throws IOException
*/
public Locator departReport_Button() throws IOException
 {
   Locator locator=getLocator("departReport_Button");
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
* 撤回按钮
* @throws IOException
*/
public Locator toReportCallback_Button() throws IOException
 {
   Locator locator=getLocator("toReportCallback_Button");
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
* 查询条件--辨识名称
* @throws IOException
*/
public Locator name_search_area() throws IOException
 {
   Locator locator=getLocator("name_search_area");
   return locator;
 }

/***
* 查询条件--辨识开始时间
* @throws IOException
*/
public Locator time_begin_search_area() throws IOException
 {
   Locator locator=getLocator("time_begin_search_area");
   return locator;
 }

/***
* 查询条件--辨识结束时间
* @throws IOException
*/
public Locator time_end_search_area() throws IOException
 {
   Locator locator=getLocator("time_end_search_area");
   return locator;
 }

/***
* 全部
* @throws IOException
*/
public Locator radio_all() throws IOException
 {
   Locator locator=getLocator("radio_all");
   return locator;
 }

/***
* 待上报
* @throws IOException
*/
public Locator radio_reporting() throws IOException
 {
   Locator locator=getLocator("radio_reporting");
   return locator;
 }

/***
* 查询条件--辨识结束时间
* @throws IOException
*/
public Locator radio_reported() throws IOException
 {
   Locator locator=getLocator("radio_reported");
   return locator;
 }

/***
* 辨识人类型
* @throws IOException
*/
public Locator leaderType_select() throws IOException
 {
   Locator locator=getLocator("leaderType_select");
   return locator;
 }

/***
* 辨识负责人下拉框
* @throws IOException
*/
public Locator leader_select() throws IOException
 {
   Locator locator=getLocator("leader_select");
   return locator;
 }

/***
* 辨识时间
* @throws IOException
*/
public Locator time_input() throws IOException
 {
   Locator locator=getLocator("time_input");
   return locator;
 }

/***
* 辨识参加人员
* @throws IOException
*/
public Locator teamMembers() throws IOException
 {
   Locator locator=getLocator("teamMembers");
   return locator;
 }

/***
* 清空辨识参加人员按钮
* @throws IOException
*/
public Locator clearTeamMembers() throws IOException
 {
   Locator locator=getLocator("clearTeamMembers");
   return locator;
 }

/***
* 辨识地点下拉框
* @throws IOException
*/
public Locator locationSelect() throws IOException
 {
   Locator locator=getLocator("locationSelect");
   return locator;
 }

/***
* 辨识结论
* @throws IOException
*/
public Locator remark_textarea() throws IOException
 {
   Locator locator=getLocator("remark_textarea");
   return locator;
 }

/***
* 提示信息
* @throws IOException
*/
public Locator hazard_tip() throws IOException
 {
   Locator locator=getLocator("hazard_tip");
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