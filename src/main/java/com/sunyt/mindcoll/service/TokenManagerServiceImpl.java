package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.dao.mapper.TokenMapper;
import com.sunyt.mindcoll.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class TokenManagerServiceImpl implements TokenManagerService {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public TokenModel createToken(long userId) {
        String token = UUID.randomUUID().toString().substring(0,16);
        String id = String.valueOf(userId);
        return null;
    }

    @Override
    public boolean checkToken(TokenModel tokenModel) {
        Date date = new Date();
        if (tokenModel.getExpireTime().getTime()<date.getTime()){
            //token已经过期
        }
        return false;
    }

    @Override
    public TokenModel getToken(String authentication) {
        return null;
    }

    @Override
    public void deleteToken(long userId) {

    }
}
