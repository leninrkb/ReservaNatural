package sarn.gui;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void initialize(JFrame panelOpciones){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(null, BorderLayout.NORTH);
        setTitle("SARN");
        setSize(500,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
