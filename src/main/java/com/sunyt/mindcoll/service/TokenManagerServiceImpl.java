package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.model.TokenModel;

import java.util.UUID;

public class TokenManagerServiceImpl implements TokenManagerService {
    @Override
    public TokenModel createToken(long userId) {
        String token = UUID.randomUUID().toString().substring(0,16);
        String id = String.valueOf(userId);
        return  null;
    }

    @Override
    public boolean checkToken(TokenModel tokenModel) {
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
