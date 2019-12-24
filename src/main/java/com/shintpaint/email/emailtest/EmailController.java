package com.shintpaint.email.emailtest;

import com.shintpaint.email.emailtest.service.advance.AdvanceEmailService;
import com.shintpaint.email.emailtest.service.attachment.AttachmentService;
import com.shintpaint.email.emailtest.service.inline.EmailWithInLineService;
import com.shintpaint.email.emailtest.service.easy_mime_message.MimeMessageHelperService;
import com.shintpaint.email.emailtest.service.simple.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件发送的controller
 *
 * @author lihuaqing
 * @date 2019-12-23
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private AdvanceEmailService advanceEmailService;

    @Autowired
    private MimeMessageHelperService mimeMessageHelperService;

    @Autowired
    private EmailWithInLineService emailWithInLineService;

    @Autowired
    private AttachmentService attachmentService;

    //发送邮件1
    @GetMapping("/send")
    public ResponseEntity<?> send() {
        //我们先进行测试一下
        //但是我们发现这个一开始调用的时候，是没有from和subject这个概念的。smsTemplate
        return ResponseEntity.ok(emailService.send());
    }

    //发送邮件2 采用mimeMessage简化流程
    @GetMapping("/send/advance")
    public ResponseEntity<?> sendAdvance() {
        //我们先进行测试一下
        //但是我们发现这个一开始调用的时候，是没有from和subject这个概念的。smsTemplate
        return ResponseEntity.ok(advanceEmailService.send());
    }

    //发送邮件3 采用MimeMessageHelper文件的格式，简化创建mimeMessage流程。
    // 501 mail from address must be same as authorization user
    @GetMapping("/send/mime")
    public ResponseEntity<?> sendAdvanceByMime() {
        //我们先进行测试一下
        //但是我们发现这个一开始调用的时候，是没有from和subject这个概念的。smsTemplate
        return ResponseEntity.ok(mimeMessageHelperService.send());
    }

    //发送邮件4 发送邮件采用内联图片
    @GetMapping("/send/inline")
    public ResponseEntity<?> sendAdvanceWithInlineResource() {
        return ResponseEntity.ok(emailWithInLineService.send());
    }

    //发送邮件5 待附件
    @GetMapping("/send/attach")
    public ResponseEntity<?> sendAttachment() {
        return ResponseEntity.ok(attachmentService.send());
    }


}
