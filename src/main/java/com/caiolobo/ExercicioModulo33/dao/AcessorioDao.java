package com.caiolobo.ExercicioModulo33.dao;

import com.caiolobo.ExercicioModulo33.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AcessorioDao implements IAcessorioDao {

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();        // faz o insert

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }
}
