package com.webui.pageObject;
import java.io.IOException;
import com.webui.utils.BaseAction;
import com.webui.utils.Locator;
/** 
* 首页
 * @author the2n
 */
public class DefultPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/com/webui/pageObjectConfig/UILibrary.xml";
 public   DefultPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 登陆用户的名称
* @throws IOException
*/
public Locator userName_1() throws IOException
 {
   Locator locator=getLocator("userName_1");
   return locator;
 }

/***
* 登陆用户的名称
* @throws IOException
*/
public Locator userName() throws IOException
 {
   Locator locator=getLocator("userName");
   return locator;
 }

/***
* 退出按钮
* @throws IOException
*/
public Locator logout_btn() throws IOException
 {
   Locator locator=getLocator("logout_btn");
   return locator;
 }

/***
* 安全风险分级管控
* @throws IOException
*/
public Locator aqfxfjgk_menu() throws IOException
 {
   Locator locator=getLocator("aqfxfjgk_menu");
   return locator;
 }

/***
* 风险点管理-list
* @throws IOException
*/
public Locator addressManage_list() throws IOException
 {
   Locator locator=getLocator("addressManage_list");
   return locator;
 }

/***
* 煤层管理
* @throws IOException
*/
public Locator layerManage() throws IOException
 {
   Locator locator=getLocator("layerManage");
   return locator;
 }

/***
* 年度风险管理-list
* @throws IOException
*/
public Locator ndfxgl_list() throws IOException
 {
   Locator locator=getLocator("ndfxgl_list");
   return locator;
 }

/***
* 矿风险清单
* @throws IOException
*/
public Locator reportDangerList() throws IOException
 {
   Locator locator=getLocator("reportDangerList");
   return locator;
 }

/***
* 风险审核
* @throws IOException
*/
public Locator reviewDangerList() throws IOException
 {
   Locator locator=getLocator("reviewDangerList");
   return locator;
 }

/***
* 部门风险清单
* @throws IOException
*/
public Locator departReportDangerList() throws IOException
 {
   Locator locator=getLocator("departReportDangerList");
   return locator;
 }

/***
* 年度辨识报告
* @throws IOException
*/
public Locator yearIdentifyReport() throws IOException
 {
   Locator locator=getLocator("yearIdentifyReport");
   return locator;
 }

/***
* 基础数据管理-list
* @throws IOException
*/
public Locator jcsjgl_li() throws IOException
 {
   Locator locator=getLocator("jcsjgl_li");
   return locator;
 }

/***
* 岗位管理
* @throws IOException
*/
public Locator postList() throws IOException
 {
   Locator locator=getLocator("postList");
   return locator;
 }

/***
* 作业活动管理
* @throws IOException
*/
public Locator activityList() throws IOException
 {
   Locator locator=getLocator("activityList");
   return locator;
 }

/***
* 危险源管理
* @throws IOException
*/
public Locator hazardList() throws IOException
 {
   Locator locator=getLocator("hazardList");
   return locator;
 }

/***
* 专项风险辨识
* @throws IOException
*/
public Locator zxfxbs() throws IOException
 {
   Locator locator=getLocator("zxfxbs");
   return locator;
 }

/***
* 专项风险辨识上报
* @throws IOException
*/
public Locator reportList() throws IOException
 {
   Locator locator=getLocator("reportList");
   return locator;
 }

/***
* 新工作面风险评估
* @throws IOException
*/
public Locator xgzm() throws IOException
 {
   Locator locator=getLocator("xgzm");
   return locator;
 }

/***
* 工艺设备风险评估
* @throws IOException
*/
public Locator gysb() throws IOException
 {
   Locator locator=getLocator("gysb");
   return locator;
 }

/***
* 停复工及新技术风险评估
* @throws IOException
*/
public Locator tfgjxjs() throws IOException
 {
   Locator locator=getLocator("tfgjxjs");
   return locator;
 }

/***
* 高危作业风险评估
* @throws IOException
*/
public Locator gwzy() throws IOException
 {
   Locator locator=getLocator("gwzy");
   return locator;
 }

/***
* 事故后风险评估
* @throws IOException
*/
public Locator sgh() throws IOException
 {
   Locator locator=getLocator("sgh");
   return locator;
 }

/***
* 专项辨识报告
* @throws IOException
*/
public Locator specialIdentifyReport() throws IOException
 {
   Locator locator=getLocator("specialIdentifyReport");
   return locator;
 }

