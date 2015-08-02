package utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.druid.util.StringUtils;


/**
* 类功能说明 TODO:常用常量定义
* 类修改者
* 修改日期
* 修改说明
* <p>Title: Constants.java</p>
* <p>Description:</p>
* <p>Copyright: Copyright (c) 2006</p>
* <p>Company:有限公司</p>
*eshore@eshore.cn
* @date 2013-5-7 下午2:50:52
* @version V1.0
*/

public class Constants
{
	public static final String COMMA = ",";

	public static final String REMOVE_IDS = "removeIds";

	public static final String UPDATE_IDS = "updateIds";

	public static final String ADD_IDS = "addIds";

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Constants.class);

	public static final String LOGIN_SESSION_DATANAME="users";
	public static final String LOGIN_URL="login";
	public static final String LOGIN_SUCCESS_URL="index";
	public static final String LOGIN_LOGIN_OUT_URL="loginout";
	public static final String LOGIN_MSG="loginMsg";
	public static final String USERNAME_IS_NULL="用户名为空!";
	public static final String LOGIN_IS_EXIST="该用户已登陆!";
	public static final String USER_CODE_EXIST="用户账号已注册,请更换!";
	public static final String UNKNOWN_SESSION_EXCEPTION="异常会话!";
	public static final String UNKNOWN_ACCOUNT_EXCEPTION="账号错误!";
	public static final String UNKNOWN_CUST_ACCOUNT_EXCEPTION="公司账号或用户账号错误!";
	public static final String INCORRECT_CREDENTIALS_EXCEPTION="密码错误!";
	public static final String LOCKED_ACCOUNT_EXCEPTION="账号已被锁定，请与系统管理员联系!";
	public static final String INCORRECT_CAPTCHA_EXCEPTION= "验证码错误!";
	public static final String AUTHENTICATION_EXCEPTION= "您没有授权!";
	public static final String REPEATLOGIN_EXCEPTION = "相同账号已经在别的地方登陆!";
	public static final String UNKNOWN_EXCEPTION= "出现未知异常,请与系统管理员联系!";
	
	public static final String CUST_ADMIN_USER= "custAdmin";
	public static final String SYS_ADMIN_USER= "sysAdmin";
	public static final String SYS_USER= "sys";
	
	public static final String TREE_GRID_ADD_STATUS= "add";
	public static final String POST_DATA_SUCCESS= "数据更新成功!";
	public static final String POST_DATA_FAIL= "提交失败了!";
	public static final String GET_SQL_LIKE= "%";
	public static final String IS_FUNCTION= "F";
	public static final String PERSISTENCE_STATUS= "A";
	public static final String PERSISTENCE_DELETE_STATUS= "I";
	public static final String SYSTEM_ADMINISTRATOR= "admin";
	public static final String NULL_STRING= "";
	public static final String IS_DOT= ".";
	public static final String HQL_LIKE= "like";
	public static final String TEXT_TYPE_PLAIN= "text/plain";
	public static final String TEXT_TYPE_HTML= "text/html";
	public static final String FUNCTION_TYPE_O= "O";
	public static final String TREE_STATUS_OPEN= "open";
	public static final String TREE_STATUS_CLOSED= "closed";
	public static final String IS_EXT_SUBMENU= " 或可能包含菜单!";
	public static final String SHIRO_USER= "shiroUser";
	public static final String LOGS_INSERT= "insert:";
	public static final String LOGS_INSERT_TEXT= "插入:";
	public static final String LOGS_INSERT_NAME= "insertLogs";
	public static final String LOGS_UPDATE= "update:";
	public static final String LOGS_UPDATE_TEXT= "更新:";
	public static final String LOGS_UPDATE_NAME= "updateLogs";
	public static final String LOGS_DELETE= "delete:";
	public static final String LOGS_DELETE_TEXT= "删除:";
	public static final String LOGS_DELETE_NAME= "deleteLogs";
	public static final String LOGS_TB_NAME= "Log";
	public static final String FILE_SUFFIX_SQL= ".sql";
	public static final String FILE_SUFFIX_ZIP= ".zip";
	public static final String BASE_PATH =System.getProperty("am-cms");
	
	public static final String VALID_STATUS= "S0A";//有效
	public static final String INVALID_STATUS= "S0X";//无效
	public static final String QUIT_STATUS= "S0Q";//商航接口中成员退出
	public static final String ORDER_STATUS_WATING= "S0P";//待支付
	public static final String ORDER_STATUS_SUCCESS= "S0S";//支付成功
	
	/** 支付状态 PAY_STATUS **/
	public static final String PAY_STATUS_WAITING= "WAITING_PAY";//等待付款
	public static final String PAY_STATUS_SUCCESS= "SUCCESS";//成功
	public static final String PAY_STATUS_FAIL= "FAIL";//失败
	public static final String PAY_STATUS_BACKING= "DRAWBACKING";//退款中
	public static final String PAY_STATUS_BACK= "DRAWBACK";//已退款
	/** PAY_STATUS **/
	
	/** 支付类别 PAY_TYPE **/
	public static final String PAY_TYPE_ALIPAY= "ALIPAY";//支付宝
	public static final String PAY_TYPE_BESTPAY= "BESTPAY";//翼支付
	public static final String PAY_TYPE_WXPAY= "WXPAY";//微信支付
	public static final String PAY_TYPE_WEBPAY= "WEBPAY";//网页支付
	/** 支付类别 PAY_TYPE **/
	
	public static final String USER_VALIDDATE= "你的用户有效期已过期了,请联系管理员";
	public static final String PWD_VALIDDATE= "你的密码有效期已过期了,请联系管理员";
	
	public static final String SHOW_TITLE = "提示";
	public static final String DB_SAVE_SUCCESS = "数据新增成功！";
	public static final String DB_SAVE_FAIL = "数据新增失败！请联系管理员！";
	public static final String DB_UPDATE_SUCCESS = "数据修改成功！";
	public static final String DB_REMOVE_SUCCESS = "数据删除成功！";
	public static final String STATUS_2 = "2";
	public static final String STATUS_1 = "1";
	public static final String STATUS_0 = "0";
	public static final String STATUS_CUCCESS_JSON="{\"status\":\""+STATUS_1+"\",\"message\":\""+DB_SAVE_SUCCESS+"\",\"title\":\""+SHOW_TITLE+"\"}";
	public static final String STATUS_FAIL_JSON="{\"status\":\""+STATUS_0+"\",\"message\":\""+DB_SAVE_FAIL+"\",\"title\":\""+SHOW_TITLE+"\"}";
	
	public static final String SEARCH_VALS = "searchVals";
	public static final String SEARCH_COLUMN_NAMES = "searchColumnNames";
	public static final String SEARCH_CONDITIONS = "searchConditions";
	public static final String SEARCH_ANDS = "searchAnds";
	public static final String SEARCH_NAME = "searchName";
	public static final String SEARCH_VALUE = "searchValue";
	
	public static final String CITY= "0";
	public static final String DICT_TYPEID = "dictTypeId";
	
	public static final String USER_ID = "userId"; 
	public static final String USER_CODE = "userCode"; 
	public static final String PKG_CODE = "pkgCode"; 
	public static final String USER_IDS = "userIds";
	public static final String ORG_IDS = "orgIds";
	public static final String USER_EMAILADDRS = "userEmailAddrs";
	public static final String USER_MOBILENBRS = "userMobileNbrs";
	
	public static final String ITEM_TYPE_B = "B";
	public static final String ITEM_TYPE_A = "A";
	
	public static final String SHIRO_LOGIN_FAILURE = "shiroLoginFailure";

	private static final int BUFFER_SIZE = 16 * 1024;

	public static final String CUST_ACCOUNT = "custAccount";
	
	public static final String CUST_ORGID = "custOrgId";
	
	public static String CUST_ID = "custId";

	public static final String A = "A";
	
	public static final String B = "B";
	
	public static final String C = "C";

	public static final String USER_PWD = "userPwd";

	public static final String ORG_ID = "orgId";

	public static final String CONTACT = "CONTACT";

	public static final String DISCONTACT = "DISCONTACT";
	
	public static final String CLOSED = "closed";
	public static final String OPEN = "open";

	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	/**
	 * ISO-8859-1编码
	 */
	public static final String ISO88591 = "ISO-8859-1";
	
	/**
	 * 重定向参数名
	 */
	public static final String REDIRECT_URL = "rurl";
	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";
	/**
	 * url中的jsessionid名称
	 */
	public static final String JSESSION_URL = "jsessionid";
	/**
	 * HTTP POST请求
	 */
	public static final String POST = "POST";
	/**
	 * HTTP GET请求
	 */
	public static final String GET = "GET";
	/**
	 * 主要用来ajax返回状态
	 */
	public static final String STATUS = "success";
	/**
	 * ajax返回警告状态
	 */
	public static final String WARN = "warn";
	/**
	 * ajax返回成功状态
	 */
	public static final boolean SUCCESS = true;
	/**
	 * ajax返回错误状态
	 */
	public static final boolean ERROR = false;
	/**
	 * ajax返回提示描述
	 */
	public static final String MESSAGE = "msg";
	/**
	 * ajax返回数据参数名
	 */
	public static final String DATA = "data";
	/**
	 * ajax返回文本信息
	 */
	public static final String CONTENT = "content";
	/**
	 * 错误页面 错误提示传递参数
	 */
	public static final String ERROR_MSG = "errorMsg";
	
	public static final String ERROR_PAGE = "common/error";
	
	
	/**
	 * ==================商航接口相关变量开始==================
	 */
	// 定义返回成功
	public static final String RETURN_SUCCESS = "20000";
	public static final String RETURN_MSG_SUCCESS = "success";
	// 定义返回失败
	public static final String RETURN_FAIL = "21000";
	public static final String RETURN_MSG_FAIL = "系统异常";
	
	// 缓装(订购、拆机、修改产品属性、修改产品状态、停复机、移机业务工单)
	public static final String RETURN_LATER = "20001";
	public static final String RETURN_MSG_LATER = "缓装";
	// 退单(订购、拆机、修改产品属性、修改产品状态、停复机、移机业务工单)
	public static final String RETURN_BACK = "20002";
	public static final String RETURN_MSG_BACK = "退单";
	// 请求时间超时
	public static final String RETURN_TIMEOUT = "22002";
	public static final String RETURN_MSG_TIMEOUT = "请求时间超时";
	// 定义hashcode错误
	public static final String RETURN_HASHCODE_INCORRECT = "22003";
	public static final String RETURN_MSG_HASHCODE_INCORRECT = "哈希吗不正确";
	// 参数错误
	public static final String RETURN_PARAM_ERROR = "22004";
	public static final String RETURN_MSG_PARAM_ERROR = "参数错误";
	// 平台客户不存在
	public static final String RETURN_CUST_NOT_EXIST = "22006";
	public static final String RETURN_MSG_CUST_NOT_EXIST = "客户不存在";
	// 产品实例不存在
	public static final String RETURN_PROD_INST_NOT_EXIST = "22007";
	public static final String RETURN_MSG_PROD_INST_NOT_EXIST = "产品实例不存在";
	// 已存在一个或多个相同产品成员实例
	public static final String RETURN_PROD_USER_INST_EXISTED = "22008";
	public static final String RETURN_MSG_PROD_USER_INST_EXISTED = "已存在一个或多个相同产品成员实例";
	// 新增订单用户失败
	public static final String RETURN_ORDERUSER_ADD_FAIL = "22009";
	public static final String RETURN_MSG_ORDERUSER_ADD_FAIL = "新增订单用户失败";
	// 新增用户实例失败
	public static final String RETURN_PRODUSERINST_ADD_FAIL = "22010";
	public static final String RETURN_MSG_PRODUSERINST_ADD_FAIL = "新增用户实例失败";
	// 新增用户失败
	public static final String RETURN_USER_ADD_FAIL = "22011";
	public static final String RETURN_MSG_USER_ADD_FAIL = "新增用户失败";
	// 组织不存在
	public static final String RETURN_ORG_NOT_EXIST = "22012";
	public static final String RETURN_MSG_ORG_NOT_EXIST = "组织不存在";
	// 未传入用户信息
	public static final String RETURN_ORDERUSER_IS_NULL = "22013";
	public static final String RETURN_MSG_ORDERUSER_IS_NULL = "未传入用户信息";
	// 无订单信息
	public static final String RETURN_ORDER_IS_NULL = "22014";
	public static final String RETURN_MSG_ORDER_IS_NULL = "无订单信息";
	// 订单项中的产品ID为空
	public static final String RETURN_ORDERID_IS_NULL = "22015";
	public static final String RETURN_MSG_ORDERID_IS_NULL = "订单项中的产品ID为空";
	// 修改产品实例失败
	public static final String RETURN_UPDATE_PROD_INST_FAIL = "22016";
	public static final String RETURN_MSG_UPDATE_PROD_INST_FAIL = "修改产品实例失败";
	// 新增订单失败
	public static final String RETURN_ADD_ORDER_FAIL = "22017";
	public static final String RETURN_MSG_ADD_ORDER_FAIL = "新增订单失败";
	// 新增成员实例失败
	public static final String RETURN_ADD_PROD_USER_INST_FAIL = "22018";
	public static final String RETURN_MSG_ADD_PROD_USER_INST_FAIL = "新增成员实例失败";
	// 修改成员实例失败
	public static final String RETURN_MODIFY_PROD_USER_INST_FAIL = "22019";
	public static final String RETURN_MSG_MODIFY_PROD_USER_INST_FAIL = "修改成员实例失败";
	
	
	public static final String SHARE_KEY = "1234567890ABCDEF";

	public static final String CMS_ACU_INTERFACE = "0";//表示cms,acu两边都处理商行接口事务
	public static final String CMS_INTERFACE = "1";//表示只处理cms的商航接口
	public static final String ACU_INTERFACE = "2";//表示只处理acu接口
	
	public static final Integer CREATE_USER = 1;//1是管理员admin的userid
	public static final String PRODUCT_APP_TYPE_ACCOUNT = "1";//1账号型
	public static final String PRODUCT_APP_TYPE_MEETING_ROOM_1 = "2";//会议室型
	public static final String PRODUCT_APP_TYPE_MEETING_ROOM_2 = "4";//会议室型
	public static final String PRODUCT_APP_TYPE_TERMINAL = "3";//3终端
	public static final String USER_PASSWORD = "888888";//创建用户时默认的密码
	public static final String PHONE_ACCOUNT_PASSWORD = "123456";//手机账号默认密码123456
	public static final String ROMM_TYPE="SYS";//系统根据条件自动创建会议室时会议室的类型
	
	public static final String LOCAL_MEMBER_DELETE="D"; //本地通讯录删除
	public static final String LOCAL_MEMBER_UPDATE="U"; //本地通讯录更新
	public static final String LOCAL_MEMBER_ADD="A";    //本地通讯录添加
	
	/**
	 * IBSS正式用户用户
	 */
	public static final Integer COMPANYTYPE_1 = 1;
	/**
	 * IBSS电信测试帐号
	 */
	public static final Integer COMPANYTYPE_2 = 2;
	/**
	 * 商航接口测试帐号
	 */
	public static final Integer COMPANYTYPE_3 = 3;
	/**
	 * 后台正式用户帐号
	 */
	public static final Integer COMPANYTYPE_4 = 4;
	/**
	 * 后台试用用户帐号
	 */
	public static final Integer COMPANYTYPE_5 = 5;
	/**
	 * 后台电信试用帐号
	 */
	public static final Integer COMPANYTYPE_6 = 6;
	/**
	 * 合作伙伴接口帐号
	 */
	public static final Integer COMPANYTYPE_7 = 7;
	/**
	 * 后台开发维护帐号
	 */
	public static final Integer COMPANYTYPE_8 = 8;
	/**
	 * IBSS体验帐号
	 */
	public static final Integer COMPANYTYPE_9 = 9;
	/**
	 * 后台体验帐号
	 */
	public static final Integer COMPANYTYPE_10 = 10;
	

	/**
	 *  验证码有效时间，单位为秒
	 */
	public static final Integer TIME_OUT = 300; 
	
	// 操作类型
	/**
	 *  1.	newProd：产品订购
		2.	cancelProd：产品拆机
		3.	modifyProdAttribute：修改产品属性
		4.	modifyProdState：修改产品状态
		5.	moveProd：产品移机
		6.	addMember：成员加入
		7.	removeMember：成员退出
		8.	authorize：用户授权
		9.	revokeAuthorize：取消用户授权
		10.	modifyMemberState:修改成员状态
		11.	modifyMemberAttribute修改成员属性
		12.	modifyMemberAccNum 修改成员接入号
	 */
	public static final String NEW_PROD = "newProd";
	public static final String CANCEL_PROD = "cancelProd";
	public static final String MODIFY_PROD_STATE = "modifyProdState";
	public static final String MODIFY_PROD_ATTRIBUTE = "modifyProdAttribute";
	public static final String MOVE_PROD = "moveProd";
	public static final String ADD_MEMBER = "addMember";
	public static final String REMOVE_MEMBER = "removeMember";
	public static final String AUTHORIZE = "authorize";
	public static final String REVOKE_AUTHORIZE = "revokeAuthorize";
	public static final String MODIFY_MEMBERSTATE = "modifyMemberState";
	public static final String MODIFY_MEMBERATTRIBUTE = "modifyMemberAttribute";
	public static final String MODIFY_MEMBERACCNUM = "modifyMemberAccNum";
	// 返回值定义
	public static final String RET_FLAG ="retFlag";
	public static final String IS_REPLY ="isReply";
	public static final String RETURN_NUMBER ="returnNumber";
	public static final String RETURN_MSG ="returnMsg";
	
	// 产品属性顺序定义
	public static final int INDEX1 =1;
	public static final int INDEX2 =2;
	public static final int INDEX3 =3;
	public static final int INDEX4 =4;
	public static final int INDEX5 =5;
	public static final int INDEX6 =6;
	public static final int INDEX7 =7;
	public static final int INDEX8 =8;
	public static final int INDEX9 =9;
	public static final int INDEX10 =10;
	public static final int INDEX11 =11;
	public static final int INDEX12 =12;
	public static final int INDEX13 =13;
	public static final int INDEX14 =14;
	public static final int INDEX15 =15;
	public static final int INDEX16 =16;
	public static final int INDEX17 =17;
	public static final int INDEX18 =18;
	public static final int INDEX19 =19;
	public static final int INDEX20 =20;
	public static final int INDEX21 =21;
	public static final int INDEX22 =22;
	public static final int INDEX23 =23;
	public static final int INDEX24 =24;
	public static final int INDEX25 =25;
	public static final int INDEX26 =26;
	public static final int INDEX27 =27;
	public static final int INDEX28 =28;
	public static final int INDEX29 =29;
	public static final int INDEX30 =30;
	public static final int INDEX31 =31;
	public static final int INDEX32 =32;
	public static final int INDEX33 =33;
	public static final int INDEX34 =34;
	public static final int INDEX35 =35;
	public static final int INDEX36 =36;
	public static final int INDEX37 =37;
	public static final int INDEX38 =38;
	public static final int INDEX39 =39;
	public static final int INDEX40 =40;
	public static final int INDEX41 =41;
	
	public static final String INDEX1_CODE ="payUserType";
	public static final String INDEX2_CODE ="prodType";
	public static final String INDEX3_CODE ="priceType";
	public static final String INDEX4_CODE ="accountNum";
	public static final String INDEX5_CODE ="freeMonthNum";
	public static final String INDEX6_CODE ="freeAccountNum";
	public static final String INDEX7_CODE ="packageType";
	public static final String INDEX8_CODE ="bandwidth";
	public static final String INDEX9_CODE ="quality";
	public static final String INDEX10_CODE ="frame";
	public static final String INDEX11_CODE ="partNum";
	public static final String INDEX12_CODE ="speakNum";
	public static final String INDEX13_CODE ="mediaModel";
	public static final String INDEX14_CODE ="startModel";
	public static final String INDEX15_CODE ="accountType";
	public static final String INDEX16_CODE ="userBandwidth";
	public static final String INDEX17_CODE ="userQuality";
	public static final String INDEX18_CODE ="userFrame";
	public static final String INDEX19_CODE ="userPartNum";
	public static final String INDEX20_CODE ="userSpeakNum";
	public static final String INDEX21_CODE ="userMediaModel";
	public static final String INDEX22_CODE ="userStartModel";
	public static final String INDEX23_CODE ="meetingPartNum";
	public static final String INDEX24_CODE ="meetingSpeakNum";
	public static final String INDEX25_CODE ="meetingModel";
	public static final String INDEX26_CODE ="meetingStartModel";
	public static final String INDEX27_CODE ="meetingQuality";
	public static final String INDEX28_CODE ="meetingRecord";
	public static final String INDEX29_CODE ="meetingAuth";
	public static final String INDEX30_CODE ="meetingPwd";
	public static final String INDEX31_CODE ="localnet";
	public static final String INDEX32_CODE ="custManagerName";
	public static final String INDEX33_CODE ="custManagerPone";
	public static final String INDEX34_CODE ="linkManPhone";
	public static final String INDEX35_CODE ="userName";
	public static final String INDEX36_CODE ="userAccount";
	public static final String INDEX37_CODE ="isPresent";
	public static final String INDEX38_CODE ="feeType";
	public static final String INDEX39_CODE ="userName1";
	public static final String INDEX40_CODE ="iccd";
	public static final String INDEX41_CODE ="IMSI";
	
	public static final String INDEX1_NAME ="付费主体";
	public static final String INDEX2_NAME ="产品类型";
	public static final String INDEX3_NAME ="套餐类型";
	public static final String INDEX4_NAME ="账号数量";
	public static final String INDEX5_NAME ="免费月数";
	public static final String INDEX6_NAME ="赠送账号数";
	public static final String INDEX7_NAME ="优惠类型";
	public static final String INDEX8_NAME ="最大带宽";
	public static final String INDEX9_NAME ="默认会议质量";
	public static final String INDEX10_NAME ="帧率";
	public static final String INDEX11_NAME ="最大参会人数";
	public static final String INDEX12_NAME ="最大发言人数";
	public static final String INDEX13_NAME ="音视频模式";
	public static final String INDEX14_NAME ="启动模式";
	public static final String INDEX15_NAME ="帐号类型";
	public static final String INDEX16_NAME ="用户最大带宽";
	public static final String INDEX17_NAME ="用户默认会议质量";
	public static final String INDEX18_NAME ="用户帧率";
	public static final String INDEX19_NAME ="用户最大参会人数";
	public static final String INDEX20_NAME ="用户最大发言人数";
	public static final String INDEX21_NAME ="用户音视频模式";
	public static final String INDEX22_NAME ="用户启动模式";
	public static final String INDEX23_NAME ="会议室最大参与者数";
	public static final String INDEX24_NAME ="会议室最大发言人数";
	public static final String INDEX25_NAME ="会议室默认会议模式";
	public static final String INDEX26_NAME ="会议室默认启动模式";
	public static final String INDEX27_NAME ="会议室默认会议质量";
	public static final String INDEX28_NAME ="会议室自由录制";
	public static final String INDEX29_NAME ="会议室认证方式";
	public static final String INDEX30_NAME ="会议室会议密码";
	public static final String INDEX31_NAME ="本地网络编码";
	public static final String INDEX32_NAME ="客户经理姓名";
	public static final String INDEX33_NAME ="客户经理联系电话";
	public static final String INDEX34_NAME ="联系人电话号码";
	public static final String INDEX35_NAME ="用户名称";
	public static final String INDEX36_NAME ="用户账号";
	public static final String INDEX37_NAME ="是否赠送";
	public static final String INDEX38_NAME ="用户号码卡付费类型";
	public static final String INDEX39_NAME ="用户姓名";
	public static final String INDEX40_NAME ="卡号-ICCID";
	public static final String INDEX41_NAME ="IMSI号码";
	
	public static final String CLIENT_TYPE_PC = "pc";
	public static final String CLIENT_TYPE_MOBILE = "mobile";
	public static final String CLIENT_TYPE_CMS = "cms";
	public static final String CLIENT_INTF_CUST_TRANS = "0035FE820A139B6E002DF9F6E7157909";//产品实例流水号，由于移动端对应同一个CUST，所以每次传同样的值
	
	public static final String MOBILE_CUST_CODE = "MOBILE_CUST";//移动端注册客户，默认对应
	
	//===========================ACU版接口变量=========================
	//产品套餐互斥配置,PRODTYPE_X,X为ACU的p_attribute_name表的prodcut_type字段值，数组元素为当前产品类型只能与此些套餐ID的套餐匹配，其他套餐为互斥套餐
	public static final int[] PRODTYPE_1 = {2015111,2015112,2015113};
	public static final int[] PRODTYPE_2 = {2015121,2015122,2015123};
	public static final int[] PRODTYPE_3 = {2015221,2015222,2015223};
	public static final int[] PRODTYPE_4 = {2015231};

	public static final String CONTACT_TYPE = "contactType";
	
	//===========================ACL版接口变量=========================
	//==================商航接口相关变量结束==================
	
	/**
	 * ==================支付接口相关变量结束==================
	 */
	// 定义返回成功
	public static final String RETURN_PAY_SUCCESS = "30000";
	public static final String RETURN_PAY_MSG_SUCCESS = "success";
	// 定义返回失败
	public static final String RETURN_PAY_FAIL = "30001";
	public static final String RETURN_PAY_MSG_FAIL = "系统异常";
	// 请求时间超时
	public static final String RETURN_PAY_TIMEOUT = "30002";
	public static final String RETURN_PAY_MSG_TIMEOUT = "请求时间超时";
	// 参数错误
	public static final String RETURN_PAY_PARAM_ERROR = "30003";
	public static final String RETURN_PAY_MSG_PARAM_ERROR = "参数错误";
	// 支付金额为0
	public static final String RETURN_PAY_ZERO_PRICE = "32001";
	public static final String RETURN_PAY_MSG_ZERO_PRICE = "支付金额为0";
	// 传入的支付金额与系统中的金额不一致
	public static final String RETURN_PAY_PRICE_NOT_FIT = "32002";
	public static final String RETURN_PAY_MSG_PRICE_NOT_FIT = "传入的支付金额与系统中的金额不一致";
	// 未找到订购的产品
	public static final String RETURN_PAY_PRODINST_NOTFOUND = "32003";
	public static final String RETURN_PAY_MSG_PRODINST_NOTFOUND = "未找到订购的产品";
	// 订单确认码错误
	public static final String RETURN_PAY_CONFIRMCODE_ERROR = "32004";
	public static final String RETURN_PAY_MSG_CONFIRMCODE_ERROR = "订单确认码错误";
	// 支付成功后回填用户支付账号等信息失败
	public static final String RETURN_PAY_RECORD_ACCOUNT_ERROR = "32005";
	public static final String RETURN_PAY_MSG_RECORD_ACCOUNT_ERROR = "支付成功后回填用户支付账号等信息失败";
	
	/**
	 * ==================支付接口相关变量结束==================
	 */
	//===========================计费功能变量=========================
	public static final Integer RECORD_STATUS_HANDDLER_WAITING = 0;
	public static final Integer RECORD_STATUS_HANDDLER_SUCCESS = 1;
	public static final Integer RECORD_STATUS_HANDDLER_FAIL = 2;
	public static final Integer RECORD_STATUS_HANDDLERING = 3;
	
	public static final Integer FILE_UPLOAD_SUCCESS = 0;
	public static final Integer FILE_UPLOAD_FAIL = 1;
	public static final Integer FILE_UPLOAD_WAITING = 2;
	
	public static final String SYS_GROUP="SYS";
    public static final String SELF_GROUP="SELF";
    
    public static final Integer DEFAULT_TMEP_ID=0;
    public static final Integer DEFAULT_SERV_ID=1;
    public static final String EMAIL_IS_MORE_Y="Y";
    public static final String EMAIL_IS_MORE_N="N";
    
    /**
	 * 立即发送邮件方式
	 */
	public static final String NOW_SEND_EMAIL = "NOW"; 
	
	/**
	 * 定时发送邮件方式
	 */
	public static final String TIME_SEND_EMAIL = "TIME"; 
	
    /**
	 * 立即发送短信方式
	 */
	public static final String NOW_SEND_SMS = "NOW"; 
	
	/**
	 * 定时发送短信方式
	 */
	public static final String TIME_SEND_SMS = "TIME"; 
	
	public static final Integer SEND_MSG_MAX_NUM=50;

	 /**
     * 匹配包含手机号码的的行 
     */
	public static final String REGEX_FOR_CONTAIN_MOBILE = "^([0-9])\\d{10}$";
	
	
	/**
	 * 匹配电信号码的正则表达式
	 */
	public static final String CT="^((133)|(153)|(18[0,9]))\\d{8}$"; 
	
	 /**
     * 匹配包含电子邮件的正则表达式
     */
	public static final String REGEX_FOR_CONTAIN_EMAIL = "\\w+@(\\w+.)+[a-z]{2,3}";

	public static final String ENABLE = "enable";
	public static final String DISABLE = "disable";

	
	//===========================计费功能变量=========================
	
	
	public static final class PKG_CODE{
		public static final String CMS = "cms";
		public static final String PROD_PORTAL = "prodportal";
	}

	
	/**  
	* 函数功能说明 TODO:获取UUID生成的主键
	* Administrator修改者名字
	* 2013-5-8修改日期
	* 修改内容
	* @Title: getPrimaryKeyByUUID 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getPrimaryKeyByUUID(){
		return UUID.randomUUID().toString();
	}  
	
	public static String getReturnStringJSON(String status,String message){
		return"{\"status\":\""+status+"\",\"message\":\""+message+"\"}";
	} 
	
	/**
	 * 合并两个list
	 * @param preList
	 * @param after
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List unionListAll(List preList, List after) {
		List ret = new  ArrayList();
		if(preList != null && preList.size() > 0){
			ret.addAll(preList);
		}
		
		if(after != null && after.size() > 0){
			ret.addAll(after);
		}
		return ret;
	} 
	
	
	
	
	
	/**  
	* 函数功能说明 TODO:获得简单查询条件
	* Administrator修改者名字
	* 2013-5-30修改日期
	* 修改内容
	* @Title: getSearchConditionsHQL 
	* @Description: 
	* @param @param asName
	* @param @param param
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getSearchConditionsHQL(String asName ,Map<String, Object> param){
		StringBuffer sb=new StringBuffer();
		if (param != null && !param.isEmpty()) {
			for (String name : param.keySet())
			{
				sb.append(" and "+asName+Constants.IS_DOT+name+" like :"+name+"");
			}
		}
		return sb.toString();
	}
	

	public static String[] getFiledName(Object o )
	{
		try
		{
			Field[] fields = o.getClass().getDeclaredFields();
			String[] fieldNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++)
			{
				fieldNames[i] = fields[i].getName();
			}
			return fieldNames;
		} catch (SecurityException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object getFieldValueByName(String fieldName, Object o)    
	{       
	   try    
	   {       
	       String firstLetter = fieldName.substring(0, 1).toUpperCase();       
	       String getter = "get" + firstLetter + fieldName.substring(1);       
	       Method method = o.getClass().getMethod(getter, new Class[] {});       
	       Object value = method.invoke(o, new Object[] {});       
	       return value;       
	   } catch (Exception e)    
	   {       
	       System.out.println("属性不存在");       
	       return "";       
	   }       
	}  
	
	  public static HashMap<String, Method> ConverBean(Class<?> drbean) {  
	        Class<?> stopClass = null;  
	        // 存放class信息  
	        BeanInfo drbeaninfo = null;  
	        // 存放属性信息  
	        PropertyDescriptor[] props;  
	        HashMap<String, Method> map = new HashMap<String, Method>();  
	        try {  
	            // 获取class中得属性方法信息  
	            drbeaninfo = Introspector.getBeanInfo(drbean, stopClass);  
	            // 把class中属性放入PropertyDescriptor数组中  
	            props = drbeaninfo.getPropertyDescriptors();  
	            for (int i = 0; i < props.length; i++) {  
	                // 获取属性所对应的set方法  
	                Method setMethod = props[i].getWriteMethod();  
	                // 判断属性是否有set方法 如果有放入map<属性名，set方法>中  
	                if (setMethod != null) {  
	                    String field = props[i].getName().toLowerCase();  
	                    map.put(field, setMethod);  
	                }  
	            }  
	        } catch (IntrospectionException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        return map;  
	    }
	
	/**  
	* 函数功能说明 TODO:获取客户端ip地址
	* Administrator修改者名字
	* 2013-6-19修改日期
	* 修改内容
	* @Title: getIpAddr 
	* @Description: 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getIpAddr() {
		   HttpServletRequest request=ServletActionContext.getRequest();
	       String ip = request.getHeader("x-forwarded-for");
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getRemoteAddr();
	       }
	       return ip;
	   } 
	
	
	 public static void copy(File src, String fullSavePath) {
	        InputStream in = null; 
	        OutputStream out = null; 
	        File newFile=new File(fullSavePath);
	        try { 
	            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE); 
	            out = new BufferedOutputStream(new FileOutputStream(newFile), 
	                    BUFFER_SIZE); 
	            byte[] buffer = new byte[BUFFER_SIZE]; 
	            int len = 0; 
	            while ((len = in.read(buffer)) > 0) { 
	                out.write(buffer, 0, len); 
	            } 
	            out.flush();
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } finally { 
	            if (null != in) { 
	                try { 
	                    in.close(); 
	                } catch (IOException e) { 
	                    e.printStackTrace(); 
	                } 
	            } 
	            if (null != out) { 
	                try { 
	                    out.close(); 
	                } catch (IOException e) { 
	                    e.printStackTrace(); 
	                } 
	            } 
	        } 
	    }
	
	 public static String dbBackUp()
		{
			//生成临时备份文件
			SimpleDateFormat sd=new SimpleDateFormat("yyyyMMddHHmmss");
			String fineName="dbBackUp-"+sd.format(new Date());
			String sqlName=fineName+Constants.FILE_SUFFIX_SQL;
			String pathSql=BASE_PATH+"attachment"+File.separator+"dbBackUp";
			try {
				File filePathSql = new File(pathSql);
				if(!filePathSql.exists()){
					filePathSql.mkdir();
				}
				StringBuffer sbs = new StringBuffer();
				sbs.append("mysqldump ");
				sbs.append("-h 192.168.110.10 ");
				sbs.append("--user=root");
				sbs.append(" --password=fortune123");
				sbs.append(" --lock-all-tables=true ");
				sbs.append("--result-file="+pathSql+File.separator);
				sbs.append(sqlName+" ");
				sbs.append(" --default-character-set=utf8 ");
				sbs.append("ERP");
		        Runtime runtime = Runtime.getRuntime();
		        Process child = runtime.exec(sbs.toString());
		        //读取备份数据并生成临时文件
		        InputStream in = child.getInputStream();
		        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(pathSql), "utf8");
		        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf8"));
		        String line=reader.readLine();
		        while (line != null) {
		                writer.write(line+"\n");
		                line=reader.readLine();
		         }
		         writer.flush();
			} catch (Exception e) {
				
			}
			return sqlName;
		}
	 
	  public static class IconCls{
		  public static final String ICON_REMOVE = "icon-remove";
		  public static final String ICON_EDIT = "icon-edit";
		  public static final String ICON_ADDS = "icon-adds";
		  public static final String DEL = "Del";
		  public static final String EDIT = "Edit";
		  public static final String ADD = "Add";
	 }

	 /**
	  * 数组去重
	  * @param num
	  * @return
	  */
	public static Integer[] getDistinct(int num[]) {
		List<Integer> list = new java.util.ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (!list.contains(num[i])) {// 如果list数组不包括num[i]中的值的话，就返回true。
				list.add(num[i]); // 在list数组中加入num[i]的值。已经过滤过。
			}
		}
		return list.toArray(new Integer[0]); // toArray（数组）方法返回数组。并要指定Integer类型。new
												// integer[o]的空间大小不用考虑。因为如果list中的长度大于0（你integer的长度），toArray方法会分配一个具有指定数组的运行时类型和此列表大小的新数组。
	}
	/**
	 * 数组去重
	 * @param arr
	 * @return
	 */
	public static String[] getDistinct(String[] arr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			String val = arr[i];
			
			if(!StringUtils.isEmpty(val)){
				val = val.replaceAll("\\s*", "");
			}
			if (!list.contains(val)) {// 如果list数组不包括num[i]中的值的话，就返回true。
				list.add(val); // 在list数组中加入num[i]的值。已经过滤过。
			}
		}
		return list.toArray(new String[0]); // toArray（数组）方法返回数组。并要指定Integer类型。new
												// integer[o]的空间大小不用考虑。因为如果list中的长度大于0（你integer的长度），toArray方法会分配一个具有指定数组的运行时类型和此列表大小的新数组。
	}
	/**
	 * 两个数组去重
	 * @param userIdsArray
	 * @param tmpUserIdsArray
	 * @return
	 */
	public static String distinctBetweenArray(String[] userIdsArray,String[] tmpUserIdsArray) {
		userIdsArray = Constants.getDistinct(userIdsArray);
		tmpUserIdsArray = Constants.getDistinct(tmpUserIdsArray);
		List<String> list = new ArrayList<String>(Arrays.asList(userIdsArray));
		list.addAll(Arrays.asList(tmpUserIdsArray));
		String[] unionList = list.toArray(new String[0]);
		String ret = getDistinct2String(unionList);
		return ret;
	}

	/**
	 * 去重返回字符串
	 * @param paramArray
	 * @return
	 */
	public static String getDistinct2String(String[] paramArray) {
		paramArray = Constants.getDistinct(paramArray);
		String ret = Arrays.toString(paramArray);
		ret = ret.replace("[", "").replace("]", "");
		return ret;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String cutLastChar(String str) {
		String ret = null;
		if(!StringUtils.isEmpty(str)){
			ret = str.substring(0, str.length() -1);
		}
		return ret;
	}

	/**
	 * 校验用户是否已经登录
	 * @param activeSession
	 * @param userId
	 * @param id 
	 * @return
	 */
	public static boolean checkRepeatLogin(
			Collection<org.apache.shiro.session.Session> activeSessions,Integer userId, Serializable sessionId) {
		boolean isRepeat = false;
		if(activeSessions != null && activeSessions.size() > 0){
			for(org.apache.shiro.session.Session actsession : activeSessions){
				Integer actUserId = (Integer)actsession.getAttribute(Constants.USER_ID);
				Serializable actsessionId  = actsession.getId();

				if(userId.equals(actUserId) 
						&& !((String)sessionId).equals(((String)actsessionId))){
					isRepeat = true;
					break;
				}
			}
		}
		return isRepeat;
	}

	public static Boolean checkSessionActiveByUserId(
			Collection<org.apache.shiro.session.Session> activeSessions,
			Integer userId) {
		Boolean isActive = false;
		if(activeSessions != null && activeSessions.size() > 0){
			for(org.apache.shiro.session.Session actsession : activeSessions){
				Integer actUserId = (Integer)actsession.getAttribute(Constants.USER_ID);
				if(userId.equals(actUserId)){
					isActive = true;
					break;
				}
			}
		}
		return isActive;
	}
	
	    
    /**
     * 比较两个数组找不同
     * @param newStr
     * @param oldStr
     */
    public static Map<String, Object> addUpdateRemoveCompare(String[] newStr,String[] oldStr) {
        
    	boolean hasNew = (newStr != null && newStr.length > 0);
    	boolean hasOld = (oldStr != null && oldStr.length > 0);
    	String [] addIdArr = null;
    	String [] updateIdArr = null;
    	String [] removeIdArr = null;
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	
        if(hasNew && hasOld){
        	Set<String> newStrSet = new HashSet<String>();
            Set<String> oldStrSet = new HashSet<String>();
            
            Set<String> addIdArrSet = new HashSet<String>();
            Set<String> updateArrSet = new HashSet<String>();


            newStrSet.addAll(Arrays.asList(newStr));
            
            oldStrSet.addAll(Arrays.asList(oldStr));
            
            Iterator<String> iter = newStrSet.iterator();
            while(iter.hasNext()) {
                String o = iter.next();
                if (oldStrSet.contains(o)) {
                	updateArrSet.add(o);
                	oldStrSet.remove(o);
                } else {
                	addIdArrSet.add(o);
                }
            }
            
            addIdArr = addIdArrSet.toArray(new String[0]);
            updateIdArr = updateArrSet.toArray(new String[0]);
            removeIdArr = oldStrSet.toArray(new String[0]);
        }else if(!hasNew && hasOld){
        	removeIdArr = oldStr;
        }else if(hasNew && !hasOld){
        	addIdArr = newStr;
        }else if(!hasNew && !hasOld){
        	
        }
        

        retMap.put(ADD_IDS, addIdArr); 
    	retMap.put(UPDATE_IDS, updateIdArr); 
    	retMap.put(REMOVE_IDS, removeIdArr); 
    	
		return retMap;
    }
    
    public static class CustOrigin{
//    	创建客户的来源；字典DICT_TYPEID=CM_CUST_ORIGIN
//    			IBSS正式用户用户 
//    			IBSS电信测试帐号
//    			商航接口测试帐号 
//    			后台正式用户帐号 
//    			后台试用用户帐号 
//    			后台电信试用帐号
//    			合作伙伴接口帐号
//    			后台开发维护帐号 
//    			待处理帐号 
//    			IBSS体验帐号 
//    			后台体验帐号
    	public static final String IBSS_OFFICIAL_USER ="IBSS_OFFICIAL_USER";
    	//public static final String IBSS_OFFICIAL_USER ="IBSS_OFFICIAL_USER";

    	
    }


}
