package Tugas;

public class ConsoleBattleLog implements BattleLog{
    public void playerHitback(Player player, int DamageRductionFromBoss) {
        //status player
        int newPlayerEnergy;
        int newPlayerHitpoint;
        
        newPlayerEnergy = player.getEnergy() - (player.getEnergy() - player.getDamage());
        player.setEnergy(newPlayerEnergy);

        newPlayerHitpoint = player.getHitPoint() - DamageRductionFromBoss;
        player.setHitpoint(newPlayerHitpoint);
        
    }

    public void reportBattle(Player player, int damageTakenBoss, int hitPointBoss) {
        System.out.println("--- Battle Log ---");
        System.out.println("Player: " + player.getName());
        System.out.println("Damage given to boss: " + damageTakenBoss);
        System.out.println("Current energy: " + player.getEnergy());
        System.out.println("Current HitPoint: " + player.getHitPoint());
        System.out.println("Health boss: " + hitPointBoss);
        
        
    }
}
