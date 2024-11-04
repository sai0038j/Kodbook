package com.kodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailServices {
	
	@Autowired
	JavaMailSender mailSender;
	public void sendMail(String userName,String email)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Registered Successfully");
		message.setText("Hi " + userName + ",\n\nYour registration has been completed with email:"+email+"\n in Kodbook.\nThank you");
		mailSender.send(message);
		
		
	}

}
