package levraijmk.billingservice;

import levraijmk.billingservice.entities.Bill;
import levraijmk.billingservice.entities.ProductItem;
import levraijmk.billingservice.repository.BillRepository;
import levraijmk.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository){

        return args -> {
            List<Long> customersIds = List.of(1L,2L,3L);
            List<Long> products = List.of(1L,2L,3L);
            customersIds.forEach(
                    clientId->{
                        Bill bill = Bill.builder()
                                .billingDate(new Date())
                                .customerId(clientId)
                                .build();

                        billRepository.save(bill);

                        products.forEach(productId->{
                            ProductItem productItem = ProductItem.builder()
                                    .productId(productId)
                                    .bill(bill)
                                    .quantity(1+new Random().nextInt(15))
                                    .price(1000*Math.random()*600)
                                    .build();
                            productItemRepository.save(productItem);
                        });
                    }
            );
        };
    }

}
