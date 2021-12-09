package artur.springframework.brewery.services;

import artur.springframework.brewery.web.model.BeerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServicesImpl implements BeerServices {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID()).beerName("Brazilian Beer").beerStyle("Pale Ale")
        .build();
  }

  @Override
  public BeerDto save(BeerDto beerDto) {
    return BeerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
    //todo impl -would add a real impl
  }

  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting a beer...");
  }

}
