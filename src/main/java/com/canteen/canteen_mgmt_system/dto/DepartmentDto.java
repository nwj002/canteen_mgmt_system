package com.canteen.canteen_mgmt_system.dto;

import com.canteen.canteen_mgmt_system.entity.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentDto {
    private Integer id;

    @NotNull(message = " please fill all the box")
    @NotBlank

    private String departmentName;
    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
    }
}
