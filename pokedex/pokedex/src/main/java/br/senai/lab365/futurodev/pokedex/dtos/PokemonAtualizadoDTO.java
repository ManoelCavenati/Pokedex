package br.senai.lab365.futurodev.pokedex.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonAtualizadoDTO {
  @NotNull
  @Min(1)
  @Max(1025)
  private Integer numero;

  @NotBlank private String nome;
  private String descricao;
  @NotBlank private String imagem;
  private String tipo;
  private String categoria;
  @NotBlank private String area;
  private Double altura;
  private Double peso;
  @NotNull private Boolean capturado;

  public @NotNull @Min(1) @Max(1025) Integer getNumero() {
    return numero;
  }

  public void setNumero(@NotNull @Min(1) @Max(1025) Integer numero) {
    this.numero = numero;
  }

  public @NotBlank String getNome() {
    return nome;
  }

  public void setNome(@NotBlank String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public @NotBlank String getImagem() {
    return imagem;
  }

  public void setImagem(@NotBlank String imagem) {
    this.imagem = imagem;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public @NotBlank String getArea() {
    return area;
  }

  public void setArea(@NotBlank String area) {
    this.area = area;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public @NotNull Boolean getCapturado() {
    return capturado;
  }

  public void setCapturado(@NotNull Boolean capturado) {
    this.capturado = capturado;
  }
}
