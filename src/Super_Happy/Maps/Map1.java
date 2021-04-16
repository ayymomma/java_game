package Super_Happy.Maps;

import Super_Happy.Items.Coins;
import Super_Happy.Items.SluggerEnemy;
import Super_Happy.Items.SpiderEnemy;
import Super_Happy.RefLinks;

public class Map1 extends Map {


    public Map1(RefLinks refLink) {
        super(refLink);
    }

    @Override
    protected int MiddleEastMap(int x, int y) {

        final int map1[][] = {
                {5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 15, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 15, 15, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8, 10, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 4},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 4, 5, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8, 10, 3, 0, 0, 0, 0, 0, 4},
                {10, 11, 2, 2, 2, 3, 0, 1, 2, 2, 2, 2, 16, 0, 14, 7, 8, 10, 11, 16, 0, 0, 0, 14, 16, 0, 0, 0, 0, 1, 2, 2, 2, 8, 5, 10, 11, 7, 8, 5, 5, 10, 11, 2, 16, 0, 0, 14, 2, 7, 8, 5, 5, 10, 2, 2, 2, 2, 7, 8},
                {5, 5, 5, 5, 5, 6, 0, 4, 5, 5, 5, 5, 0, 0, 0, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}};

        return map1[x][y];

    }

    public void populateEnemies(){

        enemy = new SluggerEnemy[3];
        enemy[0] = new SluggerEnemy(refLink,1400,340,130);
        enemy[1] = new SluggerEnemy(refLink,2110,142,140);
        enemy[2] = new SluggerEnemy(refLink,2600,340,195);


        spider = new SpiderEnemy[3];
        spider[0] = new SpiderEnemy(refLink,1000,40,60);
        spider[1] = new SpiderEnemy(refLink,675,230,60);
        spider[2] = new SpiderEnemy(refLink,1630,40,70);


        coins = new Coins[7];
        coins[0] = new Coins(refLink,455,238);
        coins[1] = new Coins(refLink,670,142);
        coins[2] = new Coins(refLink,1007,238);
        coins[3] = new Coins(refLink,1632,142);
        coins[4] = new Coins(refLink,2112,142);
        coins[5] = new Coins(refLink,2262,142);
        coins[6] = new Coins(refLink,2595,334);
    }


}