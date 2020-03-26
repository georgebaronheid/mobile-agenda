package br.com.baronheid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>(Arrays.asList(
                "George",
                "Isabela",
                "Paula"
        ));

        TextView primeiroAluno = findViewById(R.id.textView);
        TextView segundoAluno = findViewById(R.id.textView2);
        TextView terceiroAluno = findViewById(R.id.textView3);

        primeiroAluno.setText(alunos.get(0));
        segundoAluno.setText(alunos.get(1));
        terceiroAluno.setText(alunos.get(2));

    }
}
