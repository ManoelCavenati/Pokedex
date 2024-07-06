package br.senai.lab365.futurodev.pokedex.dtos;

import jakarta.validation.constraints.*;

public class PokemonVistoDTO {
    @NotNull @Min(1) @Max(1025)
    private Integer numero;
    @NotBlank
    private String nome;
    @NotBlank
    private String imagem;
    @NotBlank
    private String area;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
