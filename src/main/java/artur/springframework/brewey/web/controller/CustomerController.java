package artur.springframework.brewey.web.controller;

import artur.springframework.brewey.services.CustomerService;
import artur.springframework.brewey.web.model.BeerDto;
import artur.springframework.brewey.web.model.CustomerDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {

  private final CustomerService customerServices;

  @RequestMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    return new ResponseEntity<>(customerServices.getCustomerById(customerId), HttpStatus.OK);

  }

}
