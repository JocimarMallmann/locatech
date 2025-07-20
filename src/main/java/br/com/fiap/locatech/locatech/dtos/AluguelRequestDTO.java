package br.com.fiap.locatech.locatech.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(

        @Schema(
                description = "ID da pessoa que está alugando o veículo",
                example = "1"
        )
        @NotNull(message = "O ID da pessoa é obrigatório")
        Long pessoaId,

        @NotNull(message = "O ID do veículo é obrigatório")
        Long veiculoId,

        LocalDate dataInicio,
        LocalDate dataFim
) {


}
