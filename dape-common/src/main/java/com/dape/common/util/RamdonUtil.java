package com.dape.common.util;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.util.Properties;
import java.util.Random;

/**
 * Velocity工具类，(6位随机码)
 * Created by ZhangShuzheng on 2017/1/10.
 */
public class RamdonUtil {
	public static String[] charArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9"};

	/**
	 * 获取6位推荐码
	 * @return
	 */
	public static String getSixCode(){
		Random r = new Random();
		StringBuffer buf = new StringBuffer();
		int index = 0;
		for (int i = 0; i < 6; i++){
			index = r.nextInt(34);
			buf.append(charArr[index]);
		}
		return buf.toString();
	}
}
