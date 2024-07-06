package br.senai.lab365.futurodev.pokedex.models;

import br.senai.lab365.futurodev.pokedex.enums.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {
  @Id private int numero;

  @Column(nullable = false, unique = true)
  private String nome;

  private String descricao;

  @Column(nullable = false)
  private String imagem;

  @Enumerated(value = EnumType.STRING)
  private Tipo tipo;

  private String categoria;

  @Column(nullable = false)
  private String area;

  private Double altura;
  private Double peso;

  @Column(nullable = false)
  private boolean capturado;

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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public boolean isCapturado() {
    return capturado;
  }

  public void setCapturado(boolean capturado) {
    this.capturado = capturado;
  }
}
