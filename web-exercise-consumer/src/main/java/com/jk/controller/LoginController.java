package com.jk.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import com.jk.service.LoginService;
import com.jk.utils.CommonConf;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Date;
@Controller
@RequestMapping("login")
public class LoginController {
    @Reference
    private LoginService loginService;

    //解决dubbo分布式框架，引起的service无法正常注入的问题
    @Bean(value = "loginService")
    public LoginService getUserService() {
        return loginService;
    }
    //登录
    @RequestMapping("login")
    @ResponseBody
    public String login(User user, HttpSession session){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        session.setAttribute("user",user);
        try{
            subject.login(upt);
            return "index";
        }catch (UnknownAccountException e){
            return "账号不存在";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }catch (AuthenticationException e){
            return "用户认证失败";
        }
    }
    @RequestMapping("quindex")
    public String quindex(){
        return "index";
    }

    //登录
    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }
    //手机登录
    @RequestMapping("tokjdl")
    public String tokjdl(){
        return "kjdl";

    }
    //
    // 跳注册页面
    @RequestMapping("register")
    public String register(){
        return "register";
    }
     //注册
    @RequestMapping("loginUser")
    @ResponseBody
    public String LonginUser(User user){
        System.out.println("====="+user.getUserName()+"----"+user.getPassword());
        String loginz=user.getUserName();
        String loginm=user.getPassword();
        user.setCreateTime(new Date());
        if(loginz==null||loginz==""){
            return "请输入名称";
        }
        if(loginm==null||loginm==""){
            return "请输入密码";
        }
        loginService.RegisterUser(loginz,loginm);
        return "注册成功,请重新登陆";
    }
    //获取短信验证码
    @RequestMapping("gainCodeMsg")
    @ResponseBody
    public String gainCodeMsg(String account){
        return loginService.gainCodeMsg(account);
    }
    @Autowired
    private StringRedisTemplate redisTemplate;


    @RequestMapping("sendSms")
    @ResponseBody
    public String quickLogin(String phone,String code,HttpSession session){
        return loginService.quickLogin(phone,code,session);
    }
    @RequestMapping("sendSms1")
    @ResponseBody
    public String sendSms1(String phone,String code,HttpSession session){
        String key = CommonConf.MEG_CODE+phone;
        Boolean flag = redisTemplate.hasKey(key);
        if(!flag){
            return "重新获取验证码！";
        }
        //3、判断验证码是否一致
        String redisCode = redisTemplate.opsForValue().get(key).toString();
        if(!redisCode.equals(code)){
            return "验证码错误！";
        }
        //4、登录：清除缓存验证码
        redisTemplate.delete(key);
        /*User user = loginMapper.getPhone(phone);
        if(user == null){
            return "手机号不存在";
        }*/
        User user = new User();
        session.setAttribute("user", user);
        return "登录成功！";
    }

}
