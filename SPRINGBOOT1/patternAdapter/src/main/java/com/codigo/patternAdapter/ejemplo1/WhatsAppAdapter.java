package com.codigo.patternAdapter.ejemplo1;

public class WhatsAppAdapter implements INotificador{
    private final ServicioWhastAppExterno servicioWhastAppExterno;

    public WhatsAppAdapter(ServicioWhastAppExterno servicioWhastAppExterno) {
        this.servicioWhastAppExterno = servicioWhastAppExterno;
    }

    @Override
    public void enviar(String mensaje) {
        servicioWhastAppExterno.sendMenssage(mensaje);
    }
}
