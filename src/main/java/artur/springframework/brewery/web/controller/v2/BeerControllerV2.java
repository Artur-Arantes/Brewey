package artur.springframework.brewery.web.controller.v2;


import artur.springframework.brewery.services.v2.BeerServicesV2;
import artur.springframework.brewery.web.model.v2.BeerDtoV2;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@Validated
public class BeerControllerV2 {

  private final BeerServicesV2 beerService;

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDtoV2> getBeer(@NonNull @PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping// create new beer
  public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
    log.debug("in handle post...");
    val savedDto = beerService.save(beerDto);
    val headers = new HttpHeaders();
    //todo add hostname to url
    headers.add("Location", " /api/v1/beer" + savedDto.getId().toString());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,
                                     @Valid @RequestBody BeerDtoV2 beerDto) {
    beerService.updateBeer(beerId, beerDto);

    return new ResponseEntity(HttpStatus.NO_CONTENT);

  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerService.deleteById(beerId);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
    List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
    e.getConstraintViolations().forEach(constraintViolation -> {
      errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
