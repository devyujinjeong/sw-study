package com.dbwls.section02.annotation.subsection01.primary;

import com.dbwls.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    private Pokemon pokemon;

    @Autowired
    // 그렇다면 여기에서 어떤 포켓몬은 주입할 것인가?
    public PokemonService(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void pokemonAttack(){
        pokemon.attack();
    }
}
