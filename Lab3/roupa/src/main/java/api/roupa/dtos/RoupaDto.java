package api.roupa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoupaDto {
    @NotBlank
    private String tamanho;
    @NotBlank
    private String Cor;
    @NotNull
    private Integer Quantidade;
    @NotBlank
    private String Marca;
}

