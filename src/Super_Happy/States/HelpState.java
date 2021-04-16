package Super_Happy.States;

import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;

import java.awt.*;

public class HelpState extends State
{


    public HelpState(RefLinks refLink)
    {
        super(refLink);
    }
    @Override
    public void Update()
    {
        getInput();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.helpState,0,0,null);
    }

    private void getInput(){
        if(refLink.GetKeyManager().esc == true){
            State.SetState(new MenuState(refLink));
        }
    }

    @Override
    public void resetState(){
    }
}