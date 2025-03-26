import java.util.*;

public class Team {
    
    private String name;
    private double wlRatio;
    private String seed;
    private double oRate;
    private double dRate;
    private int round;
    
    public Team(String name, String s, double o, double d, int r, double wl){
        this.name = name;
        seed = s;
        oRate = o;
        dRate = d;
        round = r;
        wlRatio = wl;
    }
    
    public String getName(){ //name getter
        return name;
    }
    
    public String getSeed(){ //seed getter
        return seed;
    }
    
    public double getORate(){ //oRate getter
        return oRate;
    }
    
    public double getDRate(){ //dRate getter
        return dRate;
    }

    
    public int getRound(){ //round getter
        return round;
    }
    
    public double getRatio(){ //ratio getter
        return wlRatio;
    }
    
    public String toString(){
        String a = "\nTeam Name: " + getName() + "\nTeam Seed: " + getSeed();
        return a;
    }
    
    public static boolean getWinPercent(Team t1, Team t2){
        
        
        double percent1 = 0; //linked to t1
        double percent2 = 0; //linked to t2
        
        //runs through different metrics of success to assign a "value" of each team in matchup
        
        if (t1.getRound() < t2.getRound()){
            percent1 += 0.20;
        } else if (t2.getRound() < t1.getRound()){
            percent2 += 0.20;
        }
        
        if (t1.getORate() > t2.getORate()){
            percent1 += 0.15;
        } else if (t2.getORate() > t1.getORate()){
            percent2 += 0.15;
        }
        
        if (t1.getDRate() > t2.getDRate()){
            percent1 += 0.15;
        } else if (t2.getDRate() > t1.getDRate()){
            percent2 += 0.15;
        }
        
        if (t1.getRatio() > t2.getRatio()){
            percent1 += 0.25;
        } else if (t2.getRatio() > t1.getRatio()){
            percent2 += 0.25;
        }
        
        
        //checks which team has the higher score and returns it (as the "winner")
        
        return (percent1 > percent2);
        
    }
}