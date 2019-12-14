package com.campaignManagement.campaignManagement;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampaignManagementApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CampaignManagementApplication.class, args);
		SpringApplication app = new SpringApplication(CampaignManagementApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8084"));
        app.run(args);
	}

}
