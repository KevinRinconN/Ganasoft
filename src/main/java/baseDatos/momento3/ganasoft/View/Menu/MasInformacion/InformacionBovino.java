package baseDatos.momento3.ganasoft.View.Menu.MasInformacion;

import baseDatos.momento3.ganasoft.View.Configuracion;
import baseDatos.momento3.ganasoft.View.bovinos.JlabelPadres;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class InformacionBovino extends JFrame {

    private JLabel jl_Marca;
    private JLabel jl_MarcaTexto;
    private JLabel jl_FondoId;
    private JLabel jl_IdTexto;
    private JLabel jl_FondoContenido;

    private JLabel jl_FechaNacimiento;
    private JLabel jl_Sexo;
    private JLabel jl_Raza;
    private JLabel jl_RasgoDistintivo;
    private JLabel jl_Etapa;

    private JlabelPadres jl_Madre;
    private JlabelPadres jl_Padre;

    private JLOpciones jlo_Registros;
    private JLOpciones jlo_Tratamientos;
    private JLOpciones jlo_Eventos;
    private JLOpciones jlo_Hijos;



    public InformacionBovino (String marca, String id, String fechaNacimiento,String sexo, String raza, String rasgoDistintivo, String etapa){
        setSize (968, 591);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // se define le titulo
        setTitle ("Ganasoft");
        // se define su localizacion (centro)
        setLocationRelativeTo (null);
        panelPrincipal ();

        jl_MarcaTexto.setText(marca);
        jl_IdTexto.setText(id);
        jl_FechaNacimiento.setText(fechaNacimiento);
        jl_Sexo.setText(sexo);
        jl_Raza.setText(raza);
        jl_RasgoDistintivo.setText(rasgoDistintivo);
        jl_Etapa.setText(etapa);




    }

    public void panelPrincipal (){
        // Creacion de panel pricipal
        JPanel panel = new JPanel ();
        // Se quita el layout
        panel.setLayout(null);
        // Se define el color
        panel.setBackground(new Color(255,255,255));
        // Añadir panel
        this.getContentPane().add(panel);

        Color colorTexto = new Color(89,89,89);

        jl_Marca = Configuracion.imagen("fondoMarca.png",30,15,179,46);
        jl_FondoContenido = Configuracion.imagen("fondoContenido.png",30,70,647,427);
        jl_FondoId = Configuracion.imagen("fondoId.png",215,15,46,47);

        jl_MarcaTexto = Configuracion.texto("",0,0,179,46,30,new Color(226,240,217),SwingConstants.CENTER,"Rubik",Font.BOLD);
        jl_IdTexto = Configuracion.texto("",0,0,46,47,20,new Color(226,240,217),SwingConstants.CENTER,"Rubik",Font.BOLD);

        jl_Marca.add(jl_MarcaTexto);
        jl_FondoId.add(jl_IdTexto);


        jl_FondoContenido.add(Configuracion.texto("Fecha de nacimiento",30,30,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik"));
        jl_FechaNacimiento = Configuracion.texto("",30,60,300,30,20,colorTexto,SwingConstants.LEFT,"Aileron",Font.PLAIN);

        jl_FondoContenido.add(Configuracion.texto("Sexo",30,120,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik"));
        jl_Sexo = Configuracion.texto("",30,150,300,30,20,colorTexto,SwingConstants.LEFT,"Aileron",Font.PLAIN);

        jl_FondoContenido.add(Configuracion.texto("Raza",30,210,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik"));
        jl_Raza = Configuracion.texto("",30,240,300,30,20,colorTexto,SwingConstants.LEFT,"Aileron",Font.PLAIN);

        jl_FondoContenido.add(Configuracion.texto("Rasgo distintivo",30,300,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik"));
        jl_RasgoDistintivo = Configuracion.texto("",30,330,300,30,20,colorTexto,SwingConstants.LEFT,"Aileron",Font.PLAIN);

        jl_FondoContenido.add(Configuracion.texto("Etapa",420,30,300,30,20,colorTexto,SwingConstants.LEFT,"Rubik"));
        jl_Etapa = Configuracion.texto("",420,60,300,30,20,colorTexto,SwingConstants.LEFT,"Aileron",Font.PLAIN);

        jl_Padre = new JlabelPadres("Padre",410,120);
        jl_Madre = new JlabelPadres("Madre",410,232);

        jl_FondoContenido.add(jl_FechaNacimiento);
        jl_FondoContenido.add(jl_Sexo);
        jl_FondoContenido.add(jl_Raza);
        jl_FondoContenido.add(jl_RasgoDistintivo);
        jl_FondoContenido.add(jl_Etapa);
        jl_FondoContenido.add(jl_Padre);
        jl_FondoContenido.add(jl_Madre);

        jlo_Registros = new JLOpciones("fondoRegistro.png","iconoRegistro.png","Registros",new Color(255,242,204),"iconoInferiorRegistro.png");
        jlo_Registros.setBounds(697,70,182,88);

        jlo_Tratamientos = new JLOpciones("fondoTratamiento.png","iconoTratamiento.png","Tratamientos",new Color(243,215,215),"iconoInferiorTratamiento.png");
        jlo_Tratamientos.setBounds(697,173,182,88);

        jlo_Eventos = new JLOpciones("fondoEvento.png","iconoEvento.png","Eventos",new Color(222,235,247),"iconoInferiorEvento.png");
        jlo_Eventos.setBounds(697,276,182,88);

        jlo_Hijos = new JLOpciones("fondoHijos.png","iconoHijos.png","Hijos",new Color(226,240,217),"iconoInferiorHijos.png");
        jlo_Hijos.setBounds(697,380,182,88);

        panel.add(jl_Marca);
        panel.add(jl_FondoContenido);
        panel.add(jl_FondoId);
        panel.add(jlo_Registros);
        panel.add(jlo_Tratamientos);
        panel.add(jlo_Eventos);
        panel.add(jlo_Hijos);


    }

}
