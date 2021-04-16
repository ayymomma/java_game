package Super_Happy.Maps;

import Super_Happy.DataBase;
import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;
import Super_Happy.States.State;
import Super_Happy.Tiles.Tile;

import java.awt.*;

public class MapManager {

    Map map;
    private RefLinks refLinks;
    public static int level = 1;

    public MapManager(RefLinks refLinks){
        this.refLinks = refLinks;
    }

    public  void Update()
    {
        map.Update();
    }

    public void init(){
        switch (level){
            case 1: map = new Map1(refLinks); break;
            case 2: map = new Map2(refLinks); break;
        }

        Tile.init();
        map.populateEnemies();
        refLinks.SetMap(map);

    }

    public void Draw(Graphics g)
    {
        map.Draw(g);
    }

    public static void nextLevel(){
        level++;
        if(level == 3){
            level = 1;
        }
        State.db.updateLevel(level);
    }

    public static int getLevel(){
        return level;
    }

}
