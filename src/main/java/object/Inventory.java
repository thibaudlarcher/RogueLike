package object;

import object.Items.*;

public class Inventory {
    private Item[] items;
    private int max;

    private boolean casque;
    public boolean getCasqueEquipe(){ return this.casque; }

    private boolean armure;
    public boolean getArmureEquipe(){ return this.armure; }

    private boolean pantalon;
    public boolean getPantalonEquipe(){ return this.pantalon; }

    private boolean botte;
    public boolean getBotteEquipe(){ return this.botte; }

    private boolean arme;
    public boolean getArmeEquipe(){ return this.arme; }

    private int monnaie;
    public int getMonnaie(){ return this.monnaie; }
    public void setMonnaie(int monnaie){ this.monnaie = monnaie; }
    public void addMonnaie(int gain){ this.monnaie = this.monnaie + gain; }
    public void removeMonnaie(int prix){ this.monnaie = this.monnaie - prix; }

    public Item[] getItems() {
        return items;
    }

    public Item get(int i) {
        return items[i];
    }

    public Inventory(int max) {
        this.max = max;
        items = new Item[max];
        this.casque = false;
        this.armure = false;
        this.pantalon = false;
        this.botte = false;
        this.arme = false;
    }

    public void setCasqueEquipe(boolean e){
        this.casque = e;
    }

    public void setArmureEquipe(boolean e){
        this.armure = e;
    }

    public void setPantalonEquipe(boolean e){
        this.pantalon = e;
    }

    public void setBotteEquipe(boolean e){
        this.botte = e;
    }

    public void setArmeEquipe(boolean e){
        this.arme = e;
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

    public void removeAllItem(){
        for (int i = 0; i < items.length; i++) {
                items[i] = null;
            }
        }

}



