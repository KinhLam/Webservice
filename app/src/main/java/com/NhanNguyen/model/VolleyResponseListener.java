package com.NhanNguyen.model;

public interface VolleyResponseListener {
    void onErro(String mesage);
    void onResponse(ModelCommom response);//Bị thay đổi ModelCommom thành String
}
