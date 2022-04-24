package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {
        Turtle zofka;

        zofka = new Turtle();


        
    }

    private void nakresliPravouhlyTrojuhelnik(Turtle zofka, double delkaStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        double delkaStranyC = Math.sqrt(2) * delkaStrany;
        zofka.move(delkaStrany);
        zofka.turnRight(135);
        zofka.move(delkaStranyC);
        zofka.turnRight(135);
        zofka.move(delkaStrany);
    }

    private void nakresliKolecko(Turtle zofka, double delkaStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        double pocetStran = 24.0;
        for (int i = 0; i < pocetStran; i++) {
            double uhel = 360.0 / pocetStran;
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
    }

    private void nakresliObdelnik(Turtle zofka, double delkaStranyA, double delkaStranyB, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaStranyA);
            zofka.turnRight(90);
            zofka.move(delkaStranyB);
            zofka.turnRight(90);
        }
    }

    private void nakresliCtverec(Turtle zofka, double delkaStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }

    private void nakresliRovnostrannyTrojuhelnik(Turtle zofka, double delkaStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(120);
        }
    }
}