/***
* 3+1风险管控
* @throws IOException
*/
public Locator threeAndOne() throws IOException
 {
   Locator locator=getLocator("threeAndOne");
   return locator;
 }

/***
* 重大风险管控方案
* @throws IOException
*/
public Locator majorDangerList() throws IOException
 {
   Locator locator=getLocator("majorDangerList");
   return locator;
 }

/***
* 月度检查
* @throws IOException
*/
public Locator ydjc() throws IOException
 {
   Locator locator=getLocator("ydjc");
   return locator;
 }

/***
* 重大安全风险管控措施落实情况记录
* @throws IOException
*/
public Locator monthManageRecord() throws IOException
 {
   Locator locator=getLocator("monthManageRecord");
   return locator;
 }

/***
* 月度检查分析报告
* @throws IOException
*/
public Locator monthCheckAnalyReport() throws IOException
 {
   Locator locator=getLocator("monthCheckAnalyReport");
   return locator;
 }

/***
* 安全办公会议纪要
* @throws IOException
*/
public Locator safeOfficeMeetingRecord() throws IOException
 {
   Locator locator=getLocator("safeOfficeMeetingRecord");
   return locator;
 }

/***
* 旬检查
* @throws IOException
*/
public Locator xjc() throws IOException
 {
   Locator locator=getLocator("xjc");
   return locator;
 }

/***
* 旬检查记录
* @throws IOException
*/
public Locator medowCheckRecord() throws IOException
 {
   Locator locator=getLocator("medowCheckRecord");
   return locator;
 }

/***
* 旬检查分析报告
* @throws IOException
*/
public Locator medowCheckAnalyReport() throws IOException
 {
   Locator locator=getLocator("medowCheckAnalyReport");
   return locator;
 }

/***
* 跟班检查
* @throws IOException
*/
public Locator gbjc() throws IOException
 {
   Locator locator=getLocator("gbjc");
   return locator;
 }

/***
* 重大安全风险管控措施落实情况记录
* @throws IOException
*/
public Locator classManageRecord() throws IOException
 {
   Locator locator=getLocator("classManageRecord");
   return locator;
 }

/***
* 隐患排查治理
* @throws IOException
*/
public Locator yhpczl() throws IOException
 {
   Locator locator=getLocator("yhpczl");
   return locator;
 }

/***
* 安全信息录入
* @throws IOException
*/
public Locator aqxxlr() throws IOException
 {
   Locator locator=getLocator("aqxxlr");
   return locator;
 }

/***
* 上级检查
* @throws IOException
*/
public Locator sjjc() throws IOException
 {
   Locator locator=getLocator("sjjc");
   return locator;
 }

/***
* 管理干部下井
* @throws IOException
*/
public Locator glgbxj() throws IOException
 {
   Locator locator=getLocator("glgbxj");
   return locator;
 }

/***
* 矿领导带班检查
* @throws IOException
*/
public Locator klddb() throws IOException
 {
   Locator locator=getLocator("klddb");
   return locator;
 }

/***
* 矿井安全大检查
* @throws IOException
*/
public Locator kjaqdjc() throws IOException
 {
   Locator locator=getLocator("kjaqdjc");
   return locator;
 }

/***
* 质量标准化检查
* @throws IOException
*/
public Locator zlbzh() throws IOException
 {
   Locator locator=getLocator("zlbzh");
   return locator;
 }

/***
* 专业科室日常检查
* @throws IOException
*/
public Locator zyks() throws IOException
 {
   Locator locator=getLocator("zyks");
   return locator;
 }

/***
* 安监员安全检查
* @throws IOException
*/
public Locator ajy() throws IOException
 {
   Locator locator=getLocator("ajy");
   return locator;
 }

/***
* 其他检查
* @throws IOException
*/
public Locator otherList() throws IOException
 {
   Locator locator=getLocator("otherList");
   return locator;
 }

/***
* 3+1检查
* @throws IOException
*/
public Locator thrplus() throws IOException
 {
   Locator locator=getLocator("thrplus");
   return locator;
 }

/***
* 隐患闭环管理
* @throws IOException
*/
public Locator yhbhgl() throws IOException
 {
   Locator locator=getLocator("yhbhgl");
   return locator;
 }

/***
* 本矿隐患上报
* @throws IOException
*/
public Locator hiddenDangerReportList() throws IOException
 {
   Locator locator=getLocator("hiddenDangerReportList");
   return locator;
 }

/***
* 综合查询
* @throws IOException
*/
public Locator queryList() throws IOException
 {
   Locator locator=getLocator("queryList");
   return locator;
 }

