package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.NotiRepo;
import com.example.demo.entity.Notification;
import com.example.demo.input.NotificationForm;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class NotificationService {
	
	private final NotiRepo notiRepo;
	private final HtmlSanitizer sanitizer;
	
	public String create(NotificationForm form) {
		
		var entity = new Notification();
		entity.setName(form.name());
		entity.setLinkUrl(form.link());
		notiRepo.save(entity);
		return "Successfully created";
	}
	
	public String santizeCreate(NotificationForm form) {
		
		var entity = new Notification();
		entity.setName(form.name());
		entity.setLinkUrl(sanitizer.sanitizer(form.link()));
		notiRepo.save(entity);
		return "Successfully created";
	}
	
	public List<Notification> getAll() {
		var noti = notiRepo.findAll();
		return noti;
	}
}
