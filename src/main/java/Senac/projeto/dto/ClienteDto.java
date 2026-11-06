package Senac.projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteDto(
    @NotBlank(message = "O nome do cliente é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre {min} e {max} caracteres.")
    String nomeCliente,
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail informado é invalido.")
    String email,
    @NotBlank(message = "O cpf é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O cpf deve conter exatamente 11 digitos.")
    String cpf,
    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter de 10 a 11 digitos.")
    String telefone
) {

}
