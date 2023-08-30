package com.jdc.model.dto;

import org.springframework.beans.factory.annotation.Value;

public interface StateValueDto {
	
	int getId();
	@Value("#{target.name + ' ' + target.type}")
	String getDisplayName();
}
