package com.codigo.patternAdapter.ejemplo2;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PaymentAdapter {
    private final ExternalPaymentService externalPaymentService;

    public PaymentAdapter(ExternalPaymentService externalPaymentService) {
        this.externalPaymentService = externalPaymentService;
    }
    public PaymentResponse getPayment(){
        try {
            String xml = externalPaymentService.getPaymentXML();  //XML PARSING
            var builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            var doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            Long id = Long.parseLong(doc.getElementsByTagName("id").item(0).getTextContent());
            String status = doc.getElementsByTagName("status").item(0).getTextContent();
            Double amount = Double.parseDouble(doc.getElementsByTagName("amount").item(0).getTextContent());

            return PaymentResponse.builder()
                    .id(id)
                    .status(status)
                    .amount(amount)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
