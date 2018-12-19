package gameroots.mapgen.bsp;

import gameroots.mapgen.TileChar;
import gameroots.shared.geom.IntPoint;
import gameroots.shared.geom.IntRect;
import java.util.*;

/**
 * Classe de la création d'un Donjon
 *
 * @see CellNode
 * @author Groupe du InfinityRogue
 * @version Alpha 1.0
 */

public class BspMapCreator {

	/**
	 * Un nombre aléatoire calculer grâce au seed.
	 */
	static Random rnd = new Random();

	/**
	 * Permet de séparer les rooms.
	 */
	static int cellPad = 12;

	/**
	 * Séparer les nombre de cell en rooms.
	*/
	static int roomPad = 2;

	/**
	 * Largeur de la map.
	 */
	private int mapWidth;

	/**
	 * Hauteur de la map.
	 */
	private int mapHeight;

	/**
	 * Nombre d'itération pour le nombre de création de room sur la map.
	 */
	private int maxIterations;

	/**
	 * Taille minimum d'un room.
	 */
	private int minRoomSize;

	/**
	 * Permet de stocker les rooms avec leur tiles respectifs.
	 */
	private Map<IntPoint, Integer> roomsByTile;

	/**
	 * Permet de stocket les rooms dans une liste.
	 */
	private List<IntRect> rooms;

	/**
	 * Permet de stocket l'emplacement des rooms.
	 */
	private Map<Integer, IntRect> roomsByNumber;

	/**
	 * Constructeur de la classe prenant en paramètre la hauteur et la largeur.
	 * @param width Largeur
	 * @param height hauteur
	 */
	public BspMapCreator(int width, int height) {
		this();
		this.mapWidth = width;
		this.mapHeight = height;
	}

	/**
	 * Constructeur de la classe par défaut
	 */
	public BspMapCreator() {
		roomsByTile = new HashMap<>();
		roomsByNumber = new HashMap<>();
		rooms = new ArrayList<>();
	}

	/**
	 * Modifier le nombre maximum d'itération.
	 * @param maxIterations Nombre d'itération
	 */
	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	/**
	 * Permet de modifier la taille minimum des rooms.
	 * @param minRoomSize Valeur de la taille
	 */
	public void setMinRoomSize(int minRoomSize) {
		if (minRoomSize < 5) {
			throw new RuntimeException("Le minimum de la Room est de 5");
		}
		this.minRoomSize = minRoomSize;
	}

	/**
	 * Permet de modifier la taille de la map.
	 * @param mapWidth Largeur
	 * @param mapHeight Hauteur
	 */
	public void setMapDimension(int mapWidth, int mapHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
	}

	/**
	 * Permet de la création de la map de jeu.
	 * @return un tableau double entrées de caractères
	 */
	public char[][] createMap() {

		// Génération du BSP tree
		CellNode root = new CellNode(0, 0, mapWidth, mapHeight);
		root.width = mapWidth;
		root.height = mapHeight;
		splitCell(root, maxIterations);
		insertRooms(root);
		connectRooms(root);

		// Rend la map des caractères
		char[][] map = initMap();
		renderCorridors(map, root);
		renderRooms(map, root);
		renderWalls(map);
		renderDoors(map);
		renderPersonnage(map);
		renderItems(map);
		renderMonster(map);


		/*
		Il check si le sol des room est bien fait
		et il récupère les rooms avec leur caractères
		 */
		for (int i = 0; i < rooms.size(); i++) {
			IntRect room = rooms.get(i);
			//System.out.println(room);
			roomsByNumber.put(i, room);
			floodFill(map, room, i);
		}

		// Convertis le vide par du sol
		convertVoid(map);

//		for (int i = 0; i < mapWidth; i++){
//			for (int j = 0; j < mapHeight; j++){
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		return map;
	}

	/**
	 * Permet de la création de la map du village.
	 * @return Un tableau à double entrée
	 */
	public char[][] createMapVillage() {

		// Génération du BSP tree
		CellNode root = new CellNode(0, 0, mapWidth, mapHeight);
		root.width = mapWidth;
		root.height = mapHeight;
		splitCell(root, maxIterations);
		insertRooms(root);
		connectRooms(root);

		// Rend la map des caractères
		char[][] map = initMap();
		renderCorridors(map, root);
		renderRooms(map, root);
		renderWalls(map);
		renderDoors(map);
		renderPersonnage(map);
		renderVillageois(map);

		/*
		Il check si le sol des room est bien fait
		et il récupère les rooms avec leur caractères
		 */
		for (int i = 0; i < rooms.size(); i++) {
			IntRect room = rooms.get(i);
			//System.out.println(room);
			roomsByNumber.put(i, room);
			floodFill(map, room, i);
		}

		// Convertis le vide par du sol
		convertVoid(map);


		return map;
	}

