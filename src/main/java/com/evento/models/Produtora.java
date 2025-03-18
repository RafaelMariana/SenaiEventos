package com.evento.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produtoras")
public class Produtora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, name = "cpf_cnpj")
    private String cpfCnpj;

    public Produtora(){

    }

    public Produtora(Long id, String nome, String cpfCnpj) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produtora produtora = (Produtora) o;
        return Objects.equals(id, produtora.id) && Objects.equals(nome, produtora.nome) && Objects.equals(cpfCnpj, produtora.cpfCnpj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpfCnpj);
    }
}
