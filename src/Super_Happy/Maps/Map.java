package Super_Happy.Maps;

import Super_Happy.Graphics.Assets;
import Super_Happy.Items.Coins;
import Super_Happy.Items.SluggerEnemy;
import Super_Happy.Items.SpiderEnemy;
import Super_Happy.RefLinks;
import Super_Happy.Tiles.Tile;

import java.awt.*;

abstract public class Map
{
    protected RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    protected int width;          /*!< Latimea hartii in numar de dale.*/
    protected int height;         /*!< Inaltimea hartii in numar de dale.*/
    protected int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    public static SluggerEnemy[] enemy;
    public static SpiderEnemy[] spider;
    public static Coins[] coins;


    public static int offset = 0;

    
    public Map(RefLinks refLink)
    {
        this.refLink = refLink;
        LoadWorld();
    }

    public  void Update()
    {

        for(int i=0;i<enemy.length;i++)
            enemy[i].Update();

        for(int i=0;i<spider.length;i++)
            spider[i].Update();

        for(int i=0;i<coins.length;i++)
            coins[i].Update();

    }

    public void Draw(Graphics g)
    {
        g.drawImage(Assets.menuBackground,0,0,null);
        if(offset < 0)
            offset=0;
        for(int y = 0  ; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0 + (offset / Tile.TILE_WIDTH); x < (refLink.GetGame().GetWidth() + offset)/Tile.TILE_WIDTH + 1; x++)
            {
                if(GetTile( x, y)!=null)
                    GetTile( x, y).Draw(g, (int)x  * Tile.TILE_HEIGHT- offset, (int)(y) * Tile.TILE_WIDTH);
            }
        }

        for(int i=0;i<enemy.length;i++)
            enemy[i].Draw(g);

        for(int i=0;i<spider.length;i++)
            spider[i].Draw(g);

        for(int i=0;i<coins.length;i++)
            coins[i].Draw(g);

    }

    public Tile GetTile(int x, int y)
    {
        if(tiles[x][y]==0)
            return null;
        Tile t = Tile.tiles[tiles[x][y]];
        return t;
    }
    private void LoadWorld()
    {
        width = 60;
        height = 10;
        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
            }
        }
    }

    public int getMapWidth(){
        return width*Tile.TILE_WIDTH;
    }

    public boolean getSolid(float w, float h) {
        try {
            return tiles[(int)((w + offset) / Tile.TILE_HEIGHT)][(int)(h / Tile.TILE_WIDTH)] != 0;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    protected abstract int MiddleEastMap(int x ,int y);
    protected abstract void populateEnemies();
}