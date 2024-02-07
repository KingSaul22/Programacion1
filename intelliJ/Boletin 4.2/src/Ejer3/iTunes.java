package Ejer3;

public class iTunes implements OfflineMusicPlayer{
    @Override
    public void play() {
        load();
        System.out.println("Playing music on iTunes");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music on iTunes");
    }

    @Override
    public void load() {
        System.out.println("Loading music on iTunes");
    }
}
