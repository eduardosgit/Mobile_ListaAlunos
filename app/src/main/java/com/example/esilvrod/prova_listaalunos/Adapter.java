package com.example.esilvrod.prova_listaalunos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context contexto;
    List<Aluno> lista;

    public Adapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.lista, null);
        Aluno aluno = lista.get(position);

        TextView nome = (TextView) linha.findViewById(R.id.nome);
        TextView nota = (TextView) linha.findViewById(R.id.nota);
        TextView visor = (TextView) linha.findViewById(R.id.visor);

        if(aluno.getNota() < 6) {
            visor.setBackgroundColor(Color.RED);
        }else {
            visor.setBackgroundColor(Color.BLUE);
        }

        nome.setText(aluno.getNome());
        nota.setText(aluno.getNota()+ "");

        return linha;
    }
}
