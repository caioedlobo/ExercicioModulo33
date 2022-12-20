package com.caiolobo.ExercicioModulo33.dao;

import com.caiolobo.ExercicioModulo33.domain.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarroDao implements ICarroDao{


    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();        // faz o insert

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
