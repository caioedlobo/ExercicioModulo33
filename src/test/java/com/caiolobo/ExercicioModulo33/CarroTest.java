package com.caiolobo.ExercicioModulo33;

import com.caiolobo.ExercicioModulo33.dao.*;
import com.caiolobo.ExercicioModulo33.domain.Acessorio;
import com.caiolobo.ExercicioModulo33.domain.Carro;
import com.caiolobo.ExercicioModulo33.domain.Marca;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private ICarroDao carroDao = new CarroDao();
    private IAcessorioDao acessorioDao = new AcessorioDao();
    private IMarcaDao marcaDao = new MarcaDao();

    @Test
    public void cadastrar(){
        Carro carro = new Carro();
        Acessorio acessorio = criarAcessorio("Acessorio1");
        Acessorio acessorio2 = criarAcessorio("Acessorio2");
        Marca marca = criarMarca();
        carro.setCor("Azul");
        carro.setNome("208");
        carro.setMarca(marca);
        carro.adicionarAcessorio(acessorio);
        carro.adicionarAcessorio(acessorio2);
        acessorio.setCarro(carro);
        acessorio2.setCarro(carro);

        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Marca criarMarca() {
        Marca marca = new Marca();
        marca.setNome("Peugeot");
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String nome) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(nome + " para o carro");
        acessorio.setNome(nome);
        //return acessorioDao.cadastrar(acessorio);
        return acessorio;
    }
}
