package levraijmk.customerservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import levraijmk.customerservice.entities.Customer;
import levraijmk.customerservice.repositories.CustomerRepository;
import lombok.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
@Bean
CommandLineRunner start(CustomerRepository customerRepository)
    {
      return args ->{
customerRepository.save(Customer.builder().name("Joel").email("joel@gmail.com").build());
customerRepository.save(Customer.builder().name("Noemie").email("noemie@gmail.com").build());
customerRepository.save(Customer.builder().name("Sarah").email("sarah@gmail.com").build());
      };
    }
}
