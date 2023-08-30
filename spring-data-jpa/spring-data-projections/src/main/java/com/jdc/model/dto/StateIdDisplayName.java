package com.jdc.model.dto;

import com.jdc.model.entity.State.Type;

public interface StateIdDisplayName {
	
	int getId();
	String getName();
	Type getType();
	
	//open projecting using interface default method
	default String getDisplayName() {
		return "%s %s".formatted(getName(), getType());
	}
}
