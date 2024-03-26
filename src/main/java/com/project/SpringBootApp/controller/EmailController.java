package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.EmailDetails;
import com.project.SpringBootApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController
{
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails)
    {
        String status=emailService.sendSimpleEmail(emailDetails);
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails)
    {
        String status=emailService.sendSimpleEmailWithAttachment(emailDetails);
        return  status;
    }
}
