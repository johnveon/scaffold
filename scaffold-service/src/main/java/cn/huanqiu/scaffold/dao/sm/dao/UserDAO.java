package cn.huanqiu.scaffold.dao.sm.dao;

import java.util.List;

import cn.huanqiu.scaffold.service.cms.sm.vo.UserVO;

public interface UserDAO {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    UserVO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);

	List<UserVO> findUser(UserVO userVO);
}