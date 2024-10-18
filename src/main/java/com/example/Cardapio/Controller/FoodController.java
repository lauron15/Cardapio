package com.example.Cardapio.Controller;

import com.example.Cardapio.Model.Food;
import com.example.Cardapio.Service.FoodService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
@CrossOrigin("*")
public class FoodController {

    private final FoodService foodService;  // Correção aqui


    public FoodController(FoodService foodService) {
        this.foodService = foodService;  // Correção aqui
    }

    @GetMapping
    public ResponseEntity<List<Food>> listarFoods() {
        return ResponseEntity.status(200).body(foodService.listarFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food>buscarFoodsPorId(@PathVariable Long id){
        Optional<Food> food = foodService.buscarFoodsPorId(id);
        return food.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Food>criarFood( @RequestBody Food food) {
return ResponseEntity.status(201).body(foodService.criarFood(food));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food>editarComida( @RequestBody Food food, @PathVariable Long id){
        return ResponseEntity.status(200).body(foodService.editarComida(food,id));

    }
@DeleteMapping("/{id}")
    public ResponseEntity<Food>excluirFood(@PathVariable Long id){
        foodService.excluirFood(id);
        return ResponseEntity.status(204).build();
}

}


// não esqueça de colocar o @PathVariable ao passar o metodo com o id.
//não esqueça de colocoar as pastas dentro da pasta principal

