package com.example.chip.descobreviseu;

/**
 * Created by Chip on 27/02/2017.
 */

public class DB_Turista {
    int ID_turista;
    int P_turista;
    String Nome;
    String Nacionalidade;

    //construtor
    public  DB_Turista(){
    }
    public  void DB_Turista(int ID_turista, int P_turista ,String Nome,String Nacionalidade){
        this.ID_turista=ID_turista;
        this.P_turista=P_turista;
        this.Nome=Nome;
        this.Nacionalidade=Nacionalidade;
    }

    //set
    public void setID_turista(int ID_turista){this.ID_turista=ID_turista;}
    public void setP_turista(int P_turista){this.P_turista=P_turista;}
    public void setNome(String Nome){this.Nome=Nome;}
    public void setNacionalidade(String Nacionalidade){this.Nacionalidade=Nacionalidade;}

    //get
    public int getID_turista(){return  this.ID_turista;}
    public int getP_turista(){return  this.P_turista;}
    public String getNome(){return  this.Nome;}
    public String getNacionalidade(){return  this.Nacionalidade;}
}
