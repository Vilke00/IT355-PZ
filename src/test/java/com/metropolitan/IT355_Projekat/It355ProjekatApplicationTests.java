package com.metropolitan.IT355_Projekat;

import com.metropolitan.IT355_Projekat.web.UserRegistrationController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class It355ProjekatApplicationTests {

	//Provera da li context pravi controller
	@Autowired
	private UserRegistrationController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
