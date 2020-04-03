package br.com.baronheid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.baronheid.R;
import br.com.baronheid.dao.AlunoDao;
import br.com.baronheid.model.Aluno;


public class ListaAlunosActivity extends AppCompatActivity {

    public static final String APPBAR_NAME = "Lista de Alunos";

    public static final int ACTIVITY_LISTA_ALUNOS = R.layout.activity_lista_alunos;

    private FloatingActionButton botaoAdicionar;

    private ListView listaDeAlunos;

    private final AlunoDao alunoDao = new AlunoDao();

    private List<Aluno> todos = alunoDao.todos();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(APPBAR_NAME);

        setContentView(ACTIVITY_LISTA_ALUNOS);

        botaoAdicionar = findViewById(R.id.activity_main_fab_novo_aluno);
        botaoAdicionar.setOnClickListener(configuraOnClickListener());

    }


    @Override
    protected void onResume() {
        super.onResume();

        todos = alunoDao.todos();

        listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        carregaListaAlunos();

        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoClicado = todos.get(position);
                Intent intent = new Intent(ListaAlunosActivity.this,
                        FormularioAlunosActivity.class);
                intent.putExtra("aluno", alunoClicado);
                startActivity(intent);
            }
        });

    }

    private View.OnClickListener configuraOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaActivity();
            }
        };
    }

    private void carregaListaAlunos() {

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                todos));
    }

    private void iniciaActivity() {
        startActivity(new Intent(
                this, FormularioAlunosActivity.class
        ));
    }
}
