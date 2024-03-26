package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService
{
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public String sendSimpleEmail(EmailDetails emailDetails) {
        try{
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setText(emailDetails.getMsgBody());
            javaMailSender.send(simpleMailMessage);
            return "Mail Sent Sucessfully!";
        }
        catch (Exception e)
        {
            System.out.println(e);
          return "Exception occurred while sending mail!";
        }
//        return null;
    }

    @Override
    public String sendSimpleEmailWithAttachment(EmailDetails emailDetails)
    {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try{
            mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            FileSystemResource fileSystemResource=new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Sucessfully!";
        }
        catch (Exception e) {
            System.out.println(e);
            return "Exception occurred while sending mail!";
        }
//        return null;
    }
}
//JavaMailSender interface of JavaMail API is used here to send simple text email.
//To send a more sophisticated email with an attachment, MimeMessage can be used.
// MimeMessageHelper works as a helper class for MimeMessage to add the attachment and
// other details required to send the mail.