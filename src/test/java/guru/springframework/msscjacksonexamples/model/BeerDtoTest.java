package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserializeJson() throws IOException {
        String jsonString = "{\"id\":\"e091fe88-a940-443d-90c7-83240370e77a\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456,\"price\":12.99,\"createdDate\":\"2024-04-23T21:38:59.3003985+03:00\",\"lastUpdatedDate\":\"2024-04-23T21:38:59.3013988+03:00\"}";
        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(beerDto);
    }

}