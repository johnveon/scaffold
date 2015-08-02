package cn.huanqiu.scaffold.service.cms.sm.service;

import cn.huanqiu.scaffold.service.cms.sm.vo.UserVO;


public interface IUserService {
	
	UserVO login(UserVO userVO);
	
	UserVO addUser(UserVO userVO);
	
	UserVO updateUser(UserVO userVO);
	
	UserVO getUser(UserVO userVO);



}