	/**
	 * Permet de séparer les cellules de la map du jeu.
	 * @see CellNode
	 * @param parent représente une cellule
	 * @param maxDepth valeur maximum de la profondeur du parcours des cellules
	 */
	private void splitCell(CellNode parent, int maxDepth) {
		if (parent.depth < maxDepth && parent.width > 2 * cellPad && parent.height > 2 * cellPad) {
			int depth = parent.depth + 1;
			parent.horizontal = rnd.nextBoolean();

			if (parent.horizontal) {
				int split = cellPad + rnd.nextInt(parent.width - (2 * cellPad));
				parent.left = new CellNode(parent.x, parent.y, split + 1, parent.height);
				parent.right = new CellNode(parent.x + split, parent.y, parent.width - split, parent.height);
			}
			else {
				int split = cellPad + rnd.nextInt(parent.height - (2 * cellPad));
				parent.left = new CellNode(parent.x, parent.y, parent.width, split + 1);
				parent.right = new CellNode(parent.x, parent.y + split, parent.width, parent.height - split);
			}

			parent.right.depth = depth;
			parent.left.depth = depth;

			splitCell(parent.left, maxDepth);
			splitCell(parent.right, maxDepth);
		}
	}

	/**
	 * Insertion des rooms
	 * @param node cellule
	 */
	private void insertRooms(CellNode node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			int maxRoomWidth = node.width - (2 * roomPad);
			int maxRoomHeight = node.height - (2 * roomPad);
			if (maxRoomWidth >= minRoomSize && maxRoomHeight >= minRoomSize) {
				int roomWidth = minRoomSize + rnd.nextInt(maxRoomWidth - minRoomSize);
				int roomHeight = minRoomSize + rnd.nextInt(maxRoomHeight - minRoomSize);

				// Il commence au centre de la cellule pour être sur que les couloirs touche les rooms
				int hx = node.x + node.width / 2;
				int hy = node.y + node.height / 2;

				int x = hx - roomWidth / 2;
				int y = hy - roomHeight / 2;
				node.room = new IntRect(x, y, roomWidth, roomHeight);
				rooms.add(node.room);
			}
		}

