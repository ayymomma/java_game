package Super_Happy.Items;

import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.Map;
import Super_Happy.RefLinks;

import java.awt.*;

public class Coins extends Character {

    public boolean spawned = true;
    private int contor = 0;

    public Coins(RefLinks refLink, float x, float y){
        super(refLink,x,y,Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void Update() {
        contor++;
        if(contor>27)
            contor = 0;
    }

    @Override
    public void Draw(Graphics g) {
            if(spawned==true)
                g.drawImage(Assets.coin[contor/3],(int) x - Map.offset, (int)y, width, height, null);
    }

    public Rectangle getCoinRectangle(){
        return new Rectangle((int)x+15-Map.offset,(int)y+15,width-15,height-15);
    }
}
