class Mars extends Unit {
    Attribute attribute = new Strength();
    String name = this.getClass().getName();
    Skill ultimate = new Bulwark();
    int health = 1600;
    int damage = 96;
    int armor = 6 + 14; // additionnal armor

      public void ultimate(Unit unit) {
        if(this.ultimate.cooldown < 1) {
            this.armor *= 1.3;
            super.armor *= 1.3;
            this.ultimate.cooldown = 5;
        } else {
            System.out.println("This ultimate in cooldown (" + this.ultimate.cooldown + ")");
            this.attack(unit);
        }
    }



    Mars() {
        super.attribute = attribute;
        super.name = name;
        super.ultimate = this.ultimate;
        super.health = this.health;
        super.damage = this.damage;
        super.armor = this.armor;
    }
}