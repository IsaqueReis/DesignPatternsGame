package view;

import javax.swing.*;

public class Main extends JFrame {
	public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
        g.play(g);
    }
}