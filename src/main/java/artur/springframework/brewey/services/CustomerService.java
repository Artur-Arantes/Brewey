package artur.springframework.brewey.services;

import artur.springframework.brewey.web.model.CustomerDto;
import java.util.UUID;

public interface CustomerService {
  CustomerDto getCustomerById(UUID customerId);
}
