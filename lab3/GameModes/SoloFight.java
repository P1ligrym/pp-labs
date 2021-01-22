import java.util.*;

class SoloFight implements GameSetting {

    Game game;

    SoloFight(Game game) {
        this.game = game;
    }

    public void pickStage() {
        // for(int i = 0; i < 2; ++i) {
            for(Player player : this.game.players) {
                pickHeroes(player);
            }
        // }
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

    // this.game -> players -> units

    void askPlayer(Player player1, Player player2, Scanner scanner) {
        while(true) {
            System.out.println("╔════════════════╗");
            System.out.println("║ " + player1 + this.game.generateSpaces((player1.name).length() - 3) + "║");
            System.out.println("╚════════════════╝");
            String choice = scanner.nextLine();
            if(choice.equals("attack") || choice.equals("a")) {
                player1.availableHeroes.get(0).attack(player2.availableHeroes.get(0));
                break;
            } else if(choice.equals("ultimate") || choice.equals("u")) {
                player1.availableHeroes.get(0).ultimate(player2.availableHeroes.get(0));
                break;
            }
        }
    }

    boolean looseCheck(Player player) {
        if(player.availableHeroes.get(0).health < 1) {
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

        while(true) {
            if(this.looseCheck(player1)) {
                winner = player2;
                break;
            }
            this.game.clearScreen();
            this.showPicks();
            this.game.displayHeroes(player1, player2);
            this.askPlayer(player1, player2, scanner);
            this.game.clearScreen();
            if(this.looseCheck(player2)) {
                winner = player1;
                break;
            }
            this.showPicks();
            this.game.displayHeroes(player1, player2);
            this.askPlayer(player2, player1, scanner);
            this.game.decreaseCoolDowns();
        }
        System.out.println("╔════════════════╗");
        System.out.println("║ " + winner + " WIN" + Display.generateSpaces(winner.name.length() + 1) + "║");
        System.out.println("╚════════════════╝");
    }
}