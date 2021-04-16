package Super_Happy.Tiles;

import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.MapManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{

    private static final int NO_TILES   = 18;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

    public static final int TILE_WIDTH  = 48;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 48;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    public static void init(){
        for (int i = 0;i<16;i++){
            switch (MapManager.getLevel()){
                case 1: new Tile(Assets.tileLevel1[i],i+1); break;
                case 2: new Tile(Assets.tileLevel2[i],i+1); break;
            }
        }
    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {

        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
        //g.drawRect(x, y, TILE_WIDTH, TILE_HEIGHT);
    }

    public int GetId()
    {
        return id;
    }
}
