package artur.springframework.brewery.services;

import artur.springframework.brewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerServices {
  public BeerDto getBeerById(UUID beerId);

  BeerDto save(BeerDto beerDto);

  void updateBeer(UUID beerId, BeerDto beerDto);

  void deleteById(UUID beerId);
}
