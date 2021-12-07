package artur.springframework.brewey.services;

import artur.springframework.brewey.web.model.BeerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServicesImpl implements BeerServices {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID()).beerName("Brazilian Beer").beerStyle("Pale Ale")
        .build();
  }
}
