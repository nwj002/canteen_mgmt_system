package com.canteen.canteen_mgmt_system.Services.impl;

import com.canteen.canteen_mgmt_system.Services.CustomerService;
import com.canteen.canteen_mgmt_system.dto.CustomerDto;
import com.canteen.canteen_mgmt_system.entity.Customer;
import com.canteen.canteen_mgmt_system.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerServiceimpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override// helps to get the data.
    public void saveData(CustomerDto customerDto){
        Customer customer = new Customer();
        if(customerDto.getId()!=null){
            customer.setId(customerDto.getId());
        }

        customer.setCustomerId(customerDto.getCustomerId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerAddress(customerDto.getCustomerAddress());
        customer.setCustomerImage(customerDto.getCustomerImage());
        customerRepo.save(customer);
    }
    @Override // show data
    public List<Customer> getData() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer getByIdNoOps(Integer id) {
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("not Found"));
    }

    @Override   // delete data
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }
}
