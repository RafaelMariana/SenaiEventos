package com.evento.dtos;

import com.evento.enums.Estado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CidadeDTO {
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public CidadeDTO(){}

    public CidadeDTO(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
