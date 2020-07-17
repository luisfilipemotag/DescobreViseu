package com.example.chip.descobreviseu;

import java.util.ArrayList;

/**
 * Created by Chip on 02/05/2017.
 */

public class Model {
    public static ArrayList<Item> items;
    public Model(){
        this.items=new ArrayList<Item>();
    }
    public static void LoadModel(){
        items=new ArrayList<Item>();
    }
    public static void SetItem( int id , String nome , String imagem){
       items.add(new Item(id, nome, imagem));
    }

    public static void SetItem(Item item) {
        items.add(item);
    }
    public static Item getItem(int i){
        return items.get(i);
    }
}
