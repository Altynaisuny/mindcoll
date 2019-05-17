package com.sunyt.mindcoll.dao.mapper;

import com.sunyt.mindcoll.model.TokenModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper {
    void updateUserToken(TokenModel tokenModel);
}
