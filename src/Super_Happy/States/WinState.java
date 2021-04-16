package Super_Happy.States;

import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.MapManager;
import Super_Happy.RefLinks;

import java.awt.*;

public class WinState  extends State{

    private int contor = 0;
    private int contorInput = 0;

    public WinState(RefLinks refLink)
    {
        super(refLink);
    }
    @Override
    public void Update()
    {
        contor++;
        contorInput++;
        if(contor>80)
            contor=0;

        if(contorInput==10)
        {
            contorInput=0;
            getInput();
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.winState,0,0,null);

        g.setColor(new Color(191, 180, 12));
        g.setFont(new Font("Aerial", Font.BOLD, 20));
        g.drawString(Integer.toString(refLink.GetGame().coins),480,235);
    }

    private void getInput(){
        if(refLink.GetKeyManager().space==true){

            db.updateCoins(refLink.GetGame().coins);

            MapManager.nextLevel();
            PlayState.bgMusic.stop();

            State.SetState(new PlayState(refLink));
        }
    }

    @Override
    public void resetState(){
    }
}