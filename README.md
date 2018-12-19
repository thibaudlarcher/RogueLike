# Rogue Like

### Principe
Petit jeu basé sur le principe du Rogue Like.

La carte du monde est basée sur une génération aléatoire. Vous pourrez explorer les pièces afin de trouver de l'équipements, des Objets
et des Monstres. Vous aurez la possibilité d'acheter ou de vendre vos items pour de l'argent.

Vous pouvez choisir parmis deux classes Mage ou Guerrier. (De nouvelles classes arriverons bientôt)

### Contrôle
-Pour ce déplacer utiliser ZQSD ou les fléches directionnelles.

-Pour le menu du jeu appuyer sur la touche echap. Vous pourrez alors sauvegarde acceder à votre inventaire ou quitter le jeu

-Pour ouvrir l'inventaire appuyer sur i.

-Lorsque vous serrez sur un objet appuyer sur p pour le mettre dans votre invenatire.

-Et pour plus de détaille appuyer sur H pour les aides
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
Attention, Maven peut avoir des difficultés avec un chemin qui possède un espace.
Il se peut que vous soyez obliger d'installer AsciiPannel. Des tutoriels sont disponible sur internet.

Bon amusement.