class ShadowFiend extends Unit {
    Attribute attribute = new Agility();
    String name = this.getClass().getName();
    Skill ultimate = new PresenceoftheDarkLord();
    int health = 1320;
    int damage = 100;
    int armor = 10;

      public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            if(unit.armor < 5) {
                unit.armor -= 5;
            } else {
                unit.armor -= unit.armor * 1.3;
                this.ultimate.cooldown = 5;
            }
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            this.attack(unit);
        }
    }

    ShadowFiend() {
        super.ultimate = ultimate;
        super.attribute = attribute;
        super.name = name;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}