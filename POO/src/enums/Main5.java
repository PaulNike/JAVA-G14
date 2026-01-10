package enums;

public class Main5 {
    public static void main(String[] args) {
        Dia hoy = Dia.DOMINGO;

        switch (hoy){
            case LUNES,MARTES,MIERCOLES,JUEVES,VIERNES -> System.out.println("Día laboral");
            case SABADO,DOMINGO -> System.out.println("Fin de semana");
        }

        //EJERCICIO 2
        System.out.println("========================= EJERCICIO 2========================");
        for (Rol r : Rol.values()){
            System.out.println("Rol: " + r);
        }

        String texto = "ADMIN";
        Rol rol = Rol.valueOf(texto);
        System.out.println("Convertido: " + rol);

        System.out.println("========================= EJERCICIO 3========================");

        NivelAcceso n = NivelAcceso.MEDIO;
        System.out.println(n + " Tiene codigo: "+ n.getCodigo());

        System.out.println("========================= EJERCICIO 4========================");

        int a = 10, b = 3;

        Operacion op = Operacion.RESTA;
        int resultado = op.aplicar(a,b);

        System.out.println("Resultado: " + resultado);
    }
}
