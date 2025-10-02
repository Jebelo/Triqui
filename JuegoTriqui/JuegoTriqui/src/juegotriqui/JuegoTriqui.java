/*
Hecho por Juan Esteban Benavides Lopez.
          Juan Diego Marulanda Ballesteros.
*/
package juegotriqui;

import Controlador.Control;
import Logica.Modelo;
import Vista.Vista1;

public class JuegoTriqui {
    public static void main(String[] args) {
        // Crear modelo y vista
        Modelo modelo = new Modelo();
        Vista1 vista = new Vista1();

        // Crear controlador pasándole el modelo y la vista
        Control control = new Control(modelo, vista);

        // Mostrar ventana
        vista.setTitle("¯\\(°_o)/¯ Triqui Rompecabezas ( ⚆ _ ⚆ ).");
        vista.setVisible(true);
    }
}
