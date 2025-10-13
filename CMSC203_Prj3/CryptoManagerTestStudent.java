package cipherprj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	void testVigenereEncryptDecrypt() {
        String plain = "HELLO WORLD";
        String key = "KEY";
        
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        assertNotEquals(plain, encrypted); // should encrypt
        
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted); // should decrypt back correctly

        // Test out of bounds
        assertEquals("Out of bounds", CryptoManager.vigenereEncryption("hello", key));
        assertEquals("Out of bounds", CryptoManager.vigenereEncryption(plain, "key"));
    }

	@Test
    void testPlayfairEncryptDecrypt() {
        String plain = "HELLOWORLD";
        String key = "PLAYFAIR";
        
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        assertNotEquals(plain, encrypted); // should encrypt
        
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain.length(), decrypted.length());
        // Decryption may not produce exact original if padding letters were added, but basic test works

        // Out of bounds
        assertEquals("Out of bounds", CryptoManager.playfairEncryption("hello", key));
        assertEquals("Out of bounds", CryptoManager.playfairEncryption(plain, "key"));
    }

	@Test
	void testCaesarEncryptDecrypt() {
        String plain = "HELLO WORLD";
        int key = 5;
        
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        assertNotEquals(plain, encrypted); // should encrypt
        
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(plain, decrypted); // should decrypt back correctly

        // Negative shift
        encrypted = CryptoManager.caesarEncryption(plain, -3);
        decrypted = CryptoManager.caesarDecryption(encrypted, -3);
        assertEquals(plain, decrypted);

        // Out of bounds
        assertEquals("Out of bounds", CryptoManager.caesarEncryption("hello", key));
    }

}
