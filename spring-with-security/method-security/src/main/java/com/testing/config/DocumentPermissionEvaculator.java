package com.testing.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.testing.entity.Document;

@Component
public class DocumentPermissionEvaculator implements PermissionEvaluator{

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		
		Document document = (Document) targetDomainObject;
		String p = (String) permission;
		
		var admin = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(p));
		
		return admin || document.getOwner().equals(authentication.getName());
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
