package Super_Happy.Maps;

import Super_Happy.Items.Coins;
import Super_Happy.Items.SluggerEnemy;
import Super_Happy.Items.SpiderEnemy;
import Super_Happy.RefLinks;

public class Map2 extends Map {


    public Map2(RefLinks refLink) {
        super(refLink);
    }

    @Override
    protected int MiddleEastMap(int x, int y) {

        final int map2[][] = {
                {5,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,5,},
                {6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,},
                {6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,},
                {6,0,0,0,0,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,},
                {6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,15,0,0,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,},
                {6,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,0,14,15,16,0,0,0,0,0,0,15,0,0,4,},
                {6,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,},
                {6,0,0,0,0,0,0,0,0,0,0,0,4,5,5,6,0,0,0,0,2,0,0,0,0,0,0,0,0,4,5,5,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,3,0,0,0,0,4,},
                {10,11,2,2,2,2,2,2,2,2,2,2,8,5,5,10,3,0,0,1,5,3,0,1,2,2,2,2,2,8,5,5,10,3,0,1,2,2,2,2,2,3,0,0,0,1,2,2,2,2,2,8,5,5,10,2,2,2,2,8,},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,0,0,4,5,6,0,4,5,5,5,5,5,5,5,5,5,6,0,4,5,5,5,5,5,6,0,0,0,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5}
        };

        return map2[x][y];

    }

    public void populateEnemies(){

        enemy = new SluggerEnemy[3];
        enemy[0] = new SluggerEnemy(refLink,1100,340,250);
        enemy[1] = new SluggerEnemy(refLink,2245,190,140);
        enemy[2] = new SluggerEnemy(refLink,2630,340,150);


        spider = new SpiderEnemy[3];
        spider[0] = new SpiderEnemy(refLink,1000,40,60);
        spider[1] = new SpiderEnemy(refLink,635,190,40);
        spider[2] = new SpiderEnemy(refLink,1630,40,70);


        coins = new Coins[7];
        coins[0] = new Coins(refLink,385,190);
        coins[1] = new Coins(refLink,625,95);
        coins[2] = new Coins(refLink,962,142);
        coins[3] = new Coins(refLink,1632,142);
        coins[4] = new Coins(refLink,2065,94);
        coins[5] = new Coins(refLink,2262,192);
        coins[6] = new Coins(refLink,2690,190);
    }
}
