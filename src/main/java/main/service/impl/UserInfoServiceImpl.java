package main.service.impl;

import main.dao.UserInfoMapper;
import main.domain.UserInfo;
import main.domain.UserInfoExample;
import main.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo validate(String username, String password) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
        List<UserInfo> resultList = userInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(resultList) ? null : resultList.get(0);
    }

    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
