package com.canteen.canteen_mgmt_system.Controller;

import com.canteen.canteen_mgmt_system.Services.DepartmentService;
import com.canteen.canteen_mgmt_system.dto.DepartmentDto;
import com.canteen.canteen_mgmt_system.entity.Department;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService; // dependency injection

    @GetMapping
    public List<Department> getData(){
        return departmentService.getData();
    }

    @GetMapping("getById/{id}")
    public Optional<Department> getById(@PathVariable Integer id) {
        return departmentService.getById(id);
    }

    @PostMapping("save")
    public String saveData(@Valid DepartmentDto departmentDto){
        departmentService.saveData(departmentDto);
        return "data saved";
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return "data deleted sucessfully";
    }
}
