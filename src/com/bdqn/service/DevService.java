package com.bdqn.service;

import com.bdqn.pojo.DevUser;

public interface DevService {
    DevUser devlogin(String devCode, String devPassword);
}
