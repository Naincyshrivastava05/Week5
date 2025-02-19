package advanceproblems;

import com.ioprogramming.advanceprogramming.EncryptDecryptCSV;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptDecryptCSVTest {
    private static final String SECRET_KEY = "1234567890123456";

    @Test
    void testEncryptionAndDecryption() throws Exception {
        String originalData = "SensitiveData";
        String encryptedData = EncryptDecryptCSV.encrypt(originalData, SECRET_KEY);
        String decryptedData = EncryptDecryptCSV.decrypt(encryptedData, SECRET_KEY);

        assertNotEquals(originalData, encryptedData);
        assertEquals(originalData, decryptedData);
    }
}
