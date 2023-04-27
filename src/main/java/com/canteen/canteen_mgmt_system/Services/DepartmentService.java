package com.canteen.canteen_mgmt_system.Services;

import com.canteen.canteen_mgmt_system.dto.DepartmentDto;
import com.canteen.canteen_mgmt_system.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void saveData(DepartmentDto departmentDto);
    List<Department> getData();
    Optional<Department> getById(Integer id);
    Department getByIdNoOps(Integer id);
    void deleteById(Integer id);
}
