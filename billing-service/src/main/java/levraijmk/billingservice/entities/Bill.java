package levraijmk.billingservice.entities;

import jakarta.persistence.*;
import levraijmk.billingservice.entities.model.Customer;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
@Transient
    private Customer customer;
}
