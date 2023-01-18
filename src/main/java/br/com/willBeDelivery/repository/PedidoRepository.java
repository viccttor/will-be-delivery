package br.com.willBeDelivery.repository;

import br.com.willBeDelivery.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido,Long> {
}
