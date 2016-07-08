package com.zandroid;

import com.zandroid.volume.Volume;
import com.zandroid.volume.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
public class DockerJpaApplication {

	@Autowired
	VolumeRepository volumeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DockerJpaApplication.class, args);
	}

	public @PostConstruct
	void init() {

		volumeRepository.save(new Volume("Gallon","Open",2,"Milk"));

//		/**
//		 * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
//		 * with an authentication token containing the necessary privileges.
//		 */
//		SecurityUtils.runAs("system", "system", "ROLE_ADMIN");
//
//		itemRepository.save(new Item("Sting"));
//		itemRepository.save(new Item("the one ring"));
//
//		SecurityContextHolder.clearContext();
	}
}
