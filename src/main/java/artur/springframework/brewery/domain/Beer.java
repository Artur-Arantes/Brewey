package artur.springframework.brewery.domain;

import artur.springframework.brewery.web.model.v2.BeerStyleEnum;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
  private UUID id;
  private String beerName;
  private BeerStyleEnum beerStyle;
  private Long upc;
}
