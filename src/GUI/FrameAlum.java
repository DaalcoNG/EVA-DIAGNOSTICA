package GUI;
import IO.Jopi;
import TDA.Alumno;
import TDA.ListaAlumnos;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameAlum extends JFrame implements ActionListener  {
    private ListaAlumnos lista;
    private Container contenedor;
    private JList listaNombres;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;
   private JLabel numCtrl,semestre,nombre,total,edad;
    private JButton añadir,eliminar,eliminarTodo;
    private JTextField campoNumero,campoNombre,campoSemestre,campoTotal,campoEdad;
    public FrameAlum(){
        lista = new ListaAlumnos(); // Crea la lista de alumnos
        inicio();
        setTitle("Captura datos ");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        //Para poner el nimero de control
        numCtrl = new JLabel();
        numCtrl.setText("Num.Control:");//palabra
        numCtrl.setBounds(30,5,100,30);
        campoNumero = new JTextField();//campo
        campoNumero.setBounds(110,12,150,20);
        
        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(30, 35, 100, 30);
        campoNombre = new JTextField();
        campoNombre.setBounds(110,42,150,20);
        
        semestre = new JLabel();
        semestre.setText("Semestre:");
        semestre.setBounds(30, 65, 100, 30);
        campoSemestre = new JTextField();
        campoSemestre.setBounds(110,72,150,20);
        
        edad = new JLabel();
        edad.setText("Edad:");
        edad.setBounds(30, 95, 100, 30);
        campoEdad = new JTextField();
        campoEdad.setBounds(110,102,150,20);


        total = new JLabel();
        total.setText("No.Registro:");
        total.setBounds(20, 253, 135, 23);
        campoTotal = new JTextField();
        campoTotal.setBounds(20, 260, 135, 23);

        añadir = new JButton();
        añadir.setText("Alta");
        añadir.setBounds(10, 280, 70, 23);
        añadir.addActionListener(this);
        // Establece el botón Eliminar Alumno
        eliminar = new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(90, 280, 80, 23);
        eliminar.addActionListener(this);
        // Establece el botón Borrar list
        eliminarTodo = new JButton();
        eliminarTodo.setText("Limpia lista");
        eliminarTodo.setBounds(180, 280, 100, 23);
        eliminarTodo.addActionListener(this);
        
        // Establece la lista gráfica de Alumnos
        listaNombres = new JList();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();
        // Establece una barra de desplazamiento vertical
        scrollLista = new JScrollPane();
        scrollLista.setBounds(10, 140, 270, 100);
        // Asocia la barra de desplazamiento vertical a la lista de personas
        scrollLista.setViewportView(listaNombres);

        contenedor.add(numCtrl);
        contenedor.add(campoNumero);
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(semestre);
        contenedor.add(campoSemestre);
        contenedor.add(edad);
        contenedor.add(campoEdad);
        contenedor.add(total);
        contenedor.add(añadir);
        contenedor.add(eliminar);
        contenedor.add(eliminarTodo);
        contenedor.add(scrollLista);

        
    }
    private void añadirAlumno() {
        /* Se obtienen los campos de texto ingresados y se crea una Alumno */
        Alumno p = new Alumno(campoNumero.getText(), campoNombre.getText(),
                (Byte.parseByte(campoSemestre.getText())), (Byte.parseByte(campoEdad.getText())));
        lista.añadirAl(p);
        /* Se añade una persona al vector de personas */
    String cad = campoNombre.getText() + " " + campoNumero.getText() + " "
                + campoSemestre.getText() + " " + campoEdad.getText();
        modelo.addElement(cad);
        /* Se agrega el texto con los  datos del Alumni al JList */
        listaNombres.setModel(modelo);
        int x = modelo.getSize();
        total.setText("No.Registro:" + x);
        // Se colocan todos los campos de texto nulos, para limpiar el area
        campoNumero.setText("");
        campoNombre.setText("");
        campoSemestre.setText("");
        campoEdad.setText("");
        campoTotal.setText("");
    }
    private void eliminarAlumno(int indice) {
        if (indice >= 0) { // Si la posición existe
            modelo.removeElementAt(indice);
            /* Se elimina un alumno seleccionada de la lista gráfica */
            lista.eliminarAl(indice);
            int x = modelo.getSize();
            total.setText("No.Registro:" + x);
        } else {
            /* Si no se seleccionó ninguna persona, se genera un  mensaje de error */
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento");
        }
    }
    private void EliminarTodo() {
        lista.limpiarAll(); // Se eliminan todas las personas del vector
        modelo.clear(); // Limpia el JList, la lista gráfica de personas}
        int x = modelo.getSize();
        total.setText("No.Registro:" + x);
        // listaNombres= new JList();
        /* Establece que se pueda seleccionar solamente un elemento de la lista */
        //listaNombres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
}


        @Override
    public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == añadir) { // Si se pulsa el botón añadir
                añadirAlumno(); // Se invoca añadir Alumno
            }
            if (evento.getSource() == eliminar) {
                /* Si se pulsa el botón  eliminar */
             /* Se invoca el método eliminarNombre que elimina el  elemento seleccionado */
                eliminarAlumno(listaNombres.getSelectedIndex());
            }
            if (evento.getSource() == eliminarTodo) {
                //Si se pulsa el botón borrar lista 
                EliminarTodo(); // Se invoca borrar lista
            }

    } 
}
