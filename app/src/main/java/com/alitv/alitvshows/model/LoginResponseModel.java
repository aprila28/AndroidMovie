package com.alitv.alitvshows.model;

public class LoginResponseModel {
    /* response
    {
        "status": "success",
        "userModel": {
            "id": 1,
            "name": "ali",
            "email": "aprilasatya@gmail.com",
            "address": "tanggerang"
            }
    }
     */
    private String status;
    private UserModel userModel;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
