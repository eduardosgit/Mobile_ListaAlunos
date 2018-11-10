package com.example.esilvrod.prova_listaalunos;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiAluno {

    @GET("/lista_de_alunos")
    Call<List<Aluno>> obterAluno();
}
