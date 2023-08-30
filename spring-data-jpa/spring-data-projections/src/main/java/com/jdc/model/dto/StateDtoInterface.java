package com.jdc.model.dto;

import com.jdc.model.entity.State.Type;

public interface StateDtoInterface {
	
	int getId();
	String getName();
	Type getType();
	String getRegion();
	String getCapital();
	int getPorpulation();
}
