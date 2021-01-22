class Unit {
    Attribute attribute = new Attribute();
    String name = this.getClass().getName();
    Skill ultimate = new Skill();
    int health = 100;
    int damage = 5;
    int armor = 1;

    public void attack(Unit unit) {
        unit.health -= (int)(this.damage * (1 - ((0.06 * unit.armor) / (1 + 0.06 * Math.abs(unit.armor)))));
    }

    public void ultimate(Unit unit) {
        
    }

    public String toString() {
        return ConsoleColors.PURPLE_BOLD_BRIGHT + this.name + ConsoleColors.RESET;
    }
}