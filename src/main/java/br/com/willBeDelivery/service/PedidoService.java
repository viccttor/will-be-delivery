package br.com.willBeDelivery.service;


import br.com.willBeDelivery.dto.PedidoDTO;
import br.com.willBeDelivery.model.Pedido;
import br.com.willBeDelivery.model.StatusEntrega;

public interface PedidoService {

    Iterable<Pedido> buscarTodos();
    Pedido buscarPorId(long id);
    Pedido inserir(PedidoDTO pedidoDTO);
    Pedido atualizar(long id, PedidoDTO pedidoDTO);
    Pedido atualizarStatusEntrega(long id, StatusEntrega status);
    void deletar(Long id);
}
