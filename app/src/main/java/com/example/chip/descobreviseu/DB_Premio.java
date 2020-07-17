package com.example.chip.descobreviseu;

/**
 * Created by Chip on 27/02/2017.
 */

public class DB_Premio {
    int id_Premio;
    int pontos_P;
    int quantidade;
    int estado;
    String nome_Premio;

public DB_Premio(){
    }

    //contrutor
public DB_Premio(int id_Premio, int pontos_P ,int quantidade ,int estado ,String nome_Premio){
    this.id_Premio=id_Premio;
    this.pontos_P=pontos_P;
    this.quantidade=quantidade;
    this.estado=estado;
    this.nome_Premio=nome_Premio;
    }

    // set
    public void setId_Premio(int id_premio){ this.id_Premio= id_premio;}
    public void setPontos_P(int pontos_P){this.pontos_P=pontos_P;}
    public void setQuantidade(int quantidade){this.quantidade=quantidade;}
    public void setEstado(int estado){ this.estado=estado;}
    public void setNome_Premio(String nome_Premio){ this.nome_Premio=nome_Premio;}

    // get
    public int getId_Premio(){ return this.id_Premio;}
    public int getPontos_P(){return this.pontos_P;}
    public int getQuantidade(){return this.quantidade;}
    public int getEstado(){ return this.estado;}
    public  String getNome_Premio(){return this.nome_Premio;}

}
