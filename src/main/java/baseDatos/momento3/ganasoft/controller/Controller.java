package baseDatos.momento3.ganasoft.controller;

import baseDatos.momento3.ganasoft.View.Menu.MasInformacion.InformacionBovino;
import baseDatos.momento3.ganasoft.View.PrincipalPage;
import baseDatos.momento3.ganasoft.View.Tabla;
import baseDatos.momento3.ganasoft.View.bovinos.InterfazTabla;
import baseDatos.momento3.ganasoft.model.Animal;
import baseDatos.momento3.ganasoft.model.repository.AnimalRepository;


import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class Controller implements ActionListener {

    AnimalRepository animalRepository;

    PrincipalPage principalPage;


    public Controller (AnimalRepository animalRepository){
        super();
        principalPage = new PrincipalPage();
        this.animalRepository = animalRepository;

        agregarEventos();
        listarBovino();
        principalPage.setVisible(true);
    }
    private void agregarEventos (){
        principalPage.getVentanaRegistroBovino().getJb_Aceptar().addActionListener(this);
        principalPage.getVentanaRegistroBovino().getJl_Padre().addMouseListener(accionParentesco("Macho"));
        principalPage.getVentanaRegistroBovino().getJl_Madre().addMouseListener(accionParentesco("Hembra"));
        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getJb_Agregar().addActionListener(this);
        principalPage.getMasInformacion().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== principalPage.getVentanaRegistroBovino().getJb_Aceptar()){
            agregarBovino (e);
        }
        if (e.getSource()==principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getJb_Agregar()){
            agregarParentesco(e);
        }
        if (e.getSource() == principalPage.getMasInformacion()){
            accionMasInformacion(e);
        }

    }

    public MouseAdapter accionParentesco (String sexo){
        MouseAdapter accionParentesco = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirVentanaParentesco(sexo);
            }

        };

        return accionParentesco;
    }

    public void listarBovino (){
        List<Animal> listaBovino = animalRepository.getAll();
        for (Animal animal : listaBovino){


            InterfazTabla nuevoBovino = new InterfazTabla(Long.toString(animal.getId()),animal.getMarca(),animal.getFecha(),animal.getSexo(),animal.getRaza(),"Novilla");
            nuevoBovino.getDetalle().addMouseListener(seleccionarBovino(nuevoBovino,principalPage.getTabla(),true,principalPage.getOpcionesBovino()));
            nuevoBovino.getIdInterfaz().addMouseListener(eliminarBovino(nuevoBovino,true));

            principalPage.getTabla().agregarElemento(nuevoBovino);


        }
    }



    public void abrirVentanaParentesco (String sexo){

        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().removeAll();
        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().getInterfazTablas().removeAll(principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().getInterfazTablas());
        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().setIdElementoSeleccionado(null);

        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().setSexo(sexo);

        List<Animal> listaBovino = animalRepository.getBySexo(sexo);
        for (Animal animal : listaBovino){


            InterfazTabla nuevoBovino = new InterfazTabla(Long.toString(animal.getId()),animal.getMarca(),animal.getFecha(),animal.getSexo(),animal.getRaza(),"Novilla");
            nuevoBovino.getDetalle().addMouseListener(seleccionarBovino(nuevoBovino,principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla(),false,null));
            nuevoBovino.getIdInterfaz().addMouseListener(eliminarBovino(nuevoBovino,false));

            principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().agregarElemento(nuevoBovino);
        }

        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().setVisible(true);
    }

    public void agregarParentesco (ActionEvent e){
        String id = "?";
        if (!(principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().getIdElementoSeleccionado()==null)){
            id = Integer.toString(principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getTabla().getIdElementoSeleccionado());
        }


        if (principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getSexo().equals("Hembra")){
            principalPage.getVentanaRegistroBovino().getJl_Madre().getJl_idPariente().setText(id);
        }

        if (principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().getSexo().equals("Macho")){
            principalPage.getVentanaRegistroBovino().getJl_Padre().getJl_idPariente().setText(id);
        }

        principalPage.getVentanaRegistroBovino().getVentanaAgregarParentesco().setVisible(false);

    }
    public void actualizarBovino (ActionEvent ae){
        try{



        }catch (Exception sinDatos){
            // mostrar el error
            //JOptionPane.showMessageDialog(principalPage.getVentanaInserccion(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n" + sinDatos.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void agregarBovino (ActionEvent ae){
        try{
            if (!principalPage.getVentanaRegistroBovino().getJt_Marca().getText().isEmpty() &&
                    !principalPage.getVentanaRegistroBovino().getJt_Raza().getText().isEmpty() &&
                    !(principalPage.getVentanaRegistroBovino().getJd_fecha().getDate()== null)){

                String marca = principalPage.getVentanaRegistroBovino().getJt_Marca().getText();
                String raza = principalPage.getVentanaRegistroBovino().getJt_Raza().getText();
                String sexo = (String) principalPage.getVentanaRegistroBovino().getJc_Sexo().getSelectedItem();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
                String fechaNacimiento = formato.format(principalPage.getVentanaRegistroBovino().getJd_fecha().getDate());
                Animal padre = null;
                Animal madre = null;
                String rasgoDistintivo = "Sin rasgos";

                if (!principalPage.getVentanaRegistroBovino().getJta_RasgoDistintivo().getText().isEmpty()){
                    rasgoDistintivo = principalPage.getVentanaRegistroBovino().getJta_RasgoDistintivo().getText();
                }

                if (!principalPage.getVentanaRegistroBovino().getJl_Padre().getJl_idPariente().getText().equals("?")){

                    padre = animalRepository.getAnimal(Long.parseLong(principalPage.getVentanaRegistroBovino().getJl_Padre().getJl_idPariente().getText())).get();
                }
                if (!principalPage.getVentanaRegistroBovino().getJl_Madre().getJl_idPariente().getText().equals("?")){
                    madre = animalRepository.getAnimal(Long.parseLong(principalPage.getVentanaRegistroBovino().getJl_Madre().getJl_idPariente().getText())).get();
                }

                System.out.println(padre.getId());
                Animal nuevoAnimal = new Animal(fechaNacimiento,rasgoDistintivo,sexo,raza,marca,padre,madre);

                animalRepository.save(nuevoAnimal);
                InterfazTabla nuevoElemento = new InterfazTabla(Long.toString(nuevoAnimal.getId()),marca,fechaNacimiento,sexo,raza,"Novillo");

                nuevoElemento.getDetalle().addMouseListener(seleccionarBovino(nuevoElemento,principalPage.getTabla(), true,principalPage.getOpcionesBovino()));
                nuevoElemento.getIdInterfaz().addMouseListener(eliminarBovino(nuevoElemento,true));

                principalPage.getTabla().agregarElemento(nuevoElemento);
                principalPage.getVentanaRegistroBovino().vaciarCampos();







            }else{
                JOptionPane.showMessageDialog(principalPage.getVentanaRegistroBovino(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception sinDatos){
            // mostrar el error
            JOptionPane.showMessageDialog(principalPage.getVentanaRegistroBovino(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public MouseListener seleccionarBovino (InterfazTabla bovino, Tabla tabla, boolean accionEliminar,JPopupMenu menu){

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bovino.setSeleccionado(true);
                tabla.unicaSeleccionada(bovino);
                System.out.printf(tabla.getIdElementoSeleccionado().toString());

                if (SwingUtilities.isRightMouseButton(e)){
                    if (!(menu == null)){
                        menu.show(bovino,e.getX(),e.getY());
                    }
                }
                if (SwingUtilities.isLeftMouseButton(e)){

                    bovino.aparienciaSeleccionada();
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!bovino.getSeleccionado()){
                    if (accionEliminar == true){
                        bovino.aparienciaEliminada();
                    }else{
                        bovino.aparienciaSeleccionada2();
                    }

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!bovino.getSeleccionado()){
                    bovino.aparienciaPredeterminada();

                }
            }
        };
        return accion;
    }

    public MouseListener eliminarBovino (InterfazTabla bovino, boolean accionEliminar){

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!bovino.getSeleccionado()){
                    if (accionEliminar==true){
                        int opcion = JOptionPane.showConfirmDialog(principalPage, "¿Desea eliminar el Bovino " + bovino.getIdTexto().getText() + " de la base de datos?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (opcion==JOptionPane.YES_NO_OPTION){
                            animalRepository.deleteById(Long.valueOf(bovino.getId()));

                            principalPage.getTabla().getInterfazTablas().remove(bovino);
                            principalPage.getTabla().remove(bovino);
                            principalPage.getTabla().ordenarTabla();
                            JOptionPane.showMessageDialog(principalPage, "El bovino " + bovino.getIdTexto().getText() + " fue eliminado de la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));
                        }
                    }

                }else{
                    bovino.setSeleccionado(false);
                    bovino.aparienciaPredeterminada();

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!bovino.getSeleccionado()){
                    if (accionEliminar == true){
                        bovino.aparienciaEliminada();
                    }else{
                        bovino.aparienciaSeleccionada2();
                    }

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!bovino.getSeleccionado()){
                    bovino.aparienciaPredeterminada();
                }

            }

        };
        return accion;
    }

    public void accionMasInformacion (ActionEvent e){


        Animal bovinoSeleccionado = animalRepository.getAnimal(principalPage.getTabla().getIdElementoSeleccionado().longValue()).get();

        AbrirVentanaMasInformacion(bovinoSeleccionado);



    }
    public void AbrirVentanaMasInformacion(Animal bovinoSeleccionado){
        InformacionBovino nuevaVentana = new InformacionBovino(bovinoSeleccionado.getMarca(),Long.toString(bovinoSeleccionado.getId()),
                bovinoSeleccionado.getFecha(),bovinoSeleccionado.getSexo(),bovinoSeleccionado.getRaza(),bovinoSeleccionado.getRasgoDistintivo(),
                "Novillo");


        if (!(bovinoSeleccionado.getMadre() == null)){
            Long id = bovinoSeleccionado.getMadre().getId();
            nuevaVentana.getJl_Madre().addMouseListener(AccionMasInformacionPadres(animalRepository.getAnimal(id).get()));
            nuevaVentana.getJl_Madre().getJl_idPariente().setText(id.toString());
        }
        if (!(bovinoSeleccionado.getPadre() ==null)){
            Long id = bovinoSeleccionado.getPadre().getId();
            nuevaVentana.getJl_Padre().addMouseListener(AccionMasInformacionPadres(animalRepository.getAnimal(id).get()));
            nuevaVentana.getJl_Padre().getJl_idPariente().setText(id.toString());
        }
        nuevaVentana.setVisible(true);

    }

    public MouseAdapter AccionMasInformacionPadres (Animal animal){

        MouseAdapter accion = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(animal == null)){
                    AbrirVentanaMasInformacion(animal);
                }

            }

        };
        return accion;
    }
}
