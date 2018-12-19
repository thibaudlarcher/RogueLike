package object;

import object.Items.*;

/**
 * Classe pour gérer l'inventaire du personnage.
 */
public class Inventory {

    /**
     * Un tableau d'item pour stocker les items du personnage.
     */
    private Item[] items;

    /**
     * La taille max de l'inventaire.
     */
    private int max;


    /**
     * Attribut pour gérer si un item casque est équipé ou non.
     */
    private boolean casque;

    /**
     * @return vrai ou faux selon si un item casque est équipé ou non.
     */
    public boolean getCasqueEquipe(){ return this.casque; }

    /**
     * Attribut pour gérer si un item armure est équipé ou non.
     */
    private boolean armure;

    /**
     * @return vrai ou faux selon si un item armure est équipé ou non.
     */
    public boolean getArmureEquipe(){ return this.armure; }

    /**
     * Attribut pour gérer si un item pantalon est équipé ou non.
     */
    private boolean pantalon;

    /**
     * @return vrai ou faux selon si un item pantalon est équipé ou non.
     */
    public boolean getPantalonEquipe(){ return this.pantalon; }

    /**
     * Attribut pour gérer si un item botte est équipé ou non.
     */
    private boolean botte;

    /**
     * @return vrai ou faux selon si un item botte est équipé ou non.
     */
    public boolean getBotteEquipe(){ return this.botte; }

    /**
     * Attribut pour gérer si un item arme est équipé ou non.
     */
    private boolean arme;

    /**
     * @return vrai ou faux selon si un item arme est équipé ou non.
     */
    public boolean getArmeEquipe(){ return this.arme; }

    /**
     * Attribut pour gérer la monnaie du personnage.
     */
    private int monnaie;

    /**
     * @return la monnaie du personnage.
     */
    public int getMonnaie(){ return this.monnaie; }

    /**
     * Méthode pour définir la monnaie du personnage.
     * @param monnaie le nouveau montant de la monnaie du personnage.
     */
    public void setMonnaie(int monnaie){ this.monnaie = monnaie; }

    /**
     * Méthode pour ajouter de la monnaie.
     * @param gain le gain du personnage.
     */
    public void addMonnaie(int gain){ this.monnaie = this.monnaie + gain; }

    /**
     * Méthode pour retirer de la monnaie .
     * @param prix le prix a retirer.
     */
    public void removeMonnaie(int prix){ this.monnaie = this.monnaie - prix; }

    /**
     * @return le tableau d'item.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     *
     * @param i l'indice du tableau.
     * @return l'item situé à l'indice i du tableau d'item.
     */
    public Item get(int i) {
        return items[i];
    }

    /**
     * Constructeur de la classe
     * @param max la taille max du tableau et donc de l'inventaire.
     */
    public Inventory(int max) {
        this.max = max;
        items = new Item[max];
        this.casque = false;
        this.armure = false;
        this.pantalon = false;
        this.botte = false;
        this.arme = false;
    }

    /**
     * Méthode pour définir si un item casque est équipé ou non.
     * @param e vrai ou faux selon si un item casque est équipé ou non.
     */
    public void setCasqueEquipe(boolean e){
        this.casque = e;
    }

    /**
     * Méthode pour définir si un item armure est équipé ou non.
     * @param e vrai ou faux selon si un item armure est équipé ou non.
     */
    public void setArmureEquipe(boolean e){
        this.armure = e;
    }

    /**
     * Méthode pour définir si un item pantalon est équipé ou non.
     * @param e vrai ou faux selon si un item pantalon est équipé ou non.
     */
    public void setPantalonEquipe(boolean e){
        this.pantalon = e;
    }

    /**
     * Méthode pour définir si un item botte est équipé ou non.
     * @param e vrai ou faux selon si un item botte est équipé ou non.
     */
    public void setBotteEquipe(boolean e){
        this.botte = e;
    }

    /**
     * Méthode pour définir si un item arme est équipé ou non.
     * @param e vrai ou faux selon si un item arme est équipé ou non.
     */
    public void setArmeEquipe(boolean e){
        this.arme = e;
    }

    /**
     * Méthode pour ajouter un item dans le tableau et donc dans l'inventaire.
     * @param item l'item a ajouter.
     */
    public void add(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * @return la taille max de l'inventaire.
     */
    public int getSizeMax(){
        return this.max;
    }

    /**
     * Méthode pour supprimer un item de l'inventaire.
     * @param item l'item a supprimer.
     */
    public void remove(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = null;
            }
        }
    }

    /**
     * Méthode pour savoir si l'inventaire est plein ou non.
     * @return vrai ou faux selon si l'inventaire est plein ou non.
     */
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

    /**
     * Méthode pour connaitre le nombre d'item dans l'inventaire.
     * @return le nombre d'item présent dans l'inventaire.
     */
    public int getSize(){
        int size = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                size++;
            }
        }
        return size;
    }

    /**
     * @return l'indice max du dernier item.
     */
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

    /**
     * Méthode pour supprimer tout les items presents dans l'inventaire.
     */
    public void removeAllItem(){
        for (int i = 0; i < items.length; i++) {
                items[i] = null;
            }
        }

}



