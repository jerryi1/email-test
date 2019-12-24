package com.shintpaint.email.emailtest.service.simple;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Component
public class MyMailSender extends JavaMailSenderImpl {
    public MyMailSender() {
        super();
        this.setHost("smtp.qq.com");
        this.setPassword("irafipapgjdfgebh");
        this.setDefaultEncoding("UTF-8");
        this.setProtocol("smtp");
        this.setUsername("1448861367@qq.com");
    }
}
