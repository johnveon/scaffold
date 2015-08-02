package utils;

/**   
* @Title: JsonHelper.java TODO:
* @Package com.erp.util
* @Description: TODO
* @author chenguang 
* @date 2013-4-19 上午08:19:37
* @version V1.0   
*/

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 类功能说明 TODO:json帮助类
 * 类修改者	修改日期
 * 修改说明
 * <p>Title: JsonHelper.java</p>
 * <p>Description:亿迅科技</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:亿迅科技</p>
*eshore@eshore.cn
 * @date 2013-4-19 上午08:19:37
 * @version V1.0
 */
public class JsonHelper
{

	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger log = Logger
			.getLogger(JsonHelper.class);
	static {
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
		mapper.getDeserializationConfig()
				.set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,	false);
	}

	/**
	 * json字符串转化为对象
	 */
	public static <T> T toBean(String jsonStr,Class<T> clazz){
		if (StringUtils.isEmpty(jsonStr)) {  
			return null;  
		}
		try {
			return mapper.readValue(jsonStr, clazz);  
		} catch (Exception e) {  
			log.error("json转换对象异常:" + jsonStr);  
			throw new RuntimeException(e);  
		}

	}
	
	/**
	 * json字符串转化为对象
	 */
	public static <T> T toBean(String jsonStr,TypeReference<T> typeReference){
		if (StringUtils.isEmpty(jsonStr)) {  
			return null;  
		}
		try {  
			return mapper.readValue(jsonStr, typeReference);  
		} catch (Exception e) {  
			log.error("json转换对象异常:" + jsonStr);  
			throw new RuntimeException(e);  
		}
	}
	
	
	
	/**
	 * 对象转化为json字符串
	 */
	public static <T> String toJson(T bean){
		try {
			return JSON.toJSONString(bean);
		} catch (Exception e) {
			log.error("对象转换json异常:"+bean);
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static String listToJson(List list) {
		String result = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			result = objectMapper.writeValueAsString(list);
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	public static boolean validJson(String str){
		return false;
	}
}

