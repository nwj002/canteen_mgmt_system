package com.canteen.canteen_mgmt_system.Controller;

import com.canteen.canteen_mgmt_system.Services.DepartmentService;
import com.canteen.canteen_mgmt_system.dto.DepartmentDto;
import com.canteen.canteen_mgmt_system.entity.Department;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/th-department")
@RequiredArgsConstructor
public class ThymeLeafDepartmentController {

    @GetMapping("table")
    public String getDataView(Model model){
        model.addAttribute("departmentList",departmentService.getData());
        return "department/table.html";
    }

    private final DepartmentService departmentService;
    @GetMapping("create")
    public String getFormPage(Model model){
        model.addAttribute("department", new DepartmentDto());
        return "department/create.html";
    }

    @PostMapping("save")
    public String saveData(@Valid DepartmentDto departmentDto) {
        departmentService.saveData(departmentDto);
        return "department/table.html";
    }

    @GetMapping("edit/{id}")
    public String getById(@PathVariable Integer id,Model model){
        Department department= departmentService.getByIdNoOps(id);
        model.addAttribute("department",new DepartmentDto(department));
        return "department/create.html";    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return "redirect:/th-department/table";

    }

}


