package com.shintpaint.email.emailtest.service.advance;

import com.shintpaint.email.emailtest.pojo.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

/**
 * 更高级别的邮件发送
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Service
public class AdvanceEmailService {
    //配置服务器，这个邮箱邮箱配置还是需要的
    @Autowired
    private JavaMailSender mailSender;

    public EmailMessage send() {
        //这个的有点感觉是不需要配置很多的中间服务器的配置文件，挺好的。感觉这个都无视中间服务器了
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("1448861367@qq.com"));
            mimeMessage.setFrom(new InternetAddress("1448861367@qq.com"));
            mimeMessage.setText("DEAR CHILD LHQ SEND EMAIL IS SUCCESS");
        };
        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            throw ex;
        }
        return null;
    }
}
