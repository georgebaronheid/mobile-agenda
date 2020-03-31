package br.com.baronheid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.baronheid.R;
import br.com.baronheid.model.Aluno;

public class FormularioAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_alunos);
        setTitle("Novo Aluno");

        final Button botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);

        final EditText nomeAluno = findViewById(R.id.activity_formulario_alunos_nome);
        final EditText telefoneAluno = findViewById(R.id.activity_formulario_alunos_telefone);
        final EditText emailAluno = findViewById(R.id.activity_formulario_alunos_email);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nome = nomeAluno.getText().toString();
                String telefone = telefoneAluno.getText().toString();
                String email = emailAluno.getText().toString();

                Aluno novoAluno = new Aluno(nome, telefone, email);

                Toast.makeText(FormularioAlunosActivity.this,
                        "Arroz",
                        Toast.LENGTH_LONG);
            }
        });

    }
}
