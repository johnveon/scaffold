package cn.huanqiu.scaffold.service.cms.sm.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utils.MD5Util;

import cn.huanqiu.scaffold.dao.sm.dao.UserDAO;
import cn.huanqiu.scaffold.service.cms.sm.service.IUserService;
import cn.huanqiu.scaffold.service.cms.sm.vo.UserVO;

@Service("userService")
public class UserServiceIpml implements IUserService {
	
	public UserServiceIpml() {
	}

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO login(UserVO userVO) {
		
		UserVO ret = null;
		List<UserVO>  userVOs = userDAO.findUser(userVO);
		if(userVOs != null && userVOs.size() > 0){
			ret = userVOs.get(0);
		}
		
		return ret;
	}

	@Override
	public UserVO addUser(UserVO userVO) {
		if(userVO != null){
			userVO.setCreateDate(new Date());
			userDAO.insertSelective(userVO);
		}
		return userVO;
	}

	@Override
	public UserVO updateUser(UserVO userVO) {

		if(userVO != null){
			
			if("YES".equals(userVO.getPwdChange())){
				String userPwd = userVO.getUserPwd(); 
				userPwd = MD5Util.convertMD5(userPwd);
				userVO.setUserPwd(userPwd);
			}else{
				userVO.setUserPwd(null);
			}
			userVO.setModifyDate(new Date());
			String[] indusrtys =  userVO.getIndustrys();
			if(indusrtys != null && indusrtys.length > 0){
				String industry =  Arrays.toString(indusrtys); 
				industry = industry.replace("[", "");
				industry =  industry.replace("]", "");
				industry = industry.replace(" ", "");
				userVO.setIndustry(industry);
			}else{
				userVO.setIndustry(null);
			}
			userDAO.updateByPrimaryKeySelective(userVO);
		}
		return userVO;
	}

	@Override
	public UserVO getUser(UserVO userVO) {
		if(userVO != null){
			userVO = userDAO.selectByPrimaryKey(userVO.getUserId());
		}
		return userVO;
	}

}
