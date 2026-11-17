package com.productinfo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productinfo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
    

}
