package cn.huanqiu.scaffold.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import utils.Constants;
import utils.JsonHelper;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware, ApplicationAware {

	public static final String REQUEST_TYPE = "REQUEST_TYPE";

	private static final long serialVersionUID = 5822914716005346375L;

	public static final String USER_SESSION = "_user_session";

	public static final String LOGIN_UI_ACTION_URL = "login.action";
	public static final String INDEX_ACTION_URL = "index.action";

	protected HttpServletRequest httpServletRequest;
	protected HttpServletResponse httpServletResponse;
	protected Map<String, Object> sessionMap;

	//easyui param
	public int rows;
	public int page;
	//高级查询
	public String searchAnds;//:and,or,and,or
	public String searchColumnNames;//:account,name,name,account
	public String searchConditions;//:=,=,=,=
	public String searchVals;//:1,2,3,4
    //模糊查询
	public String searchName;
	public String searchValue;
	//@Autowired
	// protected ICacheUtil cachaUtil;
	/**
	 * application作用域范围
	 */
	protected Map<String, Object> application;

	/**
	 * 标识是AJAX请求（用于异常处理）<br>
	 * 
	 * @param is
	 */
	protected void setAjaxRequest(boolean is) {
		ServletActionContext.getContext().put(REQUEST_TYPE, is);
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}


	public static <T> T jsonToObject(Class<T> valueType, String objectJson)
			throws Exception {
		if (StringUtils.isBlank(objectJson)) {
			return null;
		}

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		T mReqVo = objectMapper.readValue(objectJson, valueType);
		if (mReqVo == null) {
			throw new Exception("转换类型错误！");
		}
		return mReqVo;
	}

	public static String objectToJsonString(Object o)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		return objectMapper.writeValueAsString(o);
	}

	public static byte[] objectToJsonBytes(Object o)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		return objectMapper.writeValueAsBytes(o);
	}

	public static void outputJsonData(Object o) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-Type", "text/json;charset=utf-8");
		OutputStream os = response.getOutputStream();
		os.write(objectToJsonBytes(o));
	}
	
    public static void outputPageJsonData(Object o) throws IOException {
    	long total = ((Page) o).getTotal();
    	String json = JSON.toJSONStringWithDateFormat(o,"yyyy-MM-dd HH:mm:ss");
    	json = "{\"total\":" + total + ",\"rows\":" + json + "}";
//    	HttpServletResponse response = ServletActionContext.getResponse();
//    	response.setHeader("Content-Type", "text/json;charset=utf-8");
//    	OutputStream os = response.getOutputStream();
//    	os.write(json.getBytes());
    	
    	HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(json);
		printWriter.flush();
		printWriter.close();
	}
    
    public static void outputListJsonData(Object o) throws IOException {
    	long total = ((List) o).size();
    	String json = JSON.toJSONStringWithDateFormat(o,"yyyy-MM-dd HH:mm:ss");
    	json = "{\"total\":" + total + ",\"rows\":" + json + "}";
//    	HttpServletResponse response = ServletActionContext.getResponse();
//    	response.setHeader("Content-Type", "text/json;charset=utf-8");
//    	OutputStream os = response.getOutputStream();
//    	os.write(json.getBytes());
    	
    	HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(json);
		printWriter.flush();
		printWriter.close();
	}

	public static void outputStringJsonData(String o) throws IOException {
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setHeader("Content-Type", "text/json;charset=utf-8");
//		OutputStream os = response.getOutputStream();
//		os.write(o.getBytes());
		
		if (StringUtils.isNotBlank(o)){
			if (o.startsWith("{")){
				ajaxJson(o);
			}
		}
		
	}

	public void OutputJson(Object object, String type) {
//		PrintWriter out = null;
//		HttpServletResponse httpServletResponse = ServletActionContext
//				.getResponse();
//		httpServletResponse.setContentType(type);
//		httpServletResponse.setCharacterEncoding("utf-8");
//		String json = null;
//		try {
//			out = httpServletResponse.getWriter();
//			json = JSON.toJSONStringWithDateFormat(object,
//					"yyyy-MM-dd HH:mm:ss");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		out.print(json);
//		out.close();
		
		ajaxJson(object);
	}

	public void OutputJson(Object object) {
//		PrintWriter out = null;
//		HttpServletResponse httpServletResponse = ServletActionContext
//				.getResponse();
//		httpServletResponse.setContentType("application/json");
//		httpServletResponse.setCharacterEncoding("utf-8");
//		String json = null;
//		try {
//			out = httpServletResponse.getWriter();
//			json = JSON.toJSONStringWithDateFormat(object,
//					"yyyy-MM-dd HH:mm:ss");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		out.print(json);
//		out.close();
		
		ajaxJson(object,"text/json");
	}
	
	// AJAX输出，返回null
	public static String ajax(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			PrintWriter printWriter = response.getWriter();
			printWriter.write(content);
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 public static void outputJsonStringData(Object o) throws IOException {
	    	String json = JSON.toJSONStringWithDateFormat(o,"yyyy-MM-dd HH:mm:ss");
	    	json = "{\"rows\":" + json + "}";
//	    	HttpServletResponse response = ServletActionContext.getResponse();
//	    	response.setHeader("Content-Type", "text/json;charset=utf-8");
//	    	OutputStream os = response.getOutputStream();
//	    	os.write(json.getBytes());
	    	
	    	HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
			printWriter.flush();
			printWriter.close();
		}

	// AJAX输出文本，返回null
	public static String ajaxText(String text) {
		return ajax(text, "text/plain");
	}

	// AJAX输出HTML，返回null
	public static String ajaxHtml(String html) {
		return ajax(html, "text/html");
	}

	// AJAX输出XML，返回null
	public static String ajaxXml(String xml) {
		return ajax(xml, "text/xml");
	}

	// 根据字符串输出JSON，返回null
	public static String ajaxJson(String jsonString) {
		return ajax(jsonString, "text/html");
	}
	
	// 根据字符串输出JSON，返回null
		public static String ajaxJson(Object object,String type) {
			return ajax(JsonHelper.toJson(object),type);
		}

	// 根据Object输出JSON，返回null
	public static String ajaxJson(Object object) {
		return ajax(JsonHelper.toJson(object), "text/html");
	}

	// 根据Map输出JSON，返回null
	public static <T> String ajaxJson(Map<String, T> jsonMap) {
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON警告消息，返回null <br />
	 *  输出的json数据结构为：{"success":"warn",msg:"message参数的值"}
	 */
	public static String ajaxJsonWarnMessage(String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(Constants.STATUS, Constants.WARN);
		jsonMap.put(Constants.MESSAGE, message);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON消息，返回null <br />
	 *  result参数是数组，长度为2，第一个元素是处理状态，若值为1，则表示成功，否则表示失败；第二个参数是提示文字<br />
	 *  输出的json数据结构为：{"success":"true",msg:"result参数的第二个元素的值"}
	 */
	public static String ajaxJsonMessage(Object[] result) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		int status = (Integer) result[0];
		if (status == 1) {
			jsonMap.put(Constants.STATUS, Constants.SUCCESS);
		} else {
			jsonMap.put(Constants.STATUS, Constants.ERROR);
		}
		jsonMap.put(Constants.MESSAGE, (String) result[1]);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON成功消息，返回null，此方法多用于增加，修改，删除执行成功后返回页面时调用 <br />
	 *  输出的json数据结构为：{"success":"true",msg:"message参数的值"}
	 */
	public static String ajaxJsonSuccessMessage(String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(Constants.STATUS, Constants.SUCCESS);
		jsonMap.put(Constants.MESSAGE, message);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON成功消息，并带返回数据，返回null <br />
	 *  输出的json数据结构为：{"success":"true",msg:"message参数的值","data":"data参数的值"}
	 */
	public static String ajaxJsonSuccessMessage(String message, Object data) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(Constants.STATUS, Constants.SUCCESS);
		jsonMap.put(Constants.MESSAGE, message);
		jsonMap.put(Constants.DATA, data);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON错误消息，返回null <br />
	 *  输出的json数据结构为：{"success":"false",msg:"message参数的值"}
	 */
	public static String ajaxJsonErrorMessage(String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(Constants.STATUS, Constants.ERROR);
		jsonMap.put(Constants.MESSAGE, message);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	/**
	 *  输出JSON错误消息，并且带上重定向地址 <br />
	 *  输出的json数据结构为：{"success":"false",msg:"message参数的值","rurl":"redirectUrl参数的值"}
	 */
	public static String ajaxJsonErrorMessage(String message, String redirectUrl) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(Constants.STATUS, Constants.ERROR);
		jsonMap.put(Constants.MESSAGE, message);
		jsonMap.put(Constants.REDIRECT_URL, redirectUrl);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}
	
	/**
	 *  输出JSON成功消息，返回null <br />
	 *  输出的json数据结构为：{"success":"status参数的值",msg:"message参数的值"}
	 */
	public static String ajaxJsonStatusMessage(int status,String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(Constants.STATUS, status);
		jsonMap.put(Constants.MESSAGE, message);
		return ajax(JsonHelper.toJson(jsonMap), "text/html");
	}

	// 设置页面不缓存
	public void setResponseNoCache(HttpServletResponse response) {
		response.setHeader("progma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	}
	
	public Map<String, Object> getEasyUIParamMap() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String searchValue = httpServletRequest.getParameter(Constants.SEARCH_VALUE);
		if (!StringUtils.isEmpty(searchValue)){//Constants.GET_SQL_LIKE
			searchValue = searchValue.trim();
			paramMap.put(Constants.SEARCH_VALUE, Constants.GET_SQL_LIKE+searchValue+Constants.GET_SQL_LIKE);
		}
		String searchName = httpServletRequest.getParameter(Constants.SEARCH_NAME);
		if (!StringUtils.isEmpty(searchName)){
			paramMap.put(Constants.SEARCH_NAME, searchName);
		}
		String searchAnds = httpServletRequest.getParameter(Constants.SEARCH_ANDS);
		if(!StringUtils.isEmpty(searchAnds)){
			paramMap.put(Constants.SEARCH_ANDS,searchAnds.split(","));
		}
		String searchColumnNames = httpServletRequest.getParameter(Constants.SEARCH_COLUMN_NAMES);
		if(!StringUtils.isEmpty(searchColumnNames)){
			paramMap.put(Constants.SEARCH_COLUMN_NAMES,searchColumnNames.split(","));
		}
		String searchConditions = httpServletRequest.getParameter(Constants.SEARCH_CONDITIONS);
		String[] condArray = {};
		if(!StringUtils.isEmpty(searchConditions)){
			condArray = searchConditions.split(",");
			paramMap.put(Constants.SEARCH_CONDITIONS,condArray);
		}
		String searchVals = httpServletRequest.getParameter(Constants.SEARCH_VALS);
		if(!StringUtils.isEmpty(searchVals)){
			String[] valAarry = searchVals.split(",");
			for (int i = 0; i < condArray.length; i++) {
				if(Constants.HQL_LIKE.equalsIgnoreCase(condArray[i])){
					String tmpVal = valAarry[i];
					if(!StringUtils.isEmpty(tmpVal)){
						tmpVal = tmpVal.trim();
					}
					valAarry[i] = Constants.GET_SQL_LIKE + tmpVal + Constants.GET_SQL_LIKE;
				}
			}
			paramMap.put(Constants.SEARCH_VALS,valAarry);
		}
		return paramMap;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public String getSearchAnds() {
		return searchAnds;
	}
	public void setSearchAnds(String searchAnds) {
		this.searchAnds = searchAnds;
	}
	public String getSearchColumnNames() {
		return searchColumnNames;
	}
	public void setSearchColumnNames(String searchColumnNames) {
		this.searchColumnNames = searchColumnNames;
	}
	public String getSearchConditions() {
		return searchConditions;
	}
	public void setSearchConditions(String searchConditions) {
		this.searchConditions = searchConditions;
	}
	public String getSearchVals() {
		return searchVals;
	}
	public void setSearchVals(String searchVals) {
		this.searchVals = searchVals;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	// public LoginRespVo getUserForToken(String tokenId) throws Exception {
	// return TOKEN_MAP.get(tokenId);
	// return (LoginRespVo)jsonToObject(LoginRespVo.class,
	// cachaUtil.hget("Login","Token",tokenId));
	// }
	
}
