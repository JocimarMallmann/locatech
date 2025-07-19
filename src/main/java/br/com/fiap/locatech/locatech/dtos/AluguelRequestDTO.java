package br.com.fiap.locatech.locatech.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(

        @NotNull(message = "O ID da pessoa é obrigatório")
        Long pessoaId,

        @NotNull(message = "O ID do veículo é obrigatório")
        Long veiculoId,

        LocalDate dataInicio,
        LocalDate dataFim
) {


}
