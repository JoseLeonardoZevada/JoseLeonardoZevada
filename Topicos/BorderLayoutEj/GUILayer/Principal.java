package BorderLayoutEj.GUILayer;

import java.awt.*;
import javax.swing.*;
 
public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jpNorth, jpSouth, jpEast, jpWest, jpCenter;
    private CardLayout layout = new CardLayout();
 
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
        jpEast.setLayout(new BoxLayout(jpEast, BoxLayout.Y_AXIS));
        jpEast.setBackground(Color.decode("#9cece2"));
        ContentEast();
        add(jpEast, BorderLayout.EAST);
 
        jpWest = new JPanel(new BorderLayout());
        jpWest.setBackground(Color.decode("#daa7e2"));
        ContentWest();
        add(jpWest, BorderLayout.WEST);
 
        jpCenter = new JPanel(new GridLayout(6, 2, 10, 10));
        ContentCenter();
        jpCenter.setBackground(Color.WHITE);
        add(jpCenter, BorderLayout.CENTER);
    }
 
    private void ContentWest() {
        jpWest = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,10));
        jpWest.setBackground(Color.MAGENTA);
        jpWest.add(new JLabel("Zona oeste"));
        JLabel LblNombre = new JLabel("Nombre: ");
        jpWest.add(LblNombre);
        jpWest.add(new JLabel("Topicos"));
        jpWest.add(jpWest,BorderLayout.NORTH);

        //Zona Centro
        jpWest = new JPanel(layout);

        // Crear las trajetas paneles

        JPanel tarjeta1 = crearTarjeta("Vista 1", Color.CYAN);
        JPanel tarjeta2 = crearTarjeta("Vista 2", Color.PINK);
        JPanel tarjeta3 = crearTarjeta("Vista 3", Color.BLUE);

        // AGREGAR LAS TARJETAS AL CONTENEDOR

        jpWest.add(tarjeta1, "Vista 1");
        jpWest.add(tarjeta2, "Vista 2");
        jpWest.add(tarjeta3, "Vista 3");

        jpWest.add(jpWest, BorderLayout.CENTER);

        //Crear los botones para cambiar la tarjeta

        jpWest = new JPanel (new FlowLayout());
        jpWest.setBackground(Color.GRAY);
        JButton btn1 = new JButton ("Vista 1");
        JButton btn2 = new JButton ("Vista 2");
        JButton btn3 = new JButton ("Vista 3");

        

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

    private JPanel crearTarjeta(String texto, Color color) {

        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(texto));
        return panel;

    }


}