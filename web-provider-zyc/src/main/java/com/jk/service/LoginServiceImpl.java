package com.jk.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.LoginMapper;
import com.jk.model.User;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.CommonConf;
import com.jk.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<String> queryPowerByUserid(Integer id) {
        return loginMapper.queryPowerByUserid(id);
    }


    @Override
    public User findUserByName(String userName) {
        return loginMapper.findUserByName(userName);
    }

    @Override
    public void RegisterUser(String loginz, String loginm) {
        loginMapper.RegisterUser(loginz,loginm);
    }

    @Override
    public String gainCodeMsg(String phone) {
        User user = loginMapper.getPhone(phone);
        if(user == null){
            return "手机号不存在";
        }
        long round = Math.round((Math.random()*899999+100000));
        System.out.println("随机数："+round);
        CommonConf commonConf = new CommonConf();
        //TODO b、调用短信接口发送短信
        String url="https://api.netease.im/sms/sendcode.action";
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", phone);//手机号
        params.put("templateid",  14829539);//模板编号(如不指定则使用配置的默认模版)
        params.put("authCode", round);//客户自定义验证码，长度为4～10个数字  随机数
        HashMap<String, Object> headerParam = new HashMap<String, Object>();
        headerParam.put("AppKey", commonConf.APP_KEY);//开发者平台分配的appkey
        String nonce = UUID.randomUUID().toString();
        headerParam.put("Nonce", nonce);//随机数（最大长度128个字符）
        String curTime = String.valueOf(System.currentTimeMillis()/1000);
        headerParam.put("CurTime", curTime);//当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        //SHA1(AppSecret + Nonce + CurTime)，三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
        String appSecret = commonConf.APP_SECRET;
        headerParam.put("CheckSum", CheckSumBuilder.getCheckSum(appSecret, nonce, curTime));
        String str = HttpClientUtil.post3(url, params, headerParam);
        JSONObject parseObject = JSON.parseObject(str);
        int code = parseObject.getIntValue("code");
        if(code!=200){//发送失败
            return "短信发送失败！";
        }
        String key = commonConf.MEG_CODE+phone;
       redisTemplate.opsForValue().set(key, String.valueOf(round),5,TimeUnit.MINUTES);
        return "短信发送成功！";
    }

    @Override
    public String quickLogin(String phone, String code, HttpSession session) {
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
        User user = loginMapper.getPhone(phone);
        if(user == null){
            return "手机号不存在";
        }

        session.setAttribute("user", user);
        return "登录成功！";
    }


}
