package Super_Happy.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage       spriteSheet;        /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int    tileWidth   = 48;   /*!< Latimea unei dale din sprite sheet.*/
    private static final int    tileHeight  = 48;   /*!< Inaltime unei dale din sprite sheet.*/

    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }

    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }


    public BufferedImage crop2(int x,int y, int ctileWidth,int ctileHeight){
        return spriteSheet.getSubimage(x * ctileWidth, y * ctileHeight, ctileWidth, ctileHeight);
    }
}
