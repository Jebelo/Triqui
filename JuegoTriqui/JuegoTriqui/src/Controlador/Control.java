
package Controlador;

import Logica.Modelo;
import Logica.Player;
import Vista.Vista1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Control implements ActionListener{
    
    Modelo modelo;
    Vista1 view;

    public Control(Modelo modelo, Vista1 view) {
        this.modelo = modelo;
        this.view = view;
        
        this.view.position0_0.addActionListener(this);
        this.view.position0_1.addActionListener(this);
        this.view.position0_2.addActionListener(this);
        this.view.position1_0.addActionListener(this);
        this.view.position1_1.addActionListener(this);
        this.view.position1_2.addActionListener(this);
        this.view.position2_0.addActionListener(this);
        this.view.position2_1.addActionListener(this);
        this.view.position2_2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        int fila = -1, col = -1;
        if (boton == view.position0_0) { fila=0; col=0; }
        else if (boton == view.position0_1) { fila=0; col=1; }
        else if (boton == view.position0_2) { fila=0; col=2; }
        else if (boton == view.position1_0) { fila=1; col=0; }
        else if (boton == view.position1_1) { fila=1; col=1; }
        else if (boton == view.position1_2) { fila=1; col=2; }
        else if (boton == view.position2_0) { fila=2; col=0; }
        else if (boton == view.position2_1) { fila=2; col=1; }
        else if (boton == view.position2_2) { fila=2; col=2; }

        if (fila != -1 && modelo.hacerMovimiento(fila, col)) {
            // Aqui se coloca el símbolo del jugador en el botón
            boton.setText(String.valueOf(modelo.getTurnoActual() == 'X' ? 'O' : 'X')); 
            char ganador = modelo.verificarGanador();
            if (ganador != ' ') {
                // Mostramos mensaje de quien gano según el jugador que haya hecho triqui.
            String jugador = (ganador == 'X') ? "\\ (•◡•) /Jugador P1 (X)" : "~(˘▾˘~)Jugador P2 (O)";
            javax.swing.JOptionPane.showMessageDialog(view,
                    "🎉¡Ganó el " + jugador + "!",
                    "Resultado del Triqui",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                modelo.reiniciarTablero();
                limpiarBotones();
            } else if (modelo.tableroLleno()) {
                javax.swing.JOptionPane.showMessageDialog(view, "¡Empate ¯\\_(ツ)_/¯!");
                modelo.reiniciarTablero();
                limpiarBotones();
            }
        }
    }

    private void limpiarBotones() {
        view.position0_0.setText("");
        view.position0_1.setText("");
        view.position0_2.setText("");
        view.position1_0.setText("");
        view.position1_1.setText("");
        view.position1_2.setText("");
        view.position2_0.setText("");
        view.position2_1.setText("");
        view.position2_2.setText("");
    }
}
    