/***
* 部门隐患列表
* @throws IOException
*/
public Locator bmyh() throws IOException
 {
   Locator locator=getLocator("bmyh");
   return locator;
 }

/***
* 隐患整改
* @throws IOException
*/
public Locator checkList() throws IOException
 {
   Locator locator=getLocator("checkList");
   return locator;
 }

/***
* 隐患延期
* @throws IOException
*/
public Locator applyDelayList() throws IOException
 {
   Locator locator=getLocator("applyDelayList");
   return locator;
 }

/***
* 隐患复查
* @throws IOException
*/
public Locator repartList() throws IOException
 {
   Locator locator=getLocator("repartList");
   return locator;
 }

/***
* 重大隐患上报
* @throws IOException
*/
public Locator zdyhsb() throws IOException
 {
   Locator locator=getLocator("zdyhsb");
   return locator;
 }

/***
* 隐患综合查询
* @throws IOException
*/
public Locator majorHiddenDangerList() throws IOException
 {
   Locator locator=getLocator("majorHiddenDangerList");
   return locator;
 }

/***
* 隐患整改列表
* @throws IOException
*/
public Locator rectifyList() throws IOException
 {
   Locator locator=getLocator("rectifyList");
   return locator;
 }

/***
* 隐患验收列表
* @throws IOException
*/
public Locator pendingAcceptList() throws IOException
 {
   Locator locator=getLocator("pendingAcceptList");
   return locator;
 }

/***
* 隐患复查列表
* @throws IOException
*/
public Locator pendingReviewList() throws IOException
 {
   Locator locator=getLocator("pendingReviewList");
   return locator;
 }

/***
* 排查计划管理
* @throws IOException
*/
public Locator pcjhgl() throws IOException
 {
   Locator locator=getLocator("pcjhgl");
   return locator;
 }

/***
* 月排查计划管理
* @throws IOException
*/
public Locator monthList() throws IOException
 {
   Locator locator=getLocator("monthList");
   return locator;
 }

/***
* 月排查计划受理
* @throws IOException
*/
public Locator acceptList_month() throws IOException
 {
   Locator locator=getLocator("acceptList_month");
   return locator;
 }

/***
* 旬排查计划管理
* @throws IOException
*/
public Locator xunList() throws IOException
 {
   Locator locator=getLocator("xunList");
   return locator;
 }

/***
* 旬排查计划受理
* @throws IOException
*/
public Locator acceptList_xun() throws IOException
 {
   Locator locator=getLocator("acceptList_xun");
   return locator;
 }

/***
* 周排查计划管理
* @throws IOException
*/
public Locator weekList() throws IOException
 {
   Locator locator=getLocator("weekList");
   return locator;
 }

/***
* 周排查计划受理
* @throws IOException
*/
public Locator acceptList_week() throws IOException
 {
   Locator locator=getLocator("acceptList_week");
   return locator;
 }

/***
* 三违管理
* @throws IOException
*/
public Locator swgl() throws IOException
 {
   Locator locator=getLocator("swgl");
   return locator;
 }

/***
* 三违信息上报
* @throws IOException
*/
public Locator swxxsb() throws IOException
 {
   Locator locator=getLocator("swxxsb");
   return locator;
 }

/***
* 排查计划统计
* @throws IOException
*/
public Locator pcjhtj() throws IOException
 {
   Locator locator=getLocator("pcjhtj");
   return locator;
 }

/***
* 三违统计
* @throws IOException
*/
public Locator swtj() throws IOException
 {
   Locator locator=getLocator("swtj");
   return locator;
 }

/***
* 辅助管理
* @throws IOException
*/
public Locator fzgl() throws IOException
 {
   Locator locator=getLocator("fzgl");
   return locator;
 }

/***
* 职业卫生
* @throws IOException
*/
public Locator zyws() throws IOException
 {
   Locator locator=getLocator("zyws");
   return locator;
 }

/***
* 职工个人基本信息
* @throws IOException
*/
public Locator employeeInfoList() throws IOException
 {
   Locator locator=getLocator("employeeInfoList");
   return locator;
 }

/***
* 系统管理
* @throws IOException
*/
public Locator systemManageList() throws IOException
 {
   Locator locator=getLocator("systemManageList");
   return locator;
 }

/***
* 用户管理
* @throws IOException
*/
public Locator userManageList() throws IOException
 {
   Locator locator=getLocator("userManageList");
   return locator;
 }
}