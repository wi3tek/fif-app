package pl.engineerproject.pw.fifapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import pl.engineerproject.pw.fifapp.service.InitService;
import pl.engineerproject.pw.fifapp.service.InitServiceImpl;

@EnableEncryptableProperties
@SpringBootApplication
public class FifAppApplication {

	@Autowired
	private InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(FifAppApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void initData() throws Exception {
//		initService.initUser();
//	}
}
