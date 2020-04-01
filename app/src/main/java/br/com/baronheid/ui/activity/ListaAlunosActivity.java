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
    //        O DAO será responsável por carregar os dados com sua lista estática
    private final AlunoDao alunos = new AlunoDao();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(APPBAR_NAME);

//        Referencia a view de conteudo estática utilizando o layout
        setContentView(ACTIVITY_LISTA_ALUNOS);

        botaoAdicionar = findViewById(R.id.activity_main_fab_novo_aluno);
        configuraFabOnClick();

    }

    /**
     * O método onResume é importante no ciclo de vida das Views.
     * Ele define o que será realizado quando esta View for retomada, como acontecerá quando
     * o método finish() for chamado na view de formulário.
     */
    @Override
    protected void onResume() {
        super.onResume();


//        List view permite que a renderização da lista seja dinâmica
        listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        carregaListaAlunos();

    }

    private void configuraFabOnClick() {
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaActivity();
            }
        });
    }

    private void carregaListaAlunos() {
        /** Não é possivel dar 'add' ou 'set' em um List View. É necessário o uso de um adapter.
         * O ArrayAdapter é uma implementação facilitada em casos de iteração de listas, e é
         * necessário o uso do R do Android, não o local, buscando um layout que represente um id
         * int.
         */
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
