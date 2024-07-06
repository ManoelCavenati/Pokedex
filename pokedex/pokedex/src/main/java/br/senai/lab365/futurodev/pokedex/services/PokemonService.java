package br.senai.lab365.futurodev.pokedex.services;

import static br.senai.lab365.futurodev.pokedex.utils.PokemonMapping.modelToDto;

import br.senai.lab365.futurodev.pokedex.dtos.PokemonAtualizadoDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonCapturadoDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonPreviewDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonVistoDTO;
import br.senai.lab365.futurodev.pokedex.models.Pokemon;
import br.senai.lab365.futurodev.pokedex.repositories.PokemonRepository;
import br.senai.lab365.futurodev.pokedex.utils.PokemonMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  private final PokemonRepository repository;

  public PokemonService(PokemonRepository repository) {
    this.repository = repository;
  }

  public void cadastraVisto(PokemonVistoDTO pokemonVistoDTO) {
    Pokemon pokemonVisto = PokemonMapping.dtoToModel(pokemonVistoDTO);

    // TODO: validar se já existe registro com o mesmo numero. caso sim, retornar status 400 ou 409
    repository.save(pokemonVisto);
  }

  public void cadastraCapturado(PokemonCapturadoDTO pokemonCapturadoDTO) {
    Pokemon pokemonCapturado = PokemonMapping.dtoToModel(pokemonCapturadoDTO);
    pokemonCapturado.setCapturado(true);

    // TODO: validar se já existe registro com o mesmo numero e com campos de capturado preenchidos.
    // caso sim, retornar status 400 ou 409. caso existir o registro, mas sem campos de capturado
    // preenchidos, pode atualizar.
    repository.save(pokemonCapturado);
  }

  public boolean atualiza(PokemonAtualizadoDTO pokemonAtualizadoDTO) {
    if (repository.existsById(pokemonAtualizadoDTO.getNumero())) {
      Pokemon pokemonAtualizado = PokemonMapping.dtoToModel(pokemonAtualizadoDTO);
      repository.save(pokemonAtualizado);
      return true;
    } else {
      return false;
    }
  }

  public void exclui(Integer numero) {
    repository.deleteById(numero);
  }

  public Optional<Pokemon> busca(Integer numero) {
    return repository.findById(numero);
  }

  public List<PokemonPreviewDTO> buscaTodos() {
    return modelToDto(repository.findAll());
  }
}
