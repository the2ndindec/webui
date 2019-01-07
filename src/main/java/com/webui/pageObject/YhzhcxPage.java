package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 隐患综合查询页面
 * @author the2n
 */
public class YhzhcxPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   YhzhcxPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 隐患综合查询页面iframe标记
* @throws IOException
*/
public Locator iframe_list() throws IOException
 {
   Locator locator=getLocator("iframe_list");
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
* 查看/编辑数据部分iframe标记
* @throws IOException
*/
public Locator iframe_update() throws IOException
 {
   Locator locator=getLocator("iframe_update");
   return locator;
 }

/***
* 选择危险源部分iframe标记
* @throws IOException
*/
public Locator iframe_chooseDangerSource() throws IOException
 {
   Locator locator=getLocator("iframe_chooseDangerSource");
   return locator;
 }

/***
* 查看历史部分iframe标记
* @throws IOException
*/
public Locator iframe_fkHiddenInfoId() throws IOException
 {
   Locator locator=getLocator("iframe_fkHiddenInfoId");
   return locator;
 }

/***
* 五落实部分iframe标记
* @throws IOException
*/
public Locator iframe_goFiveImpl() throws IOException
 {
   Locator locator=getLocator("iframe_goFiveImpl");
   return locator;
 }

/***
* 督办查看部分iframe标记
* @throws IOException
*/
public Locator iframe_supervise() throws IOException
 {
   Locator locator=getLocator("iframe_supervise");
   return locator;
 }

/***
* 五落实查看按钮
* @throws IOException
*/
public Locator goFiveImpl_Button() throws IOException
 {
   Locator locator=getLocator("goFiveImpl_Button");
   return locator;
 }

/***
* 查看历史按钮
* @throws IOException
*/
public Locator fkHiddenInfoId_Button() throws IOException
 {
   Locator locator=getLocator("fkHiddenInfoId_Button");
   return locator;
 }

/***
* 督办查看按钮
* @throws IOException
*/
public Locator supervise_Button() throws IOException
 {
   Locator locator=getLocator("supervise_Button");
   return locator;
 }

/***
* 重大隐患上报
* @throws IOException
*/
public Locator majorDangerReport_Button() throws IOException
 {
   Locator locator=getLocator("majorDangerReport_Button");
   return locator;
 }

/***
* 督办同步
* @throws IOException
*/
public Locator synSupervise_Button() throws IOException
 {
   Locator locator=getLocator("synSupervise_Button");
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
* 查询条件--隐患专业
* @throws IOException
*/
public Locator hdMajor_search_area() throws IOException
 {
   Locator locator=getLocator("hdMajor_search_area");
   return locator;
 }

/***
* 查询条件--隐患状态
* @throws IOException
*/
public Locator clStatus_search_area() throws IOException
 {
   Locator locator=getLocator("clStatus_search_area");
   return locator;
 }

/***
* 排查日期
* @throws IOException
*/
public Locator inveDate() throws IOException
 {
   Locator locator=getLocator("inveDate");
   return locator;
 }

/***
* 隐患地点下拉框
* @throws IOException
*/
public Locator hdLocationSelect() throws IOException
 {
   Locator locator=getLocator("hdLocationSelect");
   return locator;
 }

/***
* 隐患信息来源
* @throws IOException
*/
public Locator hdInfoSource() throws IOException
 {
   Locator locator=getLocator("hdInfoSource");
   return locator;
 }

/***
* 隐患类别
* @throws IOException
*/
public Locator hdCate() throws IOException
 {
   Locator locator=getLocator("hdCate");
   return locator;
 }

/***
* 隐患专业
* @throws IOException
*/
public Locator hdMajor() throws IOException
 {
   Locator locator=getLocator("hdMajor");
   return locator;
 }

/***
* 隐患类型
* @throws IOException
*/
public Locator hiddenType() throws IOException
 {
   Locator locator=getLocator("hiddenType");
   return locator;
 }

/***
* 责任单位下拉框
* @throws IOException
*/
public Locator magicsuggestDutyUnitSel() throws IOException
 {
   Locator locator=getLocator("magicsuggestDutyUnitSel");
   return locator;
 }

/***
* 责任人下拉框
* @throws IOException
*/
public Locator magicsuggestDutyMan() throws IOException
 {
   Locator locator=getLocator("magicsuggestDutyMan");
   return locator;
 }

/***
* 整改时限
* @throws IOException
*/
public Locator rectPeriod() throws IOException
 {
   Locator locator=getLocator("rectPeriod");
   return locator;
 }

/***
* 隐患描述
* @throws IOException
*/
public Locator hdDesc() throws IOException
 {
   Locator locator=getLocator("hdDesc");
   return locator;
 }

/***
* 提交按钮
* @throws IOException
*/
public Locator submit_btn() throws IOException
 {
   Locator locator=getLocator("submit_btn");
   return locator;
 }

/***
* 选择危险源-辨识时间
* @throws IOException
*/
public Locator yeRecognizeYear() throws IOException
 {
   Locator locator=getLocator("yeRecognizeYear");
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
}