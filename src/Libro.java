public class Libro<T> {

    private T identificativo;
    public String titolo;
    public String autore;

    public Libro(T identificativo, String titolo, String autore) {
        this.identificativo = identificativo;
        this.titolo = titolo;
        this.autore = autore;
    }

    public T getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(T identificativo) {
        this.identificativo = identificativo;
    }
}
