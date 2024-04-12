package com.example.gerenciadordeprovasdeconcursos;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class ProvasDAO {
    private Context context;
    private SQLiteDatabase database;
    public ProvasDAO(Context context){
        this.context= context;
        this.database=(new Database(context)).getWritableDatabase();

    }
    public ArrayList<Provas> getList(){
        ArrayList<Provas> result= new ArrayList<Provas>();
        String sql= "SELECT * FROM provas ORDER BY empresa";
        Cursor cursor= database.rawQuery(sql,null);

        while (cursor.moveToNext()){
            int id= cursor.getInt(0);
            String empresa= cursor.getString(1);
            String orgaoPublico= cursor.getString(2);
            String estado= cursor.getString(3);
            String ano= cursor.getString(4);
            String nivel= cursor.getString(5);
            String cargo= cursor.getString(6);
            result.add(new Provas(id, empresa, orgaoPublico, estado, ano, nivel, cargo));
        }
        return result;
    }
    public boolean add(Provas provas){
        String sql= "INSERT INTO provas VALUES (NULL,"
                + "'" + provas.getEmpresa()+ "',"
                + "'" + provas.getOrgaoPublico()+ "',"
                + "'" + provas.getEstado()+ "',"
                + "'" + provas.getAno()+ "',"
                + "'" + provas.getNivel()+ "',"
                +"'" + provas.getCargo()+ "')";
        try{
            database.execSQL(sql);
            Toast.makeText(context, "Prova salva!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM provas WHERE id= " + id;
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Prova excluída!", Toast.LENGTH_SHORT).show();
            return true;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao excluir prova: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public boolean update(Provas provas){
        String sql= "UPDATE provas SET "
                + "empresa='" + provas.getEmpresa()+ "', "
                + "orgaoPublico='" + provas.getOrgaoPublico()+ "', "
                + "estado='" + provas.getEstado()+ "', "
                + "ano='" + provas.getAno()+ "', "
                + "nivel='" + provas.getNivel()+ "', "
                + "cargo='" + provas.getCargo()+ "' "
                + "WHERE id=" + provas.getId();
        try{
            database.execSQL(sql);
            Toast.makeText(context, "Prova atualizada!", Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (SQLException e){
            Toast.makeText(context, "Erro! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public Provas get(int id){
        String sql = "SELECT * FROM provas WHERE id=" + id;
        Cursor cursor = database.rawQuery(sql, null);

        if(cursor.moveToNext()){
            String empresa= cursor.getString(1);
            String orgaoPublico= cursor.getString(2);
            String estado= cursor.getString(3);
            String ano= cursor.getString(4);
            String nivel= cursor.getString(5);
            String cargo= cursor.getString(6);
            return new Provas(id,empresa,orgaoPublico,estado,ano,nivel,cargo);

        }
        return null;
    }
}
