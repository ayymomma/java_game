package Super_Happy.Items;

import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.Map;
import Super_Happy.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SluggerEnemy extends Character {

    private BufferedImage[] image;


    private boolean dreapta = true;
    private boolean stanga  = false;

    private int contor = 0;

    private int xMax;
    private int xMin;
    private int espeed = 2;


    public SluggerEnemy(RefLinks refLink, float x, float y, int runLenght){

        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        init(runLenght);
    }

    private void init(int runLenght){
        image = new BufferedImage[4];

        xMax = (int)x + runLenght;
        xMin = (int)x;


        image[0] = Assets.enemySluggerF; //inamic inainte
        image[1] = Assets.enemySluggerFA;
        image[2] = Assets.enemySluggerB;  //inamic inapoi
        image[3] = Assets.enemySluggerBA;
    }

    @Override
    public void Update() {
        if(dreapta==true)
            if(x+espeed<xMax)
                x=x+espeed;
            else
            {
                contor=0;
                dreapta=false;
                stanga = true;
            }
        if(stanga==true){
            if(x-espeed>xMin)
                x=x-espeed;
            else{
                contor=0;
                stanga = false;
                dreapta = true;
            }
        }
        contor++;
    }


    @Override
    public void Draw(Graphics g) {

        if(onScreen())
        {
        if(dead==false) {
            if (dreapta == true) {
                if (contor < 15)
                   g.drawImage(image[0],(int) x - Map.offset, (int)y, width, height, null);
               else {
                   g.drawImage(image[1], (int) x - Map.offset, (int)y, width, height, null);
                }
               if (contor > 30)
                    contor = 0;
              }

             if (stanga == true) {
                if (contor < 15)
                    g.drawImage(image[2], (int) x - Map.offset, (int) y, width, height, null);
                else {
                    g.drawImage(image[3], (int) x - Map.offset, (int) y, width, height, null);
                }
                if (contor > 30)
                contor = 0;
                }
            }
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
