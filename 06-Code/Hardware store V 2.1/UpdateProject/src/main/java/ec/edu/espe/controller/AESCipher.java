

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

    public String cifra(String sinCifrar) throws Exception {
        final byte[] bytes = sinCifrar.getBytes(StandardCharsets.UTF_8);
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return Base64.getEncoder().encodeToString(cifrado);
    }

    public String descifra(String cifrado) throws Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = Base64.getDecoder().decode(cifrado);
        final byte[] descifrado = aes.doFinal(bytes);
        return new String(descifrado, StandardCharsets.UTF_8);
    }

    private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(KEY_FRASE.getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }

}
