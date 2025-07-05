package com.hulkhiretech.payments.service.impl;

import com.hulkhiretech.payments.service.interfaces.HMacSHA256Service;

import lombok.extern.slf4j.Slf4j;
import java.util.Base64;
import javax.crypto.Mac;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;

@Service
@Slf4j
public class HMac256ServiceImpl implements HMacSHA256Service {
        @Override
        public String generateHmacSHA256Signature(String jsonData){
            String signature = null;
            String secretKey = "THIS_IS_MY_SECRET_KEY";
             try {
            // Create a secret key specification for HMAC-SHA256
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");

            // Get a Mac instance for HMAC-SHA256
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            // Compute the HMAC
            byte[] rawHmac = mac.doFinal(jsonData.getBytes("UTF-8"));

            // Encode the result to Base64
            signature = Base64.getEncoder().encodeToString(rawHmac);
            log.info("signature  {}",signature);

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC", e);
        }
        return signature;
    }
} 


//