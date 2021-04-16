package Super_Happy.Items;

import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.Map;
import Super_Happy.RefLinks;

import java.awt.*;



public class SpiderEnemy extends Character {

    private int yMax;
    private int yMin;

    private boolean sus = false;
    private boolean jos = true;

    private int espeed = 1;

    public SpiderEnemy(RefLinks refLink, float x, float y,int goDownLength){
        super(refLink,x,y,Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        yMax = (int)y + goDownLength;
        yMin = (int)y;
    }


    @Override
    public void Update() {
        if(sus==true)
            if(y-espeed>yMin)
                y=y-espeed;
            else
            {
                sus = false;
                jos = true;
            }


        if(jos==true)
            if(y+espeed<yMax)
                y=y+espeed;
            else{
                jos = false;
                sus = true;
            }
    }


    @Override
    public void Draw(Graphics g) {

        if(onScreen())
        {
            g.setColor(Color.GRAY);
            g.drawLine((int) x - Map.offset+23, (int)yMin,(int) x - Map.offset+23, (int)y+5);
            g.drawImage(Assets.enemySpider,(int) x - Map.offset, (int)y, width, height,null);
        }
    }

    public Rectangle getEnemyRectangle(){
        return new Rectangle((int)x-Map.offset,(int)y,width,height);
    }

    public boolean onScreen(){
        if(x - Map.offset < refLink.GetGame().GetWidth())
            return true;
        return false;
    }
}
