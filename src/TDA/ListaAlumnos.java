package TDA;
import java.util.ArrayList;

public class ListaAlumnos {
    ArrayList<Alumno> Lista;
    public ListaAlumnos(){
        Lista=new ArrayList();
    }
    public  void añadirAl(Alumno p){
        Lista.add(p);
    }
    public void eliminarAl(int pos){//añadir apartir de un jlist creo
        Lista.remove(pos);
    }
    public void limpiarAll(){
        Lista.removeAll(Lista);
    }
}
