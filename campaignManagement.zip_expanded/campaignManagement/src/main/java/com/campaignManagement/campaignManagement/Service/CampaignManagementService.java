package com.campaignManagement.campaignManagement.Service;

import java.util.List;

import com.campaignManagement.campaignManagement.DAO.EmailDAO;
import com.campaignManagement.campaignManagement.model.User;

public class CampaignManagementService {
	EmailDAO emailDAO = new EmailDAO();
	public List<User> getEmailList(){
		return emailDAO.getEmailList();
	}
}
