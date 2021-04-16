package Super_Happy.Items;


import Super_Happy.RefLinks;
import Super_Happy.States.GameOver;
import Super_Happy.States.State;


public abstract class Character extends Item {
    public static final int DEFAULT_LIFE = 3;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED = 5.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH = 48;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 48;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected int life;             /*!< Retine viata caracterului.*/
    protected float speed;          /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;          /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;          /*!< Retine noua pozitie a caracterului pe axa Y.*/
    protected float jumpStrength = 0;

    protected boolean inAir = false;
    protected boolean running = false;
    protected boolean dead = false;



    public Character(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
        life = DEFAULT_LIFE;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void Move(boolean movex)
    {

        if(y > refLink.GetGame().GetHeight())
            State.SetState(new GameOver(refLink));

        if(movex == true)
            MoveX();
        MoveY();

    }

    public float canMoveX(float d){

        for (float h=bounds.y ; h<=(bounds.y+bounds.height); h+=bounds.height/2.) {
            if (d>0 && refLink.GetMap().getSolid(bounds.x + bounds.width + d, h) ||
                    d<0 && refLink.GetMap().getSolid(bounds.x + d, h))
                return 0;
        }

        return d;
    }



    public float canMoveY(float d){

        for (float w=bounds.x ; w<=(bounds.x+bounds.width); w+=bounds.width/2.) {
            if (d > 0 && refLink.GetMap().getSolid(w, bounds.y + bounds.height + d))
            {
                inAir = false;
                return 0;
            }
            if (d < 0 && refLink.GetMap().getSolid(w, bounds.y + d) )
            {
                return 0;
            }
        }

        return d;
    }


    public void MoveX()
    {
        x += xMove;
        bounds.x += xMove;
    }
    public void MoveY()
    {
        y += yMove;
        bounds.y += yMove;
    }

    public int GetLife()
    {
        return life;
    }

    public float GetSpeed()
    {
        return speed;
    }

    public void SetLife(int life)
    {
        this.life = life;
    }

    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    public float GetXMove()
    {
        return xMove;
    }

    public float GetYMove()
    {
        return yMove;
    }

    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }

    public void SetJumpS(float jumpStrength)
    {
        this.jumpStrength = jumpStrength;
    }
}

