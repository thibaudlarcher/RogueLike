package object;

import object.Items.*;

public class Inventory {
    private Item[] items;
    private int max;

    public Item[] getItems() {
        return items;
    }

    public Item get(int i) {
        return items[i];
    }

    public Inventory(int max) {
        this.max = max;
        items = new Item[max];
    }

    public void add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    public int getSizeMax(){
        return this.max;
    }

    public void remove(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = null;
            }
        }
    }

    public boolean isFull() {
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null)
                size++;
        }
        if (size == items.length) {
            return true;
        }
        return false;
    }

    public int getSize(){
        int size = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                size++;
            }
        }
        return size;
    }

    public int getIndiceMaxItem(){
        int max = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                if (i > max){
                    max = i;
                }
            }
        }
        return max;
    }

//    public boolean isEmpty() {
//        int size = 0;
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] != null)
//                size++;
//        }
//        if (size == 0) {
//            return true;
//        }
//        return false;
//    }
}



