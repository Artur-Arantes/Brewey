//package artur.springframework.brewery.web.controller;
//
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import artur.springframework.brewery.services.BeerServices;
//import artur.springframework.brewery.web.model.BeerDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.UUID;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@WebMvcTest(BeerController.class)
//@ExtendWith({MockitoExtension.class})
//class BeerControllerTest {
//  @MockBean
//  BeerServices beerServices;
//  @Autowired
//  MockMvc mockMvc;
//  @Autowired
//  ObjectMapper objectMapper;
//
//  BeerDto validBeer;
//
//  @BeforeEach
//  public void setUp() {
//    validBeer = BeerDto.builder().id(UUID.randomUUID())
//        .beerName("Brazilian Beer")
//        .beerStyle("PALE_ALE")
//        .upc(123456789012L)
//        .build();
//  }
//
//  @Test
//  void getBeer() throws Exception {
//    given(beerServices.getBeerById(any(UUID.class))).willReturn(validBeer);
//
//    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + validBeer.getId().toString())
//            .accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect((ResultMatcher) jsonPath("$.id",is(validBeer.getId().toString())))
//        .andExpect((ResultMatcher) jsonPath("$.beerName",is("Brazilian Beer")));
//  }
//
//  @Test
//  void handlePost() {
//  }
//
//  @Test
//  void handleUpdate() {
//  }
//
//  @Test
//  void deleteBeer() {
//  }
//}