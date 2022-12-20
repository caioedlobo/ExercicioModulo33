package com.caiolobo.ExercicioModulo33.dao;

import com.caiolobo.ExercicioModulo33.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MarcaDao implements IMarcaDao{
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();        // faz o insert

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }
}
