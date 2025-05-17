public class Libro<T> {

    private T identificativo;

    public Libro(T identificativo){
        this.identificativo = identificativo;
    }

    public T getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(T identificativo) {
        this.identificativo = identificativo;
    }
}
