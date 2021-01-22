import java.util.*;
import java.util.concurrent.TimeUnit;

class Ranger extends Unit {
    Attribute attribute = new Agility();
    String name = this.getClass().getName();
    Skill ultimate = new Marksmanship();
    int health = 1080;
    int damage = 118;
    int armor = 10;

    public void ultimate(Unit unit) {
        int chance = 0 + (int)(Math.random() * ((100 - 0) + 1));
        if(chance < this.ultimate.chance) {
            unit.health -= this.damage;
            System.out.println("╔════════════════╗");
            System.out.println("║ " + ConsoleColors.YELLOW_BOLD_BRIGHT + damage + ConsoleColors.RESET + Display.generateSpaces((this.damage + "").length() - 3) + "║");
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

    // fix super keyword with default fields
    Ranger() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}











