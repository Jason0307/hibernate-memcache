/**
 * 
 */
package org.zhubao.memory.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jason.zhu
 * @date 2014-10-21
 * @email jasonzhu@augmentum.com.cn
 */
public class Crawler {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.baidu.com");
			HttpURLConnection httpurl = (HttpURLConnection) url
					.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					httpurl.getInputStream(), "utf-8"));

			Pattern p = Pattern
					.compile("(http://\\w+\\.baidu\\.com)|(\\w://w+\\.baidu\\.com)");
			Matcher m;
			String line;
			while ((line = br.readLine()) != null) {
				m = p.matcher(line);

				if (m.find()) {

					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
