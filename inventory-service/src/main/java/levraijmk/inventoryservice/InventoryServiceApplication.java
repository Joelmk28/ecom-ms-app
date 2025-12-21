package levraijmk.inventoryservice;

import levraijmk.inventoryservice.entities.Product;
import levraijmk.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args ->{
            productRepository.save(new Product(null,"Pencil", 1.5, 10));
            productRepository.save(new Product(null,"Eraser", 2.5, 5));
            productRepository.save(new Product(null,"Notebook", 5.5, 15));
            productRepository.save(new Product(null,"Pen", 3.5, 20));

        };

    }

}
