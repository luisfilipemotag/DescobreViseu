package com.example.chip.descobreviseu;

import java.util.ArrayList;

/**
 * Created by Chip on 02/05/2017.
 */

public class ModelP1 {
    public static ArrayList<Item> items;
    public ModelP1(){
        this.items=new ArrayList<Item>();
    }
    public static void LoadModelP1(){
        items=new ArrayList<Item>();
    }
    public static void SetItemP1( int id , String nome , String imagem){
       items.add(new Item(id, nome, imagem));
    }

    public static void SetItemP1(Item item) {
        items.add(item);
    }
    public static Item getItemP1(int i){
        return items.get(i);
    }
}
