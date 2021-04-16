package Super_Happy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {

    protected Connection c;
    protected Statement stmt;

    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");
            c= DriverManager.getConnection("jdbc:sqlite:database.db");
            stmt=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getData(String data){
        int q=0;
        try{
            ResultSet rs=stmt.executeQuery("SELECT " + data +" FROM "+ "MainTable");
            q= rs.getInt(data);
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return q;
    }

    public void updateSettings(int difficulty){
        try{
            stmt.executeUpdate("UPDATE MainTable SET difficulty = " + difficulty);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCoins(int coins){
        try{
            stmt.executeUpdate("UPDATE MainTable SET coins = " + coins);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSkin(String skinName,int skin){
        try{
            stmt.executeUpdate("UPDATE MainTable SET " + skinName + " = " + skin);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateLevel(int level){
        try{
            stmt.executeUpdate("UPDATE MainTable SET level = " + level);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}