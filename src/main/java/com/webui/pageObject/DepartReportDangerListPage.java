package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 部门风险清单页面
 * @author the2n
 */
public class DepartReportDangerListPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   DepartReportDangerListPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 部门风险清单页面iframe标记
* @throws IOException
*/
public Locator iframe_departReportDangerList() throws IOException
 {
   Locator locator=getLocator("iframe_departReportDangerList");
   return locator;
 }

/***
* 年度辨识复制部分iframe标记
* @throws IOException
*/
public Locator iframe_goCloneYearDanger() throws IOException
 {
   Locator locator=getLocator("iframe_goCloneYearDanger");
   return locator;
 }

/***
* 从通用库复制部分iframe标记
* @throws IOException
*/
public Locator iframe_associateMajorGeneralDangerSource() throws IOException
 {
   Locator locator=getLocator("iframe_associateMajorGeneralDangerSource");
   return locator;
 }

/***
* 添加风险部分iframe标记
* @throws IOException
*/
public Locator iframe_goAddDepartDangerSource() throws IOException
 {
   Locator locator=getLocator("iframe_goAddDepartDangerSource");
   return locator;
 }

/***
* 编辑风险部分iframe标记
* @throws IOException
*/
public Locator iframe_goUpdateDepartDangerSource() throws IOException
 {
   Locator locator=getLocator("iframe_goUpdateDepartDangerSource");
   return locator;
 }

/***
* 查看风险部分iframe标记
* @throws IOException
*/
public Locator iframe_goDetail() throws IOException
 {
   Locator locator=getLocator("iframe_goDetail");
   return locator;
 }

/***
* 年度辨识复制按钮
* @throws IOException
*/
public Locator goCloneYearDanger_Button() throws IOException
 {
   Locator locator=getLocator("goCloneYearDanger_Button");
   return locator;
 }

/***
* 从通用库复制按钮
* @throws IOException
*/
public Locator chooseDangerSource_Button() throws IOException
 {
   Locator locator=getLocator("chooseDangerSource_Button");
   return locator;
 }

