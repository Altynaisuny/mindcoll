package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.model.TokenModel;

public interface TokenManagerService {
    public TokenModel createToken(long userId);
    public boolean checkToken(TokenModel tokenModel);
    public TokenModel getToken(String authentication);
    public void deleteToken(long userId);
}
