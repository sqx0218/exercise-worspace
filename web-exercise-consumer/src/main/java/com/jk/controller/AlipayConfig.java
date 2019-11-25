package com.jk.controller;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101700706550";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCotylk18Onmok8q2rh3ocnFvOocrIOJ8ShjmprX10Nbui4RPZHOOUPBJCTfVBRwBcgDC6sVTmZKZGc9fIjfpbamFcfwNPM/O6TTKKhHhvDi4aAhx0+GGLrXTEaTo4QheuCPfyXkfcj7lbpd7jrvHVyf7iHnU3pV+W1A68XVDSjP2zaix1PN6R3RUelhrk+cBSbCHJVRQCOawfITsA9l1zuM4wmLoGQsFgqHYkG9kEQKUgZEUHu20BK/wjk/rPyKJQqDGQqPMJave4yZOun0SaAFdmns6CK+OdZnLNSljWm1lW42Qy00SERCQG5ScQZzVVOIesi3o+m78WTNBLLRFHtAgMBAAECggEAVtFJ37aX29tN24ZqDaiw65CH+ZprvZUBPhFG+dGs1IjKAGicQrIoTL4Ql5TYi/jI7ZjXO57vcL1PTPHSlClD/2B9FL3pP4a4TdwVo8sWhl157RGaHqX14R+ncN4ThLUlJ3Q2Utit0DOJTcJpygTEexL2JfLwcK7maWtn4h1WqNnWJ+KC0oF5SPWJk2AQmc1lVnK5Atv6JNoVd/KyEzLsnJ1aMZrMvRWQgw3/pOiq5ayXZh0SjdZhOjHxa4rzwZMTpvD/6Eo5tIr3bSMOC47QvBTpiF9D97ae6Oofvzki908d8fLlvgO5qP4crF52XUe5RF9e/pJUX4Rj9/IS71ATAQKBgQDxRMP4OeH5F8jRR3o1IaJ1W68uicd6gasyALWj72kGpqMOJh6AJ1NrtC98k3u7Ce4v4bdbyVrTDI7DDkseQYJxnLK33BVwkWll28L6150yM3dxxoELPNVZGsSs7FtAtjmmH5W85SniggJvMUfENAqJChdVWlE4YIIZrQ/InJrMMQKBgQCzBFQipYBVJpe9kHikloSSjnJhS/vcdbdoFslYBGs/uPWk55TcdZUOCefVeE3b/27jPZpEEi7YbMfQxg8jTenl/aHEKWWUx3FJoryTg8zdp/ELcQbD5D1QnB1XXsjNKNSjM7gIqTtFoMpZALY4aDhB5UznuLEl8yJAOahxZvb+fQKBgFANYfyNsBXHN4GA9uKEK3RHHIQTgRV7ysLHi30+ZZmoVrfOHBandb1pxsvN36L6s4Y9nWoeED2wj/nWV0RNtiteM8pfgtmb1d3PIg261tSeUQZ2N8DzyVJMWG+L6Oc6zzv4hOVtIA2g14/vSQGnxssbhwxx8DsFgoVkb7U/iPkxAoGAPDE0aQHlCLyVQPQW3KCPqweihfyajyI1rRYcVTAHL8HtNql3cDlJCRNjlG+DHnngux+3gzPp9HN/LD+sT16fSunhPqf8s+3rtaq2ZZNnixAxCHvUnoFb7ILRitMgCXu1I7r8Ik1k1KCf6RVIL+c7I00Kcs+zIOODnLzGWnsYibECgYBmKFDgj7rk6VeuIJ6xKb1IOHs4NHyYzlAuYGeAmP1bNedAX07AYRrWOzB76QgOvKtHcbnUARlZuqsfvY+MkmrxEX/asfgZBZuyCt87YLJmsT4uG1Ey5CbkjCvfQTsUolWcgDWXptnisIdHifgERctD/W580Vhbjz3nQeSeCLD86g==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkt1Vz5ZTOY2j+ktyt+uMiLPgonYIQCN06wr1nXCLQJi5Pj81/dU9FADeXRbBt9i6v01NVAzwJkDAH4duUgmDy4ioWk05KLXQfH5GswT2jr6xzpYWO3YOSoZAzDC6IEUuELzaS3Kc6eQPgD/0fNgFexnar/knlJCZ5B2G8HEbozw/iy3ZYM1kPQ7yit9SAkudr4OjdvJrkaV863vrIIozUhgQAOSMcIjfhujnvjYD+NKFGfCA9dWfNIm+QxNufacG7svaR2+bKkilpnH5BW+bawOYlU9x5b+E7xRLufcv4sCKEs57g/xKuupBOa5WU01mJLGANpE6qkuA/fU7gZK4cQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8087/toOrder";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8087/toOrder";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
