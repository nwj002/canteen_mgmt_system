package com.canteen.canteen_mgmt_system.repo;

import com.canteen.canteen_mgmt_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends
        JpaRepository<Department, Integer> {
}
