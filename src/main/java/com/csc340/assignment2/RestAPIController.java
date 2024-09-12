package com.csc340.assignment2;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class RestAPIController{
    @GetMapping("/games")
    public Object getGamesDeals() {
        try {
            String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=3";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            List<games> dealsList = new ArrayList<>();

            for (JsonNode rt : root) {
                String DisplayName = rt.get("title").asText();
                int gameID = rt.get("gameID").asInt();
                double salePrice = rt.get("salePrice").asDouble();
                double regularPrice = rt.get("normalPrice").asDouble();

                games games = new games(DisplayName, gameID, salePrice, regularPrice);

                dealsList.add(games);
            }
            return dealsList;

        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestAPIController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /games";
        }
    }

}
