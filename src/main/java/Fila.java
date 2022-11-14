import java.util.ArrayList;

public class Fila {

    ArrayList lista;

    public Fila(int i) {
        lista  = new ArrayList(i);
    }

    public Fila() {
        lista = new ArrayList();
    }

    public boolean isEmpty() {
        return lista.size()==0;
    }

    public void adiciona(String string) {
        if (!lista.contains(string))
            lista.add(string);

    }

    public int size() {

        return lista.size();
    }

    public Object remove() {
        if (isEmpty())
            return null;
        return lista.remove(0);
    }

}
