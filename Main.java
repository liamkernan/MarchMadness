import java.util.*;

public class Main {
    
    //arrays for team information that will be referenced
    final static String[] teamName = {"Abilene Christian","Akron","Alabama","Albany","American","Arizona","Arizona St.","Arkansas","Auburn","Austin Peay","Baylor","Belmont","Boise St.","Bradley","Bucknell","Buffalo","Butler","BYU","Cal Poly","Cal St. Bakersfield","Cal St. Fullerton","California","Chattanooga","Cincinnati","Clemson","Cleveland St.","Coastal Carolina","Colgate","College of Charleston","Colorado","Colorado St.","Connecticut","Creighton","Davidson","Dayton","Delaware","Drake","Drexel","Duke","Duquesne","East Tennessee St.","Eastern Kentucky","Eastern Washington","Fairleigh Dickinson","Florida","Florida Atlantic","Florida Gulf Coast","Fresno St.","Furman","Gardner Webb","George Washington","Georgetown","Georgia","Georgia St.","Georgia Tech","Gonzaga","Grambling St.","Grand Canyon","Green Bay","Hartford","Harvard","Hawaii","Holy Cross","Howard","Illinois","Indiana","Iona","Iowa","Iowa St.","Jacksonville St.","James Madison","Kansas","Kansas St.","Kennesaw St.","Kent St.","Kentucky","La Salle","Lafayette","Liberty","Lipscomb","Little Rock","LIU Brooklyn","Long Beach St.","Longwood","Louisiana Lafayette","Louisville","Loyola Chicago","LSU","Manhattan","Marquette","Marshall","Maryland","Massachusetts","McNeese St.","Memphis","Mercer","Miami FL","Michigan","Michigan St.","Middle Tennessee","Milwaukee","Minnesota","Mississippi","Mississippi St.","Missouri","Montana","Montana St.","Morehead St.","Mount St. Mary's","Murray St.","Nebraska","Nevada","New Mexico","New Mexico St.","Norfolk St.","North Carolina","North Carolina A&T","North Carolina Central","North Carolina St.","North Dakota","North Dakota St.","North Texas","Northeastern","Northern Iowa","Northern Kentucky","Northwestern","Northwestern St.","Notre Dame","Oakland","Ohio","Ohio St.","Oklahoma","Oklahoma St.","Old Dominion","Oral Roberts","Oregon","Oregon St.","Pacific","Penn","Penn St.","Pittsburgh","Princeton","Providence","Purdue","Radford","Rhode Island","Richmond","Robert Morris","Rutgers","Saint Joseph's","Saint Louis","Saint Mary's","Saint Peter's","Samford","San Diego St.","San Francisco","Seton Hall","SMU","South Carolina","South Dakota St.","Southern","St. Bonaventure","St. John's","Stanford","Stephen F. Austin","Stetson","Stony Brook","Syracuse","TCU","Temple","Tennessee","Texas","Texas A&M","Texas A&M Corpus Chris","Texas Southern","Texas Tech","Troy","Tulsa","UAB","UC Davis","UC Irvine","UC Santa Barbara","UCF","UCLA","UMBC","UNC Asheville","UNC Greensboro","UNC Wilmington","UNLV","USC","Utah","Utah St.","Valparaiso","Vanderbilt","VCU","Vermont","Villanova","Virginia","Virginia Tech","Wagner","Wake Forest","Washington","Washington St.","Weber St.","West Virginia","Western Kentucky","Western Michigan","Wichita St.","Winthrop","Wisconsin","Wofford","Wright St.","Wyoming","Xavier","Yale", "loser", "Houston"};
    final static double[] o_Rate = {-0.691,3.702,9.979,1.031,-0.083,12.959,12.959,8.906,11.217,-0.421,12.766,9.39,6.438,-0.607,5.225,6.168,8.764,10.492,-1.285,-2.418,0.016,6.381,3.917,6.305,7.331,-4.55,-2.251,5.708,6.055,5.666,10.106,10.822,11.734,12.404,6.54,3.664,7.646,3.753,15.535,1.615,1.919,6.938,6.894,0.74,10.945,9.405,1.631,3.258,9.848,1.972,3.874,6.588,4.352,4.283,7.624,15.975,-5.849,4.071,2.603,-4.853,5.384,3.786,-5.713,-0.481,11.002,12.304,5.611,13.431,10.42,0.541,2.335,11.813,6.142,-0.35,1.532,13.908,7.117,9.432,2.446,0.989,4.257,4.183,0.806,1.414,3.929,10.031,7.197,9.236,1.067,10.613,3.181,7.836,4.191,5.375,8.771,3.728,10.341,13.212,10.618,4.164,-2.066,5.897,7.566,6.731,8.254,3.833,0.12,-0.489,-3.028,8.846,4.901,8.066,7.978,4.816,-1.491,12.859,-10.701,-2.398,9.089,-0.611,4.266,2.117,6.575,7.305,2.058,5.067,1.697,14.138,2.955,7.108,10.085,8.294,8.758,-1.637,7.169,9.895,4.425,1.878,0.84,10.076,10.573,4.438,6.038,12.773,-1.891,6.096,6.835,-0.728,3.369,7.355,3.309,8.937,-5.433,6.674,4.127,6.948,5.899,13.529,3.656,8.051,-5.893,6.85,5.678,7.886,6.102,3.26,3.535,6.207,8.535,4.866,9.076,7.214,8.529,-2.535,-2.154,8.172,3.857,3.111,4.608,-4.965,2.596,5.378,4.702,10.772,-1.691,-2.036,1.634,7.299,4.975,7.499,11.089,6.086,5.666,9.297,5.466,5.106,13.203,9.531,10.577,-8.251,13.347,3.681,6.405,0.171,9.917,-0.56,0.961,8.662,3.353,9.519,3.221,1.187,3.071,11.192,3.265, 0.1, 10};
    final static double[] d_Rate = {3.88,4.398,9.196,0.333,5.593,10.404,10.404,7.111,10.094,-5.608,6.439,0.307,5.477,2.19,4.476,3.302,6.259,5.359,0.157,5.585,-0.382,7.866,3.889,11.269,8.163,0.984,2.271,0.863,2.235,7.712,4.296,9.561,6.746,1.614,6.868,-0.509,3.939,-2.872,8.793,6.187,4.942,-3.807,-2.054,-7.886,10.797,6.038,1.874,3.809,1.02,-3.682,7.548,9.91,8.898,3.075,6.04,9.826,-2.183,3.229,0.879,1.037,5.259,6.844,-2.375,-3.777,7.649,6.277,-0.478,5.67,7.559,0.045,2.398,10.4,9.078,1.6,4.491,9.757,3.924,-9.156,-1.067,1.05,6.417,-7.3,-0.569,0.478,0.196,14.369,8.675,7.027,5.834,6.313,2.242,7.252,8.312,2.466,9.118,4.791,6.71,7.331,9.34,7.105,-0.75,7.552,5.458,8.836,4.762,2.709,1.115,2.974,-1.439,4.739,7.538,5.13,8.39,4.478,-0.064,9.466,2.873,0.998,4.48,1.624,0.129,5.569,0.539,6.58,0.112,7.886,-1.587,3.751,-0.615,-0.24,8.237,7.696,7.335,10.352,-1.193,6.968,3.625,-0.905,4.029,2.709,5.202,3.607,6.17,8.606,1.37,8.6,3.343,0.526,9.112,6.051,11.579,7.752,6.25,0.747,10.893,8.075,8.279,8.72,8.35,-0.882,1.524,6.12,5.115,6.212,4.312,-6.895,4.206,9.133,6.586,3.845,11.904,9.493,8.423,-1.712,-2.575,9.888,-2.883,6.431,2.033,4.241,5.963,1.697,10.633,6.971,-0.173,2.683,6.845,0.796,10.813,6.095,8.088,6.28,4.651,8.151,10.517,4.062,9.229,13.633,5.319,-0.494,1.378,9.903,7.439,1.598,9.141,1.677,1.378,8.903,2.975,9.886,2.796,2.112,4.259,5.398,3.823, 0.1, 10};
    final static int[] roundLog2 = {6,6,4,6,6,4,6,4,5,6,4,6,6,6,6,6,5,6,6,6,6,6,6,6,4,6,6,6,6,6,6,3,5,6,5,6,6,6,3,5,6,6,6,6,4,4,5,6,5,6,6,6,6,6,6,3,6,6,6,6,5,5,6,6,5,5,6,5,5,6,6,4,5,6,6,4,4,6,6,5,5,6,6,6,6,4,4,5,6,5,5,5,6,6,5,5,4,3,4,5,6,5,6,6,6,6,6,6,6,5,6,6,6,6,6,4,6,6,5,6,6,5,6,5,6,5,6,4,5,5,5,5,6,6,5,4,5,6,6,5,6,5,6,4,6,5,5,6,6,6,5,6,5,6,5,6,6,6,4,6,6,6,6,4,6,6,6,4,6,6,4,5,5,6,6,4,6,6,6,6,6,6,5,4,5,6,6,6,6,5,5,6,6,6,6,6,4,5,6,6,6,5,5,6,5,6,6,5,6,4,6,6,6,5,6, 6, 4};
    final static int[] wins = {1,0,9,0,0,19,1,11,7,0,20,0,0,0,0,2,17,3,0,0,0,2,0,6,5,1,0,0,0,3,1,29,11,3,6,0,0,0,37,1,0,0,0,1,19,4,2,0,1,0,0,3,0,1,1,34,0,1,0,0,2,1,0,0,7,7,0,4,11,0,1,41,12,0,0,32,2,0,1,0,1,0,0,0,0,22,6,4,0,12,1,8,0,0,10,1,12,24,32,2,0,2,1,1,5,0,0,1,0,4,0,2,2,1,1,41,0,0,8,0,1,1,0,4,0,3,0,10,1,4,15,12,2,1,2,16,3,0,0,1,8,2,3,21,0,2,3,0,1,1,3,5,3,0,13,0,1,0,4,0,0,0,0,4,2,0,0,21,2,2,16,11,8,0,0,11,0,0,1,0,1,0,1,20,1,0,0,0,1,5,3,1,0,1,7,0,29,13,2,0,1,5,3,0,14,3,0,9,0,23,1,0,0,18,2,0, 10};
    final static int[] loss = {2,5,6,3,3,12,4,7,5,2,11,6,3,1,4,4,9,8,1,1,3,4,3,9,7,2,2,5,3,6,4,6,9,6,6,2,4,1,13,1,3,1,2,2,10,2,3,1,1,1,1,7,3,4,2,16,1,3,1,1,4,1,1,1,7,7,7,6,10,2,2,14,10,1,3,12,1,1,2,1,1,2,2,2,2,9,3,5,1,11,1,8,1,1,8,1,7,11,15,2,1,5,3,4,8,5,2,4,2,5,2,4,5,9,3,12,1,1,7,1,4,2,2,4,3,3,1,9,3,3,11,9,7,3,3,9,2,1,1,2,8,3,6,14,2,2,3,3,1,3,4,9,3,1,11,1,5,2,2,7,1,3,2,2,5,1,1,10,4,7,11,13,8,1,5,6,1,1,3,1,2,4,1,10,2,4,2,2,5,7,3,7,2,5,11,7,11,8,5,1,2,4,2,2,11,5,1,7,3,14,5,2,1,10,4, 10, 7};
    //divider
    
