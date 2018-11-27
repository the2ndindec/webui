package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 风险审核页面
 * @author the2n
 */
public class ReviewDangerListPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   ReviewDangerListPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 风险审核页面页面iframe标记
* @return
* @throws IOException
*/
public Locator iframe_reviewDangerList() throws IOException
 {
   Locator locator=getLocator("iframe_reviewDangerList");
   return locator;
 }

/***
* 数据详情部分iframe标记
* @return
* @throws IOException
*/
public Locator iframe_detail() throws IOException
 {
   Locator locator=getLocator("iframe_detail");
   return locator;
 }

/***
* 审核弹框部分iframe标记
* @return
* @throws IOException
*/
public Locator iframe_reviewDangerSource() throws IOException
 {
   Locator locator=getLocator("iframe_reviewDangerSource");
   return locator;
 }

/***
* 编辑页面iframe标记
* @return
* @throws IOException
*/
public Locator iframe_goUpdateDangerSourceOnCheck() throws IOException
 {
   Locator locator=getLocator("iframe_goUpdateDangerSourceOnCheck");
   return locator;
 }

/***
* 导出按钮
* @return
* @throws IOException
*/
public Locator ExportXls_Button() throws IOException
 {
   Locator locator=getLocator("ExportXls_Button");
   return locator;
 }

/***
* 查看按钮
* @return
* @throws IOException
*/
public Locator detail_Button() throws IOException
 {
   Locator locator=getLocator("detail_Button");
   return locator;
 }

/***
* 审核按钮
* @return
* @throws IOException
*/
public Locator goReview_Button() throws IOException
 {
   Locator locator=getLocator("goReview_Button");
   return locator;
 }

/***
* 全部审核
* @return
* @throws IOException
*/
public Locator reviewAll_Button() throws IOException
 {
   Locator locator=getLocator("reviewAll_Button");
   return locator;
 }

/***
* 编辑
* @return
* @throws IOException
*/
public Locator editDangerSource_Button() throws IOException
 {
   Locator locator=getLocator("editDangerSource_Button");
   return locator;
 }

/***
* 批量删除
* @return
* @throws IOException
*/
public Locator deleteAllSelectedLogic_Button() throws IOException
 {
   Locator locator=getLocator("deleteAllSelectedLogic_Button");
   return locator;
 }

/***
* 查询按钮
* @return
* @throws IOException
*/
public Locator search_Button() throws IOException
 {
   Locator locator=getLocator("search_Button");
   return locator;
 }

/***
* 全部 
* @return
* @throws IOException
*/
public Locator all_radio() throws IOException
 {
   Locator locator=getLocator("all_radio");
   return locator;
 }

/***
* 待审核
* @return
* @throws IOException
*/
public Locator checkPending_radio() throws IOException
 {
   Locator locator=getLocator("checkPending_radio");
   return locator;
 }

/***
* 已审核
* @return
* @throws IOException
*/
public Locator checked_radio() throws IOException
 {
   Locator locator=getLocator("checked_radio");
   return locator;
 }

/***
* 查询条件--风险点类型
* @return
* @throws IOException
*/
public Locator addressCate_select() throws IOException
 {
   Locator locator=getLocator("addressCate_select");
   return locator;
 }

/***
* 查询条件--辨识时间开始输入框
* @return
* @throws IOException
*/
public Locator yeRecognizeTime_begin_textarea() throws IOException
 {
   Locator locator=getLocator("yeRecognizeTime_begin_textarea");
   return locator;
 }

/***
* 查询条件--辨识时间结束输入框
* @return
* @throws IOException
*/
public Locator yeRecognizeTime_end_textarea() throws IOException
 {
   Locator locator=getLocator("yeRecognizeTime_end_textarea");
   return locator;
 }

/***
* 查询条件--隐患描述输入框
* @return
* @throws IOException
*/
public Locator yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("yeMhazardDesc_textarea");
   return locator;
 }

/***
* 查询条件--专业选择框
* @return
* @throws IOException
*/
public Locator yeProfession_select() throws IOException
 {
   Locator locator=getLocator("yeProfession_select");
   return locator;
 }

/***
* 查询条件--伤害类别
* @return
* @throws IOException
*/
public Locator damageType_select() throws IOException
 {
   Locator locator=getLocator("damageType_select");
   return locator;
 }

