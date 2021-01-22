class FingerOfDeath extends Skill {
    
    int cooldown = 6;
    int chance = 100;
    String ultimateName = "Finger Of Death";

    FingerOfDeath() {
        super.cooldown = this.cooldown;
        super.chance = this.chance;
        super.ultimateName = this.ultimateName;
    }
}