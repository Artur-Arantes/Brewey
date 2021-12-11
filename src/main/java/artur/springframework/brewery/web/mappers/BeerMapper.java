package artur.springframework.brewery.web.mappers;

import artur.springframework.brewery.domain.Beer;
import artur.springframework.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
  public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
  }
