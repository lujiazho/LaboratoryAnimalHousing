package org.lah.Commons.service;
import org.lah.Commons.domain.User;

public interface LoginService {
    //loginname是登陆名称
    //password是密码
    User login(String loginname, String password);
}