/***
* 查询条件--风险描述输入框
* @return
* @throws IOException
*/
public Locator yePossiblyHazard_textarea() throws IOException
 {
   Locator locator=getLocator("yePossiblyHazard_textarea");
   return locator;
 }

/***
* 查询条件--作业活动
* @return
* @throws IOException
*/
public Locator activityId_select() throws IOException
 {
   Locator locator=getLocator("activityId_select");
   return locator;
 }

/***
* 查询条件--风险等级
* @return
* @throws IOException
*/
public Locator yeRiskGrade_select() throws IOException
 {
   Locator locator=getLocator("yeRiskGrade_select");
   return locator;
 }

/***
* 查询条件--风险类型
* @return
* @throws IOException
*/
public Locator yeHazardCate_select() throws IOException
 {
   Locator locator=getLocator("yeHazardCate_select");
   return locator;
 }

/***
* 查询条件--管控标准来源输入框
* @return
* @throws IOException
*/
public Locator docSource_textarea() throws IOException
 {
   Locator locator=getLocator("docSource_textarea");
   return locator;
 }

/***
* 查询条件--标准内容输入框
* @return
* @throws IOException
*/
public Locator yeStandard_textarea() throws IOException
 {
   Locator locator=getLocator("yeStandard_textarea");
   return locator;
 }

/***
* 查询条件--隐患等级
* @return
* @throws IOException
*/
public Locator hiddenLevel_select() throws IOException
 {
   Locator locator=getLocator("hiddenLevel_select");
   return locator;
 }

/***
* 审核弹框部分：确定按钮
* @return
* @throws IOException
*/
public Locator check_confirm_btn() throws IOException
 {
   Locator locator=getLocator("check_confirm_btn");
   return locator;
 }

/***
* 审核弹框部分：关闭按钮
* @return
* @throws IOException
*/
public Locator check_close_btn() throws IOException
 {
   Locator locator=getLocator("check_close_btn");
   return locator;
 }

/***
* 审核弹框部分：取消按钮
* @return
* @throws IOException
*/
public Locator check_cancel_btn() throws IOException
 {
   Locator locator=getLocator("check_cancel_btn");
   return locator;
 }

/***
* 审核弹框部分：备注输入框
* @return
* @throws IOException
*/
public Locator check_pass_radio() throws IOException
 {
   Locator locator=getLocator("check_pass_radio");
   return locator;
 }

/***
* 审核弹框部分：备注输入框
* @return
* @throws IOException
*/
public Locator check_dismiss_radio() throws IOException
 {
   Locator locator=getLocator("check_dismiss_radio");
   return locator;
 }

/***
* 审核弹框部分：备注输入框
* @return
* @throws IOException
*/
public Locator check_remark_textarea() throws IOException
 {
   Locator locator=getLocator("check_remark_textarea");
   return locator;
 }

/***
* 编辑页面--风险点类型
* @return
* @throws IOException
*/
public Locator update_addressCate_select() throws IOException
 {
   Locator locator=getLocator("update_addressCate_select");
   return locator;
 }

/***
* 编辑页面--辨识时间输入框
* @return
* @throws IOException
*/
public Locator update_yeRecognizeTime_textarea() throws IOException
 {
   Locator locator=getLocator("update_yeRecognizeTime_textarea");
   return locator;
 }

/***
* 编辑页面--专业选择框
* @return
* @throws IOException
*/
public Locator update_yeProfession_select() throws IOException
 {
   Locator locator=getLocator("update_yeProfession_select");
   return locator;
 }

/***
* 编辑页面--风险描述输入框
* @return
* @throws IOException
*/
public Locator update_yePossiblyHazard_textarea() throws IOException
 {
   Locator locator=getLocator("update_yePossiblyHazard_textarea");
   return locator;
 }

/***
* 编辑页面--风险描述内容为空时提示信息
* @return
* @throws IOException
*/
public Locator update_yePossiblyHazard_errormsg() throws IOException
 {
   Locator locator=getLocator("update_yePossiblyHazard_errormsg");
   return locator;
 }

/***
* 编辑页面--风险可能性选择框
* @return
* @throws IOException
*/
public Locator update_yeProbability_select() throws IOException
 {
   Locator locator=getLocator("update_yeProbability_select");
   return locator;
 }

/***
* 编辑页面--风险损失选择框
* @return
* @throws IOException
*/
public Locator update_yeCost_select() throws IOException
 {
   Locator locator=getLocator("update_yeCost_select");
   return locator;
 }

