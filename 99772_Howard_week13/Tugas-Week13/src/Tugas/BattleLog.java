package Tugas;

public interface BattleLog {
    public void playerHitback(Player player, int DamageRductionFromBoss);
    public void reportBattle(Player player, int damageTakenBoss, int hitPointBoss);
}
