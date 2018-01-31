package main.service.impl;

import main.dao.UserInfoMapper;
import main.domain.UserInfoExample;
import main.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public boolean validate(String username, String password) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
        return !CollectionUtils.isEmpty(userInfoMapper.selectByExample(example));
    }
}
