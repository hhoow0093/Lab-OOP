package Tugas;

public class BigBoss {
    private int hitPoint;
    private int damageReduction;
    private int damageTaken;
    private BattleLog report;

    public void registerBattleLog(BattleLog report) {
        this.report = report;
    }

    public BigBoss(int hitPoint, int DamageReduction, int damageTaken) {
        this.hitPoint = hitPoint;
        this.damageReduction = DamageReduction;
        this.damageTaken = damageTaken;
    }

    public void onDamageApplied(Player player) {
        // status boss
        damageTaken = player.getDamage() - damageReduction;
        hitPoint = hitPoint - damageTaken;
    }

    public ConsoleBattleLog getReport() {
        return (ConsoleBattleLog) report;
    }
    
    public int getDamageReductionFromBoss() {
        return damageReduction;
    }

    public int getDamageTakenFromBoss() {
        return damageTaken;
    }

    public int getHitPointBoss() {
        return hitPoint;
    }



}
