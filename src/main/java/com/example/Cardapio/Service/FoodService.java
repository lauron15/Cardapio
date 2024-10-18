package com.example.Cardapio.Service;

import com.example.Cardapio.Model.Food;
import com.example.Cardapio.Repository.IFood;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final IFood repository;
    public FoodService(IFood repository) {
        this.repository = repository;
    }

    public List<Food> listarFoods(){
        return repository.findAll();
    }
    public Optional<Food> buscarFoodsPorId(Long id) {
        return repository.findById(id);
    }
    public Food criarFood (Food food) {
        return repository.save(food);
    }

    public Food editarComida(Food food, Long id) {
        Optional<Food> foodExistente = repository.findById(id);

        if (foodExistente.isPresent()){
            food.setId(id);
            return  repository.save(food);
        }
        else {
            throw new RuntimeException("Food com o ID" + id + "não encontrada.");
        }
    }

    public Boolean excluirFood(Long id){
        if ( repository.existsById(id)) {
            repository.deleteById(id);
            return true;
         } else {
            throw  new RuntimeException("Comida não encontrada");
        }

    }


}
