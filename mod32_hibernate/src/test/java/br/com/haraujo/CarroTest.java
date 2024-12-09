package br.com.haraujo;


import br.com.haraujo.dao.*;
import br.com.haraujo.domain.Acessorio;
import br.com.haraujo.domain.Carro;
import br.com.haraujo.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private IMarcaDAO marcaDAO;
    private ICarroDAO carroDAO;
    private IAcessorioDAO acessorioDAO;

    public CarroTest() {
        marcaDAO = new MarcaDAO();
        carroDAO = new CarroDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void cadastrarMarca() {
        Carro carro = cadastrarCarro("C1");

        Marca marca = new Marca();
        marca.setCodigo("H1");
        marca.setFabricante("Honda");
        marca.setCarro(carro);


        marca = marcaDAO.cadastrar(marca);
        assertNotNull(marca);
        assertNotNull(marca.getId());


    }

    private Carro cadastrarCarro(String codigo) {
        Acessorio acessorio = cadastrarAcessorio("A1");

        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNome("CIVIC");
        carro.setModelo("sedan");
        carro.setValor(2000.999);
        carro.setAcessorio(acessorio);

        return carroDAO.cadastrar(carro);

    }



    private Acessorio cadastrarAcessorio(String codigo) {

        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setTipo("Acessorio 1");

        return acessorioDAO.cadastrar(acessorio);


    }


}
