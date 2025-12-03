package w13;

public class Room {
	private String description; // 이 Room에 대한 설명.
	private Room northExit; // 북쪽 방향으로 이웃한 Room을 가리키는 참조변수.
	private Room southExit;
	private Room eastExit;
	private Room westExit;

	/**
	 * "description" 설명에 해당하는 Room을 구성한다. 초기에는 exit을 갖지 않는다. "description"은 가령
	 * "과사무실", "실습실", "동아리방" 같은 것이다.
	 * 
	 * @param description 이 방에 관한 설명.
	 */
	public Room(String description) {
		this.description = description;
	}

	/**
	 * 이 방의 출구들을 설정해 준다. 각 방향은 다른 방일 수도 있고 null일 수도 있다(다른 방으로 연결되지 않는 경우).
	 * 
	 * @param north The north exit.
	 * @param east  The east east.
	 * @param south The south exit.
	 * @param west  The west exit.
	 */
	public void setExits(Room north, Room east, Room south, Room west) {
		if (north != null)
			northExit = north;
		if (east != null)
			eastExit = east;
		if (south != null)
			southExit = south;
		if (west != null)
			westExit = west;
	}
	
	/**
	 * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다.
	 * @param direction 나가려고 하는 방향 "north", "east", "south", "west"
	 * @return 나가려고 하는 방향으로 연결된 Room, 그 방향으로 출구가 없으면 null.
	 */
	public Room getExit(String direction) {
		Room exit = null; // direction 방향에 있는 Room;
		if("north".equals(direction))
			exit = northExit;
		else if("east".equals(direction))
			exit = eastExit;
		else if("south".equals(direction))
			exit = southExit;
		else if("west".equals(direction))
			exit = westExit;
		return exit;
	}

	/*.*
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 현재 Room의 출구 정보를 문자열로 만들어 반환한다.
	 * 이 메소드는 출력(System.out.println)을 하지 않고 문자열만 반환해야 한다.
	 * 반환 예: "Exits: north east" (북,동,남,서 순서)
	 * 
	 * @return 출구 정보를 담은 문자열(접두사 "Exits:" 포함)
	 */
	public String getExitString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Exits:");
		if (northExit != null) {
			sb.append(" north");
		}
		if (eastExit != null) {
			sb.append(" east");
		}
		if (southExit != null) {
			sb.append(" south");
		}
		if (westExit != null) {
			sb.append(" west");
		}
		return sb.toString();
	}
}


