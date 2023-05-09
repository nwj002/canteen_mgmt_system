package com.canteen.canteen_mgmt_system.Services.impl;

import com.canteen.canteen_mgmt_system.Services.DepartmentService;
import com.canteen.canteen_mgmt_system.config.PasswordEncoderUtill;
import com.canteen.canteen_mgmt_system.dto.DepartmentDto;
import com.canteen.canteen_mgmt_system.entity.Department;
import com.canteen.canteen_mgmt_system.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class DepartmentServiceimpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    @Override
    public void saveData(DepartmentDto departmentDto){
        Department department = new Department();
        if(departmentDto.getId()!=null){
            department.setId(departmentDto.getId());
        }
        department.setDepartmentName(departmentDto.getDepartmentName());
        departmentRepo.save(department);

    }
    @Override
    public List<Department> getData(){
        return departmentRepo.findAll();
    }
    @Override
    public Optional<Department> getById(Integer id) {
        return departmentRepo.findById(id);
    }
    @Override
    public Department getByIdNoOps(Integer id) {
        return departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepo.deleteById(id);
    }

}