/***
* 编辑页面--风险类型
* @return
* @throws IOException
*/
public Locator update_yeHazardCate_select() throws IOException
 {
   Locator locator=getLocator("update_yeHazardCate_select");
   return locator;
 }

/***
* 编辑页面--管控标准来源输入框
* @return
* @throws IOException
*/
public Locator update_docSource_textarea() throws IOException
 {
   Locator locator=getLocator("update_docSource_textarea");
   return locator;
 }

/***
* 编辑页面--章节条款输入框
* @return
* @throws IOException
*/
public Locator update_sectionName_textarea() throws IOException
 {
   Locator locator=getLocator("update_sectionName_textarea");
   return locator;
 }

/***
* 编辑页面--标准内容输入框
* @return
* @throws IOException
*/
public Locator update_yeStandard_textarea() throws IOException
 {
   Locator locator=getLocator("update_yeStandard_textarea");
   return locator;
 }

/***
* 编辑页面--管控措施输入框
* @return
* @throws IOException
*/
public Locator update_manageMeasure_textarea() throws IOException
 {
   Locator locator=getLocator("update_manageMeasure_textarea");
   return locator;
 }

/***
* 编辑页面--隐患描述输入框
* @return
* @throws IOException
*/
public Locator update_yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("update_yeMhazardDesc_textarea");
   return locator;
 }

/***
* 编辑页面--隐患等级
* @return
* @throws IOException
*/
public Locator update_hiddenLevel_select() throws IOException
 {
   Locator locator=getLocator("update_hiddenLevel_select");
   return locator;
 }

/***
* 编辑页面--罚款金额输入框
* @return
* @throws IOException
*/
public Locator update_fineMoney_textarea() throws IOException
 {
   Locator locator=getLocator("update_fineMoney_textarea");
   return locator;
 }

/***
* 编辑页面--保存按钮
* @return
* @throws IOException
*/
public Locator update_btn_save() throws IOException
 {
   Locator locator=getLocator("update_btn_save");
   return locator;
 }

/***
* 编辑页面--关闭按钮
* @return
* @throws IOException
*/
public Locator update_closeBtn() throws IOException
 {
   Locator locator=getLocator("update_closeBtn");
   return locator;
 }

/***
* 编辑页面--危险源名称
* @return
* @throws IOException
*/
public Locator update_hazardName_textarea() throws IOException
 {
   Locator locator=getLocator("update_hazardName_textarea");
   return locator;
 }

/***
* 编辑页面--危险源名称下拉按钮
* @return
* @throws IOException
*/
public Locator update_hazardNameList() throws IOException
 {
   Locator locator=getLocator("update_hazardNameList");
   return locator;
 }

/***
* 编辑页面--责任岗位
* @return
* @throws IOException
*/
public Locator update_postName_textarea() throws IOException
 {
   Locator locator=getLocator("update_postName_textarea");
   return locator;
 }

/***
* 编辑页面--责任岗位下拉按钮
* @return
* @throws IOException
*/
public Locator update_postNameList() throws IOException
 {
   Locator locator=getLocator("update_postNameList");
   return locator;
 }

/***
* 数据列表
* @return
* @throws IOException
*/
public Locator data_tbody() throws IOException
 {
   Locator locator=getLocator("data_tbody");
   return locator;
 }

/***
* 底部信息--数据总量
* @return
* @throws IOException
*/
public Locator data_num() throws IOException
 {
   Locator locator=getLocator("data_num");
   return locator;
 }

/***
* 底部信息--每页显示数量
* @return
* @throws IOException
*/
public Locator data_pagelist() throws IOException
 {
   Locator locator=getLocator("data_pagelist");
   return locator;
 }

/***
* 底部信息--首页按钮
* @return
* @throws IOException
*/
public Locator data_firstPage() throws IOException
 {
   Locator locator=getLocator("data_firstPage");
   return locator;
 }

/***
* 底部信息--上一页按钮
* @return
* @throws IOException
*/
public Locator data_prevPage() throws IOException
 {
   Locator locator=getLocator("data_prevPage");
   return locator;
 }

/***
* 底部信息--下一页按钮
* @return
* @throws IOException
*/
public Locator data_nexttPage() throws IOException
 {
   Locator locator=getLocator("data_nexttPage");
   return locator;
 }

/***
* 底部信息--尾页按钮
* @return
* @throws IOException
*/
public Locator data_lastPage() throws IOException
 {
   Locator locator=getLocator("data_lastPage");
   return locator;
 }
}