package com.sathya.Api_GateWay.jwtTestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.Api_GateWay.jwtUtil.JwtUtil;
import com.sathya.Api_GateWay.loginDetails.LoginDetails;

@RestController
public class JwtTestController {
 
	@PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails) {
        // Validate credentials (for simplicity, using hardcoded values)
        if (loginDetails.getUsername().equals("nikhil") && loginDetails.getPassword().equals("Nikhil@143"))
        {	// Generate token
            String token = JwtUtil.generateToken(loginDetails.getUsername());
            return ResponseEntity.status(HttpStatus.OK)
            					 .header("token", "Token generated successfully...")
            					 .body(token);
        }
        else {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					 .header("token", "username & password fail...")
					 .body("username & password fail...");
        }
    }
	
	@GetMapping("/tokengreet")
	public String greet()
	{	return "This is the Greeting from after token validation";
	}	

}
