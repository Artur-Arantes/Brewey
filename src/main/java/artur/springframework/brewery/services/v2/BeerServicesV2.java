package artur.springframework.brewery.services.v2;

import artur.springframework.brewery.web.model.v2.BeerDtoV2;
import java.util.UUID;

public interface BeerServicesV2 {

  public BeerDtoV2 getBeerById(UUID beerId);

  public BeerDtoV2 save(BeerDtoV2 beerDto);

  public void updateBeer(UUID beerId, BeerDtoV2 beerDto);

  public void deleteById(UUID beerId);
}
