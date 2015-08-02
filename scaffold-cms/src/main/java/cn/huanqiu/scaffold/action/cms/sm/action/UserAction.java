package cn.huanqiu.scaffold.action.cms.sm.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.util.StringUtils;

import utils.Constants;
import utils.JsonVO;
import utils.MD5Util;
import cn.huanqiu.scaffold.action.BaseAction;
import cn.huanqiu.scaffold.service.cms.sm.service.IUserService;
import cn.huanqiu.scaffold.service.cms.sm.vo.IndustryVO;
import cn.huanqiu.scaffold.service.cms.sm.vo.UserVO;

/**
 * 用户action
 * @author 周枫恩
 *
 */
@Controller("userAction")
public class UserAction extends BaseAction {
	
	@Autowired
	private IUserService userService;
	
	private UserVO userVO;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		
		JsonVO jsonVO = new JsonVO();
		
		userVO.getUserCode();
		userVO.setUserPwd(MD5Util.convertMD5(userVO.getUserPwd()));
		UserVO tmpUserVO=  userService.login(userVO);
		
		
		if(tmpUserVO == null){
			jsonVO.setStatus(false);
			jsonVO.setMessage("用户名/密码错误！");
			
		}else{
			httpServletRequest.getSession().setAttribute("userInfo", tmpUserVO);
			jsonVO.setStatus(true);
			jsonVO.setMessage("成功！");
		}
		
		OutputJson(jsonVO);
		
		return null;
		
	}
	
	/**
	 * 获取用户信息
	 * @return
	 * @throws IOException
	 */
	public String getUserInfo() throws IOException{
		
		UserVO  userVO = ( UserVO) httpServletRequest.getSession().getAttribute("userInfo");
		List<UserVO> userVOs = new ArrayList<>();
		if(userVO != null){
			userVO = userService.getUser(userVO);
			
			String industryStr = userVO.getIndustry();
			if(!StringUtils.isEmpty(industryStr)){
				String[] industrys = industryStr.split(",");
				userVO.setIndustrys(industrys);
				
				String industryNamesStr = "";
				for(String industry : industrys){
					  
					industryNamesStr += getIndustryName(industry) + ",";
				}
				String[] industryNames = null;
				if(!"".equals(industryNamesStr) ){
					industryNamesStr = industryNamesStr.substring(0, industryNamesStr.length() - 1);
					industryNames = industryNamesStr.split(",");
				}
				userVO.setIndustryNames(industryNames);
			}
			
			userVOs.add(userVO);
		}
		outputListJsonData(userVOs);
		
		return null;
	}
	
	/**
	 * 封装数据
	 * @return
	 */
	public String getIndustrys(){
		List<IndustryVO> industrys = new ArrayList<>();
		
		IndustryVO ligth = new IndustryVO("light", "灯具");
		industrys.add(ligth);
		IndustryVO cloth  = new IndustryVO("cloth", "服饰");;
		industrys.add(cloth);
		IndustryVO toy = new IndustryVO("toy", "玩具");;
		industrys.add(toy);
		
		OutputJson(industrys);
		
		return null;
	}
	
	/**
	 * 编辑用户
	 * @return
	 */
	public String updateUser(){
		JsonVO json = new JsonVO();
		
		String industrys = httpServletRequest.getParameter("userVO.industrys");

		if(StringUtils.isEmpty(industrys)){
			userVO.setIndustrys(null);
		}
		
		try {
			UserVO user = ( UserVO) httpServletRequest.getSession().getAttribute("userInfo");
			if(userVO.getUserId() != null && user != null){
				userVO.setModifyUser(user.getUserCode()+"");
				userService.updateUser(userVO);
				json.setStatus(true);
				json.setMessage(Constants.POST_DATA_SUCCESS);
			}
		} catch (Exception e) {
			json.setStatus(false);
			json.setMessage(Constants.POST_DATA_FAIL);

			e.printStackTrace();
		}
		 
		OutputJson(json);
		return null;
	}
	
	/**
	 *  字典转换
	 * @param industry
	 * @return
	 */
	private String getIndustryName(String industry) {
		String industryName = null;
		switch (industry) {
		case "light":
			industryName = "灯具";
			break;
			
		case "cloth":
			industryName = "服饰";
			break;
			
		case "toy":
			industryName = "玩具";
			break;

		default:
			break;
		}
		
		return industryName;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
	
	
}
