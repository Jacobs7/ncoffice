package com.dape.bc.web.controller;

public class AlipayConfig {

    // 应用ID，收款帐号既是appId对应支付宝帐号
    public static String app_id = "2016092700605584";
    // 商户私钥，PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJAqk/OwekG0xyVaIfG0Arj4+lxOxreNv/+4SJ8qeHGB7fLaeO+YoGpEGOjf8rlu6GkeaMkVr1Vqc77EHWqH7GU6dH8X5azUzM6JDbqyYqg/f6oaGzJqqGWMr4U1Cc5j6uJJH+5oQLmTVDNM1cy0GqOJwnBXuv1lqDpDQsIKL4G/aE90KoEPoIYEfOWsAXz+jC1A/lkevVaokFQBi0VP0yw8XfG7OR2opFkMdsZFnKukKrNpdGzZaFNbokLA49kYxLMn0LSp/keCRDT2h9zFjqqcAZAvOeEz2/E2mRyF7TqS7B+ZCCMo+dWjn57/Trd3N2V7S8fsszRXWm8XUBr3fzAgMBAAECggEATJP2MOc3cBvp8IW4ZZZ/mVlWOpsEYVVd8YeNHuVHiZSLvMXxv1HuOaQZGCp5ks17aC+oIq0jn7jdI/r7GZV3tjYPa4Co1Oumn2jlfkH8xQqZ0bYBgPZ9nTWHzKAUkH2ITyEVkNkauLjbMkMS/WiFvTSC4rSH21H9qVJf7sIXFIEFhXVmz+rT+8SigJZ3imjTgTE3Q+03pkv7aG+RRRbO4gjCdSoOI4IvXW5r7QTrBTfwQUAyoKoPKwXxRn+2AmLhzEpHopNomMZN3KuOVz3GyTe9zC7GlxJDRyCzkUVFTqmHMrQrvvT8px+J5ddTGgLFFTN/hgGYsCMiT1GrKr+RoQKBgQDsgkdcSVhRNIfl97bTHrWsdUk8qZjc20LhFAVZ8WUFYJ+7kS0AR2fYtN4hXvoEVB4IEduzralJViciAx5LN0prXt7/MmNireDl6ZY3snhcQnj/AWX/UqI65tKRCgnXEjCZ3AjmAcBVlQIhCWruUJhHx2qFUQIwcMu12EPLKIbXWQKBgQCUTTkofScx9S1ys2yIEAJcxdQe2/F8UD7f+cNSjmGJTtZrS62ubf2nJ5LeN+bDJQtQC97WrUdbyGlgdASaWVcwBlaC4yCqOS8wk2KXm6ZNCQmjR0z7ok5tlQHUcvCQ7O+BD/YSfMBAoRcUlTWVnVUtDaYTd9XKdAGqGNDXe3YsKwKBgA6iNPYh16QWov34qMhBUy5bh2+IctvfeTDiAz7Ab+a4RsndPrKQuH0xG7lm3gNcjQskx7pDWYEfIoa5OKugvSsNkLCrlnipl4vCOzgxA795oXDtzjjRDRal54tv2pIDHxy1/5rzqsng0WPn6ETcmb9/ODkNfRwwLnqO6grs9ALpAoGANtafbjNpTPXmimWCmoWg+gFFQOv/zgI2XcgTy/FOa+G1NBPV84xEoYzmqDlvoXWPS1g4XJXSr0Pag4ojMZgbv2x4jQnDyG5A3uuBJ6Ksyguvfqsc8mfALJFPDeo6vrx+i/EFAy0SQlPPHxNVry9wkapcYRKNAcIH44gtoaDLv+UCgYBokLxVGE+R7L/xCu06zHhX4K3lPZHA+BxijsQ9uV2/89byY8hZWmRLks3b94HCgk02C+8GZcq5e2Qb4XDUnEzJbs3N6hS/FzVIbSxBWd+76Vi0FnMwwI9Rnu/62DvY9eesuZi29SYAl8JlfyuNa3s5eTfpoLVi02ge8a6ey8eWlw==";
    // 支付宝公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm，对应APPID下的支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiQKpPzsHpBtMclWiHxtAK4+PpcTsa3jb//uEifKnhxge3y2njvmKBqRBjo3/K5buhpHmjJFa9VanO+xB1qh+xlOnR/F+Ws1MzOiQ26smKoP3+qGhsyaqhljK+FNQnOY+riSR/uaEC5k1QzTNXMtBqjicJwV7r9Zag6Q0LCCi+Bv2hPdCqBD6CGBHzlrAF8/owtQP5ZHr1WqJBUAYtFT9MsPF3xuzkdqKRZDHbGRZyrpCqzaXRs2WhTW6JCwOPZGMSzJ9C0qf5HgkQ09ofcxY6qnAGQLznhM9vxNpkche06kuwfmQgjKPnVo5+e/063dzdle0vH7LM0V1pvF1Aa938wIDAQAB";
    // 服务器异步通知页面路径，需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以访问
    public static String notify_url = "";
    // 页面跳转同步通知页面路径，需http://格式的完整路径... 同notify_url
    public static String return_url = "";
    // 签名格式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关，此地址为沙箱环境
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // log path
    public static String log_path = "C:\\";

}
