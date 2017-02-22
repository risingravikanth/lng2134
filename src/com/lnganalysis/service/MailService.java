package com.lnganalysis.service;

public interface MailService {
	public String sendMailToAdmin(String email);
	public String sendMailToUser(String email,String password);
}
