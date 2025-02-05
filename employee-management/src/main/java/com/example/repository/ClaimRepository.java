package com.example.repository;

import com.example.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByEmployeeId(Long employeeId);
    void deleteByEmployeeId(Long employeeId);
}
