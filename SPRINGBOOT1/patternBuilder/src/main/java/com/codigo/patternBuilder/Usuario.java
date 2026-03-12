package com.codigo.patternBuilder;

public class Usuario {
    private final String nombre;
    private final String apellido;
    private final Integer edad;
    private final String email;
    private final String ciudad;
    private final boolean activo;
    private final String rol;

    public Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.edad = builder.edad;
        this.email = builder.email;
        this.ciudad = builder.ciudad;
        this.activo = builder.activo;
        this.rol = builder.rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getRol() {
        return rol;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String nombre;
        private String apellido;
        private Integer edad;
        private String email;
        private String ciudad;
        private boolean activo;
        private String rol;

        public Builder nombre(String nombre){
            this.nombre = nombre;
            return this;
        }
        public Builder apellido(String apellido){
            this.apellido = apellido;
            return this;
        }
        public Builder edad(Integer edad){
            this.edad = edad;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder ciudad(String ciudad){
            this.ciudad = ciudad;
            return this;
        }
        public Builder activo(boolean activo){
            this.activo = activo;
            return this;
        }
        public Builder rol(String rol){
            this.rol = rol;
            return this;
        }
        public Usuario build(){
            if(apellido == null || apellido.isBlank()) throw new IllegalArgumentException("El apellido no puede ser nulo o vacio");
            return new Usuario(this);
        }
    }
}
