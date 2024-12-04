package br.com.haraujo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.haraujo.dao.IProdutoDAO;
import br.com.haraujo.dao.ProdutoDAO;
import br.com.haraujo.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	public ProdutoTest() {
		produtoDAO = new ProdutoDAO();
	}

	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setCodigo("P2");
		produto.setNome("Produto1");
		produto.setEstoque(50);
		produto.setPreco(99.99);
		produto = produtoDAO.cadastrar(produto);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());
		
	}
}
