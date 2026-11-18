package Senac.projeto.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TrabalhoDto (
    @NotBlank(message = "O trabalho é obrigatório.")
    String trabalho,
    @NotBlank(message = "O tipo de trabalho é obrigatório.")
    String tipoTrabalho,
    @NotNull(message = "A data de entrega é obrigatória.")
    @Future(message = "A data de entrega deve ser futura.")
    OffsetDateTime dataEntrega,
    @NotNull(message = "O cliente é obrigatório.")
    Long clienteId
    )
{}
