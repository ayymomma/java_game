package Super_Happy.States;

import Super_Happy.Audio.AudioPlayer;
import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;

import java.awt.*;
public class MenuState extends State
{

    private int counter = 0;

    private int currentChoice = 0;


    public static AudioPlayer menuMusic;


    private String[] options = {
            "Start",
            "Help",
            "Settings",
            "Shop",
            "Quit"
    };

    public MenuState(RefLinks refLink)
    {
        super(refLink);
    }

    @Override
    public void Update()
    {
        if(counter==8)
        { getInput(); counter = 0;}
        counter++;
    }

    @Override
    public void Draw(Graphics g)
    {
        switch (currentChoice){
            case 0: g.drawImage(Assets.menuStart,0,0,null); break;
            case 1: g.drawImage(Assets.menuHelp,0,0,null); break;
            case 2: g.drawImage(Assets.menuSettings,0,0,null); break;
            case 3: g.drawImage(Assets.menuShop,0,0,null); break;
            case 4: g.drawImage(Assets.menuQuit,0,0,null); break;
        }
    }

    private void select(){
        if(currentChoice == 0){
            State.SetState(new PlayState(refLink));
        }
        if(currentChoice == 1){
            State.SetState(new HelpState(refLink));
        }
        if(currentChoice == 2){
            State.SetState(new SettingsState(refLink));
        }
        if(currentChoice == 3){
                State.SetState(new Shop(refLink));
        }
        if(currentChoice == 4){
            System.exit(0);
        }
    }

    private void getInput(){
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
