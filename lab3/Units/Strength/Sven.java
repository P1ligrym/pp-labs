import java.util.*;

class Sven extends Unit {
    Attribute attribute = new Strength();
    String name = this.getClass().getName();
    Skill ultimate = new GodsStrangth();
    int health = 1520;
    int damage = 102;
    int armor = 9;

     public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            this.damage *= 1.4;
            super.damage *= 1.4;
            this.ultimate.cooldown = 6;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            this.attack(unit);
        }
    }

     Sven() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}
