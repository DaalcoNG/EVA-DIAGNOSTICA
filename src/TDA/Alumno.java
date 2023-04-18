package TDA;
public class Alumno {
    private String nCont;
    private String nAlum;
    private byte edad;
    private byte semAlum;

    public Alumno(String nCont, String nAlum,byte edad, byte semAlum) {
        this.nCont = nCont;
        this.nAlum = nAlum;
        this.edad= edad;
        this.semAlum = semAlum;
    }
    public Alumno(){
        
    }
    public String getnCont() {
        return nCont;
    }

    public void setnCont(String nCont) {
        this.nCont = nCont;
    }

    public String getnAlum() {
        return nAlum;
    }

    public void setnAlum(String nAlum) {
        this.nAlum = nAlum;
    }

    public byte getSemAlum() {
        return semAlum;
    }

    public void setSemAlum(byte semAlum) {
        this.semAlum = semAlum;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nCont=" + nCont +
                ", nAlum=" + nAlum + ", edad=" + edad + ", semAlum=" + semAlum + '}';
    } 
}
