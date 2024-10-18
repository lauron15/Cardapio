package com.example.Cardapio.Repository;

import com.example.Cardapio.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFood extends JpaRepository<Food, Long> {


}


//o que é passado dentro do JPA <> é o tipo da entidade em questão, e o tipo do identificador único dela.