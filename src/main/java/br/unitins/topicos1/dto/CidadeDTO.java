package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public record CidadeDTO(
        @NotBlank(message = "O nome não pode ser nulo ou vazio")
        @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
        String nome,
        @NotBlank(message = "O id não pode ser nulo ou vazio")
        Long idEstado
) {}