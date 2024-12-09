package br.com.haraujo.dao;

import br.com.haraujo.domain.Carro;
import br.com.haraujo.domain.Marca;

public interface ICarroDAO {

    public Carro cadastrar(Carro carro);

    public Carro buscarPorCodigoMarca(String codigoMarca);

    public Carro buscarPorMarca(Marca marca);

}
