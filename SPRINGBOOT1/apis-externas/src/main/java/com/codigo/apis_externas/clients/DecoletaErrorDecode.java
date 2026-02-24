package com.codigo.apis_externas.clients;

import com.codigo.apis_externas.dto.ProviderErrorResponse;
import com.codigo.apis_externas.exception.DniInvalidoException;
import com.codigo.apis_externas.exception.ReniecProviderException;
import feign.Response;
import feign.codec.ErrorDecoder;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DecoletaErrorDecode implements ErrorDecoder {
    private final ObjectMapper objectMapper;
    private final ErrorDecoder defaultDecode = new Default();

    public DecoletaErrorDecode(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String s, Response response) {
        try {
            //Leer body (Si exista)
            if (response.body() != null) {
                try (InputStream is = response.body().asInputStream()) {
                    byte[] bytes = is.readAllBytes();
                    String raw = new String(bytes, StandardCharsets.UTF_8);
                    //Intento de Parseo de string a objeto java
                    ProviderErrorResponse error = objectMapper.readValue(raw,
                            ProviderErrorResponse.class);

                    //RELGAS DE STATUS
                    if (response.status() == 422 && error.message() != null) {
                        //Aqui vamos a decidir comno mapear mensajes
                        if (error.message().toLowerCase().contains("dni")) {
                            return new DniInvalidoException(error.message());
                        }
                        return new ReniecProviderException(error.message());
                    }

                    if (response.status() == 401) {
                        return new ReniecProviderException("Token invalido o expirado");
                    }
                    if (response.status() >= 500) {
                        return new ReniecProviderException("Proveedor de Reniec caido (5xx): " + error.message());
                    }

                    return new ReniecProviderException("ERROR PROVEEDOR: "
                            + response.status() + " mensaje: " + error.message());

                }
            }
            // ignored -> Hacemos referencia a que este ctach se va
            // ignorar porque las ecepciones ya  se definierons antes
        } catch (Exception ignored) {

        }
        //Si ninguna expecion se lanza, se termina ejecutando este default
        return defaultDecode.decode(s,response);
    }
}
