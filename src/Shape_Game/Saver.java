package Shape_Game;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Saver {
    private String out = "PlayerSave.json";

    public Saver(){
    };

    public void savePlayer(Player player){
        ObjectMapper save = new ObjectMapper();
        try {
            save.writeValue(new File(out), player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player loadPlayer() throws IOException {
        ObjectMapper load = new ObjectMapper();
        load.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Player player = load.readValue(new File(out), Player.class);
        return player;
    }
}
