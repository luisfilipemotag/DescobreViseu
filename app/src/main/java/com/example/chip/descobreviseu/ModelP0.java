package com.example.chip.descobreviseu;

import java.util.ArrayList;

/**
 * Created by Chip on 02/05/2017.
 */

public class ModelP0 {
    public static ArrayList<Item> items;
    public ModelP0(){
        this.items=new ArrayList<Item>();
    }
    public static void LoadModelP0(){
        items=new ArrayList<Item>();
    }
    public static void SetItemP0( int id , String nome , String imagem){
       items.add(new Item(id, nome, imagem));
    }

    public static void SetItemP0(Item item) {
        items.add(item);
    }
    public static Item getItemP0(int i){
        return items.get(i);
    }
}
