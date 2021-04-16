package Super_Happy;

import Super_Happy.Maps.Map;

import Super_Happy.Input.KeyManager;
import Super_Happy.Maps.MapManager;


public class RefLinks
{
    private Game game;          /*!< Referinta catre obiectul Game.*/
    private Map map;            /*!< Referinta catre harta curenta.*/
    private MapManager mapManager;

    public RefLinks(Game game)
    {
        this.game = game;
    }

    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    public int GetWidth()
    {
        return game.GetWidth();
    }

    public int GetHeight()
    {
        return game.GetHeight();
    }

    public Game GetGame()
    {
        return game;
    }

    public Map GetMap()
    {
        return map;
    }

    public void SetMap(Map map)
    {
        this.map = map;
    }

    public void SetMapManager(MapManager mapManager){
        this.mapManager = mapManager;
    }

    public MapManager GetMapManager(){
        return this.mapManager;
    }
}
