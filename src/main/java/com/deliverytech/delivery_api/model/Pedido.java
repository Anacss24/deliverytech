package com.deliverytech.delivery_api.model;


import jakarta.persistence.*; 
import lombok.Data; 
 
import java.math.BigDecimal; 
import java.time.LocalDateTime;
import java.util.List;

 
@Entity 
@Data 
public class Pedido { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
 
    private String numeroPedido;
    private LocalDateTime dataPedido; 
    private String enderecoEntrega; 
    private BigDecimal subtotal; 
    private BigDecimal taxaEntrega; 
    private BigDecimal valorTotal; 
 
  
    @Enumerated(EnumType.STRING) 
    private StatusPedido status; 
 
    @ManyToOne 
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente; 
 
    @ManyToOne 
    @JoinColumn(name = "restaurante_id") 
    private Restaurante restaurante; 
 
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) 
    private List<ItemPedido> itens; 
}
