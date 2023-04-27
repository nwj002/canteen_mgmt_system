package com.canteen.canteen_mgmt_system.Controller;

import com.canteen.canteen_mgmt_system.Services.CustomerService;
import com.canteen.canteen_mgmt_system.dto.CustomerDto;
import com.canteen.canteen_mgmt_system.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping() // get data
    public List<Customer> getData() {
        return customerService.getData();
    }

    @GetMapping("getById/{id}")
    public Optional<Customer> getById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @PostMapping("/save") // save data
    public String saveData(@Valid  CustomerDto customerDto) {
        customerService.saveData(customerDto);
        return "data saved";
    }

    @DeleteMapping("deleteById/{id}") // delete code
    public String deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
        return "deleted sucessfully";
    }
}
