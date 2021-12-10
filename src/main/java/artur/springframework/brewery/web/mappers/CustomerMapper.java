package artur.springframework.brewery.web.mappers;

import artur.springframework.brewery.domain.Customer;
import artur.springframework.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
  Customer customerDtoToCustomer(CustomerDto dto);

  CustomerDto customerToCustomerDto(Customer customer);
}
