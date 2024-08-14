package com.testing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkApi {
	
	@GetMapping("/a")
	public String getEndPointA() {
		return "Work A!";
	}
	
	@PostMapping("/a")
	public String postEndPointA() {
		return "Work B!";
	}
	
	@GetMapping("/a/b")
	public String getEndPointB() {
		return "Work C!";
	}
	
	@GetMapping("/a/b/c")
	public String postEndPointC() {
		return "Work D!";
	}
	
	@GetMapping("/email/{email}")
	public String video(@PathVariable String email) {
		
		return "Video allowed for " + email;
	}
}
