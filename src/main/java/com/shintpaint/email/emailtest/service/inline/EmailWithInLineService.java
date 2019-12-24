package com.shintpaint.email.emailtest.service.inline;

import com.shintpaint.email.emailtest.pojo.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送带有附件的邮件系统---内联资源。就是我们不想作为附件来进行显示
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@Service
public class EmailWithInLineService {

    //配置服务器，这个邮箱邮箱配置还是需要的
    @Autowired
    private JavaMailSender mailSender;

    public EmailMessage send() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            //这里面设置multipart = true 就可以了
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            //这里面的from必须得设置，而且吆喝mailSender里面一致。不然的话，就出现501 mail from address must be same as authorization user错误
            helper.setFrom("1448861367@qq.com");
            helper.setTo("1448861367@qq.com");
            helper.setSubject("这是查看内联样式的数据");
            helper.setText("<html><body>图片是：<img src='cid:identifier1234'>pdf是：<embed src='cid:pdf' /></body></html>", true);
            //添加内联资源(pdf在附件里面能够预览，所以暂时我们先不考虑)
            ClassPathResource resource = new ClassPathResource("pic/basePic.png");
            helper.addInline("identifier1234", resource);
            mailSender.send(mimeMessage);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
