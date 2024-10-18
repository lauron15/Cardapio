package com.example.Cardapio.DTO;

import com.example.Cardapio.Model.Food;

public record FoodResponseDTO(long id, String title, String image, Integer price) {
public FoodResponseDTO(Food food){
    this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
}

}
