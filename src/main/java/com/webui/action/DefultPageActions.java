package com.webui.action;

import com.webui.utils.ElementAction;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

public class DefultPageActions extends TestBaseCase {

	ElementAction ea = new ElementAction();

	/**
	 * 
	 * @param locator
	 * @Description:同级目录下切换菜单
	 */
	public void openMenu(Locator locator) {
		ea.click(locator);
	}

	/**
	 * 
	 * @param locator1
	 * @param locator2
	 * @Description:同父级目录下切换菜单, ！！注意菜单顺序
	 */
	public void openMenu(Locator locator1, Locator locator2) {
		ea.click(locator1);
		ea.click(locator2);
	}

	/**
	 * 
	 * @param locator1
	 * @param locator2
	 * @param locator3
	 * @Description:不同模块切换菜单, ！！注意菜单顺序
	 */
	public void openMenu(Locator locator1, Locator locator2, Locator locator3) {
		ea.click(locator1);
		ea.click(locator2);
		ea.click(locator3);
	}
}
