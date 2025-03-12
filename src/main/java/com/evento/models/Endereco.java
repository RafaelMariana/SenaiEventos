package com.evento.models;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "endereco")
public class Endereco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String cep;
    private String rua;
    private String bairro;
    private String complemento;

    @ManyToOne
    @JoinTable(name = "cidade_id")
    private Cidade cidade;

    public Endereco(){}

    public Endereco(Long id, String numero, String cep, String rua, String bairro, String complemento, Cidade cidade) {
        this.id = id;
        this.numero = numero;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(numero, endereco.numero)
                && Objects.equals(cep, endereco.cep) && Objects.equals(rua, endereco.rua)
                && Objects.equals(bairro, endereco.bairro) && Objects.equals(complemento, endereco.complemento)
                && Objects.equals(cidade, endereco.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, cep, rua, bairro, complemento, cidade);
    }
}
