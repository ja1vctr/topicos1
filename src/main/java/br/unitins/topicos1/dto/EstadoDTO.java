package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public record EstadoDTO(
        @NotBlank(message = "Não pode ter valor Null ou vazio")
        @Size(min = 4, max = 60, message = "Tamanho do nome deve ser entre 4 e 60 caracteres.")
        String nome,
        @NotBlank(message = "Não pode ter valor Null ou vazio")
        @Size(min = 2, max = 2, message = "Adicione uma sigla válida (deve possuir 2 caracteres)")
        String sigla
) {

}