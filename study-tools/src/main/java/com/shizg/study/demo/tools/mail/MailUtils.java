package com.shizg.study.demo.tools.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailUtils {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    private static MailUtils mailUtils;


    @PostConstruct
    public void init(){
        mailUtils=this;
        mailUtils.javaMailSender=this.javaMailSender;
        mailUtils.templateEngine=this.templateEngine;
    }

     //1、文本邮件发送
    public  static void sendSimpleEmail() {
        // 构造Email消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shizg666@163.com");
        message.setTo("shizengguang@landleaf-tech.com");
        message.setSubject("邮件主题");
        message.setText("邮件内容");
        mailUtils.javaMailSender.send(message);
    }

    //2、附件邮件发送
    public static void mimeEmail() throws MessagingException {
        // MimeMessage 本身的 API 有些笨重，我们可以使用 MimeMessageHelper
        MimeMessage mimeMessage = mailUtils.javaMailSender.createMimeMessage();
        // 第二个参数是 true ，表明这个消息是 multipart类型的/
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("shizg666@163.com");
        mimeMessageHelper.setTo("shizengguang@landleaf-tech.com");
        mimeMessageHelper.setSubject("附件邮件主题");
        mimeMessageHelper.setText("附件邮件内容");
        //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
        mimeMessageHelper.addAttachment("a.png", new ClassPathResource("/images/a.png"));
        mailUtils.javaMailSender.send(mimeMessage);
    }
    // 3、富文本邮件发送
    public static void htmlEmail() throws MessagingException {
        MimeMessage mimeMessage = mailUtils.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("shizg666@163.com");
        mimeMessageHelper.setTo("shizengguang@landleaf-tech.com");
        mimeMessageHelper.setSubject("富文本邮件主题");
        String html = "<html><body><h4>Hello,SpringBoot</h4><img src='cid:boot' /></body></html>";
        mimeMessageHelper.setText(html, true);
        // 设置内嵌元素 cid，第一个参数表示内联图片的标识符，第二个参数标识资源引用
        mimeMessageHelper.addInline("boot", new ClassPathResource("/images/a.png"));
        mailUtils.javaMailSender.send(mimeMessage);
    }

    public static void contextLoads() throws MessagingException {
        MimeMessage mimeMessage = mailUtils.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("shizg666@163.com");
        mimeMessageHelper.setTo("shizengguang@landleaf-tech.com");
        mimeMessageHelper.setSubject("ThymeLeaf 模板邮件");
        // 利用 Thymeleaf 模板构建 html 文本
        Context ctx = new Context();
        ctx.setVariable("title", "Craig Walls");
        ctx.setVariable("content", "Hello Boot!");
        String emailText = mailUtils.templateEngine.process("hellow", ctx);
        mimeMessageHelper.setText(emailText, true);
        // 设置内嵌元素 cid，第一个参数表示内联图片的标识符，第二个参数标识资源引用
        mimeMessageHelper.addInline("boot", new ClassPathResource("/images/a.png"));
        mailUtils.javaMailSender.send(mimeMessage);
    }
}
