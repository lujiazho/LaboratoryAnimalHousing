package org.lah.Commons.service.impl;
import org.lah.Commons.domain.User;
import org.lah.Commons.mapper.UserMapper;
import org.lah.Commons.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// 声明这个service所有方法需要事务管理。每一个业务方法开始时都会打开一个事务
// REQUIRED:业务方法需要在一个容器里运行。如果方法运行时，已经处在一个事务中，那么加入到这个事务，否则自己新建一个新的事务
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly=true)
    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithLoginNameAndPassword(loginname, password);
    }
}
