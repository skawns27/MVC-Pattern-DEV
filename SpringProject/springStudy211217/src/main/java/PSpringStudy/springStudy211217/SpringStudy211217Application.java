package PSpringStudy.springStudy211217;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStudy211217Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudy211217Application.class, args);
//		모든 Spring 탐색은 SpringContainer => .. => 정작파일 순으로 탐색
	}

}