		insertRooms(node.left);
		insertRooms(node.right);
	}

	/**
	 * Permet de faire la connexion entre les rooms.
	 * @param node Cellules
	 */
	private void connectRooms(CellNode node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			int x1 = node.left.x + node.left.width / 2;
			int y1 = node.left.y + node.left.height / 2;
			int x2 = node.right.x + node.right.width / 2;
			int y2 = node.right.y + node.right.height / 2;
			node.corridor = new IntRect(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		}

		connectRooms(node.left);
		connectRooms(node.right);
	}

	/**
	 * Permet de créer les mur tout autour des rooms et des couloires.
	 * @param map Map
	 */
	private void renderWalls(char[][] map) {
		// Les murs des rooms
		for (int y = 1; y < mapHeight - 1; y++) {
			for (int x = 1; x < mapWidth - 1; x++) {
				if (map[y][x] == TileChar.charTemp) {
					if (map[y][x - 1] == TileChar.charVoid) {
						map[y][x] = TileChar.charWall;
					}
					if (map[y][x + 1] == TileChar.charVoid) {
						map[y][x] = TileChar.charWall;
					}
					if (map[y - 1][x] == TileChar.charVoid) {
						map[y][x] = TileChar.charWall;
					}
					if (map[y + 1][x] == TileChar.charVoid) {
						map[y][x] = TileChar.charWall;
					}
				}
			}
		}

		// les murs des couloirs
		for (int y = 1; y < mapHeight - 1; y++) {
			for (int x = 1; x < mapWidth - 1; x++) {
				if (map[y][x] == TileChar.charFloor) {
					if (map[y][x - 1] == TileChar.charVoid) {
						map[y][x - 1] = TileChar.charWall;
					}
					if (map[y][x + 1] == TileChar.charVoid) {
						map[y][x + 1] = TileChar.charWall;
					}
					if (map[y - 1][x] == TileChar.charVoid) {
						map[y - 1][x] = TileChar.charWall;
					}
					if (map[y + 1][x] == TileChar.charVoid) {
						map[y + 1][x] = TileChar.charWall;
					}
				}
			}
		}
	}

	/**
	 * Permet de créer les portes a chaque entrée des rooms
	 * @param map Map
	 */
	private void renderDoors(char[][] map) {
		// Séquence de caractère qui montre où sont les portes
		String roomToken = new StringBuilder().append(TileChar.charWall).append(TileChar.charTemp).append(TileChar.charTemp).append(TileChar.charWall).toString();

		for (int y = 1; y < mapHeight - 1; y++) {
			for (int x = 1; x < mapWidth - 1; x++) {
				if (isHSeq(map, x, y, roomToken)) {
					map[y][x + 1] = TileChar.charDoorV;
					map[y][x + 2] = TileChar.charDoorV;
				}
				else if (isVSeq(map, x, y, roomToken)) {
					map[y + 1][x] = TileChar.charDoorH;
					map[y + 2][x] = TileChar.charDoorH;
				}
			}
		}
	}

	/**
	 * Permet de faire la relation avec les portes entre les rooms
	 * @param map Map
	 * @param x Position en x
	 * @param y Postition en y
	 * @param seq Séquence de caractères
	 * @return Un booléan
	 */
	private boolean isHSeq(char[][] map, int x, int y, String seq) {
		for (int i = 0; i < seq.length(); i++) {
			if (map[y][x + i] != seq.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Permet de modifier la séquence de caractère.
	 * @param map Map
	 * @param x Position en x
	 * @param y Position en y
	 * @param seq Séquence de caractère
	 * @return un booléan
	 */
	private boolean isVSeq(char[][] map, int x, int y, String seq) {
		for (int i = 0; i < seq.length(); i++) {
			if (map[y + i][x] != seq.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Permet de remplir les rooms de sol.
	 * @param map Map
	 * @param room Les rooms
	 * @param roomNr valeur du parcours
	 */
	private void floodFill(char[][] map, IntRect room, int roomNr) {
		ArrayDeque<IntPoint> todo = new ArrayDeque<>();
		todo.push(new IntPoint(room.x + 1, room.y + 1));
		while(!todo.isEmpty()) {
			IntPoint tile = todo.pop();
			if (isTempFloor(map, tile.x, tile.y)) {
				map[tile.y][tile.x] = TileChar.charRoomFloor;
				roomsByTile.put(tile, roomNr);
			}
			if (isTempFloor(map, tile.x, tile.y - 1) && !isDoor(map, tile.x, tile.y - 1)) {
				todo.push(new IntPoint(tile.x, tile.y - 1));
			}
			if (isTempFloor(map, tile.x, tile.y + 1) && !isDoor(map, tile.x, tile.y + 1)) {
				todo.push(new IntPoint(tile.x, tile.y + 1));
			}
			if (isTempFloor(map, tile.x - 1, tile.y) && !isDoor(map, tile.x - 1, tile.y)) {
				todo.push(new IntPoint(tile.x - 1, tile.y));
			}
			if (isTempFloor(map, tile.x + 1, tile.y) && !isDoor(map, tile.x + 1, tile.y)) {
				todo.push(new IntPoint(tile.x + 1, tile.y));
			}
		}
	}

	/**
	 * Il va changer tous les caractères de chartemp par du sol
	 * @param map Map
	 * @param x Position en x
	 * @param y Position en y
	 * @return booléan
	 */
	private boolean isTempFloor(char[][] map, int x, int y) {
		return map[y][x] == TileChar.charTemp || map[y][x] == TileChar.charFloor;
	}

	/**
	 * Permet de savoir si c'est des portes
	 * @param map Map
	 * @param x Position en x
	 * @param y Position en y
	 * @return un booléan
	 */
	private boolean isDoor(char[][] map, int x, int y) {
		return map[y][x] == TileChar.charDoorH || map[y][x] == TileChar.charDoorV;
	}

	/**
	 * Permet de représenter les bordures des cellules.
	 * @param map Map
	 * @param node Cellule
	 */
	private void renderCellBorders(char[][] map, CellNode node) {
		if (node == null) {
			return;
		}

		// représente les bords des cellules
		for (int x = node.x; x < node.x + node.width; x++) {
			map[node.y][x] = TileChar.charCell;
			map[node.y + node.height - 1][x] = TileChar.charCell;
		}

		for (int y = node.y; y < node.y + node.height; y++) {
			map[y][node.x] = TileChar.charCell;
			map[y][node.x + node.width - 1] = TileChar.charCell;
		}

		renderCellBorders(map, node.left);
		renderCellBorders(map, node.right);
	}

	/**
	 * Représentation des couloirs.
	 * @param map Map
	 * @param node Cellule
	 */
	private void renderCorridors(char[][] map, CellNode node) {
		if (node == null) {
			return;
		}

		// Représentation de couloirs
		IntRect corridor = node.corridor;
		if (corridor != null) {
			for (int y = corridor.y; y < corridor.y + corridor.height; y++) {
				for (int x = corridor.x; x < corridor.x + corridor.width; x++) {
					map[y][x] = TileChar.charFloor;
				}
			}
		}

		renderCorridors(map, node.left);
		renderCorridors(map, node.right);
	}

	/**
	 * Permet de représenter les rooms.
	 * @param map map
	 * @param node cellule
	 */
	private void renderRooms(char[][] map, CellNode node) {
		if (node == null) {
			return;
		}

		// Représenter les rooms
		IntRect room = node.room;
		if (room != null) {
			for (int x = room.x; x < room.x + room.width; x++) {
				for (int y = room.y; y < room.y + room.height; y++) {
					if (!isDoor(map, x, y)) {
						map[y][x] = TileChar.charTemp;
					}
				}
			}
		}

		renderRooms(map, node.left);
		renderRooms(map, node.right);
	}

	/**
	 * Permet de convertir le vide par un tile de sol void.
	 * @param map Map
	 */
	private void convertVoid(char[][] map) {
		for (int y = 0; y < mapHeight; y++) {
			for (int x = 0; x < mapWidth; x++) {
				if (map[y][x] == TileChar.charVoid) {
					map[y][x] = TileChar.charOuterFloor;
				}
			}
		}
	}

	/**
	 * Initialise la map.
	 * @return Tableau a double entrée
	 */
	private char[][] initMap() {
		char[][] map = new char[mapHeight][mapWidth];
		for (int y = 0; y < mapHeight; y++) {
			for (int x = 0; x < mapWidth; x++) {
				map[y][x] = TileChar.charVoid;
			}
		}
		return map;
	}

	/**
	 * Représenter le personnage.
	 * @param map Map
	 */
	private void renderPersonnage(char[][] map){
		int xmin = rooms.get(0).getX();
		int ymin = rooms.get(0).getY();
		for (int i = 1; i < rooms.size(); i++){
			if (xmin > rooms.get(i).getX()){
				xmin = rooms.get(i).getX();
				ymin = rooms.get(i).getY();
			}
		}
		map[ymin+1][xmin+1] = TileChar.charPerso;
	}

	/**
	 * Représenter les items.
	 * @param map Map
	 */
	private void renderItems(char[][] map) {
		for (int i = 0; i < rooms.size(); i++) {
			int randx = (int) (Math.random() * (rooms.get(i).getWidth()-2)) + rooms.get(i).getX()+1;
			int randy = (int) (Math.random() * (rooms.get(i).getHeight()-2)) + rooms.get(i).getY()+1;

			map[randy][randx] = TileChar.charItem;
		}
	}

	/**
	 * Représentation des monstres.
	 * @param map Map
	 */
	private void renderMonster(char[][] map){
		int xmin = rooms.get(0).getX();
		int min = 0;
		for (int i =1; i< rooms.size(); i++){
			if (xmin > rooms.get(i).getX()){
				xmin = rooms.get(i).getX();
				min = i;
			}
		}
		for(int i = 0;i<rooms.size();i++){
			int rand = (int)(Math.random() * ( 4 ));
			if(rand == 1 && i != min){
				int randX = ((int)(Math.random() * ( rooms.get(i).getWidth()-2)))+ rooms.get(i).getX()+1;
				int randY = (int)(Math.random() * ( rooms.get(i).getHeight()-2))+ rooms.get(i).getY()+1;
				map[randY][randX] = TileChar.charMonster;
			}
		}
	}

	private void renderVillageois(char[][] map){
		for(int i = 0; i < rooms.size(); i++){
			int randX = ((int)(Math.random() * ( rooms.get(i).getWidth()-2)))+ rooms.get(i).getX()+1;
			int randY = (int)(Math.random() * ( rooms.get(i).getHeight()-2))+ rooms.get(i).getY()+1;

			map[randY][randX] = TileChar.charVillageois;
		}
	}
}
