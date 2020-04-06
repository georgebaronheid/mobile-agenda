package br.com.baronheid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.baronheid.R;
import br.com.baronheid.dao.AlunoDao;
import br.com.baronheid.model.Aluno;

import static br.com.baronheid.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class FormularioAlunosActivity extends AppCompatActivity {

    private static final String APPBAR_NAME_NOVO = "Novo Aluno";

    public static final int ACTIVITY_FORMULARIO_ALUNOS = R.layout.activity_formulario_alunos;
    public static final String APPBAR_NAME_EDITAR = "Editar Aluno";

    private Button botaoSalvar;

    private EditText nomeAluno;

    private EditText telefoneAluno;

    private EditText emailAluno;

    private final AlunoDao dao = new AlunoDao();

    private Aluno aluno = null;
    private String nome;
    private String telefone;
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_FORMULARIO_ALUNOS);


        instanciaCampos();

        botaoSalvar.setOnClickListener(configuraOnClickListener());

        aluno = getIntent().getParcelableExtra(CHAVE_ALUNO);
        if (aluno != null) {
            setTitle(APPBAR_NAME_EDITAR);
            preencheCamposAlunoExistente();
        } else setTitle(APPBAR_NAME_NOVO);


    }

    private View.OnClickListener configuraOnClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (aluno == null) {
                    preencheCamposNovos();
                    dao.salva(new Aluno(nome, email, telefone));
                } else {

                    preencheObjetoEditado();
                    dao.edita(aluno);
                }
                finish();
            }

        };
    }

    private void preencheObjetoEditado() {
        aluno.setNome(nomeAluno.getText().toString());
        aluno.setTelefone(telefoneAluno.getText().toString());
        aluno.setEmail(emailAluno.getText().toString());
    }

    private void preencheCamposNovos() {
        nome = nomeAluno.getText().toString();
        telefone = telefoneAluno.getText().toString();
        email = emailAluno.getText().toString();
    }

    private void preencheCamposAlunoExistente() {
        nomeAluno.setText(aluno.getNome());
        telefoneAluno.setText(aluno.getTelefone());
        emailAluno.setText(aluno.getEmail());
    }


    private void instanciaCampos() {
        botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);

        nomeAluno = findViewById(R.id.activity_formulario_alunos_nome);
        telefoneAluno = findViewById(R.id.activity_formulario_alunos_telefone);
        emailAluno = findViewById(R.id.activity_formulario_alunos_email);
    }


}
