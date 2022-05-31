package baseDatos.momento3.ganasoft.View.bovinos;

import baseDatos.momento3.ganasoft.View.Configuracion;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class JlabelPadres extends JLabel {
    private JLabel jl_Pariente;
    private JLabel jl_TextoId;
    private JLabel jl_idPariente;

    public JlabelPadres (String pariente,int x, int y){

        Color colorTexto = new Color(89,89,89);

        this.setBounds(x,y,206,92);
        this.setIcon(new ImageIcon("padres.png"));
        jl_Pariente = Configuracion.texto(pariente,20,15,100,30,20,colorTexto,SwingConstants.LEFT,"Rubik");
        jl_TextoId = Configuracion.texto("ID:",20,45,30,30,20,colorTexto,SwingConstants.LEFT,"Aileron");
        jl_idPariente = Configuracion.texto("?",60,45,30,30,20,colorTexto,SwingConstants.LEFT,"Aileron");

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));


        this.add(jl_Pariente);
        this.add(jl_TextoId);
        this.add(jl_idPariente);

    }


}
