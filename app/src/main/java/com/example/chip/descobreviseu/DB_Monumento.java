package com.example.chip.descobreviseu;

/**
 * Created by Chip on 27/02/2017.
 */

public class DB_Monumento {
    int ID_monumento;
    int Pontos_M;
    int Cod_Scan;
    String Nome_m;
    String Descricao;
    String Latitude;
    String Longitude;
    int Estado_Visita;
    public DB_Monumento(){

    }
    //construtor
    public DB_Monumento(int ID_monumento, int Pontos_M, int Cod_Scan,String Nome_m,String Descricao,String Latitude, String Longitude,int Estado_Visita){

        this.ID_monumento=ID_monumento;
        this.Pontos_M=Pontos_M;
        this.Cod_Scan=Cod_Scan;
        this.Nome_m=Nome_m;
        this.Descricao=Descricao;
        this.Latitude=Latitude;
        this.Longitude=Longitude;
        this.Estado_Visita=Estado_Visita;
    }
    //set
    public void setID_monumento(int ID_monumento){this.ID_monumento=ID_monumento;}
    public void setPontos_M(int Pontos_M){this.Pontos_M=Pontos_M;}
    public void setCod_Scan(int Cod_Scan){this.Cod_Scan=Cod_Scan;}
    public void setNome_m(String Nome_m){this.Nome_m=Nome_m; }
    public void setDescricao(String Descricao){ this.Descricao=Descricao;}
    public void setLatitude(String Latitude){this.Latitude=Latitude; }
    public void setLongitude(String Longitude){ this.Longitude=Longitude; }
    public void setEstado_Visita(int Estado_Visita){this.Estado_Visita=Estado_Visita;}
    //get
    public int getID_monumento(){return  this.ID_monumento;}
    public int getPontos_M(){return this.Pontos_M;}
    public int getCod_Scan(){return  this.Cod_Scan;}
    public String getNome_m(){return  this.Nome_m;}
    public String getDescricao(){return  this.Descricao;}
    public String getLatitude(){return  this.Latitude;}
    public String getLongitude(){return  this.Longitude;}
    public int getEstado_Visita(){return  this.Estado_Visita;}
}
