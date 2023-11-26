package com.example.www_lab6;

import com.example.www_lab6.backend.entities.Post;
import com.example.www_lab6.backend.entities.User;
import com.example.www_lab6.backend.repositories.PostRepository;
import com.example.www_lab6.backend.repositories.UserRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class WwwLab6Application {

	public static void main(String[] args) {
		SpringApplication.run(WwwLab6Application.class, args);
	}
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Faker faker = new Faker();
			Device device = faker.device();

			for (int i = 0; i < 200; i++) {
				User user = new User();
				userRepository.save(user);
				Post post= new Post(user, null, device.modelName(), device.manufacturer(), "Sumary"+i,true, LocalDate.now(),LocalDate.now(),LocalDate.now(),"Content"+ i);
				postRepository.save(post);
			}
		};
	}

}
