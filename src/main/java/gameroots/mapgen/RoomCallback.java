package gameroots.mapgen;

import gameroots.shared.geom.IntPoint;
import gameroots.shared.geom.IntRect;

import java.util.List;

public interface RoomCallback {
	void processRoom(int room, IntRect roomRect, List<IntPoint> tiles);
}
