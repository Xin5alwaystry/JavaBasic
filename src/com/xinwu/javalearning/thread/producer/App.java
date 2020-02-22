package com.xinwu.javalearning.thread.producer;

public class App {

    public static void main(String[] args) {
        Movie movie = new Movie();
        Player player = new Player(movie);
        Watcher watcher = new Watcher(movie);
        Thread threadPlay = new Thread(player);
        Thread threadWatcher = new Thread(watcher);
        threadPlay.start();
        threadWatcher.start();
    }
}
