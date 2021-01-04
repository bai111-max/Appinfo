package com.bdqn.service;

import com.bdqn.mapper.DevMapper;
import com.bdqn.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevServiceImpl implements DevService {
    @Resource
    private DevMapper devMapper;

    @Override
    public DevUser devlogin(String devCode, String devPassword) {
        return devMapper.devlogin(devCode,devPassword);
    }
}
