package artur.springframework.brewery.web.controller;

import artur.springframework.brewery.services.CustomerService;
import artur.springframework.brewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @PostMapping// create new beer
  public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
    CustomerDto savedDto = customerServices.save(customerDto);
    HttpHeaders headers = new HttpHeaders();
    //todo add hostname to url
    headers.add("Location", " /api/v1/customer" + savedDto.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId,
                                     @RequestBody CustomerDto customerDto) {
    customerServices.updateCustomer(customerId, customerDto);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("customerId") UUID beerId) {
    customerServices.deleteById(beerId);
  }
}
