package com.automation.api.client;

import com.automation.api.model.AuthRequestModel;

public interface AuthApi {

    String createToken(AuthRequestModel authRequestModel);
}
