package bbddmysql.springboot.infrastructure.servicios;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class AESCipherService {

    private final SecretKeySpec secretKey;

    public AESCipherService() {
        try {
            File file = new ClassPathResource("templates/assets/passwordEncoder.txt").getFile();
            byte[] key = Files.readAllBytes(file.toPath());
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            throw new RuntimeException("Error reading secret key", e);
        }
    }

    public String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting", e);
        }
    }

    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting", e);
        }
    }
}
