import javax.swing.*;

/**
 * Created by student on 12/4/17.
 */
public class Main extends JPanel{

    public static void main(String[] args) {
        JFrame window = new JFrame("Traveling Salesperson, HI WAM!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1000, 800); //(x, y, w, h)
        Main panel = new Main();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        System.out.println("bwekfast");

    }
}
