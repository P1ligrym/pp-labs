import java.util.*;

class TeamFight implements GameSetting {

    Game game;
    public int heroes;

    TeamFight(Game game, int heroes) {
        this.game = game;
        this.heroes = heroes;
    }

    public void pickStage() {
        for(int i = 0; i < this.heroes; ++i) {
            for(Player player : this.game.players) {
                pickHeroes(player);
            }
        }
        this.showPicks();
        this.startFight();
    }

    public void showPicks() {
        for(Player iplayer : this.game.players) {
            System.out.println(iplayer + " --> " +     iplayer.availableHeroes);
        }
    }

    public void pickHeroes(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean notChoosen = true;
        while(notChoosen) {
            this.showPicks();
            this.game.displayHeroes();
            System.out.print(player.name + " is choosing a hero: ");
            String heroName = scanner.nextLine();            
            for(Unit unit : this.game.availableHeroes) {
                String uname = unit.name.toLowerCase();
                heroName = heroName.toLowerCase();
                if(uname.equals(heroName)) {
                    player.availableHeroes.add(unit);
                    this.game.availableHeroes.remove(unit);
                    notChoosen = false;
                    break;
                }
            }
            this.game.clearScreen();
        }
    }

    void askPlayer(Player player1, Player player2, Scanner scanner, int iteration, Unit unit) {
        while(true) {
            System.out.println("╔══════════════════════╗");
            System.out.println("║ " + player1 + " (" + unit.name + ")" + this.game.generateSpaces((player1.name + " (" + unit.name + ")").length() - 9) + "║");
            System.out.println("╚══════════════════════╝");
            String choice = scanner.nextLine();
            String[] values = choice.split(" ");
            if(values.length < 2)
                continue; 
            if(values[0].equals("attack") || values[0].equals("a")) {
                Unit tunit = null;
                try {
                    tunit = player2.availableHeroes.get(Integer.parseInt(values[1]) - 1);                        
                } catch(IndexOutOfBoundsException exception) {
                    System.out.println("Wrong ID");
                    continue;
                }
                player1.availableHeroes.get(iteration).attack(tunit);
                break;
            } else if(values[0].equals("ultimate") || values[0].equals("u")) {
                Unit tunit = null;
                try {
                    if(values.length > 2 && values[1].equals("a")) {
                        tunit = player1.availableHeroes.get(Integer.parseInt(values[2]) - 1);
                    } else {
                        tunit = player2.availableHeroes.get(Integer.parseInt(values[1]) - 1);                        
                    }
                } catch(IndexOutOfBoundsException exception) {
                    System.out.println("Wrong ID");
                    continue;
                }
                player1.availableHeroes.get(iteration).ultimate(tunit);
                break;
            }
        }
    }

    void updateAlive(Player player) {
        List<Unit> units = new ArrayList(player.availableHeroes);
        for(Unit unit : units) {
            if(unit.health < 1) {
                player.availableHeroes.remove(unit);
            }
        }
    }

    boolean looseCheck(Player player) {
        if(player.availableHeroes.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    void startFight() {
        Scanner scanner = new Scanner(System.in);
        Player player1 = this.game.players.get(0);
        Player player2 = this.game.players.get(1);

        Player winner = null;

        int p1_i = 0;
        int p2_i = 0;

        while(true) {
            if(this.looseCheck(player1)) {
                winner = player2;
                break;
            }
            this.game.clearScreen();
            this.showPicks();
            this.game.displayHeroes(player1, player2);
            if(p1_i > player1.availableHeroes.size() - 1) {
                p1_i = 0;
            }
            this.askPlayer(player1, player2, scanner, p1_i, player1.availableHeroes.get(p1_i));
            ++p1_i;
            if(p1_i > player1.availableHeroes.size() - 1) {
                p1_i = 0;
            }
            this.game.clearScreen();
            this.updateAlive(player2);
            if(this.looseCheck(player2)) {
                winner = player1;
                break;
            }
            this.showPicks();
            this.game.displayHeroes(player1, player2);
            if(p1_i > player1.availableHeroes.size() - 1) {
                p1_i = 0;
            }
            this.askPlayer(player2, player1, scanner, p2_i, player2.availableHeroes.get(p2_i));
            ++p2_i;
            if(p2_i > player2.availableHeroes.size() - 1) {
                p2_i = 0;
            }
            this.updateAlive(player1);
            this.game.decreaseCoolDowns();
        }
        System.out.println("╔════════════════╗");
        System.out.println("║ " + winner + " WIN" + Display.generateSpaces(winner.name.length() + 1) + "║");
        System.out.println("╚════════════════╝");
    }
}