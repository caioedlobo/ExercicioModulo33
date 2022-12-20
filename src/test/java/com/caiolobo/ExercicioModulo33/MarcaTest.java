package com.caiolobo.ExercicioModulo33;

import com.caiolobo.ExercicioModulo33.dao.*;
import com.caiolobo.ExercicioModulo33.domain.Acessorio;
import com.caiolobo.ExercicioModulo33.domain.Carro;
import com.caiolobo.ExercicioModulo33.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarcaTest {

    private IMarcaDao marcaDao = new MarcaDao();
    private ICarroDao carroDao = new CarroDao();

    @Test
    public void cadastrar(){
        Marca marca = new Marca();
        Carro carro = criarCarro();
        marca.setNome("Toyota");
        //marca.setCarro(carro);        quem usa a marca é o carro (marca fica na tabela do carro)
        carro.setMarca(marca);
        marca = marcaDao.cadastrar(marca);
        carro = carroDao.cadastrar(carro);  // tem que colocar para criar
        assertNotNull(marca);
        assertNotNull(marca.getId());
    }

    private Carro criarCarro() {
        Carro carro = new Carro();
        carro.setCor("Vermelho");
        carro.setNome("Corolla");
        Acessorio acessorio = criarAcessorio("Acessorio1");
        Acessorio acessorio2 = criarAcessorio("Acessorio2");
        carro.adicionarAcessorio(acessorio);
        carro.adicionarAcessorio(acessorio2);
        acessorio.setCarro(carro);
        acessorio2.setCarro(carro);

        return carro;
    }

    private Acessorio criarAcessorio(String nome) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(nome + " para o carro");
        acessorio.setNome(nome);
        //return acessorioDao.cadastrar(acessorio);
        return acessorio;
    }
}
