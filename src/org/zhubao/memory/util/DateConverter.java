/**
 * 
 */
package org.zhubao.memory.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * @author jason.zhu
 * @date 2014-10-20
 * @email jasonzhu@augmentum.com.cn
 */
public class DateConverter extends CustomConverter<Date, String> {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public String convert(Date source, Type<? extends String> desc) {
		return formatter.format(source);
	}

}
