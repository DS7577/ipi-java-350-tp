package com.ipiecoles.java.java350.model;

import com.thoughtworks.gauge.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    //Embauché en 2020. On est en 2020 : 0 an d'ancienneté
    public void testNombreAnneeAncienneteNow() {
        //Given = Initialisation des données d'entrée
        LocalDate now = LocalDate.now();
        Employe employe = new Employe();
        employe.setDateEmbauche(now);

        //When = Exécution de la méthode à tester
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();
        //Then = Vérifications de ce qu'a fait la méthode
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

    @Test
    //Embauché en 2019. On est en 2020 : 1 an d'ancienneté
    public void testNombreAnneeAncienneteNMoins1() {
        //Given = Initialisation des données d'entrée
        LocalDate nMoins1 = LocalDate.now().minusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nMoins1);

        //When = Exécution de la méthode à tester
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();
        //Then = Vérifications de ce qu'a fait la méthode
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(1);
    }

    @Test
    //Embauché en 2020. On est en 2021 : 0 an d'ancienneté
    public void testNombreAnneeAncienneteNPlus1() {
        //Given = Initialisation des données d'entrée
        LocalDate nPlus1 = LocalDate.now().plusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nPlus1);

        //When = Exécution de la méthode à tester
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();
        //Then = Vérifications de ce qu'a fait la méthode
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

    @Test
    //Embauché en 2021. On est en 2020 : 0 an d'ancienneté
    public void testNombreAnneeAncienneteNull() {
        //Given = Initialisation des données d'entrée
        LocalDate nMPlus1 = LocalDate.now().minusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(null);

        //When = Exécution de la méthode à tester
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();
        //Then = Vérifications de ce qu'a fait la méthode
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }
}
