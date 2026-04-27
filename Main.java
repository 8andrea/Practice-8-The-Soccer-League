//4 teams
//2 games played on Tuesday only
//<= 32 degrees no games played
//3 freezing weeks in a row means season ends
//get random temperature
//
// [Team 1, Team 2, Team 3, Team 4]
// rand.nextint(4);
//
// Keeps tracks of seasons
// Class Teams - Data Fields: name, Win-total, loss-total, total goals scored, and total goals allowed, Methods: print_stats()
// Class Game - Data Fields: id number, team's score, temperature
// Random score - min 0 max 20
//

import java.util.ArrayList;
import java.util.Random;


public class Main {
    static void main(String[] args) {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Team team3 = new Team("Team 3");
        Team team4 = new Team("Team 4");

        Team[] teams = {team1, team2, team3, team4};
        ArrayList<Game> games_played = new ArrayList<Game>();


        Random rand = new Random ();
        int winter_weeks = 0;
        int gameID = 1;


        while (winter_weeks < 3 ) {

            //generate random temperature
            double temp = rand.nextDouble(100);

            // Decide if game is played or not
            if (temp <= 32) {
                winter_weeks++;
                if (winter_weeks == 3){
                    System.out.println("too cold to play");
                    System.out.println("too cold to play");
                    System.out.println("too cold to play");
                }
                continue;
            }
            else {
                //A game is played


                // reset winter_weeks
                winter_weeks = 0;

                // Select team 4 first
                Team home1 = teams[3];

                // Randomly select another team from array
                int awayTeam = rand.nextInt(3);
                Team away1 = teams[awayTeam];

                // Select other 2 teams for Game 2
                Team home2 = null;
                Team away2 = null;

                switch (awayTeam) {
                    case 0:
                        home2 = teams[1];
                        away2 = teams[2];
                        break;
                    case 1:
                        home2 = teams[0];
                        away2 = teams[2];
                        break;
                    case 2:
                        home2 = teams[0];
                        away2 = teams[1];
                        break;
                }

                Game game1 = null;
                Game game2 = null;

                // Randomly select scores
                if (temp <= 49) {
                    game1 = new Game(gameID, temp, away1, home1, rand.nextInt(6), rand.nextInt(6));
                    game2 = new Game(gameID + 1, temp, away2, home2, rand.nextInt(6), rand.nextInt(6));
                }
                else if(temp <= 66) {
                    game1 = new Game(gameID, temp, away1, home1, rand.nextInt(11), rand.nextInt(11));
                    game2 = new Game(gameID + 1, temp, away2, home2, rand.nextInt(11), rand.nextInt(11));

                }
                else if(temp <= 83){
                    game1 = new Game(gameID, temp, away1, home1, rand.nextInt(16), rand.nextInt(16));
                    game2 = new Game(gameID + 1, temp, away2, home2, rand.nextInt(16), rand.nextInt(16));

                }
                else if (temp <= 100){
                    game1 = new Game(gameID, temp, away1, home1, rand.nextInt(21), rand.nextInt(21));
                    game2 = new Game(gameID + 1, temp, away2, home2, rand.nextInt(21), rand.nextInt(21));
                }

                gameID+=2;


                // Game 1 Total Goals
                away1.setTotal_goals_scored(away1.getTotal_goals_scored() + game1.getAway_score());
                away1.setTotal_goals_allowed(away1.getTotal_goals_allowed() + game1.getHome_score());
                home1.setTotal_goals_scored(home1.getTotal_goals_scored() + game1.getHome_score());
                home1.setTotal_goals_allowed(home1.getTotal_goals_allowed() + game1.getAway_score());

                //Game 2 Total goals
                away2.setTotal_goals_scored(away2.getTotal_goals_scored() + game2.getAway_score());
                away2.setTotal_goals_allowed(away2.getTotal_goals_allowed() + game2.getHome_score());
                home2.setTotal_goals_scored(home2.getTotal_goals_scored() + game2.getHome_score());
                home2.setTotal_goals_allowed(home2.getTotal_goals_allowed() + game2.getAway_score());

                games_played.add(game1);
                games_played.add(game2);

                record_WLT(game1);
                record_WLT(game2);

            }
        } // end of while loop

        System.out.println("Season is over.");
        System.out.println("*********RESULTS*********\n\n\n");

        for (Team team : teams){
            team.print_stats();
        }

        System.out.println("\n");

        for (Game game : games_played){
            game.print_stats();
            System.out.println();
        }

    }

    public static void record_WLT(Game game){
        if (game.getAway_score() > game.getHome_score()){
            game.getAway().setWin_total(game.getAway().getWin_total() + 1);
            game.getHome().setLoss_total(game.getHome().getLoss_total() + 1);

        }
        else if (game.getHome_score() > game.getAway_score()) {
            game.getHome().setWin_total(game.getHome().getWin_total() + 1);
            game.getAway().setLoss_total(game.getAway().getLoss_total() + 1);
        }
        else{
            game.getHome().setTie_total(game.getHome().getTie_total() + 1);
            game.getAway().setTie_total(game.getAway().getTie_total() + 1);
        }
    }
}


