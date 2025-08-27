package BorderLayoutEj.GUILayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jpNorte, jpSur, jpCentro, jpEste, jpOeste;

     public Principal(String title) throws HeadlessException {

        super(title);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InitComponents();

    }

     private void InitComponents() {

        jpNorte = new JPanel();
        jpNorte.setBackground(Color.cyan);
        add(jpNorte, BorderLayout.NORTH);

        jpCentro = new JPanel(new GridLayout(6,2,10,10));
        jpCentro.setBackground(Color.white);
        add(jpCentro, BorderLayout.CENTER);

        jpEste = new JPanel();
        jpEste.setBackground(Color.white);
        add(jpEste, BorderLayout.EAST);

        jpSur = new JPanel();
        jpSur.setBackground(Color.blue);
        add(jpSur, BorderLayout.SOUTH);

        jpOeste = new JPanel(new FlowLayout (FlowLayout.RIGHT, 50,10));
        jpOeste.setBackground(Color.LIGHT_GRAY);
        ContenidoWest = 
        add(jpOeste, BorderLayout.WEST);

    }

    private void ContenidoEste() {
        jpEste.add(new JLabel("Etiqueta 1"));
        jpEste.add(new JLabel("Etiqueta 1"));
        jpEste.add(new JLabel("Etiqueta 1"));
    }



}
