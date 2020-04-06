package br.com.baronheid.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.baronheid.model.Aluno;

public class AlunoDao {

    private static Integer contadorId = 1;

    private static List<Aluno> alunos = new ArrayList<>();
    private Integer posicao = null;

    public void salva(Aluno aluno) {

        aluno.setId(contadorId);
        alunos.add(aluno);
        contadorId++;
    }

    public void edita(Aluno alunoEditado) {

        for (Aluno aluno :
                alunos) {
            if (aluno.getId().equals(alunoEditado.getId())) {
                alunos.set(
                        alunos.indexOf(aluno),
                        alunoEditado);
            }
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno alunoRemovido) {
        Aluno alunoPraRemover = null;
        for (Aluno aluno :
                alunos) {
            if (aluno.getId().equals(alunoRemovido.getId())) {
                alunoPraRemover = alunoRemovido;
                break;
            }
        }
        if (alunoPraRemover != null) {
            alunos.remove(alunoPraRemover);
        }
    }
}

