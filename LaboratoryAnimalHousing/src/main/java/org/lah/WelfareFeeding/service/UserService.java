package org.lah.WelfareFeeding.service;

import org.lah.Commons.domain.User;

public interface UserService {
    User getUser();
    void setUser(User user);
    String getUserIdString();
}
