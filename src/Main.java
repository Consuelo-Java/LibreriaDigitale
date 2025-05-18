import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Libro<?> libro1 = new Libro<>("ISBN-123","Moby Dick", "Melville");
        Libro<?> libro2 = new Libro<>("ISBN-459","Il ritratto di Dorian Gray", "Wilde");
        Libro<?> libro3 = new Libro<>("ISBN-633","Piccole donne", "Alcoot");
        Libro<?> libro4 = new Libro<>("ISBN-209","Il libro della giungla", "Kipling");
        Libro<?> libro5 = new Libro<>("ISBN-333","Il vecchio e il mare", "Hemingway");
        Libro<?> libro6 = new Libro<>("ISBN-455","Harry Potter e la pietra filosofale", "Rowling");
        Libro<?> libro7 = new Libro<>("ISBN-163","Il castello errante di Howl", "Jones");
        Libro<?> libro8 = new Libro<>("ISBN-988","Rinascimento privato", "Bellonci");
        Libro<?> libro9 = new Libro<>("ISBN-029","1984", "Orwell");
        Libro<?> libro10 = new Libro<>("ISBN-740","Gente di dublino", "Joyce");
        Libro<?> libro11 = new Libro<>("ISBN-406","Il giocatore", "Dostojevski");
        Libro<?> libro12 = new Libro<>("ISBN-805","Canto di Natale", "Dickens");

        Comparator<Libro<?>> ordinatore = new Comparator<Libro<?>>() {
            @Override
            public int compare(Libro<?> l1, Libro<?> l2) {
                return l1.titolo.compareToIgnoreCase(l2.titolo);
            }
        };

        Biblioteca<?> biblioteca = new Biblioteca<>();
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);
        biblioteca.aggiungiLibro(libro4);
        biblioteca.aggiungiLibro(libro5);
        biblioteca.aggiungiLibro(libro6);
        biblioteca.aggiungiLibro(libro7);
        biblioteca.aggiungiLibro(libro8);
        biblioteca.aggiungiLibro(libro9);
        biblioteca.aggiungiLibro(libro10);
        biblioteca.aggiungiLibro(libro11);
        biblioteca.aggiungiLibro(libro12);
        Collections.sort(biblioteca.libri, ordinatore);

        for(Libro<?> libro : biblioteca.libri){
            System.out.println(libro.titolo+" ("+libro.autore+")");
        }

    }
}
