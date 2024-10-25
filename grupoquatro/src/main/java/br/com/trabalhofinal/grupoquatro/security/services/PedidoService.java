package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.PedidoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;
import br.com.trabalhofinal.grupoquatro.security.entities.Pedido;
import br.com.trabalhofinal.grupoquatro.security.entities.Produto;
import br.com.trabalhofinal.grupoquatro.security.repositories.ClienteRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.PedidoRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public PedidoResponseDTO adicionarPedido(PedidoRequestDTO pedidoDto) {
		PedidoResponseDTO pedido = new PedidoResponseDTO();
		pedido.setNumero(pedidoDto.getNumero());
		pedido.setStatus("Em processamento");

		Set<String> nomesProdutos = new HashSet<>();
		Set<Produto> produtos = produtoRepository.retornaLista(pedidoDto.getIdProduto());
		for (Produto prod : produtos) {
			nomesProdutos.add(prod.getNome());
		}

		pedido.setNomeProduto(nomesProdutos);

		Double valorTotal = produtos.stream().mapToDouble(Produto::getPreco).sum();

		pedido.setValorTotal(valorTotal);

		Pedido pedidoConvert = pedido.toPedido();
		pedidoConvert.setProdutos(produtos);

		Cliente cliente = clienteRepository.buscarCliente(pedidoDto.getIdCliente());
		pedidoConvert.setFkCliente(cliente);
		pedido.setNomeCliente(cliente.getNome());

		pedidoRepository.save(pedidoConvert);

		return pedido;
	}

	public PedidoResponseDTO buscarPedido(Integer id) {

		Optional<Pedido> pedido = pedidoRepository.findById(id);
		Optional<Cliente> cliente = clienteRepository.findById(pedido.get().getFkCliente().getId());

		Set<String> nomesProdutos = new HashSet<>();
		Set<Produto> produtos = pedido.get().getProdutos();
		for (Produto prod : produtos) {
			nomesProdutos.add(prod.getNome());
		}

		return new PedidoResponseDTO(pedido.get().getNumero(), pedido.get().getValorTotal(), pedido.get().getStatus(),
				cliente.get().getNome(), nomesProdutos);
	}

	public boolean pedidoDelete(Integer id) {
		if (pedidoRepository.existsById(id)) {
			pedidoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public void atualizarPedido(Integer id, PedidoRequestUpdateDTO pedidoDto) {
		Pedido pedidoTodo = pedidoRepository.findById(id).get();
		pedidoTodo.setStatus(pedidoDto.getStatus());
		pedidoRepository.save(pedidoTodo);	
	}
	
}
