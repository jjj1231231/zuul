package w13;

import java.util.Map;
import java.util.HashMap;

public class Room {
    private String description; // 이 Room에 대한 설명
    private Map<String, Room> exits; // 방향 문자열 -> 인접 Room

    /**
     * Room 객체 생성자
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    /**
     * 이 Room의 출구들 중 하나를 설정한다.
     * @param direction 출구 방향
     * @param neighbor  그 방향으로 연결된 Room
     */
    public void setExit(String direction, Room neighbor) {
        // neighbor이 null이면 출구가 없는 것 → map에 넣지 않음
        if (neighbor != null) {
            exits.put(direction, neighbor);
        }
    }

    /**
     * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다.
     */
    public Room getExit(String direction) {
        if (direction == null) return null;
        return exits.get(direction);
    }

    public String getDescription() {
        return description;
    }

    /**
     * 출구 정보를 문자열로 반환한다.
     * 예: "Exits: north east"
     */
    public String getExitString() {
        StringBuilder sb = new StringBuilder("Exits:");

        Room r;
        r = exits.get("north");
        if (r != null) sb.append(" north");

        r = exits.get("east");
        if (r != null) sb.append(" east");

        r = exits.get("south");
        if (r != null) sb.append(" south");

        r = exits.get("west");
        if (r != null) sb.append(" west");

        return sb.toString();
    }
}