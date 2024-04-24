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
        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456,\"price\":\"12.99\",\"createdDate\":\"2024-04-24T20:25:44+0300\",\"lastUpdatedDate\":\"2024-04-24T20:25:45.0009096+03:00\",\"myLocalDate\":\"20240424\",\"beerId\":\"9bdfbb3d-f83f-41ad-bd6c-bbf926e7d5b6\"}\n";
        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(beerDto);
    }

}