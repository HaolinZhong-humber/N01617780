package com.example.repository;

<<<<<<< HEAD
import com.example.model.Claim;
=======
>>>>>>> 3d7697b (lab5 submission)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    // 通过 employee_id 找到所有的 claims 记录
    List<Claim> findByEmployeeId(Long employeeId);

    // 删除所有和 employee_id 关联的 claims
    void deleteByEmployeeId(Long employeeId);
}
