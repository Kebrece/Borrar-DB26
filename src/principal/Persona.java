package principal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona
{
    private int cedula;
    private String nombre;
    private String apellido;
    private int edad;
    //private String direccion;

    public Persona() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /*public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }*/

    @Override
    public String toString() {
        return "principal.Persona{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                //", direccion='" + direccion + '\'' +
                '}' + "\n";
    }


    public static List<Persona> cargarDatosURL()
{
    List<Persona> list = new ArrayList<>();
    SQLExecutorURL sqlExecutorURL = new SQLExecutorURL("1433", "CURSO", "sa", "password");
    sqlExecutorURL.abreConexion();
    ResultSet rs2 = sqlExecutorURL.ejecutaSQL("select * from CURSO.dbo.PERSONA");
    try
    {
        while (rs2.next())
        {
            Persona comodin = new Persona();
            comodin.setNombre(rs2.getString("NOMBRE"));
            comodin.setApellido(rs2.getString("APELLIDO"));
            comodin.setEdad(rs2.getInt("EDAD"));
            //comodin.setDireccion(rs2.getString("DIRECCION"));
            comodin.setCedula(rs2.getInt("EDAD"));
            list.add(comodin);
        }
    }catch (SQLException ex)
    {
        ex.printStackTrace();
    }
    sqlExecutorURL.cierraConexion();
    return list;
}

}
