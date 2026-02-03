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

        System.out.println("========================= EJERCICIO 5========================");

        int code = 409;

        HttpStatus status = HttpStatus.fromCode(code);

        if(status != null){
            System.out.println("Code: "+ status.getCode());
            System.out.println("Status "+ status);
            System.out.println("Descripcion: "+ status.getDescripcion());
        }else {
            System.out.println("Codigo invalido " + code);
        }

        System.out.println("============================================");
        int code2 = 3;
        EstadoPedido estado = EstadoPedido.fromCodigo(code2);
        if(estado!=null){
            System.out.println("Nombre del estado :" + estado);
            System.out.println("Codigo del estado :" + estado.getCodigo());
            System.out.println("Descripcion :" + estado.getDescripcion());
        }else {
            System.out.println("Error");
        }
    }
}
