package cn.huanqiu.scaffold.service.cms.sm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utils.Constants;
import utils.MD5Util;
import cn.huanqiu.scaffold.service.cms.sm.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml"})
public class TestUserService {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testAddUser() throws Exception {
		
		UserVO userVO = new  UserVO();
		userVO.setCreateUsear("admin");
		userVO.setEmail("test@test.com");
		userVO.setIndustry("light");
		userVO.setStatus(Constants.ENABLE);
		userVO.setUserCode("admin");
		userVO.setUserName("管理员");
		
		String userPwd = "123456";
		userVO.setUserPwd( MD5Util.convertMD5(userPwd));
		userService.addUser(userVO );
	}
	
	
	@Test
	public void testUpdateUser() throws Exception {
		
		UserVO userVO = new  UserVO();
		userVO.setCreateUsear("admin");
		userVO.setEmail("test@test.com");
		userVO.setIndustry("light");
		userVO.setStatus(Constants.ENABLE);
		userVO.setUserCode("admin");
		userVO.setUserName("管理员");
		
		String userPwd = "123456";
		MD5Util.string2MD5(userPwd);
		MD5Util.convertMD5(userPwd);
		userVO.setUserPwd(userPwd);
		userService.updateUser(userVO);
	}
	
	@Test
	public void testGetUser() throws Exception {
		
		UserVO userVO = new  UserVO();
		userVO.setUserId(1);
		userVO =  userService.getUser(userVO);
		  
		System.out.println("数据库加密后:"+userVO.getUserPwd());
		System.out.println("解密后:"+MD5Util.convertMD5(userVO.getUserPwd()));
		  
	}
	
	@Test
	public void testLogin() throws Exception {
		
		UserVO userVO = new UserVO();
		userVO.setUserCode("admin");
		userVO.setUserPwd(MD5Util.convertMD5("1"));
		UserVO tmp =  userService.login(userVO);
		
		System.out.println("返回："+tmp);
		  
	}
	
	
}
