package com.caiolobo.ExercicioModulo33;

import com.caiolobo.ExercicioModulo33.dao.*;
import com.caiolobo.ExercicioModulo33.domain.Acessorio;
import com.caiolobo.ExercicioModulo33.domain.Carro;
import com.caiolobo.ExercicioModulo33.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AcessorioTest {
    private ICarroDao carroDao = new CarroDao();
    private IAcessorioDao acessorioDao = new AcessorioDao();
    private IMarcaDao marcaDao = new MarcaDao();
    @Test
    public void cadastrar(){
        Acessorio acessorio = new Acessorio();
        Carro carro = criarCarro();
        //carro = carroDao.cadastrar(carro);
        //System.out.println(carro);
        acessorio.setNome("Acessorio1");
        acessorio.setDescricao("Acessorio1 para o carro");
        acessorio.setCarro(carro);
        acessorio = acessorioDao.cadastrar(acessorio);
        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());
    }

    private Carro criarCarro() {
        Carro carro = new Carro();
        Marca marca = criarMarca();
        carro.setCor("Azul 2");
        carro.setNome("208 2");
        carro.setMarca(marca);
        return carroDao.cadastrar(carro);
    }

    private Marca criarMarca() {
        Marca marca = new Marca();
        marca.setNome("Peugeot2");
        return marcaDao.cadastrar(marca);

    }
}
