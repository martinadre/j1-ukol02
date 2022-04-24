package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {
        Turtle zofka;
        Color ruzovaBarva;
        Color hnedaBarva;
        Color modraBarva;
        Color cernaBarva;
        Color zelenaBarva;

        zofka = new Turtle();
        ruzovaBarva = new Color(238, 9, 210);
        hnedaBarva = new Color (126, 83, 29);
        modraBarva = new Color(46, 155, 215, 255);
        cernaBarva = new Color(12, 2, 2);
        zelenaBarva = new Color(94, 225, 7);

        zofka.setLocation(40, 100);

        nakresliZmrzlinu(zofka, 20, ruzovaBarva, hnedaBarva);

        // Sněhulák:
        zofka.setLocation(300, 500);
        zofka.turnLeft(90);
        nakresliKolecko(zofka, 20, modraBarva);
        // vrchní bod největšího kolečka (x, y): 280 + 10 (polovina z delkaStrany), 348.0849177454969
        // počáteční bod pro nakreslení středního kolečka (x): 280 + 10 + 7.5 (polovina z delkaStrany)
        zofka.setLocation(297.5, 348.0849177454969);
        nakresliKolecko(zofka, 15, modraBarva);
        // počáteční bod pro nakreslení nejmenšího kolečka (x): 280 + 10 + 5 (polovina z delkaStrany)
        zofka.setLocation(295, 234.14860605461962);
        nakresliKolecko(zofka, 10, modraBarva);
        // počáteční bod pro nakreslení pravé ruky (x, y): 346.9681558454386, 283.61676190005824 + 10
        zofka.setLocation(346.9681558454386, 293.61676190005824);
        zofka.turnRight(90);
        nakresliKolecko(zofka, 5, modraBarva);
        // počáteční bod pro nakreslení levé ruky (x, y): 233.03184415456138, 298.61676190005824 - 10
        zofka.setLocation(233.03184415456138, 288.61676190005824);
        zofka.turnLeft(180);
        nakresliKolecko(zofka, 5, modraBarva);
        zofka.turnRight(180);

        // Sněhulák pomocí metody:
        zofka.setLocation(700, 280);
        nakresliSnehulaka(zofka, 15,10,7,3, new Color(8, 38, 236));

        // Mašinka:
        zofka.setLocation(900, 500);
        zofka.turnLeft(90);
        nakresliKolecko(zofka, 20, cernaBarva);
        zofka.turnRight(90);
        // levý spodní roh vysokého obdélníku (x, y):  814.0424588727486, 414.04245887274845 + 10 (polovina z delkaStrany kolečka)
        // pravý spodní roh vysokého obdélníku (x): 965.9575411272514
        zofka.setLocation(814.0424588727486, 424.04245887274845);
        double stranaBVysokehoObdelniku = 965.9575411272514 - 814.0424588727486;
        nakresliObdelnik(zofka, 225, stranaBVysokehoObdelniku, zelenaBarva);
        zofka.turnLeft(90);
        nakresliObdelnik(zofka, 225, 120, zelenaBarva);
        // levý spodní roh širokého obdélníku (x): 589.0424588727486
        double poziceXLevehoMalehoKola = 589.0424588727486 + 60;
        zofka.setLocation(poziceXLevehoMalehoKola, 500);
        nakresliKolecko(zofka, 10, cernaBarva);
        // pravý bod levého kolečka (x, y): 682.0212294363746, 457.0212294363743 + 5
        double poziceXPravehoMalehoKola = 682.0212294363746 + 60;
        zofka.setLocation(poziceXPravehoMalehoKola, 500);
        nakresliKolecko(zofka, 10, cernaBarva);
        double poziceYPravouhlehoTrojuhelniku = 457.0212294363743 + 5;
        zofka.setLocation(589.0424588727486, poziceYPravouhlehoTrojuhelniku);
        nakresliPravouhlyTrojuhelnik(zofka, 120, new Color(14, 72, 16));
    }

    private void nakresliSnehulaka(Turtle zofka, double delkaStrany1, double delkaStrany2, double delkaStrany3, double delkaStrany4, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        zofka.turnLeft(90);
        nakresliKolecko(zofka, delkaStrany1, barvaCary);
        double polomerKolecka1 = delkaStrany1 / (2 * Math.sin(7.5 * (Math.PI/180)));
        zofka.penUp();
        zofka.move(delkaStrany1 / 2);
        zofka.turnRight(90);
        double sirka1 = 2 * (Math.sqrt(Math.pow(polomerKolecka1, 2) - Math.pow(0.5 * delkaStrany1, 2)));
        zofka.move(sirka1);
        zofka.turnRight(90);
        zofka.move(delkaStrany2 / 2);
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKolecko(zofka, delkaStrany2, barvaCary);
        double polomerKolecka2 = delkaStrany2 / (2 * Math.sin(7.5 * (Math.PI/180)));
        zofka.penUp();
        zofka.move(delkaStrany2 / 2);
        zofka.turnRight(90);
        double sirka2 = 2 * (Math.sqrt(Math.pow(polomerKolecka2, 2) - Math.pow(0.5 * delkaStrany2, 2)));
        zofka.move(sirka2);
        zofka.turnRight(90);
        zofka.move(delkaStrany3 / 2);
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKolecko(zofka, delkaStrany3, barvaCary);
        zofka.penUp();
        zofka.move(delkaStrany3 / 2);
        zofka.turnLeft(90);
        zofka.move(0.5 * sirka2);
        zofka.turnRight(90);
        zofka.move(0.5 * sirka2);
        zofka.turnRight(90);
        zofka.move(delkaStrany4 / 2);
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKolecko(zofka, delkaStrany4, barvaCary);
        zofka.penUp();
        zofka.move(delkaStrany4 / 2);
        zofka.turnLeft(90);
        zofka.move(sirka2);
        zofka.turnRight(90);
        zofka.move(delkaStrany4 / 2);
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKolecko(zofka, delkaStrany4, barvaCary);
    }

    private void nakresliZmrzlinu(Turtle zofka, double delkaStrany, Color barvaKopecku, Color barvaKornoutku) {
        nakresliKolecko(zofka, delkaStrany, barvaKopecku );
        posunSeNaLevyRohKornoutku(zofka, delkaStrany);
        double polohaKornoutkuLeveX = zofka.getX();
        double polohaKornoutkuLeveY = zofka.getY();
        posunSeNaPravyRohKornoutku(zofka, delkaStrany);
        double polohaKornoutkuPraveX = zofka.getX();

        zofka.setLocation(polohaKornoutkuLeveX, polohaKornoutkuLeveY);
        zofka.turnRight(240);
        double delkaStranyKornoutku = polohaKornoutkuPraveX - polohaKornoutkuLeveX;
        nakresliRovnostrannyTrojuhelnik(zofka, delkaStranyKornoutku, barvaKornoutku);
        zofka.turnLeft(90);
    }

    private void posunSeNaLevyRohKornoutku(Turtle zofka, double delkaStrany) {
        zofka.penUp();
        double pocetStran = 24.0;
        for (int i = 0; i < 23; i++) {
            double uhel = 360.0 / pocetStran;
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
        zofka.penDown();
    }

    private void posunSeNaPravyRohKornoutku(Turtle zofka, double delkaStrany) {
        zofka.penUp();
        double pocetStran = 24.0;
        for (int i = 0; i < 15; i++) {
            double uhel = 360.0 / pocetStran;
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
        zofka.penDown();
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
