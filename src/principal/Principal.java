package principal;

import java.util.ArrayList;
import java.util.List;

public class Principal
{
    public static void main(String args[])
    {
        List<Persona> list = Persona.cargarDatosURL();
        System.out.println(list);
    }

}
