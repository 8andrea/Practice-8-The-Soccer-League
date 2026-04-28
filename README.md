# Practice-8-The-Soccer-League

# Team and Game Class 
* I used private data fields to encapsulate the team's and Game's information. I made these data types private since only the team needs to access this info.
  
* I then used a constructor in both classes to assign each team and game their values. This will then be initialized once the object is created.
  
* Getters and Setters were used to get the private data fields and update the teams/Games statistics since the private data fields cannot be accessed in other classes. 

* Lastly, I created a print method to print out the teams/Games statistics and format the output. 

# Main Class
* I used an array to store all 4 teams. I then used an array list to store the games played in the season since the games depend on the temperature.

* The random class was used to generate the temperature, which teams played against each other, and the game score.

* I used if statements to check if games can be played based on the temperature, keep track if temperature is below 32 degrees, and increase the score when the temperature was warm.

* A switch statement was used to set up a match for the remaining teams after the first matchup was chosen. This also made sure that the teams don't end up playing against themselves or play more than once.

* I created a record_WLT method to update the team's wins, losses, and ties after each game. This was so that the code wouldn't have to repeat multiple times.

* I then used setter methods to updated each team's goal scored and allowed after every game. 

* A counter variable was used to keep track of the temperatures that were freezing. If the temperature was below 32 for 3 weeks in a row, the season would end. 
