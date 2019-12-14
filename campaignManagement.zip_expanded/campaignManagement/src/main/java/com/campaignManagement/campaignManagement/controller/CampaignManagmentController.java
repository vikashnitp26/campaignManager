package com.campaignManagement.campaignManagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.campaignManagement.campaignManagement.Service.CampaignManagementService;
import com.campaignManagement.campaignManagement.model.MailRequest;
import com.campaignManagement.campaignManagement.model.User;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;


@RestController
public class CampaignManagmentController {
	CampaignManagementService campaignManagementService;
	@PostConstruct
	void init(){
		campaignManagementService = new CampaignManagementService();
	}
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public @ResponseBody String sendMail(@RequestBody MailRequest mailRequest){
		System.out.print(mailRequest.toString());
		Email from = new Email(mailRequest.getEmailId());
		  String subject = mailRequest.getSubject();
		  List<User> userList = campaignManagementService.getEmailList();
		  //Email to = new Email("checkvk26@gmail.com"); 
		  
		  List<Mail> mailList = new ArrayList<>();
		  for(User user: userList) {
			  Email to = new Email(user.getEmailId());
			  Content content = new Content("text/html", "Hi "+user.getName()+",\n"+mailRequest.getHtml());
			  mailList.add(new Mail(from, subject, to, content));
		  }
		  
		  SendGrid sg = new SendGrid("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");
		  Request request = new Request(); 
		  try { 
			  for(Mail mail:mailList) {
				  request.setMethod(Method.POST);
				  request.setEndpoint("mail/send"); 
				  request.setBody(mail.build()); 
				  Response response = sg.api(request);
				  System.out.println(response.getStatusCode());
				  System.out.println(response.getBody());
				  System.out.println(response.getHeaders()); 
			  } 
		  } catch (IOException ex) {
			   ex.printStackTrace();; 
		  }
		return "Ok";
	}
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public @ResponseBody String sendMailGet( MailRequest mailRequest){
		System.out.print(mailRequest.toString());
		Email from = new Email(mailRequest.getEmailId());
		  String subject = mailRequest.getSubject();
		  List<User> userList = campaignManagementService.getEmailList();
		  //Email to = new Email("checkvk26@gmail.com"); 
		  
		  List<Mail> mailList = new ArrayList<>();
		  for(User user: userList) {
			  Email to = new Email(user.getEmailId());
			  Content content = new Content("text/html", "Hi "+user.getName()+",\n"+mailRequest.getHtml());
			  mailList.add(new Mail(from, subject, to, content));
		  }
		  
		  SendGrid sg = new SendGrid("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");
		  Request request = new Request(); 
		  try { 
			  for(Mail mail:mailList) {
				  request.setMethod(Method.POST);
				  request.setEndpoint("mail/send"); 
				  request.setBody(mail.build()); 
				  Response response = sg.api(request);
				  System.out.println(response.getStatusCode());
				  System.out.println(response.getBody());
				  System.out.println(response.getHeaders()); 
			  } 
		  } catch (IOException ex) {
			   ex.printStackTrace();; 
		  }
		return "Ok";
	}
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demo(){
		
		return "vikash";
	}
	

}
