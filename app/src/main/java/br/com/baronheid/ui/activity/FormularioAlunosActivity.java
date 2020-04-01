package br.com.baronheid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.baronheid.R;
import br.com.baronheid.dao.AlunoDao;
import br.com.baronheid.model.Aluno;

public class FormularioAlunosActivity extends AppCompatActivity {

    public static final String APPBAR_NAME = "Novo Aluno";

    public static final int ACTIVITY_FORMULARIO_ALUNOS = R.layout.activity_formulario_alunos;

    private Button botaoSalvar;

    private EditText nomeAluno;

    private EditText telefoneAluno;

    private EditText emailAluno;

    private final AlunoDao dao = new AlunoDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_FORMULARIO_ALUNOS);

        setTitle(APPBAR_NAME);

        instanciaCampos();

        configuraFabSalvarAluno();

    }

    private void configuraFabSalvarAluno() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                salvaAluno();
            }
        });
    }

    private void salvaAluno() {
        String nome = nomeAluno.getText().toString();
        String telefone = telefoneAluno.getText().toString();
        String email = emailAluno.getText().toString();

        Aluno novoAluno = new Aluno(nome, telefone, email);

        dao.salva(novoAluno);

        finish();
    }

    private void instanciaCampos() {
        botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);

        nomeAluno = findViewById(R.id.activity_formulario_alunos_nome);
        telefoneAluno = findViewById(R.id.activity_formulario_alunos_telefone);
        emailAluno = findViewById(R.id.activity_formulario_alunos_email);
    }
}
