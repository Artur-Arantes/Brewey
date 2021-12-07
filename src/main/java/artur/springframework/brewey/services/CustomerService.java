package artur.springframework.brewey.services;

import artur.springframework.brewey.web.model.CustomerDto;
import java.util.UUID;

public interface CustomerService {


  CustomerDto save(CustomerDto customerDto);

  CustomerDto getCustomerById(UUID customerId);

  void updateCustomer(UUID customerId, CustomerDto customerDto);

  void deleteById(UUID beerId);
}
