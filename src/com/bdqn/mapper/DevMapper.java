package com.bdqn.mapper;

import com.bdqn.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevMapper {
    DevUser devlogin(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
}
