package br.com.willBeDelivery.repository;

import br.com.willBeDelivery.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco,String> {
}
