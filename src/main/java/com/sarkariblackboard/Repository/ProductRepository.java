package com.sarkariblackboard.Repository;

import com.sarkariblackboard.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
