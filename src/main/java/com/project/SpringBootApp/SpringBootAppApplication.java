package com.project.SpringBootApp;

import com.project.SpringBootApp.model.Residence;
import com.project.SpringBootApp.repository.ResidenceRepository;
import com.project.SpringBootApp.repository.StudentRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.project.SpringBootApp.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
//@EnableWebSecurity
@EnableEncryptableProperties          //to make the application understand the encryptable properties across the entire Spring Environment.
public class SpringBootAppApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ResidenceRepository residenceRepository;

	public static void main(String[] args) {
		// Calling run() method to execute SpringBootApplication by
		// invoking run() inside main() method
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	public void run(String[] args) throws Exception
	{
		Student student=new Student(1,"Shital");
		studentRepository.save(student);
		Residence residence=new Residence(4,"Hisar",student);
		residenceRepository.save(residence);
		System.out.println("Hello world");   //for showing output in terminal here we are using command line runner interface
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}

}
//By using the @Bean annotation, you make the ModelMapper instance available for dependency injection
// throughout your application.This allows for centralizing configuration and creating reusable, managed instances.
// In this case, any part of your application can inject ModelMapper by autowiring it.
// By creating a bean for ModelMapper, you can easily manage its configuration centrally and inject it into
// other Spring components where needed.