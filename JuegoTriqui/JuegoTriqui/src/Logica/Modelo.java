
package Logica;

public class Modelo {
    private char[][] tablero;  // Matriz 3x3
    private char turnoActual;  // 'X' o 'O'

    public Modelo() {
        tablero = new char[3][3];
        reiniciarTablero();
    }

    public char getTurnoActual() {
        return turnoActual;
    }

    public boolean hacerMovimiento(int fila, int col) {
        if (tablero[fila][col] == ' ') {
            tablero[fila][col] = turnoActual;
            cambiarTurno();
            return true;
        }
        return false;
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual == 'X') ? 'O' : 'X';
    }

    public char verificarGanador() {
        // Revisar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' &&
                tablero[i][0] == tablero[i][1] &&
                tablero[i][1] == tablero[i][2]) {
                return tablero[i][0];
            }
        }

        // Revisar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != ' ' &&
                tablero[0][j] == tablero[1][j] &&
                tablero[1][j] == tablero[2][j]) {
                return tablero[0][j];
            }
        }

        // Revisar diagonales
        if (tablero[0][0] != ' ' &&
            tablero[0][0] == tablero[1][1] &&
            tablero[1][1] == tablero[2][2]) {
            return tablero[0][0];
        }

        if (tablero[0][2] != ' ' &&
            tablero[0][2] == tablero[1][1] &&
            tablero[1][1] == tablero[2][0]) {
            return tablero[0][2];
        }

        return ' '; // No hay ganador todavía
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reiniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
        turnoActual = 'X'; // Siempre empieza X
    }
}
    
    

