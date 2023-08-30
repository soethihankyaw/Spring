package com.jdc.model.record;

import com.jdc.model.entity.State.Type;

public record StateRecord(
		int id,
		String name,
		Type type,
		String region
		) {
		
	public String displayName() {
		return "%s %s".formatted(name, type);
	}
} 
