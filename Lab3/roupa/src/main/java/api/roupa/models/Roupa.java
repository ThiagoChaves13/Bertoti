package api.roupa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "Roupas")
public class Roupa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 4)
    private String tamanho;
    @Column(nullable = false, length = 50)
    private String Cor;
    @Column(nullable = false, length = 50)
    private Integer Quantidade;
    @Column(nullable = false, length = 50)
    private String Marca;
}

