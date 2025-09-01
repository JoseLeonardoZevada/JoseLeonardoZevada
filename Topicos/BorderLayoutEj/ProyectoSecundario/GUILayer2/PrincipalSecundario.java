package BorderLayoutEj.ProyectoSecundario.GUILayer2;

import java.awt.*;
import javax.swing.*;
 
public class PrincipalSecundario extends JFrame {
    
    private static final long serialVersionUID = 1L;

    //Inicializo las variables como me dijo el profe 
    private JLabel nombreJLabel, apellidoJLabel, correoJLabel, contrasenaJLabel, confirmarContrasenaJLabel;
    private JTextField nombre, apellido, correo; 
    private JPasswordField contrasena, confirmarContrasena;
    private JButton botonRegistro;
     
    public PrincipalSecundario(String str) throws HeadlessException { //Constructor

        super(str);
        setSize(900, 600);
        setShape(getShape());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InitComponent();

    }

    private void InitComponent() {

        nombre = new JTextField(30);
        apellido = new JTextField(30);
        correo = new JTextField(30);
        contrasena = new JPasswordField(30);
        confirmarContrasena = new JPasswordField(30);
        botonRegistro = new JButton();

        nombreJLabel =  new JLabel("Nombre:");
        add(nombre);
        apellidoJLabel =  new JLabel("Apellido:");
        add(apellido);
        correoJLabel =  new JLabel("Correo:");
        add(correo);
        contrasenaJLabel =  new JLabel("Contraseña:");
        add(contrasena);
        confirmarContrasenaJLabel =  new JLabel("Confirmar:");
        add(confirmarContrasena);



    }

}
