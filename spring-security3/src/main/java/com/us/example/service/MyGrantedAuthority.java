package com.us.example.service;

import org.springframework.security.core.GrantedAuthority;

public class MyGrantedAuthority implements GrantedAuthority {

    private String url;
    private String method;

    MyGrantedAuthority(String url, String method) {
        this.url = url;
        this.method = method;
    }

    String getPermissionUrl() {
        return url;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.url = permissionUrl;
    }

    String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.url + ";" + this.method;
    }

    @Override
    public String toString() {
        return "MyGrantedAuthority{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}