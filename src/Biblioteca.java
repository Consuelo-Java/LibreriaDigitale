import java.util.*;

public class Biblioteca<T> {
    List<Libro<?>> libri;
    Set<String> utenti;
    HashMap<String, Stack<Libro<?>>> prestitiUtenti;
    Queue<Libro<?>> daRestituire;

    public boolean aggiungiLibro(Libro<?> libro){
        return libri.add(libro);
    }

    public boolean rimuoviLibro(T id){
        for(Libro<?> libro : libri){
            if(libro.getIdentificativo() == id){
                return libri.remove(libro);
            }
        }
        return false;
    }

    public void registraUtente(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Non si puo' aggiungere un utente senza nome");
        }
        utenti.add(nome);
    }

    public void prestaLibro(String nome, Libro<?> libro){
        if(!utenti.contains(nome)){
            throw new IllegalArgumentException("Utente "+nome+" non trovato");
        }
        if(!libri.contains(libro)){
            throw new IllegalArgumentException("Libro "+libro.titolo+" ("+libro.autore+") non trovato o gia' in prestito");
        }
        if(prestitiUtenti.containsKey(nome)){
            Stack<Libro<?>> libriInPrestito = prestitiUtenti.get(nome);
            libriInPrestito.add(libro);
            prestitiUtenti.put(nome, libriInPrestito);
        } else {
            Stack<Libro<?>> libriInPrestito = new Stack<>();
            libriInPrestito.add(libro);
            prestitiUtenti.put(nome, libriInPrestito);
        }
    }

    public void restauraLibro(String nome){
        if(!utenti.contains(nome)){
            throw new IllegalArgumentException("Utente "+nome+" non trovato");
        }
        Stack<Libro<?>> libriInPrestito = prestitiUtenti.get(nome);
        if(libriInPrestito.isEmpty()){
            throw new IllegalArgumentException("L'utente "+nome+" non ha libri da restituire");
        }
        Libro<?> libro = libriInPrestito.pop();
        daRestituire.add(libro);
    }

}
