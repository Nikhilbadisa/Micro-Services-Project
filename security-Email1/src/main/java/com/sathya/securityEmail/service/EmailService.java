package com.sathya.securityEmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	 private JavaMailSender mailSender;
	public String sendEmail(String to, String subject, String message) {

		try {
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			mailSender.send(mailMessage);
			return "Email sent Successfully to "+ to;
		}
		catch (Exception e) {
			return "Error while sending email: "+e.getMessage();
		}
	}

}
