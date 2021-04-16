package Super_Happy.States;

import Super_Happy.Audio.AudioPlayer;
import Super_Happy.Graphics.Assets;
import Super_Happy.Items.Coins;
import Super_Happy.Items.Hero;
import Super_Happy.Items.SluggerEnemy;
import Super_Happy.Items.SpiderEnemy;
import Super_Happy.Maps.MapManager;
import Super_Happy.RefLinks;
import Super_Happy.Maps.Map;
import Super_Happy.Tiles.Tile;

import java.awt.*;
import java.sql.Ref;

public class PlayState extends State
{
    public static Hero hero;
    private MapManager mapManager;
    public static int earnedCoins = 0;


    public static AudioPlayer bgMusic;


    public PlayState(RefLinks refLink)
    {
        super(refLink);


        earnedCoins = 0;
        Map.offset = 0;
        mapManager = new MapManager(refLink);
        mapManager.init();
        bgMusic = new AudioPlayer("/music/level1.wav");
        bgMusic.play();

        hero = new Hero(refLink,100, 300);
    }


    @Override
    public void Update()
    {
        mapManager.Update();
        hero.Update();

        if(refLink.GetKeyManager().esc == true) {
            PlayState.bgMusic.stop();
            State.SetState(new MenuState(refLink));
        }

    }

    @Override
    public void Draw(Graphics g)
    {
        mapManager.Draw(g);
        hero.Draw(g);


        g.drawImage(Assets.flag,(int) 2765 - Map.offset, (int) 320,null);
        g.setColor(new Color(191, 180, 12));
        g.setFont(new Font("Aerial", Font.BOLD, 20));
        g.drawImage(Assets.coinsText, Tile.TILE_WIDTH,Tile.TILE_HEIGHT,null);
        g.drawString(Integer.toString(refLink.GetGame().coins),3*Tile.TILE_WIDTH - 25 ,Tile.TILE_HEIGHT+23);
        g.drawImage(Assets.lifesText,Tile.TILE_WIDTH-5,Tile.TILE_HEIGHT+25,null);

        for(int i = 0; i< PlayState.hero.GetLife(); i++)
            g.drawImage(Assets.life,2*Tile.TILE_WIDTH+ 10 + i*25 ,Tile.TILE_HEIGHT+25,null);

    }

    @Override
    public void resetState(){

        hero = new Hero(refLink,100, 300);
        earnedCoins = 0;
        Map.offset = 0;
        bgMusic = new AudioPlayer("/music/level1.wav");
        bgMusic.play();

    }
}
