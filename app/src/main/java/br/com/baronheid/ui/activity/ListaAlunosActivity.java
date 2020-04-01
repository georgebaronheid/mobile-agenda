package br.com.baronheid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.baronheid.R;
import br.com.baronheid.dao.AlunoDao;


public class ListaAlunosActivity extends AppCompatActivity {

    public static final String APPBAR_NAME = "Lista de Alunos";

    public static final int ACTIVITY_LISTA_ALUNOS = R.layout.activity_lista_alunos;

    private FloatingActionButton botaoAdicionar;

    private ListView listaDeAlunos;

    private final AlunoDao alunos = new AlunoDao();


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

        listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        carregaListaAlunos();

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
                alunos.todos()));
    }

    private void iniciaActivity() {
        startActivity(new Intent(
                this, FormularioAlunosActivity.class
        ));
    }
}
