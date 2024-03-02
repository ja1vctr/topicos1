package br.unitins.topicos1.dto;

import java.util.Objects;

public class EstadoDTO {
    private String nome;
    private String sigla;

    public EstadoDTO(String nome, String sigla){
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoDTO estadoDTO = (EstadoDTO) o;
        return Objects.equals(nome, estadoDTO.nome) && Objects.equals(sigla, estadoDTO.sigla);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, sigla);
    }
}
