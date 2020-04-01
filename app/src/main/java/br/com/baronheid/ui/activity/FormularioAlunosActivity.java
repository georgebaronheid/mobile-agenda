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

    //        Foi criado um DAO para transportar o dado persistido de uma view para a outra
    private final AlunoDao dao = new AlunoDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_FORMULARIO_ALUNOS);

//        O Set title define o nome da AppBar
        setTitle(APPBAR_NAME);


        /**
         * Os atributos que estão com final são para permitir acesso a eles a partir de uma
         * execução da lógica localmente dentro do ClickListener.
         */
        instanciaCampos();

        /**
         * O método a seguir requer a implementação de uma interface de View.
         *
         * O override de onClick acessará os dados de cada EditText, permitindo sua manipulação
         * e criação de objeto de Aluno com os dados pertinentes.
         */
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

        /**
         * Diferentemente do método startActivity, o método abaixo matará a Activity atual,
         * trigando o onResume da Activity anterior
         */
        finish();
    }

    private void instanciaCampos() {
        botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);

        nomeAluno = findViewById(R.id.activity_formulario_alunos_nome);
        telefoneAluno = findViewById(R.id.activity_formulario_alunos_telefone);
        emailAluno = findViewById(R.id.activity_formulario_alunos_email);
    }
}
