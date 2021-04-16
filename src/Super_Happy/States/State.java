package Super_Happy.States;

import java.awt.*;

import Super_Happy.DataBase;
import Super_Happy.RefLinks;

public abstract class State
{
    private static State previousState  = null; /*!< Referinta catre starea anterioara a jocului.*/
    private static State currentState   = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    public static DataBase db;
    protected RefLinks refLink;

    public State(RefLinks refLink)
    {
        this.refLink = refLink;
        db = new DataBase();
    }

    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }

    public static State GetState()
    {
        return currentState;
    }

    public abstract void Update();
    public abstract void Draw(Graphics g);
    public abstract void resetState();
}
