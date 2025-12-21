package levraijmk.customerservice.repositories;

import levraijmk.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource //annotation de springDataRest pour generer toutes les methodes classiques sur une entitée(CRUD,SEARCH)
// cela nous epargne d'avoir un RestController
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
