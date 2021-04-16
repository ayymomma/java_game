package Super_Happy.States;

import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;

import java.awt.*;

public class GameOver  extends State{

    private int contor = 0;
    private int contorInput = 0;

    public GameOver(RefLinks refLink)
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
            g.drawImage(Assets.gameOver,0,0,null);

            if(contor/8<6)
                g.drawImage(Assets.heroDead[contor/8],refLink.GetWidth()/2-20,refLink.GetHeight()/2-100,null);
            else
                g.drawImage(Assets.heroDead[contor/8],refLink.GetWidth()/2-20,refLink.GetHeight()/2-90,null);
    }

    private void getInput(){
            if(refLink.GetKeyManager().space==true)
            {
                PlayState.bgMusic.stop();
                db.updateCoins(refLink.GetGame().coins);
                State.SetState(new PlayState(refLink));
            }
    }

    @Override
    public void resetState(){
    }
}
