import java.util.*;

class Lina extends Unit {
    Attribute attribute = new Intelligence();
    String name = this.getClass().getName();
    Skill ultimate = new Laguna();
    int health = 1260;
    int damage = 100;
    int armor = 7;

    public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            unit.health -= (int)(800 * (1 - ((0.06 * unit.armor) / (1 + 0.06 * Math.abs(unit.armor)))));
            this.ultimate.cooldown = 6;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            this.attack(unit);
        }
    }

    Lina() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
      }
}