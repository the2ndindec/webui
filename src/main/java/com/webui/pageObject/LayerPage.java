package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 煤层管理页面
 * @author the2n
 */
public class LayerPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   LayerPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 煤层管理页面iframe标记
* @throws IOException
*/
public Locator iframe_Layer() throws IOException
 {
   Locator locator=getLocator("iframe_Layer");
   return locator;
 }

/***
* 添加数据部分iframe标记
* @throws IOException
*/
public Locator iframe_add() throws IOException
 {
   Locator locator=getLocator("iframe_add");
   return locator;
 }

/***
* 编辑部分iframe标记
* @throws IOException
*/
public Locator iframe_update() throws IOException
 {
   Locator locator=getLocator("iframe_update");
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
* 查看
* @throws IOException
*/
public Locator detail_Button() throws IOException
 {
   Locator locator=getLocator("detail_Button");
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
* 图层名称
* @throws IOException
*/
public Locator layerCode_select() throws IOException
 {
   Locator locator=getLocator("layerCode_select");
   return locator;
 }

/***
* 矿图名称
* @throws IOException
*/
public Locator layerDetailName_input() throws IOException
 {
   Locator locator=getLocator("layerDetailName_input");
   return locator;
 }

/***
* 超图路径
* @throws IOException
*/
public Locator url_input() throws IOException
 {
   Locator locator=getLocator("url_input");
   return locator;
 }

/***
* 风险点类型
* @throws IOException
*/
public Locator isShow_select() throws IOException
 {
   Locator locator=getLocator("isShow_select");
   return locator;
 }

/***
* 备注输入框
* @throws IOException
*/
public Locator remark_input() throws IOException
 {
   Locator locator=getLocator("remark_input");
   return locator;
 }

/***
* 超图中心点
* @throws IOException
*/
public Locator center_input() throws IOException
 {
   Locator locator=getLocator("center_input");
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