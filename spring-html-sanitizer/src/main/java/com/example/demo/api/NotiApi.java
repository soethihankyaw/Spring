package com.example.demo.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Notification;
import com.example.demo.input.NotificationForm;
import com.example.demo.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NotiApi {
	
	private final NotificationService service;
	
	@PostMapping
	public String create(@RequestBody NotificationForm form) {
		return service.create(form);
	}
	
	@PostMapping("santizer")
	public String createSantize(@RequestBody NotificationForm form) {
		return service.santizeCreate(form);
	}
	
	@GetMapping
	public List<Notification> create() {
		return service.getAll();
	}
}
