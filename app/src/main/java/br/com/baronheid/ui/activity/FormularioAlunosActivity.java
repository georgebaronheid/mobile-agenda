package br.com.baronheid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.baronheid.R;
import br.com.baronheid.dao.AlunoDao;
import br.com.baronheid.model.Aluno;

public class FormularioAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_alunos);

//        O Set title define o nome da AppBar
        setTitle("Novo Aluno");

//        Foi criado um DAO para transportar o dado persistido de uma view para a outra
        final AlunoDao dao = new AlunoDao();

        /**
         * Os atributos que estão com final são para permitir acesso a eles a partir de uma
         * execução da lógica em localmente dentro do ClickListener.
         */
        final Button botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);

        final EditText nomeAluno = findViewById(R.id.activity_formulario_alunos_nome);
        final EditText telefoneAluno = findViewById(R.id.activity_formulario_alunos_telefone);
        final EditText emailAluno = findViewById(R.id.activity_formulario_alunos_email);

        /**
         * O método a seguir requer a implementação de uma interface de View.
         *
         * O override de onClick acessará os dados de cada EditText, permitindo sua manipulação
         * e criação de objeto de Aluno com os dados pertinentes.
         */
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nome = nomeAluno.getText().toString();
                String telefone = telefoneAluno.getText().toString();
                String email = emailAluno.getText().toString();

                Aluno novoAluno = new Aluno(nome, telefone, email);

                dao.salva(novoAluno);

                /**
                 * startActivity é um método do Android que permite circulação entre Views
                 * no Android, carregando consigo o contexto e informando a View destino
                 * por meio de uma interface Intent.
                 */
                startActivity(new Intent(
                        FormularioAlunosActivity.this, ListaAlunosActivity.class));
            }
        });

    }
}
