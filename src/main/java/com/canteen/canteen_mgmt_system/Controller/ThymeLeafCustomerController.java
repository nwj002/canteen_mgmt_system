package com.canteen.canteen_mgmt_system.Controller;

import com.canteen.canteen_mgmt_system.Services.CustomerService;
import com.canteen.canteen_mgmt_system.dto.CustomerDto;
import com.canteen.canteen_mgmt_system.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th-customer")
@RequiredArgsConstructor
public class ThymeLeafCustomerController {

    @GetMapping("customertable")
    public String getDataView(Model model){
        model.addAttribute("customerList", customerService.getData());
        return "customer/customertable.html";
    }
    private final CustomerService customerService;

    @GetMapping("create")
    public String getFormPage(Model model){
        model.addAttribute("customer", new CustomerDto());
        return "customer/customercreate.html";
    }

    @PostMapping("save")
    public String saveData(@Valid CustomerDto customerDto) {
        customerService.saveData(customerDto);
        return "customer/customertable.html";
    }

    @GetMapping("edit/{id}")
    public String getById(@PathVariable Integer id, Model model){
        Customer customer= customerService.getByIdNoOps(id);
        model.addAttribute("customer",new CustomerDto(customer));
        return "customer/customercreate.html";    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
        return "redirect:/th-customer/customertable";

    }
}
