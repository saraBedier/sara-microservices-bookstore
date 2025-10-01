package com.sara.bookstore.Notification.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifacationController {

	@RestController
	@RequestMapping("/notifications")
	public class NotificationController {

	    @PostMapping("/send")
	    public String sendNotification(@RequestBody String message) {
	        System.out.println("📢 Notification received: " + message);
	        return "Notification sent: " + message;
	    }
	}

}
