package Super_Happy.States;

import Super_Happy.DataBase;
import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;

import java.awt.*;

public class SettingsState extends State
{
    private int counter = 0;
    private String[] options = {"Hard",
                                "Normal",
                                "Easy"};
    private int currentChoice = 0;
    public static int difficulty = 0;

    public SettingsState(RefLinks refLink)
    {
        super(refLink);
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

    @Override
    public void Draw(Graphics g)
    {
        switch (currentChoice){
            case 0: g.drawImage(Assets.settingsHard,0,0,null); break;
            case 1: g.drawImage(Assets.settingsMedium,0,0,null); break;
            case 2: g.drawImage(Assets.settingsEasy,0,0,null); break;
        }
    }

    private void select(){
        if(currentChoice == 0){
            difficulty = 2;
        }
        if(currentChoice == 1){
            difficulty = 1;
        }
        if(currentChoice == 2){
            difficulty = 0;
        }
    }

    private void getInput(){
        if(refLink.GetKeyManager().esc==true)
        {
            db.updateSettings(difficulty);
            State.SetState(new MenuState(refLink));
        }

        if(refLink.GetKeyManager().enter)
            select();


        if(refLink.GetKeyManager().up){
            currentChoice--;
            if(currentChoice == -1)
            {
                currentChoice = options.length-1;
            }
        }


        if(refLink.GetKeyManager().down){
            currentChoice++;
            if(currentChoice == options.length)
                currentChoice = 0;
        }
    }

    @Override
    public void resetState(){

    }
}
