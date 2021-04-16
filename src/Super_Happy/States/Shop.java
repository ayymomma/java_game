package Super_Happy.States;

import Super_Happy.Graphics.Assets;
import Super_Happy.RefLinks;
import static Super_Happy.Game.ownedSkins;

import java.awt.*;

public class Shop extends State{

    private int currentChoice = 0;
    //private static boolean[] ownedSkins;
    private int counter=0;
    private boolean enough = false;
    private boolean selected = false;
    private boolean bought = false;
    private int contor = 0;

    public Shop(RefLinks refLink){
        super(refLink);
        //ownedSkins = new boolean[3];
    }

    @Override
    public void Update()
    {
        counter++;
        if(counter==8)
        {
            getInput();
            counter = 0;
        }
    }

    @Override
    public void Draw(Graphics g) {
        switch (currentChoice) {
            case 0:
                g.drawImage(Assets.shop1, 0, 0, null);
                break;
            case 1:
                g.drawImage(Assets.shop2, 0, 0, null);
                break;
            case 2:
                g.drawImage(Assets.shop3, 0, 0, null);
                break;
        }

        if (enough == true && contor < 60)
        {
            g.drawImage(Assets.enoughMoney,290,300,null);
            contor++;
        }
        if (bought == true && contor < 60)
        {
            g.drawImage(Assets.succBought,290,300,null);
            contor++;
        }
        if (selected == true && contor < 60)
        {
            g.drawImage(Assets.skinSelected,290,300,null);
            contor++;
        }

        g.setColor(new Color(191, 180, 12));
        g.setFont(new Font("Aerial", Font.BOLD, 20));
        g.drawString(Integer.toString(refLink.GetGame().coins),465,107);
    }

    @Override
    public void resetState(){
        enough      = false;
        bought      = false;
        selected    = false;
        contor      = 0;
    }

    private void select(){
        try {

            if (currentChoice == 0) {
                selected = false;
                bought = false;
                enough = false;
                if (ownedSkins[currentChoice] == true) {
                    PlayState.hero.setSkin(2);
                    selected = true;
                    contor = 0;
                } else {
                    if (refLink.GetGame().coins >= 5) {
                        ownedSkins[currentChoice] = true;
                        db.updateSkin("skin2", 1);
                        PlayState.hero.setSkin(2);
                        refLink.GetGame().coins -= 5;
                        bought = true;
                        contor = 0;
                    } else {
                        contor = 0;
                        enough = true;
                    }
                }
            }

            if (currentChoice == 1) {
                selected = false;
                bought = false;
                enough = false;
                if (ownedSkins[currentChoice] == true) {
                    PlayState.hero.setSkin(3);
                    selected = true;
                    contor = 0;
                } else {
                    if (refLink.GetGame().coins >= 15) {

                        ownedSkins[currentChoice] = true;
                        db.updateSkin("skin3", 1);
                        PlayState.hero.setSkin(3);
                        refLink.GetGame().coins -= 15;
                        bought = true;
                        contor = 0;
                    } else {
                        contor = 0;
                        enough = true;
                    }

                }
            }

            if (currentChoice == 2) {
                selected = false;
                bought = false;
                enough = false;
                if (ownedSkins[currentChoice] == true) {
                    PlayState.hero.setSkin(1);
                    selected = true;
                    contor = 0;
                } else {
                    if (refLink.GetGame().coins >= 25) {
                        ownedSkins[currentChoice] = true;
                        db.updateSkin("skin1", 1);
                        PlayState.hero.setSkin(1);
                        refLink.GetGame().coins -= 25;
                        bought = true;
                        contor = 0;
                    } else {
                        contor = 0;
                        enough = true;
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("Not hero yet!");
        }

    }

    private void getInput(){
        if(refLink.GetKeyManager().esc==true) {
            State.SetState(new MenuState(refLink));
        }

        if(refLink.GetKeyManager().enter)
            select();


        if(refLink.GetKeyManager().left){
            currentChoice--;
            if(currentChoice == -1)
            {
                currentChoice = 2;
            }
        }


        if(refLink.GetKeyManager().right){
            currentChoice++;
            if(currentChoice == 3)
                currentChoice = 0;
        }
    }


}
