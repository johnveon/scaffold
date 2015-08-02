package utils;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印系统和环境变量和系统属性值的工具类。
 * 
 * @author User
 * 
 */
public class MySystemPropertiesUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(MySystemPropertiesUtil.class);

	/**
	 * 查看系统环境变量。环境变量是对于整个操作系统中所有进程都可见的，就如同你在OS里面设置的一样。因此除非必要，或者你确实需要环境变量，
	 * 比如classpath和path，一般推荐使用properties。
	 */
	public static void getSystemEnvs() {
		Map<String, String> envs = System.getenv();
		Iterator<String> keys = envs.keySet().iterator();
		logger.debug("=========================================SystemEnvs start=========================================");
		while (keys.hasNext()) {
			String key = keys.next();
			String value = System.getenv(key);
			logger.debug(String.format("%s: %s", key, value));
		}
		logger.debug("=========================================SystemEnvs finished=========================================");
	}

	/**
	 * 查看系统属性值。 系统属性值是在同一个Java process里面有效的全局变量。
	 */
	public static void getSystemProperties() {
		Properties properties = System.getProperties();
		Enumeration<Object> keys = properties.keys();
		logger.debug("=========================================SystemProperties start=========================================");
		while (keys.hasMoreElements()) {
			String key = keys.nextElement().toString();
			String value = System.getProperty(key);
			logger.debug(String.format("%s: %s", key, value));
		}
		logger.debug("=========================================SystemProperties finished=========================================");
	}

	/**
	 * 查看系统的环境变量和项目属性
	 */
	public static void getSystemEnvsAndProperties() {
		getSystemEnvs();
		getSystemProperties();
	}

	/**
	 * 测试main方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		getSystemEnvsAndProperties();
	}

}
