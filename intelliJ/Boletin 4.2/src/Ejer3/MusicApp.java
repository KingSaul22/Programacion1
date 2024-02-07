package Ejer3;

public class MusicApp {
    public static void main(String[] args){
        MusicPlayer[] players = {new Spotify(), new iTunes(), new MP3Player()};
        startMusic(players);
    }

    private static void startMusic(MusicPlayer[] players){
        for (MusicPlayer player : players) {
            System.out.println();
            player.play();
            player.stop();
        }
    }
}
