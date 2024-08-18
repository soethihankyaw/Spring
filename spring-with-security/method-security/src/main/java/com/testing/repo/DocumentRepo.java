package com.testing.repo;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.testing.entity.Document;

@Repository
public class DocumentRepo {
	
	private Map<String, Document> documents =
			Map.of("abc123", new Document("soethi"),
			"qwe123", new Document("soethi"),
			"asd555", new Document("hankyaw"));
	
	public Document findDocument(String code) {
		return documents.get(code);
	}
}
