package levraijmk.billingservice.feign;

import levraijmk.billingservice.entities.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);
}
