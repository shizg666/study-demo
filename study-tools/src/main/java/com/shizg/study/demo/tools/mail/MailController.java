package com.shizg.study.demo.tools.mail;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail/")
public class MailController {


    @ApiOperation(value = "邮件测试", notes = "", consumes = "application/json")
    @GetMapping(value = "/smile-send")
    public void test() throws MessagingException {
        MailUtils.sendSimpleEmail();
        MailUtils.mimeEmail();
        MailUtils.htmlEmail();
        MailUtils.contextLoads();
    }
}
