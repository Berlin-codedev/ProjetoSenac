package Senac.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;
    @Column(nullable = false)
    private int quantidade;
    @Column(length = 500)
    private String descricaoMaterial;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precoUnitario;
    @Builder.Default
    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();
}
