package com.campaignManagement.campaignManagement.model;

import java.util.List;

public class MailRequest {
	String html;
	String emailId;
	String subject;
	List<String> filter;
	public String getHtml() {
		return html;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	@Override
	public String toString() {
		return "MailRequest [html=" + html + ", emailId=" + emailId + ", subject=" + subject + ", filter=" + filter
				+ "]";
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<String> getFilter() {
		return filter;
	}
	public void setFilter(List<String> filter) {
		this.filter = filter;
	}
	
}
