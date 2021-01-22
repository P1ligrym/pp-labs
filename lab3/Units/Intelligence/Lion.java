import java.util.*;

class Lion extends Unit {
    Attribute attribute = new Intelligence();
    String name = this.getClass().getName();
    Skill ultimate = new FingerOfDeath();
    int health = 1160;
    int damage = 86;
    int armor = 6;

    public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            unit.health -= 600;
            this.ultimate.cooldown = 6;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            this.attack(unit);
        }
    }

    // fix super keyword with default fields
    Lion() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}
