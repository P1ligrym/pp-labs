class Dazzle extends Unit {
    Attribute attribute = new Intelligence();
    String name = this.getClass().getName();
    Skill ultimate = new ShadowWave();
    int health = 1260;
    int damage = 104;
    int armor = 7;



      public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            this.health += 80;
            this.health += 80;
            this.ultimate.cooldown = 4;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            this.attack(unit);
        }
    }

    // fix super keyword with default fields
    Dazzle() {
        super.ultimate = ultimate;
        super.attribute = attribute;
        super.name = name;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}








