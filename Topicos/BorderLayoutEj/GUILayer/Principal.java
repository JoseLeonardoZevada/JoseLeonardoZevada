package BorderLayoutEj.GUILayer;

import java.awt.*;
import javax.swing.*;
 
public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jpNorth, jpSouth, jpEast, jpWest, jpCenter;
 
    public Principal(String str) throws HeadlessException {
        super(str);
        setSize(800, 600);
        setShape(getShape());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InitComponent();
    }
 
    private void InitComponent() {
        jpNorth = new JPanel();
        //jpNorth.setBackground(Color.decode("#e7df72ff"));
        jpNorth.setBackground(Color.decode("#e7df72"));
        add(jpNorth, BorderLayout.NORTH);
 
        jpSouth = new JPanel();
        jpSouth.setBackground(Color.decode("#5a57c7"));
        add(jpSouth, BorderLayout.SOUTH);
 
        jpEast = new JPanel();
        jpEast.setBackground(Color.decode("#9cece2"));
        ContentEast();
        add(jpEast, BorderLayout.EAST);
 
        jpWest = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 10));
        jpWest.setBackground(Color.decode("#daa7e2"));
        ContentWest();
        add(jpWest, BorderLayout.WEST);
 
        jpCenter = new JPanel(new GridLayout(6, 2, 10, 10));
        ContentCenter();
        jpCenter.setBackground(Color.WHITE);
        add(jpCenter, BorderLayout.CENTER);
    }
 
    private void ContentWest() {
        jpWest.add(new JLabel("West"));
        jpWest.add(new JLabel("Nombre: "));
        jpWest.add(new JLabel("Topicos"));
    }
 
    private void ContentCenter() {
        jpCenter.add(new JLabel("1"));
        jpCenter.add(new JLabel("2"));
        jpCenter.add(new JLabel("3"));
        jpCenter.add(new JLabel("4"));
        jpCenter.add(new JLabel("5"));
        jpCenter.add(new JLabel("6"));
        jpCenter.add(new JLabel("7"));
    }
 
    private void ContentEast() {
        jpEast.add(new JLabel("Etiqueta 1"));
        jpEast.add(new JLabel("Etiqueta 2"));
        jpEast.add(new JLabel("Etiqueta 3"));
        
    }
}