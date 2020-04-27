// Defines Room class which has north, south, east, west members
package Shape_Game;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String[][] area = new String[10][10];

    public Room(String name) {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                area[i][j] = "  ";
            }
        }
        this.name = name;
    }
    void showArea(){
        for (int i = 0; i < 10; i++){
            System.out.print("|");
            for (int j = 0; j < 10; j++){
                System.out.print(area[i][j]);
            }
            System.out.println("|");
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
    void setNorth(Room nextRoom){
        north = nextRoom;
    }
    void setSouth(Room nextRoom){
        south = nextRoom;
    }
    void setEast(Room nextRoom){
        east = nextRoom;
    }
    void setWest(Room nextRoom){
        west = nextRoom;
    }
    String getName(){
        return name;
    }
    Room getNorth() {
        return north;
    }
    Room getSouth() {
        return south;
    }
    Room getEast() {
        return east;
    }
    Room getWest() {
        return west;
    }
}