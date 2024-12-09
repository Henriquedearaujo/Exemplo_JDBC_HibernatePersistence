package br.com.haraujo.dao;

import br.com.haraujo.domain.Carro;
import br.com.haraujo.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDAO implements ICarroDAO {
    @Override
    public Carro cadastrar(Carro carro) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return carro;
    }

    @Override
    public Carro buscarPorCodigoMarca(String codigoMarca) {
        return null;
    }

    @Override
    public Carro buscarPorMarca(Marca marca) {
        return null;
    }
}
