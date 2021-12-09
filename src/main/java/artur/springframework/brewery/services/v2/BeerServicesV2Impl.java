package artur.springframework.brewery.services.v2;

import artur.springframework.brewery.web.model.v2.BeerDtoV2;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServicesV2Impl implements BeerServicesV2 {

  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    return null;
  }

  @Override
  public BeerDtoV2 save(BeerDtoV2 beerDto) {
    return null;
  }

  @Override
  public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {

  }

  @Override
  public void deleteById(UUID beerId) {

  }
}
