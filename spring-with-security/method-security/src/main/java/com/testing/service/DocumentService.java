package com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.entity.Document;
import com.testing.repo.DocumentRepo;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepo documentRepo;
	
	public Document getDocument(String code) {
		return documentRepo.findDocument(code);
	}
}
