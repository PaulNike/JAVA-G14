package com.codigo.patternSingleton;

public class ConfiguracionGlobal {
    private static final ConfiguracionGlobal INSTANCE = new ConfiguracionGlobal();
    private String ambiente = "DEV";

    private ConfiguracionGlobal() {
    }

    public static ConfiguracionGlobal getINSTANCE() {
        return INSTANCE;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
}
