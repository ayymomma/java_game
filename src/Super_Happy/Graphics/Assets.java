package Super_Happy.Graphics;

import Super_Happy.Maps.MapManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Assets
{

    public static BufferedImage[] heroRunRight;
    public static BufferedImage[] heroRunRight2;
    public static BufferedImage[] heroRunRight3;
    public static BufferedImage[] heroRunRight4;

    public static BufferedImage[] heroIdleRight;
    public static BufferedImage[] heroIdleRight2;
    public static BufferedImage[] heroIdleRight3;
    public static BufferedImage[] heroIdleRight4;

    public static BufferedImage[] heroRunLeft;
    public static BufferedImage[] heroRunLeft2;
    public static BufferedImage[] heroRunLeft3;
    public static BufferedImage[] heroRunLeft4;
    public static BufferedImage[] heroDead;

    public static BufferedImage enemySluggerF;
    public static BufferedImage enemySluggerB;
    public static BufferedImage enemySluggerFA;
    public static BufferedImage enemySluggerBA;
    public static BufferedImage enemySpider;


    public static BufferedImage[] tileLevel1 = new BufferedImage[16];
    public static BufferedImage[] tileLevel2 = new BufferedImage[16];

    public static BufferedImage menuBackground;
    public static BufferedImage menuStart;
    public static BufferedImage menuHelp;
    public static BufferedImage menuSettings;
    public static BufferedImage menuQuit;
    public static BufferedImage menuShop;
    public static BufferedImage helpState;
    public static BufferedImage settingsEasy;
    public static BufferedImage settingsMedium;
    public static BufferedImage settingsHard;
    public static BufferedImage gameOver;
    public static BufferedImage winState;
    public static BufferedImage shop1;
    public static BufferedImage shop2;
    public static BufferedImage shop3;
    public static BufferedImage loadNew;
    public static BufferedImage loadLoad;

    public static BufferedImage[] coin;
    public static BufferedImage coinsText;
    public static BufferedImage lifesText;
    public static BufferedImage life;
    public static BufferedImage flag;
    public static BufferedImage winCondition;
    public static BufferedImage enoughMoney;
    public static BufferedImage skinSelected;
    public static BufferedImage succBought;


    public static void Init()
    {
        //harta
        SpriteSheet sheet       = new SpriteSheet(ImageLoader.LoadImage("/textures/Map/tile222.png"));
        SpriteSheet sheet1       = new SpriteSheet(ImageLoader.LoadImage("/textures/Map/tile22.png"));

        //player
        SpriteSheet sheet2      = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/IdleRight/idleRight.png"));
        SpriteSheet sheet22     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/IdleRight/idleRight2.png"));
        SpriteSheet sheet23     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/IdleRight/idleRight3.png"));
        SpriteSheet sheet24     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/IdleRight/idleRight4.png"));

        SpriteSheet sheet3      = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunRight/runRight.png"));
        SpriteSheet sheet32     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunRight/runRight2.png"));
        SpriteSheet sheet33     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunRight/runRight3.png"));
        SpriteSheet sheet34     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunRight/runRight4.png"));

        SpriteSheet sheet4      = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunLeft/runLeft.png"));
        SpriteSheet sheet42     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunLeft/runLeft2.png"));
        SpriteSheet sheet43     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunLeft/runLeft3.png"));
        SpriteSheet sheet44     = new SpriteSheet(ImageLoader.LoadImage("/textures/Player/RunLeft/runLeft4.png"));


        heroRunRight    = new BufferedImage[8];
        heroRunRight2   = new BufferedImage[8];
        heroRunRight3   = new BufferedImage[8];
        heroRunRight4   = new BufferedImage[8];


        heroIdleRight   = new BufferedImage[8];
        heroIdleRight2  = new BufferedImage[8];
        heroIdleRight3  = new BufferedImage[8];
        heroIdleRight4  = new BufferedImage[8];

        heroRunLeft     = new BufferedImage[8];
        heroRunLeft2    = new BufferedImage[8];
        heroRunLeft3    = new BufferedImage[8];
        heroRunLeft4    = new BufferedImage[8];


        heroDead        = new BufferedImage[11];

        for(int i =0;i<8;i++){
            tileLevel1[i] = sheet.crop(i,0);
            tileLevel1[i+8] = sheet.crop(i,1);
        }
        for(int i = 0;i<8;i++){
            tileLevel2[i] = sheet1.crop(i,0);
            tileLevel2[i+8] = sheet1.crop(i,1);
        }

        coin        = new BufferedImage[10];

        for(int i=0;i<10;i++) {
            coin[i] = ImageLoader.LoadImage("/textures/Coins/" + i +".png");
        }


        menuBackground  = ImageLoader.LoadImage("/textures/Backgrounds/BG.png");


        menuStart       = ImageLoader.LoadImage("/textures/Backgrounds/meniuStart.png");
        menuHelp        = ImageLoader.LoadImage("/textures/Backgrounds/meniuHelp.png");
        menuSettings    = ImageLoader.LoadImage("/textures/Backgrounds/meniuSettings.png");
        menuQuit        = ImageLoader.LoadImage("/textures/Backgrounds/meniuQuit.png");
        menuShop        = ImageLoader.LoadImage("/textures/Backgrounds/meniuShop.png");
        helpState       = ImageLoader.LoadImage("/textures/Backgrounds/helpState.png");
        settingsEasy    = ImageLoader.LoadImage("/textures/Backgrounds/settingsEasy.png");
        settingsMedium  = ImageLoader.LoadImage("/textures/Backgrounds/settingsMedium.png");
        settingsHard    = ImageLoader.LoadImage("/textures/Backgrounds/settingsHard.png");
        winState        = ImageLoader.LoadImage("/textures/Backgrounds/winState.png");
        shop1           = ImageLoader.LoadImage("/textures/Shop/select1.png");
        shop2           = ImageLoader.LoadImage("/textures/Shop/select2.png");
        shop3           = ImageLoader.LoadImage("/textures/Shop/select3.png");
        loadNew         = ImageLoader.LoadImage("/textures/Load/loadNew.png");
        loadLoad        = ImageLoader.LoadImage("/textures/Load/loadLoad.png");


        coinsText       = ImageLoader.LoadImage("/textures/Backgrounds/coins.png");
        lifesText       = ImageLoader.LoadImage("/textures/Backgrounds/lifes.png");
        life            = ImageLoader.LoadImage("/textures/Backgrounds/lifeTile.png");
        gameOver        = ImageLoader.LoadImage("/textures/Backgrounds/gameOver.png");
        flag            = ImageLoader.LoadImage("/textures/Map/flag.png");
        winCondition    = ImageLoader.LoadImage("/textures/Backgrounds/allCoinsNeed.png");
        enoughMoney     = ImageLoader.LoadImage("/textures/Backgrounds/enoughMoney.png");
        skinSelected    = ImageLoader.LoadImage("/textures/Backgrounds/skinSelected.png");
        succBought      = ImageLoader.LoadImage("/textures/Backgrounds/succBought.png");



        for(int i=0;i<7;i++)
        {
            heroIdleRight[i]    = sheet2.crop2(i,0,18,26);
            heroIdleRight2[i]   = sheet22.crop2(i,0,18,26);
            heroIdleRight3[i]   = sheet23.crop2(i,0,18,26);
            heroIdleRight4[i]   = sheet24.crop2(i,0,18,26);

            heroRunRight[i]     = sheet3.crop2(i,0,18,28);
            heroRunRight2[i]    = sheet32.crop2(i,0,18,28);
            heroRunRight3[i]    = sheet33.crop2(i,0,18,28);
            heroRunRight4[i]    = sheet34.crop2(i,0,18,28);

            heroRunLeft[i]      = sheet4.crop2(i,0,18,28);
            heroRunLeft2[i]     = sheet42.crop2(i,0,18,28);
            heroRunLeft3[i]     = sheet43.crop2(i,0,18,28);
            heroRunLeft4[i]     = sheet44.crop2(i,0,18,26);
        }


        for(int i=0;i<11;i++)
            heroDead[i] = ImageLoader.LoadImage("/textures/Player/Dead/" + i + ".png");

        enemySluggerF  = ImageLoader.LoadImage("/textures/Enemy/inamic2F.png");
        enemySluggerB  = ImageLoader.LoadImage("/textures/Enemy/inamic2B.png");
        enemySluggerFA = ImageLoader.LoadImage("/textures/Enemy/inamic2FA.png");
        enemySluggerBA = ImageLoader.LoadImage("/textures/Enemy/inamic2BA.png");
        enemySpider    = ImageLoader.LoadImage("/textures/Enemy/spider.gif");
    }
}
