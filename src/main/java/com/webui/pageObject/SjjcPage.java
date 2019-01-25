package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 上级检查页面
 * @author the2n
 */
public class SjjcPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   SjjcPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 上级检查iframe标记
* @throws IOException
*/
public Locator iframe_sjjc() throws IOException
 {
   Locator locator=getLocator("iframe_sjjc");
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
* 查看罚款按钮
* @throws IOException
*/
public Locator goLinkFine_Button() throws IOException
 {
   Locator locator=getLocator("goLinkFine_Button");
   return locator;
 }

/***
* 录入罚款
* @throws IOException
*/
public Locator goAddFine_Button() throws IOException
 {
   Locator locator=getLocator("goAddFine_Button");
   return locator;
 }

/***
* 上报
* @throws IOException
*/
public Locator reportHiddenDanger_Button() throws IOException
 {
   Locator locator=getLocator("reportHiddenDanger_Button");
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
* 查询条件--班次
* @throws IOException
*/
public Locator shift_area() throws IOException
 {
   Locator locator=getLocator("shift_area");
   return locator;
 }

/***
* 查询条件--开始时间
* @throws IOException
*/
public Locator examDate_begin_area() throws IOException
 {
   Locator locator=getLocator("examDate_begin_area");
   return locator;
 }

/***
* 查询条件--结束时间
* @throws IOException
*/
public Locator examDate_end_area() throws IOException
 {
   Locator locator=getLocator("examDate_end_area");
   return locator;
 }

/***
* 草稿选择项 
* @throws IOException
*/
public Locator toReported_radio() throws IOException
 {
   Locator locator=getLocator("toReported_radio");
   return locator;
 }

/***
* 已上报选择项
* @throws IOException
*/
public Locator reported_radio() throws IOException
 {
   Locator locator=getLocator("reported_radio");
   return locator;
 }

/***
* 已退回选择项
* @throws IOException
*/
public Locator ROLLBACK_radio() throws IOException
 {
   Locator locator=getLocator("ROLLBACK_radio");
   return locator;
 }

/***
* 排查日期
* @throws IOException
*/
public Locator examDate() throws IOException
 {
   Locator locator=getLocator("examDate");
   return locator;
 }

/***
* 地点下拉框
* @throws IOException
*/
public Locator magicsuggest() throws IOException
 {
   Locator locator=getLocator("magicsuggest");
   return locator;
 }

/***
* 上级检查部门
* @throws IOException
*/
public Locator sjjcDept() throws IOException
 {
   Locator locator=getLocator("sjjcDept");
   return locator;
 }

/***
* 监察人
* @throws IOException
*/
public Locator sjjcCheckMan() throws IOException
 {
   Locator locator=getLocator("sjjcCheckMan");
   return locator;
 }

/***
* 危险源
* @throws IOException
*/
public Locator dangerName() throws IOException
 {
   Locator locator=getLocator("dangerName");
   return locator;
 }

/***
* 辨识时间
* @throws IOException
*/
public Locator yeRecognizeYear() throws IOException
 {
   Locator locator=getLocator("yeRecognizeYear");
   return locator;
 }

/***
* 隐患描述
* @throws IOException
*/
public Locator yeMhazardDesc() throws IOException
 {
   Locator locator=getLocator("yeMhazardDesc");
   return locator;
 }

/***
* 专业
* @throws IOException
*/
public Locator yeProfession() throws IOException
 {
   Locator locator=getLocator("yeProfession");
   return locator;
 }

/***
* 伤害类别
* @throws IOException
*/
public Locator damageType() throws IOException
 {
   Locator locator=getLocator("damageType");
   return locator;
 }

/***
* 风险描述
* @throws IOException
*/
public Locator yePossiblyHazard() throws IOException
 {
   Locator locator=getLocator("yePossiblyHazard");
   return locator;
 }

/***
* 作业活动
* @throws IOException
*/
public Locator activity() throws IOException
 {
   Locator locator=getLocator("activity");
   return locator;
 }

/***
* 风险等级
* @throws IOException
*/
public Locator yeRiskGrade() throws IOException
 {
   Locator locator=getLocator("yeRiskGrade");
   return locator;
 }

/***
* 风险类型
* @throws IOException
*/
public Locator yeHazardCate() throws IOException
 {
   Locator locator=getLocator("yeHazardCate");
   return locator;
 }

/***
* 管控标准来源
* @throws IOException
*/
public Locator docSource() throws IOException
 {
   Locator locator=getLocator("docSource");
   return locator;
 }

/***
* 标准内容
* @throws IOException
*/
public Locator yeStandard() throws IOException
 {
   Locator locator=getLocator("yeStandard");
   return locator;
 }

/***
* 隐患等级
* @throws IOException
*/
public Locator hiddenLevel() throws IOException
 {
   Locator locator=getLocator("hiddenLevel");
   return locator;
 }

/***
* 责任单位
* @throws IOException
*/
public Locator dutyUnit() throws IOException
 {
   Locator locator=getLocator("dutyUnit");
   return locator;
 }

/***
* 责任人
* @throws IOException
*/
public Locator dutyMan() throws IOException
 {
   Locator locator=getLocator("dutyMan");
   return locator;
 }

/***
* 督办单位
* @throws IOException
*/
public Locator superviseUnit() throws IOException
 {
   Locator locator=getLocator("superviseUnit");
   return locator;
 }

/***
* 督办人
* @throws IOException
*/
public Locator superviseMan() throws IOException
 {
   Locator locator=getLocator("superviseMan");
   return locator;
 }

/***
* 隐患类别
* @throws IOException
*/
public Locator hiddenCategory() throws IOException
 {
   Locator locator=getLocator("hiddenCategory");
   return locator;
 }

/***
* 隐患等级
* @throws IOException
*/
public Locator hiddenNature() throws IOException
 {
   Locator locator=getLocator("hiddenNature");
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
* 隐患描述
* @throws IOException
*/
public Locator problemDesc() throws IOException
 {
   Locator locator=getLocator("problemDesc");
   return locator;
 }

/***
* 自动关联按钮
* @throws IOException
*/
public Locator attach_btn() throws IOException
 {
   Locator locator=getLocator("attach_btn");
   return locator;
 }

/***
* 资金
* @throws IOException
*/
public Locator fund() throws IOException
 {
   Locator locator=getLocator("fund");
   return locator;
 }

/***
* 预案
* @throws IOException
*/
public Locator plan() throws IOException
 {
   Locator locator=getLocator("plan");
   return locator;
 }

/***
* 备注
* @throws IOException
*/
public Locator remark() throws IOException
 {
   Locator locator=getLocator("remark");
   return locator;
 }

/***
* 限期整改
* @throws IOException
*/
public Locator dealType_xianqi() throws IOException
 {
   Locator locator=getLocator("dealType_xianqi");
   return locator;
 }

/***
* 期限日期
* @throws IOException
*/
public Locator limitDate() throws IOException
 {
   Locator locator=getLocator("limitDate");
   return locator;
 }

/***
* 现场处理
* @throws IOException
*/
public Locator dealType_xianchang() throws IOException
 {
   Locator locator=getLocator("dealType_xianchang");
   return locator;
 }

/***
* 复查人
* @throws IOException
*/
public Locator reviewMan() throws IOException
 {
   Locator locator=getLocator("reviewMan");
   return locator;
 }

/***
* 整改措施
* @throws IOException
*/
public Locator rectMeasures() throws IOException
 {
   Locator locator=getLocator("rectMeasures");
   return locator;
 }

/***
* 复查情况
* @throws IOException
*/
public Locator reviewReport() throws IOException
 {
   Locator locator=getLocator("reviewReport");
   return locator;
 }

/***
* 保存按钮
* @throws IOException
*/
public Locator btn_draft() throws IOException
 {
   Locator locator=getLocator("btn_draft");
   return locator;
 }

/***
* 保存并上报按钮
* @throws IOException
*/
public Locator btn_subRep() throws IOException
 {
   Locator locator=getLocator("btn_subRep");
   return locator;
 }

/***
* btn_subRep按钮
* @throws IOException
*/
public Locator btn_close() throws IOException
 {
   Locator locator=getLocator("btn_close");
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