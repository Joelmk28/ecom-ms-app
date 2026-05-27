package levraijmk.billingservice.web;

import levraijmk.billingservice.entities.Bill;
import levraijmk.billingservice.feign.CustomerServiceRestClient;
import levraijmk.billingservice.feign.InventoryServiceRestClient;
import levraijmk.billingservice.repository.BillRepository;
import levraijmk.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
private BillRepository billRepository;
@Autowired
private ProductItemRepository productItemRepository;
@Autowired
private CustomerServiceRestClient customerServiceRestClient;
@Autowired
private InventoryServiceRestClient inventoryServiceRestClient;


@GetMapping("/bills/{id}")
public Bill getBillById(@PathVariable Long id){
    Bill bill = billRepository.findById(id).orElse(null);
    if(bill == null){
        return null;
    }
    bill.setCustomer(customerServiceRestClient.findCustomerById(bill.getCustomerId()));
    return bill;
}

}
