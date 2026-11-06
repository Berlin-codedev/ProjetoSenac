package Senac.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @Column(nullable = false, length = 300)
    private String nomePedido;
    @Column(nullable = false)
    private int quantidadePedido;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal quantiedadeUnitaria;
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;
}