/***
* 导出按钮
* @throws IOException
*/
public Locator exportXls_Button() throws IOException
 {
   Locator locator=getLocator("exportXls_Button");
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
* 上报审核按钮
* @throws IOException
*/
public Locator goReport_Button() throws IOException
 {
   Locator locator=getLocator("goReport_Button");
   return locator;
 }

/***
* 全部上报审核按钮
* @throws IOException
*/
public Locator doReportAll_Button() throws IOException
 {
   Locator locator=getLocator("doReportAll_Button");
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
* 模板下载按钮
* @throws IOException
*/
public Locator importXlsT_Button() throws IOException
 {
   Locator locator=getLocator("importXlsT_Button");
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
* 撤回全部按钮
* @throws IOException
*/
public Locator undoReportAll_Button() throws IOException
 {
   Locator locator=getLocator("undoReportAll_Button");
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
* 查询条件--辨识时间开始输入框
* @throws IOException
*/
public Locator s_yeRecognizeTime_begin_textarea() throws IOException
 {
   Locator locator=getLocator("s_yeRecognizeTime_begin_textarea");
   return locator;
 }

/***
* 查询条件--辨识时间结束输入框
* @throws IOException
*/
public Locator s_yeRecognizeTime_end_textarea() throws IOException
 {
   Locator locator=getLocator("s_yeRecognizeTime_end_textarea");
   return locator;
 }

/***
* 查询条件--隐患描述输入框
* @throws IOException
*/
public Locator s_yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("s_yeMhazardDesc_textarea");
   return locator;
 }

/***
* 查询条件--专业选择框
* @throws IOException
*/
public Locator s_yeProfession_select() throws IOException
 {
   Locator locator=getLocator("s_yeProfession_select");
   return locator;
 }

/***
* 查询条件--伤害类别
* @throws IOException
*/
public Locator s_damageType_select() throws IOException
 {
   Locator locator=getLocator("s_damageType_select");
   return locator;
 }

/***
* 查询条件--风险描述输入框
* @throws IOException
*/
public Locator s_yePossiblyHazard_textarea() throws IOException
 {
   Locator locator=getLocator("s_yePossiblyHazard_textarea");
   return locator;
 }

/***
* 查询条件--作业活动
* @throws IOException
*/
public Locator s_activityId_select() throws IOException
 {
   Locator locator=getLocator("s_activityId_select");
   return locator;
 }

/***
* 查询条件--风险等级
* @throws IOException
*/
public Locator s_yeRiskGrade_select() throws IOException
 {
   Locator locator=getLocator("s_yeRiskGrade_select");
   return locator;
 }

/***
* 查询条件--风险类型
* @throws IOException
*/
public Locator s_yeHazardCate_select() throws IOException
 {
   Locator locator=getLocator("s_yeHazardCate_select");
   return locator;
 }

/***
* 查询条件--管控标准来源输入框
* @throws IOException
*/
public Locator s_docSource_textarea() throws IOException
 {
   Locator locator=getLocator("s_docSource_textarea");
   return locator;
 }

/***
* 查询条件--标准内容输入框
* @throws IOException
*/
public Locator s_yeStandard_textarea() throws IOException
 {
   Locator locator=getLocator("s_yeStandard_textarea");
   return locator;
 }

/***
* 查询条件--隐患等级
* @throws IOException
*/
public Locator s_hiddenLevel_select() throws IOException
 {
   Locator locator=getLocator("s_hiddenLevel_select");
   return locator;
 }

/***
* 风险点类型
* @throws IOException
*/
public Locator addressCate_select() throws IOException
 {
   Locator locator=getLocator("addressCate_select");
   return locator;
 }

/***
* 编辨识时间输入框
* @throws IOException
*/
public Locator yeRecognizeTime_textarea() throws IOException
 {
   Locator locator=getLocator("yeRecognizeTime_textarea");
   return locator;
 }

/***
* 专业选择框
* @throws IOException
*/
public Locator yeProfession_select() throws IOException
 {
   Locator locator=getLocator("yeProfession_select");
   return locator;
 }

/***
* 危险源名称输入框
* @throws IOException
*/
public Locator hazardName_input() throws IOException
 {
   Locator locator=getLocator("hazardName_input");
   return locator;
 }

/***
* 危险源名称下拉按钮
* @throws IOException
*/
public Locator hazardNameList() throws IOException
 {
   Locator locator=getLocator("hazardNameList");
   return locator;
 }

/***
* 删除危险源
* @throws IOException
*/
public Locator hazard_ms_close() throws IOException
 {
   Locator locator=getLocator("hazard_ms_close");
   return locator;
 }

/***
* 风险描述输入框
* @throws IOException
*/
public Locator yePossiblyHazard_textarea() throws IOException
 {
   Locator locator=getLocator("yePossiblyHazard_textarea");
   return locator;
 }

/***
* 风险可能性选择框
* @throws IOException
*/
public Locator yeProbability_select() throws IOException
 {
   Locator locator=getLocator("yeProbability_select");
   return locator;
 }

/***
* 风险损失选择框
* @throws IOException
*/
public Locator yeCost_select() throws IOException
 {
   Locator locator=getLocator("yeCost_select");
   return locator;
 }

/***
* 风险值
* @throws IOException
*/
public Locator riskValue_textarea() throws IOException
 {
   Locator locator=getLocator("riskValue_textarea");
   return locator;
 }

/***
* 风险等级
* @throws IOException
*/
public Locator yeRiskGrade_textarea() throws IOException
 {
   Locator locator=getLocator("yeRiskGrade_textarea");
   return locator;
 }

/***
* 风险类型
* @throws IOException
*/
public Locator yeHazardCate_select() throws IOException
 {
   Locator locator=getLocator("yeHazardCate_select");
   return locator;
 }

/***
* 作业活动下拉按钮
* @throws IOException
*/
public Locator activityNameList() throws IOException
 {
   Locator locator=getLocator("activityNameList");
   return locator;
 }

/***
* 删除作业活动
* @throws IOException
*/
public Locator activity_ms_close() throws IOException
 {
   Locator locator=getLocator("activity_ms_close");
   return locator;
 }

/***
* 管控标准来源输入框
* @throws IOException
*/
public Locator docSource_textarea() throws IOException
 {
   Locator locator=getLocator("docSource_textarea");
   return locator;
 }

/***
* 章节条款输入框
* @throws IOException
*/
public Locator ectionName_textarea() throws IOException
 {
   Locator locator=getLocator("ectionName_textarea");
   return locator;
 }

/***
* 标准内容输入框
* @throws IOException
*/
public Locator yeStandard_textarea() throws IOException
 {
   Locator locator=getLocator("yeStandard_textarea");
   return locator;
 }

/***
* 管控措施输入框
* @throws IOException
*/
public Locator manageMeasure_textarea() throws IOException
 {
   Locator locator=getLocator("manageMeasure_textarea");
   return locator;
 }

/***
* 责任岗位下拉按钮
* @throws IOException
*/
public Locator postNameList() throws IOException
 {
   Locator locator=getLocator("postNameList");
   return locator;
 }

/***
* 删除责任岗位
* @throws IOException
*/
public Locator postname_ms_close() throws IOException
 {
   Locator locator=getLocator("postname_ms_close");
   return locator;
 }

/***
* 隐患描述输入框
* @throws IOException
*/
public Locator yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("yeMhazardDesc_textarea");
   return locator;
 }

/***
* 隐患等级
* @throws IOException
*/
public Locator hiddenLevel_select() throws IOException
 {
   Locator locator=getLocator("hiddenLevel_select");
   return locator;
 }

/***
* 罚款金额输入框
* @throws IOException
*/
public Locator fineMoney_textarea() throws IOException
 {
   Locator locator=getLocator("fineMoney_textarea");
   return locator;
 }

/***
* 保存按钮
* @throws IOException
*/
public Locator save_btn() throws IOException
 {
   Locator locator=getLocator("save_btn");
   return locator;
 }

/***
* 保存并提交按钮
* @throws IOException
*/
public Locator subRep_btn() throws IOException
 {
   Locator locator=getLocator("subRep_btn");
   return locator;
 }

/***
* 关闭按钮
* @throws IOException
*/
public Locator closeBtn() throws IOException
 {
   Locator locator=getLocator("closeBtn");
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
* 提示信息
* @throws IOException
*/
public Locator tip() throws IOException
 {
   Locator locator=getLocator("tip");
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