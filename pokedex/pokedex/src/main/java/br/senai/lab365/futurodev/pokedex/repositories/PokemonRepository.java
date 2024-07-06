package br.senai.lab365.futurodev.pokedex.repositories;

import br.senai.lab365.futurodev.pokedex.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
