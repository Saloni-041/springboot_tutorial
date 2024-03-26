package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails emailDetails);
    String sendSimpleEmailWithAttachment(EmailDetails emailDetails);

}
