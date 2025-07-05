package com.hulkhiretech.payments;
import com.hulkhiretech.payments.service.impl.HMac256ServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HMac256ServiceImplTest {
      private HMac256ServiceImpl service = new HMac256ServiceImpl();

    @Test
    public void testGenerateHmacSHA256Signature_withValidJson_returnsSignature() {
        String jsonData = "{\"amount\":100,\"currency\":\"USD\"}";
        String signature = service.generateHmacSHA256Signature(jsonData);
        log.info("Generated signature: {}", signature);
        assertNotNull(signature);
        assertFalse(signature.isEmpty());
    }

    @Test
    public void testGenerateHmacSHA256Signature_withEmptyString_returnsSignature() {
        HMac256ServiceImpl service = new HMac256ServiceImpl();
        String jsonData = "";
        String signature = service.generateHmacSHA256Signature(jsonData);
        log.info("Generated signature: {}", signature);

        assertNotNull(signature);
        assertFalse(signature.isEmpty());
    }

  
}
