package Super_Happy;

import Super_Happy.GameWindow.GameWindow;
import Super_Happy.Graphics.Assets;
import Super_Happy.Input.KeyManager;
import Super_Happy.States.*;
import Super_Happy.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Singletone implements Runnable
{
    private GameWindow      wnd;        /*!< Fereastra in care se va desena tabla jocului*/
    private boolean         runState;   /*!< Flag ce starea firului de executie.*/
    private Thread          gameThread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/
    private BufferStrategy  bs;         /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/


    private Graphics        g;          /*!< Referinta catre un context grafic.*/


    private KeyManager keyManager;      /*!< Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului.*/
    private RefLinks refLink;            /*!< Referinta catre un obiect a carui sarcina este doar de a retine diverse referinte pentru a fi usor accesibile.*/


    private Tile tile; /*!< variabila membra temporara. Este folosita in aceasta etapa doar pentru a desena ceva pe ecran.*/
    public int coins = 50;
    public static boolean ownedSkins[] = new boolean[3];


    protected Game(String title, int width, int height)
    {
        wnd = new GameWindow(title, width, height);
        runState = false;
        keyManager = new KeyManager();

    }

    private void InitGame()
    {
        wnd.BuildGameWindow();
        wnd.GetCanvas().addKeyListener(keyManager);
        Assets.Init();
        refLink = new RefLinks(this);

        State.SetState(new LoadState(refLink));
    }

    public void run()
    {
        InitGame();
        long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
        long curentTime;                    /*!< Retine timpul curent de executie.*/

        final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
        final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

        while (runState == true)
        {
            curentTime = System.nanoTime();
            if((curentTime - oldTime) > timeFrame)
            {
                Update();
                Draw();
                oldTime = curentTime;
            }
        }

    }

    public synchronized void StartGame()
    {
        if(runState == false)
        {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            runState = false;
            try
            {
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }

    private void Update()
    {
        keyManager.Update();
        if(State.GetState() != null)
        {
            State.GetState().Update();
        }

    }

    private void Draw()
    {
        bs = wnd.GetCanvas().getBufferStrategy();

        if(bs == null)
        {
            try
            {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

            if(State.GetState() != null)
            {
                State.GetState().Draw(g);
            }
        bs.show();

        g.dispose();
    }

    public static Game getInstance(String title, int width, int height){
        if(instance == null)
            return new Game(title,width,height);
        return (Game)instance;
    }

    public int GetWidth()
    {
        return wnd.GetWndWidth();
    }

    public int GetHeight()
    {
        return wnd.GetWndHeight();
    }

    public KeyManager GetKeyManager()
    {
        return keyManager;
    }
}

