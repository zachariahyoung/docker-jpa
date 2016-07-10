package com.zandroid;

import com.zandroid.appointment.Appointment;
import com.zandroid.appointment.AppointmentRepository;
import com.zandroid.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

@SpringBootApplication
//@EnableDiscoveryClient
public class DockerJpaApplication {

    @Autowired
    AppointmentRepository appointmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DockerJpaApplication.class, args);
    }

    public
    @PostConstruct
    void init() {

        Product product = new Product();
        product.setDescription("Truck");
        product.setModel("Chevy");


        Appointment appointment = new Appointment();
        appointment.setTrackNumber("test");
        appointment.setProducts(asList(product));

//        appointmentRepository.save(appointment);

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
