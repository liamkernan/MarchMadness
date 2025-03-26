import java.util.*;

/*
spreadsheet: https://docs.google.com/spreadsheets/d/1Dl_S3lyLL665QXSnlcxmzdP9wEN9VE1X0p39iwXMjGA/edit?usp=sharing

DO NOT PUT CSV FILES HERE

2025 bracket not finalized: https://www.espn.com/espn/feature/story/_/page/bracketology/ncaa-bracketology-2025-march-madness-men-field-predictions

Team object format for reference = new Team(String name, String seed, double orate, double drate, int round, double winLoss)
*/

public class Bracket {
    private Team r64[][];
    private Team r32[][];
    private Team r16[][];
    private Team e8[][];
    private Team f4[][];
    private Team f2[];
    
    public Bracket(Team[][] r64){
        this.r64 = r64;
        r32 = new Team[16][2];
        r16 = new Team[8][2];
        e8 = new Team[4][2];
        f4 = new Team[2][2];
        f2 = new Team[2];
    }
    
    //method allows for pitting 2 teams against each other for winning
    public Team arenaMatch(Team t1, Team t2){
        
        String name = ""; //team name
        String seed = ""; //given seed
        double o = 0.0; //team o rate
        double d = 0.0; //team d rate
        int r = 0; //team round
        double wl = 0.0; //team wl ratio
        
        if(Team.getWinPercent(t1, t2)){ //team 1 wins by win%
            name = t1.getName();
            seed = t1.getSeed();
            o = t1.getORate();
            d = t1.getDRate();
            r = t1.getRound();
            wl = t1.getRatio();
        } else if(!Team.getWinPercent(t1, t2)){ //team 2 wins by win%
            name = t2.getName();
            seed = t2.getSeed();
            o = t2.getORate();
            d = t2.getDRate();
            r = t2.getRound();
            wl = t2.getRatio();
        }
        
        
        Team winner = new Team(name, seed, o, d, r, wl);
        return winner;
    }
    
    
    
    //takes the bracket of 64, and runs arena match with the matchups, where each row has a pair of team facing each other, 2 total columns
    public void runSim(Team[][] bracketOf64){
        System.out.println();
        System.out.println("Round of 32");
        System.out.println();
        for (int i = 0; i < r32.length; i++){
            int j = 0;
            r32[i][j] = arenaMatch(bracketOf64[i*2][0], bracketOf64[i*2][1]);
            j++;
            r32[i][j] = arenaMatch(bracketOf64[(i*2) + 1][0], bracketOf64[(i*2) + 1][1]);
            
            System.out.println(r32[i][0].getName() + " vs. " + r32[i][1].getName());
        }
        System.out.println();
        System.out.println("Sweet 16");
        System.out.println();
        for (int i = 0; i < r16.length; i++){
            int j = 0;
            r16[i][j] = arenaMatch(r32[(i*2)][0], r32[i*2][1]);
            j++;
            r16[i][j] = arenaMatch(r32[(i*2) + 1][0], r32[(i*2) + 1][1]);
            
            System.out.println(r16[i][0].getName() + " vs. " + r16[i][1].getName());
        }
        System.out.println();
        System.out.println("Elite 8");
        System.out.println();
        for (int i = 0; i < e8.length; i++){
            int j = 0;
            e8[i][j] = arenaMatch(r16[i*2][0], r16[i*2][1]);
            j++;
            e8[i][j] = arenaMatch(r16[(i*2) + 1][0], r16[(i*2) + 1][1]);
            
            System.out.println((e8[i][0]).getName() + " vs. " + (e8[i][1]).getName());
        }
        System.out.println();
        System.out.println("Final Four");
        System.out.println();
        for (int i = 0; i < f4.length; i++){
            int j = 0;
            f4[i][j] = arenaMatch(e8[i*2][0], e8[i*2][1]);
            j++;
            f4[i][j] = arenaMatch(e8[(i*2) + 1][0], e8[(i*2) + 1][1]);
            
            System.out.println((f4[i][0]).getName() + " vs. " + (f4[i][1]).getName());
        }
        System.out.println();
        System.out.println("Final Two");
        System.out.println();
    
            f2[0] = arenaMatch(f4[0][0], f4[0][1]);
            f2[1] = arenaMatch(f4[1][0], f4[1][1]);
            
            System.out.println((f2[0]).getName() + " vs. " + (f2[1]).getName());
        System.out.println();
        System.out.println(arenaMatch(f2[0], f2[1]).getName() + " is the predicted winner of the 2025 March Madness Tournament.");
    }
    
}