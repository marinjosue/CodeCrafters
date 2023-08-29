package ec.edu.espe.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class AESCipher {

    private static final String KEY_FRASE = "4";

    public String encrypted(String cracked) throws Exception {
        final byte[] bytes = cracked.getBytes(StandardCharsets.UTF_8);
        final Cipher aes = getsCipher(true);
        final byte[] encryption = aes.doFinal(bytes);
        return Base64.getEncoder().encodeToString(encryption);
    }

    public String decrypt(String encryption) throws Exception {
        final Cipher aes = getsCipher(false);
        final byte[] bytes = Base64.getDecoder().decode(encryption);
        final byte[] decoded = aes.doFinal(bytes);
        return new String(decoded, StandardCharsets.UTF_8);
    }

    private Cipher getsCipher(boolean toEncrypt) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(KEY_FRASE.getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (toEncrypt) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }

}
