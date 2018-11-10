package com.example.esilvrod.prova_listaalunos;

import java.util.HashMap;
import java.util.Map;

public class Aluno {

    private String nome;
    private Integer nota;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Aluno(String nome, Integer nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
