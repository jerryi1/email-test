package com.shintpaint.email.emailtest.service.easy_mime_message;

import com.shintpaint.email.emailtest.pojo.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * 这里我们使用MimeMessageHelper来更加容易的创建MimeMessage
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Service
public class MimeMessageHelperService {
    @Autowired
    private JavaMailSender mailSender;

    public EmailMessage send() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            //这里面的from必须得设置，而且吆喝mailSender里面一致。不然的话，就出现501 mail from address must be same as authorization user错误
            helper.setFrom("1448861367@qq.com");
            helper.setTo("1448861367@qq.com");
            helper.setSubject("优秀表彰");
            helper.setText("thanks for you try.you are become a good boy");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
