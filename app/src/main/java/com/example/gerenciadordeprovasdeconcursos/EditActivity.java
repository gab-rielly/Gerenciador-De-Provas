package com.example.gerenciadordeprovasdeconcursos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditActivity extends AppCompatActivity {
    private ProvasDAO provasDAO;
    private int provaId;
    private TextView editEmpresa, editOrgaoPublico, editEstado, editAno, editNivel, editCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editEmpresa= findViewById(R.id.addEmpresa);
        editOrgaoPublico= findViewById(R.id.addOrgaoPublico);
        editEstado=findViewById(R.id.addEstado);
        editAno=findViewById(R.id.addAno);
        editNivel=findViewById(R.id.addNivel);
        editCargo= findViewById(R.id.addCargo);
        provasDAO= new ProvasDAO(this);

        Intent intent= getIntent();
        provaId= intent.getIntExtra("provaId", -1);

        if(provaId!= -1){
            Provas provas= provasDAO.get(provaId);
            editEmpresa.setText(provas.getEmpresa());
            editOrgaoPublico.setText(provas.getOrgaoPublico());
            editEstado.setText(provas.getEstado());
            editAno.setText(provas.getAno());
            editNivel.setText(provas.getNivel());
            editCargo.setText(provas.getCargo());
        }
    }
    public void salvarClicado(View view){
        Provas provas= new Provas(provaId, editEmpresa.getText() .toString(),
                editOrgaoPublico.getText() .toString(), editEstado.getText() .toString(),
                editAno.getText() .toString(), editNivel.getText() .toString(),
                editCargo.getText() .toString());
        boolean result;
        if(provaId== -1){
            result= provasDAO.add(provas);
        }else{
            result=provasDAO.update(provas);
        }
        if(result){
            finish();
        }
    }
    public void deleteClick(View view){
        boolean result;
        if(provaId != -1){ // Ensure provaId is valid
            result = provasDAO.delete(provaId);
            if(result){
                finish();
            }
        }
    }

}