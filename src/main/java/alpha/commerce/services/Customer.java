package alpha.commerce.services;

import alpha.commerce.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface Customer {
    public CustomerDto save(CustomerDto dto);
    public CustomerDto findById(Long id);
    public List<CustomerDto> findAll();
    public void disableCustomer(Long id);
}
