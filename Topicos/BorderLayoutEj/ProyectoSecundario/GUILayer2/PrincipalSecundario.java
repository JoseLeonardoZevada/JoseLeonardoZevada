package GUILayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PrincipalSecundario extends JFrame {

    private static final long serialVersionUID = 1L;

    // Inicializo las variables como me dijo el profe
    private JLabel nombreJLabel, apellidoJLabel, correoJLabel, contrasenaJLabel, confirmarContrasenaJLabel;
    private JTextField nombre, apellido, correo;
    private JPasswordField contrasena, confirmarContrasena;
    private JButton botonRegistro;

    public PrincipalSecundario(String str) throws HeadlessException { // Constructor

        super(str);
        setSize(900, 600);
        setShape(getShape());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InitComponent();

    }

    private void InitComponent() {

        // Creo un panel central para organizar todo en el medio
        JPanel panelCentral = new JPanel(new GridBagLayout());
        // Creo el objeto GridBagConstraints
        GridBagConstraints diseñoGBC = new GridBagConstraints();

        //Le doy un margenes alrededor del componente
        diseñoGBC.insets = new Insets(5, 5, 5, 5);
        // Con esto los hago a la izquierda como me lo pide el ejercicio
        diseñoGBC.anchor = GridBagConstraints.WEST;

        nombre = new JTextField(20);
        apellido = new JTextField(20);
        correo = new JTextField(20);
        contrasena = new JPasswordField(20);
        confirmarContrasena = new JPasswordField(20);
        botonRegistro = new JButton("Registrar");

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

        // Acomodamos todo para que se muestre como me pide el ejercicio
    
        // Empiezo por el nombre
        diseñoGBC.gridx = 0; // Columna 0
        diseñoGBC.gridy = 0; // Fila 0, se ira aumentando este valor por que si no todo quedaria uno encima de otro
        panelCentral.add(nombreJLabel, diseñoGBC);
        diseñoGBC.gridx = 1; // Columna 1
        panelCentral.add(nombre, diseñoGBC);

        // Lo mismo con el apellido
        diseñoGBC.gridx = 0; // Columna 1
        diseñoGBC.gridy = 1; // Fila 1, se ira aumentando este valor por que si no todo quedaria uno encima de otro
        panelCentral.add(apellidoJLabel, diseñoGBC);
        diseñoGBC.gridx = 1; // Columna 1, espacio interno horizontal
        panelCentral.add(apellido, diseñoGBC);
        
        //Correo
        diseñoGBC.gridx = 0;
        diseñoGBC.gridy = 2;// se le sigue aumentando
        panelCentral.add(correoJLabel, diseñoGBC);
        diseñoGBC.gridx = 1;
        panelCentral.add(correo, diseñoGBC);

        // Contraseña
        diseñoGBC.gridx = 0;
        diseñoGBC.gridy = 3;
        panelCentral.add(contrasenaJLabel, diseñoGBC);
        diseñoGBC.gridx = 1;
        panelCentral.add(contrasena, diseñoGBC);

        // confirmar contra
        diseñoGBC.gridx = 0;
        diseñoGBC.gridy = 4;
        panelCentral.add(confirmarContrasenaJLabel, diseñoGBC);
        diseñoGBC.gridx = 1;
        panelCentral.add(confirmarContrasena, diseñoGBC);

        // Registro o boton 
        diseñoGBC.gridx = 0;
        diseñoGBC.gridy = 5;
        diseñoGBC.gridwidth = 2; // Para que el boton se diferencie de las demas campos, tendra mas columnas, o sea sera mas grande
        diseñoGBC.anchor = GridBagConstraints.CENTER; // Lo centramos horizontalmente
        panelCentral.add(botonRegistro, diseñoGBC);

        add(panelCentral, BorderLayout.CENTER);

        register.addActionListener (new ActionListener() {

            if(nombre.getText().isEmpty() || )

        
        public void actionPerformed (ActionEvent e) {
            
        }
        })

    

    }

}