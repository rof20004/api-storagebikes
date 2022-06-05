package br.com.ffseguros.apistoragebikes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ApiStoragebikesApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> ApiStoragebikesApplication.main(new String[] {}));
	}

}
