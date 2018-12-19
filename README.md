# Rogue Like

### Principe
Petit jeu basé sur le principe du Rogue Like.

La carte du monde est basée sur une génération aléatoire. La carte du village également. Vous pourrez explorer les pièces afin de trouver de l'équipements, des Objets
et des Monstres. Vous aurez la possibilité d'acheter ou de vendre vos items pour de l'argent.

Les monstres sont générés aléatoirement dans les salles, cependant ils ne peuvent pas apparaitre dans la salle ou spawn votre personnage.
Il est possible qu'aucun monstre n'apparaisse dans un niveau.

Les items sont également générés de manière aléatoire, mais contrairement aux monstres, il y a un item par salle qui est généré.

Vous pouvez choisir parmis deux classes Mage ou Guerrier. (De nouvelles classes arriverons bientôt)

Le but étant d'atteindre le niveau **99** et de le finir pour gagner.

Pour passer d'un niveau à l'autre, vous devez emprunter le portail rouge de sortie.

Il y a également sur la map un portail bleu qui vous mènera au village, où vous pourrez allez parler au villageois (représenté par un *v*) afin de vendre ou acheter des items.

### Contrôles
- Pour vous déplacer utiliser ZQSD ou les flèches directionnelles.

- Pour le menu du jeu appuyer sur la touche escape. Vous pourrez alors sauvegarder votre partie, accéder à votre inventaire, relancer une nouvelle partie ou quitter le jeu.

- Pour ouvrir l'inventaire appuyer sur la touche I.

- Lorsque vous serez sur un objet appuyer sur la touche P pour le prendre et le placer dans votre invenataire.

- Vous pouvez accéder à l'écran d'aide en appuyant sur la touche H ou en passant par le menu.
### Installation
Télécharger ou cloner le répértoire.
Allez dans le répertoire et taper la commande :
```
mvn package
```
Pour finir, lancer le jeux avec la commande :
```
java -jar target/RogueLike-1.0-SNAPSHOT.jar
```
Attention, Maven peut avoir des difficultés avec un chemin qui possède un ou plusieurs espace.
Il se peut que vous soyez obliger d'installer AsciiPannel. Des tutoriels sont disponible sur internet.

Bon amusement.