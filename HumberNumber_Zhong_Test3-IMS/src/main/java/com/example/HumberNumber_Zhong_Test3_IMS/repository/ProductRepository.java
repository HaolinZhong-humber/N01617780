package com.example.HumberNumber_Zhong_Test3_IMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.humbernumberzhong.test3ims.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}


