package org.example.xcx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class XcxApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void registerUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 	String encodedPassword = passwordEncoder.encode("YT123456789");
			System.out.println(encodedPassword);

		boolean isPasswordMatch = passwordEncoder.matches("YT123456789", "$2a$10$zsEuwFcsoZtjxV.V.4vvGuDH40fFKei6jtxMqaIFZyOaNv2WY9iIa");
		System.out.println(isPasswordMatch);
	}
//	@Test
//	void getUser() {
//		System.out.println("hiihihihi");
//	}
}

