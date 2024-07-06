package br.senai.lab365.futurodev.pokedex.controllers;

import br.senai.lab365.futurodev.pokedex.dtos.PokemonAtualizadoDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonCapturadoDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonPreviewDTO;
import br.senai.lab365.futurodev.pokedex.dtos.PokemonVistoDTO;
import br.senai.lab365.futurodev.pokedex.models.Pokemon;
import br.senai.lab365.futurodev.pokedex.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

  private PokemonService pokemonService;

  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @Operation(
      summary = "Cadastro de pokémon visto",
      description =
          "Cadastra pokémon que foi apenas visto, e não capturado, com apenas alguns dados.",
      responses = {
        @ApiResponse(responseCode = "201", description = "Pokémon visto cadastrado com sucesso."),
        @ApiResponse(
            responseCode = "409",
            description = "Já existe um pokémon cadastrado com o mesmo número."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos de cadastro.")
      })
  @PostMapping("/visto")
  public ResponseEntity<Void> cadastraVisto(@Valid @RequestBody PokemonVistoDTO pokemonVistoDTO) {
    pokemonService.cadastraVisto(pokemonVistoDTO);

    return ResponseEntity.created(URI.create(String.format("/%d", pokemonVistoDTO.getNumero())))
        .build();
  }

  @Operation(
      summary = "Cadastro de pokémon capturado",
      description = "Cadastra pokémon que foi capturado, contendo todos os dados.",
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "Pokémon capturado cadastrado com sucesso."),
        @ApiResponse(
            responseCode = "409",
            description = "Já existe um pokémon capturado cadastrado com o mesmo número."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos de cadastro.")
      })
  @PostMapping("/capturado")
  public ResponseEntity<Void> cadastraCapturado(
      @Valid @RequestBody PokemonCapturadoDTO pokemonCapturadoDTO) {
    pokemonService.cadastraCapturado(pokemonCapturadoDTO);

    return ResponseEntity.created(URI.create(String.format("/%d", pokemonCapturadoDTO.getNumero())))
        .build();
  }

  @PutMapping
  public ResponseEntity<Void> atualiza(
      @Valid @RequestBody PokemonAtualizadoDTO pokemonAtualizadoDTO) {
    return pokemonService.atualiza(pokemonAtualizadoDTO)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{numero}")
  public ResponseEntity<Void> exclui(@PathVariable Integer numero) {
    pokemonService.exclui(numero);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{numero}")
  public ResponseEntity<Pokemon> busca(@PathVariable Integer numero) {
    return pokemonService
        .busca(numero)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<PokemonPreviewDTO>> buscaTodos() {
    return ResponseEntity.ok(pokemonService.buscaTodos());
  }
}
