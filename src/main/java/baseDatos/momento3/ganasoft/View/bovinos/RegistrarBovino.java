package baseDatos.momento3.ganasoft.View.bovinos;

import baseDatos.momento3.ganasoft.View.Configuracion;
import baseDatos.momento3.ganasoft.View.PanelContenido;
import com.toedter.calendar.JDateChooser;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

@Data
public class RegistrarBovino extends JDialog {

    private JLabel jl_Marca;
    private JLabel jl_Sexo;
    private JLabel jl_Raza;
    private JLabel jl_RasgoDistintivo;
    private JLabel jl_FechaNacimiento;
    private JLabel jl_IconoRegistrarBovino;
    private JLabel jl_Registrar;
    private JLabel jl_bovino;

    private JDateChooser jd_fecha;
    private JComboBox jc_Sexo;

    private JTextField jt_Marca;
    private JTextField jt_Raza;
    private JTextArea jta_RasgoDistintivo;

    private JlabelPadres jl_Madre;
    private JlabelPadres jl_Padre;

    private JButton jb_Aceptar;
    private JButton jb_Cancelar;

    private VentanaAgregarParentesco ventanaAgregarParentesco;

    private PanelContenido panelContenido;

    public RegistrarBovino (JFrame ventanaPrincipal){
        super(ventanaPrincipal, true);
        // se define el tamaño de la ventana
        setSize (881, 592);
        // se define su localizacion (centro)
        setLocationRelativeTo (null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0,0));
        panelPrincipal ();
    }
    public void panelPrincipal(){

        panelContenido = new PanelContenido("registrarBovinos.png");
        panelContenido.setLayout(null);
        this.getContentPane().add(panelContenido);

        ventanaAgregarParentesco = new VentanaAgregarParentesco(this);

        jl_IconoRegistrarBovino = Configuracion.imagen("iconoRegistrarBovino.png",76, 129,150,142);
        jl_Registrar = Configuracion.texto("Registrar",31,279,240,30,25,new Color(84,130,53),0,"Rubik");
        jl_bovino = Configuracion.texto("bovino",31,309,240,30,25,new Color (84,130,53),0,"Rubik");


        jb_Aceptar = Configuracion.boton("aceptar.png","aceptarSeleccionado.png","aceptarOprimido.png",726,39,47,46);
        jb_Cancelar = Configuracion.boton("salir.png","salirSeleccionado.png","salirOprimido.png",773,39,47,46);
        ActionListener accionSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana(e);
            }
        };

        //********************************** Formulario ************************************************
        Color colorTexto = new Color(89,89,89);
        Color colorFondoTextField = new Color(217,217,217);
        Color colorLetraTextField = new Color(127,127,127);

        jl_Marca = Configuracion.texto("Marca",311,109,100,30,20,colorTexto,SwingConstants.LEFT,"Rubik");
        jt_Marca = Configuracion.cajaTexto(311,149,200,30,colorFondoTextField,colorLetraTextField);
        jl_FechaNacimiento = Configuracion.texto("Fecha de nacimiento",571,109,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik");

        jd_fecha = new JDateChooser();
        jd_fecha.setBounds(571,149,200,30);
        jd_fecha.setFont(new Font ("Aileron",Font.PLAIN,20));

        jl_Sexo = Configuracion.texto("Sexo",311,189,100,30,20,colorTexto,SwingConstants.LEFT,"Rubik");

        String [] sexos = {"Macho","Hembra"};
        jc_Sexo = new JComboBox(sexos);
        jc_Sexo.setBounds(311,229,200,30);
        jc_Sexo.setBackground(colorFondoTextField);
        jc_Sexo.setBorder(null);

        jl_Raza = Configuracion.texto("Raza",571,189,100,30,20,colorTexto,SwingConstants.LEFT,"Rubik");
        jt_Raza = Configuracion.cajaTexto(571,229,200,30,colorFondoTextField,colorLetraTextField);

        jl_RasgoDistintivo = Configuracion.texto("Rasgo distintivo",311,269,200,30,20,colorTexto,SwingConstants.LEFT,"Rubik");
        jta_RasgoDistintivo = Configuracion.areaTexto(311,309,200,90,colorFondoTextField,colorLetraTextField);
        jta_RasgoDistintivo.setLineWrap(true);
        jta_RasgoDistintivo.setWrapStyleWord(true);


        jl_Madre = new JlabelPadres("Madre",571,279);
        jl_Padre = new JlabelPadres("Padre",571,381);


        panelContenido.add(jl_Marca);
        panelContenido.add(jt_Marca);
        panelContenido.add(jl_FechaNacimiento);
        panelContenido.add(jd_fecha);
        panelContenido.add(jl_Sexo);
        panelContenido.add(jc_Sexo);
        panelContenido.add(jl_Raza);
        panelContenido.add(jt_Raza);
        panelContenido.add(jl_RasgoDistintivo);
        panelContenido.add(jta_RasgoDistintivo);
        panelContenido.add(jl_Madre);
        panelContenido.add(jl_Padre);

        //***********************************************************************************************

        jb_Cancelar.addActionListener(accionSalir);

        panelContenido.add(jl_IconoRegistrarBovino);
        panelContenido.add(jl_Registrar);
        panelContenido.add(jl_bovino);
        panelContenido.add(jb_Aceptar);
        panelContenido.add(jb_Cancelar);


    }

    public void cerrarVentana (ActionEvent e){
        this.setVisible(false);
    }

    public void vaciarCampos (){
        jd_fecha.setDate(null);
        jta_RasgoDistintivo.setText("");
        jt_Raza.setText("");
        jl_Padre.getJl_idPariente().setText("?");
        jl_Madre.getJl_idPariente().setText("?");
    }


}
