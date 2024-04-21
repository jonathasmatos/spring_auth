package authentication.authentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import authentication.authentication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
