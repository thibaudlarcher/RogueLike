package creature;
import java.awt.Color;
import object.*;
import object.Items.Item;
//import world.World;

/**
 * Classe abstraite des Creatures.
 *
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public abstract class Creature {
    //private World world;
    /**
     * Permet de gérer l'inventaire.
     */
    protected Inventory inventory;

    /**
     * Permet de créer une instance d'inventaire pour les Créatures.
     * @return inventory
     */
    public Inventory inventory() {
        return inventory;
    }

    /**
     * Elle permet de récupérer les coordonnées x du player.
     */
    public int x;

    /**
     * Elle permet de récupérer les coordonnées y du player.
     */
    public int y;

    /**
     * Nom de la Créature
     */
    protected String name;

    /**
     * Permet de récupérer le nom de la créature.
     * @return nom
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de modifier le nom.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Représente le caractère de représentation de la créature en particulier.
     */
	protected char glyph;

    /**
     * Permet de récupérer la glyph.
     * @return glyph
     */
    public char getGlyph() {
        return glyph;
    }

    /**
     * permet de modifier le caractère de réprésentation de la créature en particulier.
     * @param glyph glyph
     */
    public void setGlyph(char glyph) {
         this.glyph = glyph;
    }

    /**
     * Permet de stocker la couleur du caractère de la glyph.
     */
    protected Color color;

    /**
     * Permet de récupérer la couleur de la glyph.
     * @return Couleur
     */
    public Color getColor() {
        return color;
    }

    /**
     * Permet de stocker les point de vie maximum de la Créature.
     */
    protected int pointDeVieMax;

    /**
     * Elle permet de récupérer les point de vie maximum de la créature.
     * @return point de vie max
     */
    public int getPointDeVieMax() {
        return pointDeVieMax;
    }

    /**
     * Elle permet de modifier les points de vie maximum.
     * @param pointDeVieMax point de vie max
     */
    public void setPointDeVieMax(int pointDeVieMax) {
        this.pointDeVieMax = pointDeVieMax;
    }

    /**
     * Elle permet de stoker le niveau de la créature.
     */
    private int niveau;

    /**
     * Elle permet de récupérer le niveau de la créature.
     * @return niveau de la créature
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Elle permet de modifier la niveau de la créature.
     * @param niveau Niveau de la créature
     */
    public void setNiveau(int niveau){this.niveau = niveau;}

    /**
     * Permet de stocker les points de vie de la créature.
     */
    protected int pointDeVie;

    /**
     * Permet de récupérer les points de vie de la créature.
     * @return point de vie
     */
    public int getPointDeVie() {
        return pointDeVie;
    }

    /**
     * Permet de modifier les points de vie de de la créature.
     * @param pointDeVie points de vie
     */
    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    /**
     * Fonction qui modifie les point de vie en fonction des point de vie max de la créature.
     * Elle va ajouter la valeur au point de vie déjà présent sans dépasser les points de vie max.
     * @param modif valeur de la modification des points de vie
     */
    public void modifPointDeVie(int modif){
        if (this.pointDeVie < this.pointDeVieMax) {
            if (this.pointDeVie + modif > 20) {
                this.pointDeVie = this.pointDeVieMax;
            } else { this.pointDeVie = this.pointDeVie + modif; }
        }
    }

    /**
     * Permet de stocker la défense d'une créature.
     */
    protected int defense;

    /**
     * Permet de récupérer la défense de la créature.
     * @return valeur de défense de la créature
     */
    public int getDefense(){ return this.defense; }

    /**
     * Permet de modifier la défense d'une créature.
     * @param modif valeur de défense a ajouter à la valeur de base.
     */
    public void modifDefense(int modif){
        this.defense = this.defense + modif;
    }

    /**
     * Permet de stocker l'attaque physique de la créature.
     */
    protected int attaque;

    /**
     * Permet de récupérer l'attaque physique de la créature.
     * @return valeur de l'attaque physique
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Permet de modifier la valeur de l'attaque physique de la créature.
     * @param attaque valeur de l'attaque physique
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    /**
     * Permet de stocker la valeur de l'attaque magique.
     */
    protected int magicattaque;

    /**
     * Permet de récupérer la valeur de l'attaque magique de la créature.
     * @return valeur de l'attaque magique
     */
    public int getmagicattaque() {
        return magicattaque;
    }

    /**
     * Permet de modifier la valeur de l'attaque magique de la créature.
     * @param magicattaque valeur de l'attaque magique de la créature
     */
    public void setmagicattaque(int magicattaque) {
        this.magicattaque = magicattaque;
    }

    /**
     * Permet de modifier la valeur de l'attaque physique en ajoutant un valeur a cette dernière.
     * @param modif valeur a ajouter
     */
    public void modifAttaque(int modif){
        this.attaque = this.attaque + modif;
    }

    /**
     * Permet de stocker la vitesse de la créature.
     */
    protected int vitesse;

    /**
     * Permet de récupérer la valeur de la vitesse de la créature.
     * @return valeur de la vitesse de la créature
     */
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Permet de modifier la valeur de la vitesse de la créature.
     * @param vitesse valeur de la vitesse de la créature
     */
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Permet d'ajouter la valeur de la vitesse a l'ancienne valeur de la vitesse de la créature.
     * @param vitesse valeur d'ajout de la vitesse
     */
    public void modifVitesse(int vitesse){
        this.vitesse = vitesse;
    }

    /**
     * Permet de stocker le tour ou se trouve la créature dans un combat.
     */
    protected int tour;

    /**
     * Permet de récupérer le tour de jeux de la créature.
     * @return valeur du tour
     */
    public int getTour() {
        return tour;
    }

    /**
     * Permet de modifier un tour de jeux de la créature.
     * @param tour valeur du tour de jeux
     */
    public void setTour(int tour) {
        this.tour = tour;
    }

    /**
     * Permet de mettre à jour la valeur du tour de jeux de la créature.
     */
    public void updateTour() {
        this.setTour(tour+vitesse);
    }

    /**
     * Permet de faire des dommages physique à une créature.
     * Si la valeur du dommage est supérieure à celle de la vie on ne deal pas la totalité des dommages.
     * @param Crea Créature
     */
    public void dealDamageTo(Creature Crea){
        if (Crea.getDefense() - this.getAttaque() < 0) {
            Crea.setPointDeVie((Crea.getPointDeVie() + Crea.getDefense()) - this.getAttaque());
            this.setTour(0);
        }
    }

    /**
     * Permet de faire des dommages magique à une créature.
     * Si la valeur du dommage est supérieure à celle de la vie on ne deal pas la totalité des dommages.
     * @param Crea Créature
     */
    public void dealDamageToMagic(Creature Crea){
        if (Crea.getDefense() - this.getmagicattaque() < 0) {
            Crea.setPointDeVie((Crea.getPointDeVie() + Crea.getDefense()) - this.getmagicattaque());
            this.setTour(0);
        }
    }

    /**
     * Permet de savoir si une créature est morte.
     * @return vrais ou faux
     */
    public boolean isDead() {
        if(this.getPointDeVie() < 0) return true;
        return false;
    }

    /**
     * Permet de récupérer l'item
     * @param item item
     */
    public abstract void pickupItem(Item item);

    /**
     * Permet de lacher l'item
     * @param item
     */
    public abstract void dropItem(Item item);
}

