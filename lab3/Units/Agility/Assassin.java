import java.util.*;
import java.util.concurrent.TimeUnit;

class Assassin extends Unit {
    Attribute attribute = new Agility();
    String name = this.getClass().getName();
    Skill ultimate = new CoupDeGrace();
    int health = 1220;
    int damage = 104;
    int armor = 13;

    public void ultimate(Unit unit) {
        int chance = 0 + (int)(Math.random() * ((100 - 0) + 1));
        if(chance < this.ultimate.chance) {
            int damage = (int)((this.damage) * 3 * (1 - ((0.06 * unit.armor) / (1 + 0.06 * Math.abs(unit.armor)))));
            unit.health -= damage;
            System.out.println("╔════════════════╗");
            System.out.println("║ " + ConsoleColors.RED_BOLD_BRIGHT + damage + ConsoleColors.RESET + Display.generateSpaces(((this.damage * 3) + "").length() - 3) + "║");
            System.out.println("╚════════════════╝");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException exception) {}
        } else {
            unit.health -= (int)(this.damage * (1 - ((0.06 * unit.armor) / (1 + 0.06 * Math.abs(unit.armor)))));
        }
    }

    public void attack(Unit unit) {
        this.ultimate(unit);
    }

    Assassin() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
    
}