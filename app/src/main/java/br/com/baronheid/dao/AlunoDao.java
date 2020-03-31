package br.com.baronheid.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.baronheid.model.Aluno;

public class AlunoDao {

    private final static List<Aluno> listaAlunos = new ArrayList<>();

    public void salva(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(listaAlunos);
    }
}
