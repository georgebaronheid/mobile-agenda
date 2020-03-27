package br.com.baronheid.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.baronheid.R;


public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos");

//        Referencia a view de conteudo estática utilizando o layout
        setContentView(R.layout.activity_lista_alunos);

        List<String> alunos = new ArrayList<>(Arrays.asList(
                "George",
                "Isabela",
                "Paula",
                "Glenda"
        ));

//        List view permite que a renderização da lista seja dinâmica
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        /** Não é possivel dar 'add' ou 'set' em um List View. É necessário o uso de um adapter
         * O ArrayAdapter é uma implementação facilitada em casos de iteração de listas, e é
         * necessário o uso do R do Android, não o local, buscando um layout que represente um id
         * int.
         */
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos));
    }

}
