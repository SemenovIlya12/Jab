public class Pistol {
    private int rounds;

    public Pistol(int rounds) {
        this.rounds = rounds;
    }

    public Pistol() {
        this.rounds = 5;
    }

    public void shoot() {
        if (this.rounds > 0) {
            System.out.println("Bah!");
            this.rounds--;
        } else System.out.println("Click! Unlucky bro");
    }

}
