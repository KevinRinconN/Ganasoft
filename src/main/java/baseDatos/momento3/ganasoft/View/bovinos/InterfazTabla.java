package baseDatos.momento3.ganasoft.View.bovinos;

import baseDatos.momento3.ganasoft.View.Configuracion;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class InterfazTabla extends JLabel {

    private ImageIcon predeterminado;
    private ImageIcon idPredeterminado;
    private ImageIcon seleccionada;
    private ImageIcon idSeleccionado;
    private ImageIcon seleccionada2;
    private ImageIcon idSeleccionado2;
    private ImageIcon oprimido;
    private ImageIcon idOprimido;

    private JLabel detalle;
    private JLabel idInterfaz;

    private Integer id;

    private JLabel idTexto;
    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;
    private JLabel texto4;
    private JLabel texto5;

    private Boolean seleccionado;

    public InterfazTabla (String id, String texto1, String texto2, String texto3, String texto4, String texto5){

        setBounds(20,0,765,41);
        predeterminado = new ImageIcon("interfaz.png");
        idPredeterminado = new ImageIcon("id.png");
        seleccionada = new ImageIcon("interfazSeleccionada.png");
        idSeleccionado = new ImageIcon("idSeleccionado.png");
        seleccionada2 = new ImageIcon("interfazSeleccionada2.png");
        idSeleccionado2 = new ImageIcon("idSeleccionado2.png");
        oprimido = new ImageIcon("interfazOprimida.png");
        idOprimido = new ImageIcon("idOprimido.png");

        seleccionado = false;
        detalle = Configuracion.imagen(predeterminado, 60, 0, 705, 41);
        idInterfaz = Configuracion.imagen(idPredeterminado, 0, 0, 54, 41);

        this.id = Integer.parseInt(id);
        this.idTexto = Configuracion.texto(id,0,0,54,41);
        this.texto1 = Configuracion.texto(texto1, 0,0,120,41);
        this.texto2 = Configuracion.texto(texto2, 115,0,200,41);
        this.texto3 = Configuracion.texto(texto3, 315,0,118,41);
        this.texto4 = Configuracion.texto(texto4, 433,0,146,41);
        this.texto5 = Configuracion.texto(texto5, 579,0,135,41);

        idInterfaz.setCursor(new Cursor(Cursor.HAND_CURSOR));


        idInterfaz.add(this.idTexto);
        detalle.add(this.texto1);
        detalle.add(this.texto2);
        detalle.add(this.texto3);
        detalle.add(this.texto4);
        detalle.add(this.texto5);

        editarColorTexto(new Color(127,127,127));
        aparienciaPredeterminada();

        this.add(idInterfaz);
        this.add(detalle);

    }
    public void editarColorTexto (Color color){
        idTexto.setForeground(color);

        texto1.setForeground(color);
        texto2.setForeground(color);
        texto3.setForeground(color);
        texto4.setForeground(color);
        texto5.setForeground(color);

    }

    public void aparienciaPredeterminada (){
        detalle.setIcon(predeterminado);
        idInterfaz.setIcon(idPredeterminado);
        idTexto.setText(String.valueOf(id));

    }

    public void aparienciaSeleccionada (){
        detalle.setIcon(seleccionada);
        idInterfaz.setIcon(idSeleccionado);
        idTexto.setText("");
    }

    public void aparienciaSeleccionada2 (){
        detalle.setIcon(seleccionada2);
        idInterfaz.setIcon(idSeleccionado2);
        idTexto.setText(String.valueOf(id));
    }

    public void aparienciaEliminada (){
        detalle.setIcon(oprimido);
        idInterfaz.setIcon(idOprimido);
        idTexto.setText("");
    }

}
