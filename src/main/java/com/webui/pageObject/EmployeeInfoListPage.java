package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 职工个人基本信息页面
 * @author the2n
 */
public class EmployeeInfoListPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   EmployeeInfoListPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 职工个人基本信息页面iframe标记
* @throws IOException
*/
public Locator iframe_employeeInfoList() throws IOException
 {
   Locator locator=getLocator("iframe_employeeInfoList");
   return locator;
 }

/***
* 职工信息编辑部分iframe标记
* @throws IOException
*/
public Locator iframe_goUpdate() throws IOException
 {
   Locator locator=getLocator("iframe_goUpdate");
   return locator;
 }

/***
* 职工信息详情部分iframe标记
* @throws IOException
*/
public Locator iframe_detail() throws IOException
 {
   Locator locator=getLocator("iframe_detail");
   return locator;
 }

/***
* 添加职工信息部分iframe标记
* @throws IOException
*/
public Locator iframe_goAdd() throws IOException
 {
   Locator locator=getLocator("iframe_goAdd");
   return locator;
 }

/***
* 导出按钮
* @throws IOException
*/
public Locator exportXlsByT_Button() throws IOException
 {
   Locator locator=getLocator("exportXlsByT_Button");
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
* 导入按钮
* @throws IOException
*/
public Locator importXls_Button() throws IOException
 {
   Locator locator=getLocator("importXls_Button");
   return locator;
 }

/***
* 导入模板下载按钮
* @throws IOException
*/
public Locator importXlsT_Button() throws IOException
 {
   Locator locator=getLocator("importXlsT_Button");
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
public Locator reload_Button() throws IOException
 {
   Locator locator=getLocator("reload_Button");
   return locator;
 }

/***
* 查询条件--档案号输入框
* @throws IOException
*/
public Locator fileNo_textarea() throws IOException
 {
   Locator locator=getLocator("fileNo_textarea");
   return locator;
 }

/***
* 查询条件--在岗编号输入框
* @throws IOException
*/
public Locator postNumber_textarea() throws IOException
 {
   Locator locator=getLocator("postNumber_textarea");
   return locator;
 }

/***
* 查询条件--退休编号输入框
* @throws IOException
*/
public Locator retireNumber_textarea() throws IOException
 {
   Locator locator=getLocator("retireNumber_textarea");
   return locator;
 }

/***
* 查询条件-姓名输入框
* @throws IOException
*/
public Locator name_textarea() throws IOException
 {
   Locator locator=getLocator("name_textarea");
   return locator;
 }

/***
* 查询条件-身份证号输入框
* @throws IOException
*/
public Locator cardNumber_textarea() throws IOException
 {
   Locator locator=getLocator("cardNumber_textarea");
   return locator;
 }

/***
* 添加职工信息部分：档案号输入框
* @throws IOException
*/
public Locator fileNo_textarea() throws IOException
 {
   Locator locator=getLocator("fileNo_textarea");
   return locator;
 }

/***
* 添加职工信息部分：在岗编号输入框
* @throws IOException
*/
public Locator postNumber_textarea() throws IOException
 {
   Locator locator=getLocator("postNumber_textarea");
   return locator;
 }

/***
* 添加职工信息部分：退休编号输入框
* @throws IOException
*/
public Locator retireNumber_textarea() throws IOException
 {
   Locator locator=getLocator("retireNumber_textarea");
   return locator;
 }

/***
* 添加职工信息部分：姓名输入框
* @throws IOException
*/
public Locator name_textarea() throws IOException
 {
   Locator locator=getLocator("name_textarea");
   return locator;
 }

/***
* 添加职工信息部分：性别
* @throws IOException
*/
public Locator gender_textarea() throws IOException
 {
   Locator locator=getLocator("gender_textarea");
   return locator;
 }

/***
* 添加职工信息部分：身份证号输入框
* @throws IOException
*/
public Locator cardNumber_textarea() throws IOException
 {
   Locator locator=getLocator("cardNumber_textarea");
   return locator;
 }

/***
* 添加职工信息部分：参加工作时间输入框
* @throws IOException
*/
public Locator partiWorkDate_textarea() throws IOException
 {
   Locator locator=getLocator("partiWorkDate_textarea");
   return locator;
 }

/***
* 添加职工信息部分：现工作单位输入框
* @throws IOException
*/
public Locator currWorkUnits_textarea() throws IOException
 {
   Locator locator=getLocator("currWorkUnits_textarea");
   return locator;
 }

/***
* 添加职工信息部分：现从事工种输入框
* @throws IOException
*/
public Locator currTrade_textarea() throws IOException
 {
   Locator locator=getLocator("currTrade_textarea");
   return locator;
 }

/***
* 添加职工信息部分：接触职业危害种类输入框
* @throws IOException
*/
public Locator jobHazardCategory_textarea() throws IOException
 {
   Locator locator=getLocator("jobHazardCategory_textarea");
   return locator;
 }

/***
* 添加职工信息部分：岗位类别
* @throws IOException
*/
public Locator postCategory_textarea() throws IOException
 {
   Locator locator=getLocator("postCategory_textarea");
   return locator;
 }

/***
* 添加职工信息部分：岗位状态
* @throws IOException
*/
public Locator postStatus_textarea() throws IOException
 {
   Locator locator=getLocator("postStatus_textarea");
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
* 提示信息
* @throws IOException
*/
public Locator error_tip() throws IOException
 {
   Locator locator=getLocator("error_tip");
   return locator;
 }

/***
* 审核弹框部分：确定按钮
* @throws IOException
*/
public Locator check_confirm_btn() throws IOException
 {
   Locator locator=getLocator("check_confirm_btn");
   return locator;
 }

/***
* 审核弹框部分：关闭按钮
* @throws IOException
*/
public Locator check_close_btn() throws IOException
 {
   Locator locator=getLocator("check_close_btn");
   return locator;
 }

/***
* 审核弹框部分：取消按钮
* @throws IOException
*/
public Locator check_cancel_btn() throws IOException
 {
   Locator locator=getLocator("check_cancel_btn");
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
}