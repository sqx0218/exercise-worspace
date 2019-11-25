package com.jk.service;

import com.jk.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {

    List<String> queryPowerByUserid(Integer userId);

    User findUserByName(String username);

    void RegisterUser(String loginz, String loginm);

    String gainCodeMsg(String phone);

    String quickLogin(String phone, String code, HttpSession session);
}
