package com.example.logonrmlocal.questao1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doPesquisar(View view){

        // URL PARA CONSUMO DA API REST
        String url = "https://jsonplaceholder.typicode.com/todos/";

        // O ID DESEJADO É INCLUSO NO URL
        EditText edtId = findViewById(R.id.edtId);
        url += edtId.getText().toString();

        // ATRELA-SE OS TEXTVIEWS DO CODIGO AOS DA ACTIVITY
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtCompleted = findViewById(R.id.txtCompleted);

        //SOLICITA A BUSCA NA URL
        new DataGetter(txtTitle,txtCompleted).execute(url);

        //SELECIONA O ID DIGITADO PARA FACILITAR ALTERAÇÃO
        edtId.selectAll();
    }
}
