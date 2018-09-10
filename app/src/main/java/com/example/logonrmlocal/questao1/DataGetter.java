package com.example.logonrmlocal.questao1;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String> {

    private TextView txtTitle;
        private TextView txtCompleted;

    public DataGetter(TextView txtTitle, TextView txtCompleted) {
        this.txtTitle = txtTitle;
        this.txtCompleted = txtCompleted;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        try
        {
            // jsonObject A BAIXO É UM OBJETO COMO:
            //
            //  {
            //    "userId": 1,
            //    "id": 1,
            //    "title": "delectus aut autem",
            //    "completed": false
            //  }

            JSONObject jsonObject = new JSONObject(s);


            // A BAIXO SÃO RECUPERADOS OS VALORES ATRELADOS A CADA CHAVE
            // E CONVERTIDOS PARE SEUS RESPECTIVOS TIPOS

            //     CHAVE     |         VALOR
            //  "userId"     |  1
            //  "id"         |  1
            //  "title"      |  "delectus aut autem"
            //  "completed"  |  false

            String title = jsonObject.getString("title");
            boolean completed = jsonObject.getBoolean("completed");


            // A BAIXO OS VALORES RECUPERADOS SÃO ATRIBUIDOS A SUA RESPECTIVA TEXTVIEW
            txtTitle.setText(title);
            txtCompleted.setText(String.valueOf(completed));

        }
        catch(JSONException e){
            //CASO OCORRA ALGUM ERRO NO JSON A TEXTVIEW txtTitle RECEBE E MOSTRA O ERRO
            this.txtTitle.setText(e.toString());
        }
    }
}

