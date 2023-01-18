package br.com.willBeDelivery.dto;

import lombok.Data;

@Data
public class PedidoDTO {
    private String destinatario;
    private EnderecoDTO enderecoDTO;
}
