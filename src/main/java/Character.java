public class Character {
    public int hp;
    public int power;

    public void kick(Character c){
        c.hp -= power;
    }
    public boolean isAlive(){
        return hp > 0;
    }
}
