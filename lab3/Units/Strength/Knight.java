class Knight extends Unit {
    Attribute attribute = new Strength();
    String name = this.getClass().getName();
    Skill ultimate = new BreatheFire();
    int health = 1560;
    int damage = 112;
    int armor = 8 + 8; // additional armor
     
     
     
     public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            unit.damage -= 20;
            this.ultimate.cooldown = 6;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            this.attack(unit);
        }
    }

    // fix super keyword with default fields
    Knight() {
        super.ultimate = this.ultimate;
        super.attribute = this.attribute;
        super.name = name;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}




