package com.testing.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.testing.entity.Document;
import com.testing.service.DocumentService;

@RestController
public class DocumentApi {
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/documents/{code}")
	@PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
	public Document getDetails(@PathVariable String code) {
	return documentService.getDocument(code);
	}
}
