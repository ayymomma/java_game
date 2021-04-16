package Super_Happy.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import Super_Happy.Audio.AudioPlayer;
import Super_Happy.Maps.Map;
import Super_Happy.RefLinks;
import Super_Happy.Graphics.Assets;
import Super_Happy.States.*;

public class Hero extends Character
{
    private BufferedImage[] image;
    private int contor = 0;
    private boolean dreapta = false;
    private boolean stanga  = false;
    private boolean collect = false;


    private boolean[] intersect;
    private boolean[] intersectSpider;
    private boolean[] intersectCoin;
    private static int skin = 0;
    private AudioPlayer jmpMusic;

    public Hero(RefLinks refLink, float x, float y)
    {
        super(refLink, x,y, 36, 52);
        init();
    }

    private void init(){
        if(SettingsState.difficulty == 2)
            life = 1;
        else if(SettingsState.difficulty == 1)
            life = 2;

        image = new BufferedImage[8];

        bounds.x = (int)x + 12;
        bounds.y = (int)y + 2;
        bounds.width = Character.DEFAULT_CREATURE_WIDTH - 24;
        bounds.height = Character.DEFAULT_CREATURE_HEIGHT - 1;

        image = Assets.heroIdleRight;



        intersect       = new boolean[refLink.GetMap().enemy.length];
        intersectSpider = new boolean[refLink.GetMap().spider.length];
        intersectCoin   = new boolean[refLink.GetMap().coins.length];

        for(int i=0;i<intersect.length;i++)
            intersect[i]=false;
        for(int i=0;i<intersectSpider.length;i++)
            intersectSpider[i]=false;
        for(int i=0;i<intersectCoin.length;i++)
            intersectCoin[i]=false;

        jmpMusic = new AudioPlayer("/music/jump.wav");
    }

    @Override
    public void Update()
    {
        GetInput();
        checkLifes();
        MovePlayer();
        checkColWithEnemy();
        checkColWithCoin();
        checkFinal();

        System.out.println(x+Map.offset);
        System.out.println(y);

    }

    private void MovePlayer(){
        if( x + xMove < refLink.GetGame().GetWidth() / 2)
            Move(true);
        else{
            if(Map.offset + refLink.GetGame().GetWidth() + xMove < refLink.GetMap().getMapWidth())
            {
                Map.offset += xMove;
                Move(false);
            }
            else {
                Move(true);
            }
        }
    }

    private void checkColWithEnemy(){
        for(int i = 0; i< refLink.GetMap().enemy.length; i++)
            if(getHeroRectangle().intersects(refLink.GetMap().enemy[i].getEnemyRectangle())==true)
            {
                if(intersect[i]==false)
                {
                    life-=1;
                    intersect[i]=true;
                }
            }
            else
                intersect[i]=false;
        for(int i = 0; i< refLink.GetMap().spider.length; i++){
            if(getHeroRectangle().intersects(refLink.GetMap().spider[i].getEnemyRectangle())==true)
            {
                if(intersectSpider[i]==false)
                {
                    life-=1;
                    intersectSpider[i]=true;
                }
            }
            else
                intersectSpider[i]=false;
        }
    }

    private void checkColWithCoin(){
        for(int i = 0; i< refLink.GetMap().coins.length; i++){
            if(getHeroRectangle().intersects(refLink.GetMap().coins[i].getCoinRectangle())==true) {
                if (intersectCoin[i] == false) {
                    refLink.GetMap().coins[i].spawned = false;
                    refLink.GetGame().coins++;
                    intersectCoin[i] = true;
                    PlayState.earnedCoins ++;
                }
            }
        }
    }

    private void checkFinal(){
        if(getHeroRectangle().intersects(new Rectangle(2765 - Map.offset,320,37,70))==true)
        {
            if(PlayState.earnedCoins == 7)
                State.SetState(new WinState(refLink));
            else{
                collect = true;
            }
        }
        else
            collect = false;
    }

    private void checkLifes(){
        if(life<=0)
            State.SetState(new GameOver(refLink));
    }

    private void GetInput()
    {
        xMove = 0;
        yMove = 0;
        running = false;


        contor++;
        if(contor>27)
            contor=0;


        if(refLink.GetKeyManager().left)
        {
            xMove = canMoveX(-speed);
            stanga = true;
            dreapta = false;
            running = true;
        }
        else{
            stanga=false;
        }


        if(refLink.GetKeyManager().right)
        {
            xMove = canMoveX(speed);
            stanga = false;
            dreapta = true;
            running = true;
        }
        else {
            dreapta = false;
        }


        if(refLink.GetKeyManager().space && inAir==false)
        {
            jmpMusic.play();
            jumpStrength = -17;
            jumpStrength = canMoveY(++jumpStrength);
            yMove = jumpStrength;
            inAir = true;
        }

        jumpStrength = canMoveY(++jumpStrength);
        yMove = jumpStrength;

    }

    public Rectangle getHeroRectangle(){
        return new Rectangle((int)x,(int)y,width,height);
    }

    @Override
    public void Draw(Graphics g)
    {

        if(running == true){

            if(dreapta==true)
                switch (skin){
                case 0:
                    image = Assets.heroRunRight; break;
                case 1:
                    image = Assets.heroRunRight2; break;
                case 2:
                    image = Assets.heroRunRight3; break;
                case 3:
                    image = Assets.heroRunRight4; break;
            }

            if(stanga==true)
                switch (skin) {
                    case 0:
                        image = Assets.heroRunLeft; break;
                    case 1:
                        image = Assets.heroRunLeft2; break;
                    case 2:
                        image = Assets.heroRunLeft3; break;
                    case 3:
                        image = Assets.heroRunLeft4; break;
                }

            g.drawImage(image[contor/4], (int)x, (int)y, width, height, null);

        }
        else
            {
                switch (skin) {
                    case 0:
                        image = Assets.heroIdleRight; break;
                    case 1:
                        image = Assets.heroIdleRight2; break;
                    case 2:
                        image = Assets.heroIdleRight3; break;
                    case 3:
                        image = Assets.heroIdleRight4; break;
                }
            g.drawImage(image[contor/4], (int)x, (int)y, width, height, null);
        }

        if(collect == true)
            g.drawImage(Assets.winCondition,refLink.GetWidth()/2-150,refLink.GetHeight()/2,null);





        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }
    public void setPos(int xx,int yy){
        x=xx;
        y=yy;
    }

    public void setSkin(int x){
        skin = x;
    }
}
