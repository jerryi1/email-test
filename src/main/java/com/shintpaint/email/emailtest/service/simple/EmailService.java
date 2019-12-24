package com.shintpaint.email.emailtest.service.simple;


import com.shintpaint.email.emailtest.pojo.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * 发送邮件的服务层
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessageTemplate;

    public EmailMessage send() {
        //复制模板信息到sms
        SimpleMailMessage msg = new SimpleMailMessage(simpleMailMessageTemplate);

        msg.setTo("1448861367@qq.com");
        //这个字符串的内容可进行数据的拼接（目前测试的是文本内容的fasong）
        msg.setText("这是一封测试的邮箱信息");

        try {
            mailSender.send(msg);
        } catch (MailException ex) {
            throw ex;
        }
        return null;
    }
}
