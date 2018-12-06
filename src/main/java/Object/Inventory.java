package Object;

import Object.Items.*;

public class Inventory {
    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public Item get(int i) {
        return items[i];
    }

    public Inventory(int max) {
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



