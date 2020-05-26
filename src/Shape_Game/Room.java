// Defines Room class which has north, south, east, west members
package Shape_Game;

public class Room {
    private String name;
    private Rooms nextRoom;
    private final String[][] area = new String[10][10];

    public enum Rooms{
        UNDERWORLD("Underworld"),
        SHRINE("Shrine", Rooms.UNDERWORLD),
        DARKTEMPLE("Dark Temple", Rooms.SHRINE),
        HIDDENCAVE("Hidden Cave", Rooms.DARKTEMPLE),
        DUNGEON("Dungeon", Rooms.HIDDENCAVE),
        BASEMENT("Basement", Rooms.DUNGEON),
        FOYER("Foyer", Rooms.BASEMENT),
        GARDEN("Garden", Rooms.FOYER),
        COURTYARD("Courtyard", Rooms.GARDEN);

        private final String name;
        private Rooms nextRoom;

        Rooms(String name){
            this.name = name;
        }

        Rooms(String name, Rooms nextRoom){
            this.name = name;
            this.nextRoom = nextRoom;
        }
    }

    public Room(Rooms room) {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                area[i][j] = "  ";
            }
        }
        this.name = room.name;
        this.nextRoom = room.nextRoom;
    }
    void showArea(){
        for (int i = 0; i < 10; i++){
            System.out.print("|");
            for (int j = 0; j < 10; j++){
                System.out.print(area[i][j]);
            }
            if (i == 0){
                System.out.print("|");
                System.out.println("   "+this.name);
            }
            else{
                System.out.println("|");
            }

        }
    }
    void setChestLocation(int x, int y){
        area[y][x] = "C ";
    }

    void resetLoc(int x, int y){
        area[y][x] = "  ";
    }

    void setPlayerLocation(int x, int y){
        area[y][x] = "O ";
    }

    Rooms getNextRoom(){
        return nextRoom;
    }

    String getName(){
        return name;
    }
}