package w13;

import java.util.Map;
import java.util.HashMap;

public class Room {
	private String description; // 이 Room에 대한 설명.
	private Map<String, Room> exits; // 방향 문자열 -> 이 방향의 인접 Room

	/**
	 * "description" 설명에 해당하는 Room을 구성한다. 초기에는 exit을 갖지 않는다.
	 * 
	 * @param description 이 방에 관한 설명.
	 */
	public Room(String description) {
		this.description = description;
		this.exits = new HashMap<>(); // Map 인터페이스 구현체인 HashMap 인스턴스 생성
	}

	/**
	 * 이 방의 출구들을 설정해 준다. 각 방향은 다른 방일 수도 있고 null일 수도 있다(다른 방으로 연결되지 않는 경우).
	 * 메소드 시그니처는 변경하지 않는다.
	 * 
	 * @param north The north exit.
	 * @param east  The east exit.
	 * @param south The south exit.
	 * @param west  The west exit.
	 */
	public void setExits(Room north, Room east, Room south, Room west) {
		// 방향 키로 각각 저장한다. null인 경우에도 키를 저장해서 getExit에서 null을 반환하게 한다.
		exits.put("north", north);
		exits.put("east", east);
		exits.put("south", south);
		exits.put("west", west);
	}
	
	/**
	 * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다.
	 * @param direction 나가려고 하는 방향 "north", "east", "south", "west"
	 * @return 나가려고 하는 방향으로 연결된 Room, 그 방향으로 출구가 없으면 null.
	 */
	public Room getExit(String direction) {
		if (direction == null) return null;
		// Map에 해당 키가 없거나 값이 null이면 null을 반환한다.
		return exits.get(direction);
	}

	/**
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
		StringBuilder sb = new StringBuilder("Exits:");
		// 북, 동, 남, 서 순서로 추가 (요구한 순서 유지)
		Room r;
		
		r = exits.get("north");
		if (r != null) {
			sb.append(" north");
		}
		r = exits.get("east");
		if (r != null) {
			sb.append(" east");
		}
		r = exits.get("south");
		if (r != null) {
			sb.append(" south");
		}
		r = exits.get("west");
		if (r != null) {
			sb.append(" west");
		}
		return sb.toString();
	}
}