package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 矿风险清单页面
 * @author the2n
 */
public class ReportDangerListPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   ReportDangerListPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 矿风险清单页面iframe标记
* @throws IOException
*/
public Locator iframe_reportDangerList() throws IOException
 {
   Locator locator=getLocator("iframe_reportDangerList");
   return locator;
 }

/***
* 数据详情部分iframe标记
* @throws IOException
*/
public Locator iframe_detail() throws IOException
 {
   Locator locator=getLocator("iframe_detail");
   return locator;
 }

/***
* 关联风险点-风险点部分iframe标记
* @throws IOException
*/
public Locator iframe_addresslist() throws IOException
 {
   Locator locator=getLocator("iframe_addresslist");
   return locator;
 }

/***
* 关联风险点-选择风险点部分iframe标记
* @throws IOException
*/
public Locator iframe_addressAddlist() throws IOException
 {
   Locator locator=getLocator("iframe_addressAddlist");
   return locator;
 }

/***
* 一键复制部分iframe标记
* @throws IOException
*/
public Locator iframe_goOneKeyCopy() throws IOException
 {
   Locator locator=getLocator("iframe_goOneKeyCopy");
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
* 一键复制按钮
* @throws IOException
*/
public Locator copy_Button() throws IOException
 {
   Locator locator=getLocator("copy_Button");
   return locator;
 }

/***
* 关联风险点
* @throws IOException
*/
public Locator chooseAddress_Button() throws IOException
 {
   Locator locator=getLocator("chooseAddress_Button");
   return locator;
 }

/***
* 上报省局平台
* @throws IOException
*/
public Locator goReport_Button() throws IOException
 {
   Locator locator=getLocator("goReport_Button");
   return locator;
 }

/***
* 全部上报省局平台
* @throws IOException
*/
public Locator goReportAll_Button() throws IOException
 {
   Locator locator=getLocator("goReportAll_Button");
   return locator;
 }

/***
* 撤回按钮
* @throws IOException
*/
public Locator mineCallback_Button() throws IOException
 {
   Locator locator=getLocator("mineCallback_Button");
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
* 全部 
* @throws IOException
*/
public Locator all_radio() throws IOException
 {
   Locator locator=getLocator("all_radio");
   return locator;
 }

/***
* 待上报
* @throws IOException
*/
public Locator toBeReported_radio() throws IOException
 {
   Locator locator=getLocator("toBeReported_radio");
   return locator;
 }

/***
* 已上报
* @throws IOException
*/
public Locator beenReported_radio() throws IOException
 {
   Locator locator=getLocator("beenReported_radio");
   return locator;
 }

/***
* 查询条件--风险点类型
* @throws IOException
*/
public Locator addressCate_select() throws IOException
 {
   Locator locator=getLocator("addressCate_select");
   return locator;
 }

/***
* 查询条件--辨识时间开始输入框
* @throws IOException
*/
public Locator yeRecognizeTime_begin_textarea() throws IOException
 {
   Locator locator=getLocator("yeRecognizeTime_begin_textarea");
   return locator;
 }

/***
* 查询条件--辨识时间结束输入框
* @throws IOException
*/
public Locator yeRecognizeTime_end_textarea() throws IOException
 {
   Locator locator=getLocator("yeRecognizeTime_end_textarea");
   return locator;
 }

/***
* 查询条件--隐患描述输入框
* @throws IOException
*/
public Locator yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("yeMhazardDesc_textarea");
   return locator;
 }

/***
* 查询条件--专业选择框
* @throws IOException
*/
public Locator yeProfession_select() throws IOException
 {
   Locator locator=getLocator("yeProfession_select");
   return locator;
 }

/***
* 查询条件--伤害类别
* @throws IOException
*/
public Locator damageType_select() throws IOException
 {
   Locator locator=getLocator("damageType_select");
   return locator;
 }

/***
* 查询条件--风险描述输入框
* @throws IOException
*/
public Locator yePossiblyHazard_textarea() throws IOException
 {
   Locator locator=getLocator("yePossiblyHazard_textarea");
   return locator;
 }

/***
* 查询条件--作业活动
* @throws IOException
*/
public Locator activityId_select() throws IOException
 {
   Locator locator=getLocator("activityId_select");
   return locator;
 }

/***
* 查询条件--风险等级
* @throws IOException
*/
public Locator yeRiskGrade_select() throws IOException
 {
   Locator locator=getLocator("yeRiskGrade_select");
   return locator;
 }

/***
* 查询条件--风险类型
* @throws IOException
*/
public Locator yeHazardCate_select() throws IOException
 {
   Locator locator=getLocator("yeHazardCate_select");
   return locator;
 }

/***
* 查询条件--管控标准来源输入框
* @throws IOException
*/
public Locator docSource_textarea() throws IOException
 {
   Locator locator=getLocator("docSource_textarea");
   return locator;
 }

/***
* 查询条件--标准内容输入框
* @throws IOException
*/
public Locator yeStandard_textarea() throws IOException
 {
   Locator locator=getLocator("yeStandard_textarea");
   return locator;
 }

/***
* 查询条件--隐患等级
* @throws IOException
*/
public Locator hiddenLevel_select() throws IOException
 {
   Locator locator=getLocator("hiddenLevel_select");
   return locator;
 }

/***
* 关联风险点-风险点部分：查询条件--地点输入框
* @throws IOException
*/
public Locator addresslist_address_textarea() throws IOException
 {
   Locator locator=getLocator("addresslist_address_textarea");
   return locator;
 }

/***
* 关联风险点-风险点部分：查询按钮
* @throws IOException
*/
public Locator addresslist_search_Button() throws IOException
 {
   Locator locator=getLocator("addresslist_search_Button");
   return locator;
 }

/***
* 关联风险点-风险点部分：重置按钮
* @throws IOException
*/
public Locator addresslist_reload_Button() throws IOException
 {
   Locator locator=getLocator("addresslist_reload_Button");
   return locator;
 }

/***
* 关联风险点-风险点部分：选择风险点按钮
* @throws IOException
*/
public Locator addresslist_chooseAddress_Button() throws IOException
 {
   Locator locator=getLocator("addresslist_chooseAddress_Button");
   return locator;
 }

/***
* 关联风险点-风险点部分：删除关联按钮
* @throws IOException
*/
public Locator addresslist_delAddressRel_Button() throws IOException
 {
   Locator locator=getLocator("addresslist_delAddressRel_Button");
   return locator;
 }

/***
* 关联风险点-选择风险点部分：查询条件--地点输入框
* @throws IOException
*/
public Locator addressAddlist_address_textarea() throws IOException
 {
   Locator locator=getLocator("addressAddlist_address_textarea");
   return locator;
 }

/***
* 关联风险点-选择风险点部分：查询按钮
* @throws IOException
*/
public Locator addressAddlist_search_Button() throws IOException
 {
   Locator locator=getLocator("addressAddlist_search_Button");
   return locator;
 }

/***
* 关联风险点-选择风险点部分：重置按钮
* @throws IOException
*/
public Locator addressAddlist_reload_Button() throws IOException
 {
   Locator locator=getLocator("addressAddlist_reload_Button");
   return locator;
 }

/***
* 关联风险点-选择风险点部分：关联风险点按钮
* @throws IOException
*/
public Locator addressAddlist_addRelFunction_Button() throws IOException
 {
   Locator locator=getLocator("addressAddlist_addRelFunction_Button");
   return locator;
 }

/***
* 一键复制开始时间
* @throws IOException
*/
public Locator cloneFrom_textarea() throws IOException
 {
   Locator locator=getLocator("cloneFrom_textarea");
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
}