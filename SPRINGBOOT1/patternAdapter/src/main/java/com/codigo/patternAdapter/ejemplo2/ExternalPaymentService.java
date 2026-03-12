package com.codigo.patternAdapter.ejemplo2;

public class ExternalPaymentService {
    public String getPaymentXML(){
        return "<payment>\n" +
                "    <id>123</id>\n" +
                "    <status>SUCCESS</status>\n" +
                "    <amount>150.50</amount>\n" +
                "</payment>";
    }
}
