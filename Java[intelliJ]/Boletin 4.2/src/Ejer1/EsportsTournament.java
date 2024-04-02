package Ejer1;

public class EsportsTournament {
    public static void main(String[] args) {
        FPSGamer pj1 = new FPSGamer();
        MOBAGamer pj2 = new MOBAGamer();
        SportGamer pj3 = new SportGamer();

        Gamer[] players = {pj1, pj2, pj3};
        startTournament(players);
    }

    public static void startTournament(Gamer[] players) {
        for (Gamer player : players) {
            player.playGame();
        }
    }
}
