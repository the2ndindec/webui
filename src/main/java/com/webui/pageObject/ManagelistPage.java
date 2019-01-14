package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 风险区域管理页面
 * @author the2n
 */
public class ManagelistPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   ManagelistPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 风险区域管理页面iframe标记
* @throws IOException
*/
public Locator iframe_managelist() throws IOException
 {
   Locator locator=getLocator("iframe_managelist");
   return locator;
 }

/***
* 风险区域管理页面iframe标记
* @throws IOException
*/
public Locator iframe_Managelist() throws IOException
 {
   Locator locator=getLocator("iframe_Managelist");
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
* 录入风险点部分iframe标记
* @throws IOException
*/
public Locator iframe_goAdd() throws IOException
 {
   Locator locator=getLocator("iframe_goAdd");
   return locator;
 }

/***
* 编辑风险点部分iframe标记
* @throws IOException
*/
public Locator iframe_goUpdate() throws IOException
 {
   Locator locator=getLocator("iframe_goUpdate");
   return locator;
 }

/***
* 克隆风险点部分iframe标记
* @throws IOException
*/
public Locator iframe_goClone() throws IOException
 {
   Locator locator=getLocator("iframe_goClone");
   return locator;
 }

/***
* 关联的风险部分iframe标记
* @throws IOException
*/
public Locator iframe_riskList() throws IOException
 {
   Locator locator=getLocator("iframe_riskList");
   return locator;
 }

/***
* 关联的单位部分iframe标记
* @throws IOException
*/
public Locator iframe_addressDepartRelList() throws IOException
 {
   Locator locator=getLocator("iframe_addressDepartRelList");
   return locator;
 }

/***
* 风险选择部分iframe标记
* @throws IOException
*/
public Locator iframe_goAddressDangerSourceList() throws IOException
 {
   Locator locator=getLocator("iframe_goAddressDangerSourceList");
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
public Locator addAddress_Button() throws IOException
 {
   Locator locator=getLocator("addAddress_Button");
   return locator;
 }

/***
* 编辑
* @throws IOException
*/
public Locator update_Button() throws IOException
 {
   Locator locator=getLocator("update_Button");
   return locator;
 }

/***
* 更改坐标
* @throws IOException
*/
public Locator editCoordinate_Button() throws IOException
 {
   Locator locator=getLocator("editCoordinate_Button");
   return locator;
 }

/***
* 删除
* @throws IOException
*/
public Locator deleteALLSelect_Button() throws IOException
 {
   Locator locator=getLocator("deleteALLSelect_Button");
   return locator;
 }

/***
* 克隆
* @throws IOException
*/
public Locator cloneAddress_Button() throws IOException
 {
   Locator locator=getLocator("cloneAddress_Button");
   return locator;
 }

/***
* 图形化
* @throws IOException
*/
public Locator withImage() throws IOException
 {
   Locator locator=getLocator("withImage");
   return locator;
 }

/***
* 关联的风险
* @throws IOException
*/
public Locator withRisk() throws IOException
 {
   Locator locator=getLocator("withRisk");
   return locator;
 }

/***
* 关联的单位
* @throws IOException
*/
public Locator withDepart() throws IOException
 {
   Locator locator=getLocator("withDepart");
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
* 查询条件--地点名称输入框
* @throws IOException
*/
public Locator address_textarea() throws IOException
 {
   Locator locator=getLocator("address_textarea");
   return locator;
 }

/***
* 录入风险点部分：经度输入框
* @throws IOException
*/
public Locator add_lon_textarea() throws IOException
 {
   Locator locator=getLocator("add_lon_textarea");
   return locator;
 }

/***
* 录入风险点部分：纬度输入框
* @throws IOException
*/
public Locator add_lat_textarea() throws IOException
 {
   Locator locator=getLocator("add_lat_textarea");
   return locator;
 }

/***
* 录入风险点部分：是否显示
* @throws IOException
*/
public Locator add_isshow() throws IOException
 {
   Locator locator=getLocator("add_isshow");
   return locator;
 }

/***
* 录入风险点部分：分管领导输入框
* @throws IOException
*/
public Locator add_manageMan_textarea() throws IOException
 {
   Locator locator=getLocator("add_manageMan_textarea");
   return locator;
 }

/***
* 录入风险点部分：description输入框
* @throws IOException
*/
public Locator add_description_textarea() throws IOException
 {
   Locator locator=getLocator("add_description_textarea");
   return locator;
 }

/***
* 编辑风险点部分：是否显示
* @throws IOException
*/
public Locator update_belongLayer() throws IOException
 {
   Locator locator=getLocator("update_belongLayer");
   return locator;
 }

/***
* 关联的风险部分：隐患描述输入框
* @throws IOException
*/
public Locator ar_yeMhazardDesc_textarea() throws IOException
 {
   Locator locator=getLocator("ar_yeMhazardDesc_textarea");
   return locator;
 }

/***
* 关联风险按钮
* @throws IOException
*/
public Locator ar_chooseDangerSource_Button() throws IOException
 {
   Locator locator=getLocator("ar_chooseDangerSource_Button");
   return locator;
 }

/***
* 删除关联按钮
* @throws IOException
*/
public Locator ar_doBatchDelAddressRel_Button() throws IOException
 {
   Locator locator=getLocator("ar_doBatchDelAddressRel_Button");
   return locator;
 }

/***
* 风险选择部分：地点
* @throws IOException
*/
public Locator ar_addressCate() throws IOException
 {
   Locator locator=getLocator("ar_addressCate");
   return locator;
 }

/***
* 风险选择部分-辨识时间
* @throws IOException
*/
public Locator ar_yeRecognizeYear() throws IOException
 {
   Locator locator=getLocator("ar_yeRecognizeYear");
   return locator;
 }

/***
* 风险选择部分-风险描述
* @throws IOException
*/
public Locator ar_yePossiblyHazard() throws IOException
 {
   Locator locator=getLocator("ar_yePossiblyHazard");
   return locator;
 }

/***
* 风险选择部分：专业属性
* @throws IOException
*/
public Locator ar_yeProfession() throws IOException
 {
   Locator locator=getLocator("ar_yeProfession");
   return locator;
 }

/***
* 风险选择部分：风险类型
* @throws IOException
*/
public Locator ar_yeHazardCate() throws IOException
 {
   Locator locator=getLocator("ar_yeHazardCate");
   return locator;
 }

/***
* 风险选择部分：风险等级
* @throws IOException
*/
public Locator ar_yeRiskGrade() throws IOException
 {
   Locator locator=getLocator("ar_yeRiskGrade");
   return locator;
 }

/***
* 风险选择部分：作业活动
* @throws IOException
*/
public Locator ar_activityId() throws IOException
 {
   Locator locator=getLocator("ar_activityId");
   return locator;
 }

/***
* 风险选择部分：隐患描述
* @throws IOException
*/
public Locator ar_yeMhazardDesc() throws IOException
 {
   Locator locator=getLocator("ar_yeMhazardDesc");
   return locator;
 }

/***
* 风险选择部分：管控标准来源
* @throws IOException
*/
public Locator ar_docSourcec() throws IOException
 {
   Locator locator=getLocator("ar_docSourcec");
   return locator;
 }

/***
* 风险选择部分：标准内容
* @throws IOException
*/
public Locator ar_yeStandard() throws IOException
 {
   Locator locator=getLocator("ar_yeStandard");
   return locator;
 }

/***
* 全部关联按钮
* @throws IOException
*/
public Locator ar_relAll_Button() throws IOException
 {
   Locator locator=getLocator("ar_relAll_Button");
   return locator;
 }

/***
* 添加关联按钮
* @throws IOException
*/
public Locator ar_addRelFunction_Button() throws IOException
 {
   Locator locator=getLocator("ar_addRelFunction_Button");
   return locator;
 }

/***
* 添加关联关系按钮
* @throws IOException
*/
public Locator ad_addRel_Button() throws IOException
 {
   Locator locator=getLocator("ad_addRel_Button");
   return locator;
 }

/***
* 重置按钮
* @throws IOException
*/
public Locator ad_reset_Button() throws IOException
 {
   Locator locator=getLocator("ad_reset_Button");
   return locator;
 }

/***
* 保存按钮
* @throws IOException
*/
public Locator ad_confirm_btn() throws IOException
 {
   Locator locator=getLocator("ad_confirm_btn");
   return locator;
 }

/***
* 重置按钮
* @throws IOException
*/
public Locator ad_close_btn() throws IOException
 {
   Locator locator=getLocator("ad_close_btn");
   return locator;
 }

/***
* 重置按钮
* @throws IOException
*/
public Locator map() throws IOException
 {
   Locator locator=getLocator("map");
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
* 更改坐标：确定按钮
* @throws IOException
*/
public Locator update_confirm_btn() throws IOException
 {
   Locator locator=getLocator("update_confirm_btn");
   return locator;
 }

/***
* 更改坐标：取消按钮
* @throws IOException
*/
public Locator update_cancel_btn() throws IOException
 {
   Locator locator=getLocator("update_cancel_btn");
   return locator;
 }
}