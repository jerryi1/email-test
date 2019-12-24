package com.shintpaint.email.emailtest.service.attachment;

import com.shintpaint.email.emailtest.pojo.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * @author lihuaqing
 * 附件的服务层
 */
@Service
public class AttachmentService {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送携带附件
     */
    public EmailMessage send() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(new InternetAddress("1448861367@qq.com"));
            mimeMessageHelper.setFrom("1448861367@qq.com");
            mimeMessageHelper.setText("这里是测试的数据");
            //这个附件为什么没办法进行预览(要对这个文件的名称进行后缀的声明。不然出来的数据是不正确的)
            mimeMessageHelper.addAttachment("aaa.pdf",new ClassPathResource("pdf/daily_report_20191124.pdf").getFile());
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
