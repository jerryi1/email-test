package com.shintpaint.email.emailtest.service.simple;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


/**
 * 这里配置简单邮箱的模板
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Component
public class MySimpleMailMessage extends SimpleMailMessage {
    public MySimpleMailMessage() {
        super();
        this.setFrom("1448861367@qq.com");
        this.setSubject("主题1");
    }
}
