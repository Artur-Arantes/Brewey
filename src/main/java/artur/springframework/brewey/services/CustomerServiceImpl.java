package artur.springframework.brewey.services;

import artur.springframework.brewey.web.model.CustomerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto save(CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder().id(UUID.randomUUID()).name("Toquio").build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    //todo impl -would add a real impl

  }

  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting a customer...");
  }
}
