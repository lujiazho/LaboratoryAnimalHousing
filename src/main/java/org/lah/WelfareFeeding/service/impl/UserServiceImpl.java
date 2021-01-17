package org.lah.WelfareFeeding.service.impl;

import org.lah.Commons.LahConstants;
import org.lah.Commons.domain.User;
import org.lah.WelfareFeeding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private final HttpSession session;

    @Autowired
    public UserServiceImpl(HttpSession session) {
        this.session = session;
    }

    @Override
    public User getUser() {
        return (User) session.getAttribute(LahConstants.USER_SESSION);
    }

    @Override
    public void setUser(User user) {
        session.setAttribute(LahConstants.USER_SESSION, user);
    }

    @Override
    public String getUserIdString() {
        return getUser().getId().toString();
    }

}