    static ArrayList<Team> teams = new ArrayList<Team>();
    
    public static void main(String[] args) {
        
        String[] teamInR64 = {
            "Auburn" , "San Francisco" ,
            "Louisville" , "Creighton" ,
            "Michigan" , "loser" ,
            "Texas A&M" , "Yale" ,
            "Mississippi" , "loser" ,
            "Iowa St." , "Lipscomb" ,
            "Marquette" , "New Mexico" ,
            "Michigan St." , "loser" ,
            "Florida" , "Norfolk St." ,
            "Connecticut" , "Oklahoma" ,
            "Memphis" , "Colorado St." ,
            "Maryland" , "Grand Canyon" ,
            "Missouri" , "Drake" ,
            "Texas Tech" , "UNC Wilmington" ,
            "Kansas" , "Arkansas" ,
            "St. John's" , "Nebraska" ,
            "Tenneessee" , "Wofford" ,
            "UCLA" , "Utah St." ,
            "Kentucky" , "Troy" ,
            "Illinois" , "loser" ,
            "Purdue" , "High Point" ,
            "Clemson" , "McNeese" ,
            "Gonzaga" , "Georgia" ,
            "Houston" , "Edwardsville" ,
            "Alabama" , "Robert Morris" ,
            "Saint Mary's" , "Vanderbilt" ,
            "Wisconsin" , "Montana" ,
            "BYU" , "VCU" ,
            "Arizona" , "Akron" ,
            "Oregon" , "Liberty" ,
            "Mississippi St" , "Baylor" ,
            "Duke" , "loser" 
        };
        
        String[] seedsR64 = {
            "01a" , "16a" ,
            "08a" , "09a" ,
            "05a" , "12a" ,
            "04a" , "13a" ,
            "06a" , "11a" ,
            "03a" , "14a" ,
            "07a" , "10a" ,
            "02a" , "15a" ,
            "01b" , "16" ,
            "08b" , "09b" ,
            "05b" , "12b" ,
            "04b" , "13b" ,
            "06b" , "11b" ,
            "03b" , "14b" ,
            "07b" , "10b" ,
            "02b" , "15b" ,
            "02c" , "15c" ,
            "07c" , "10c" ,
            "03c" , "14c" ,
            "06c" , "11c" ,
            "04c" , "13c" ,
            "05c" , "12c" ,
            "08c" , "09c" ,
            "01c" , "16c" ,
            "02d" , "15d" ,
            "07d" , "10d" ,
            "03d" , "14d" ,
            "06d" , "11d" ,
            "04d" , "13d" ,
            "05d" , "12d" ,
            "08d" , "09d" ,
            "01d" , "16d" ,
        };
        

        System.out.println("March Madness 25' Predictions: ");
        System.out.println();
        int count = 0;
        for(int i = 0; i < 64; i++){
            int index = 0;
            boolean inList = false;
            while(!inList && index < teamName.length){
                if(teamInR64[count].equals(teamName[index])){
                    inList = true;
                    break;
                }
                index++;
            }
            
            String tN = "";
            String seed = "";
            double o = 0;
            double d = 0;
            int r = 0;
            double wl = 0;
            
            if(inList){
                tN = teamInR64[count];
                seed = seedsR64[count];
                o = o_Rate[index];
                d = d_Rate[index];
                wl = wins[index]/loss[index];
                r = roundLog2[index];
            } else {
                tN = teamInR64[count];
                seed = seedsR64[count];
            }
            
            Team t = new Team(tN, seed, o, d, r, wl);
            teams.add(t);
            count++;
        }
        /*
        Team[] cA = new Team[16];
        Team[] cB = new Team[16];
        Team[] cC = new Team[16];
        Team[] cD = new Team[16];
        int countA = 0;
        int countB = countA;
        int countC = countB;
        int countD = countC;
        for(int i = 0; i<teams.size(); i++){
            String s1 = teams.get(i).getSeed();
            if(s1.substring(2).equals("a")){
                cA[countA] = teams.get(i);
                countA++;
            } else if(s1.substring(2).equals("b")){
                cB[countB] = teams.get(i);
                countB++;
            } else if(s1.substring(2).equals("c")){
                cC[countC] = teams.get(i);
                countC++;
            } else if(s1.substring(2).equals("d")){
                cD[countD] = teams.get(i);
                countD++;
            }
        }
        */
        
        //matchups have to be made - from arraylist of all teams in MM, pairups have to be handcoded
        Team[][] round64Start = new Team[32][2];
        /*
        round64Start
        0.) [][]
        1.) [][]
        2.) [][]
        ...
        32.) [][]
        */
        //System.out.println("Enter the teams that are playing with seed in the form TeamSeedDivision ex: Arizona4c");
        
        for(int i = 0; i < 64; i+=2){
            round64Start[i/2][0] = teams.get(i);
            round64Start[i/2][1] = teams.get(i+1);
        }
        
        
        
        Bracket b = new Bracket(round64Start);
        b.runSim(round64Start);
        
        
        
        //pull from the data to figure out which teams are playing
        
        //run through data to get score and predict winner
        
        //return winner
        
        //advance winner in the rank
        
    }
    
    //clears console, does not need to be used
    public static void c(){
        System.out.println("\033[2J\033[H");
    }
    
    //method for delaying actions, will delay any code procedeing it by n * 0.1 seconds, does not need to be used
    public static void w(int n){
        try{
            Thread.sleep(n * 100);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
    
    //method for "loading" animation, does not need to be used
    public static void loader(String s, int len){
        for(int l = 0; l < len; l++){
            String temp = s;
            for(int i = 0; i < 4; i++){
                System.out.println(temp);
                temp += ".";
                w(3);
                c();
            }
        }
    }
    
    
    
    
    
}