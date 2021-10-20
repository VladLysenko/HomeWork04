package Part2HW.hw1;

public class App {

    public static void main(String[] args) {
        int Stage = 0;

        Team[] team = new Team[3];
        team[0] = new Cat("Boris",700, 5);
        team[1] = new Man("Oleg",3000, 3);
        team[2] = new Robot("Ai012",30000, 15);

        Treadmill treadmill = new Treadmill(300);
        Wall wall = new Wall(2);


        playMarathon(team, treadmill, wall);
    }


    public static void playMarathon(Team[] team, Treadmill treadmill, Wall wall) {
        int Stage;
        do {
            for ( Stage = 1; Stage <=3 ; Stage++) {
                treadmill.setRange(treadmill.getRange()*Stage);
                wall.setHeight(wall.getHeight()*Stage);
                for (int i = 0; i < 3; i++) {
                    if (team[i].getMaxRange() < treadmill.getRange()){
                        continue;
                    }
                    team[i].runTreadmill(treadmill);
                }
                for (int j = 0; j < 3; j++) {
                    if (team[j].getMaxJump() < wall.getHeight()) {
                        continue;
                    }
                    team[j].jumpWall(wall);
                }
                System.out.println("\n" + Stage + " этап окончен" + "\n");
            }
        } while (Stage == 3);
    }
}