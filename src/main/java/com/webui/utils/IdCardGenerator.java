package com.webui.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class IdCardGenerator {

	/**
	 * 获取随机生成的身份证号码
	 * 
	 * @return
	 */
	public String getRandomID() {
		String id = null;
		// 随机生成省、自治区、直辖市代码 1-2
		String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37",
				"41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
				"81", "82" };
		String province = randomOne(provinces);
		// 随机生成地级市、盟、自治州代码 3-4
		String city = randomCityCode(18);
		// 随机生成县、县级市、区代码 5-6
		String county = randomCityCode(28);
		// 随机生成出生年月 7-14
		String birth = randomBirth(20, 50);
		// 随机生成顺序号 15-17(随机性别)
		String no = new Random().nextInt(899) + 100 + "";
		// 随机生成校验码 18
		String checks[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "X" };
		String check = randomOne(checks);
		// 拼接身份证号码
		id = province + city + county + birth + no + check;
		return id;
	}

	private String randomBirth(int minAge, int maxAge) {
		// TODO 随机生成minAge到maxAge年龄段的人的生日日期
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期
		// 随机设置日期为前maxAge年到前minAge年的任意一天
		int randomDay = 365 * minAge + new Random().nextInt(365 * (maxAge - minAge));
		date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
		return dft.format(date.getTime());
	}

	private String randomCityCode(int max) {
		// TODO 随机生成两位数的字符串（01-max）,不足两位的前面补0
		int i = new Random().nextInt(max) + 1;
		return i > 9 ? i + "" : "0" + i;
	}

	private String randomOne(String s[]) {
		// TODO 从String[] 数组中随机取出其中一个String字符串
		return s[new Random().nextInt(s.length - 1)];
	}
	
	public static void main(String[] args) {
		IdCardGenerator cre = new IdCardGenerator();  
        String randomID = cre.getRandomID();  
        System.out.println(randomID);
	}
}
