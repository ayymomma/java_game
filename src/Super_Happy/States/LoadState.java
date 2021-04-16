package Super_Happy.States;


import Super_Happy.Graphics.Assets;
import Super_Happy.Maps.MapManager;
import Super_Happy.RefLinks;

import java.awt.*;

public class LoadState extends State {

    private int currentChoice = 0;
    private int counter = 0;

    public LoadState(RefLinks refLinks){
        super(refLinks);
    }

    @Override
    public void Update() {
        if(counter==8)
        {
            getInput();
            counter = 0;
        }
        counter++;
    }

    private void select(){
        if(currentChoice == 0){
            State.SetState(new MenuState(refLink));
        }
        if(currentChoice == 1){
            refLink.GetGame().coins     = db.getData("coins");
            SettingsState.difficulty    = db.getData("difficulty");
            MapManager.level            = db.getData("level");


            if(db.getData("skin1") == 1)
                refLink.GetGame().ownedSkins[0] = true;

            if(db.getData("skin2") == 1)
                refLink.GetGame().ownedSkins[1] = true;

            if(db.getData("skin3") == 1)
                refLink.GetGame().ownedSkins[2] = true;

            State.SetState(new MenuState(refLink));
        }
    }

    private void getInput(){

        if(refLink.GetKeyManager().enter)
            select();


        if(refLink.GetKeyManager().up){
            currentChoice--;
            if(currentChoice == -1)
            {
                currentChoice = 1;
            }
        }


        if(refLink.GetKeyManager().down){
            currentChoice++;
            if(currentChoice == 2)
                currentChoice = 0;
        }
    }


    @Override
    public void Draw(Graphics g) {
        switch (currentChoice){
            case 0: g.drawImage(Assets.loadNew,0,0,null); break;
            case 1: g.drawImage(Assets.loadLoad,0,0,null); break;
        }
    }

    @Override
    public void resetState() {

    }
}
