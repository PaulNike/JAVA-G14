package enums;

public enum EstadoPedido {
    PENDIENTE(1,"Pedido registrado"),
    PROCESAnDO(2,"Pedido en reparacion"),
    ENVIADO(3,"Pedido enviado al cliente"),
    CANCELADO(4, "Pedido cancelado");

    private final int codigo;
    private final String descripcion;

    EstadoPedido(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstadoPedido fromCodigo(int codigo) {
        for(EstadoPedido e : values()){
            if(e.getCodigo()==codigo) return e;
        }
        return null;
    }
}
