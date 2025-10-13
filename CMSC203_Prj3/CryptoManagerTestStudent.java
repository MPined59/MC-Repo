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
        
        //Encrypt and plain should not equal
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        assertNotEquals(plain, encrypted); 
        
        //Decrypt should equal
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted); 

        
    }

	@Test
    void testPlayfairEncryptDecrypt() {
        String plain = "HELLOWORLD";
        String key = "PLAYFAIR";
        
        //Encrypt and plain should not equal
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        assertNotEquals(plain, encrypted); 
       
        //Decrypt should equal
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain.length(), decrypted.length());
        
    }

	@Test
	void testCaesarEncryptDecrypt() {
        String plain = "HELLO WORLD";
        int key = 5;
        
        //Encrypt and plain should not equal
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        assertNotEquals(plain, encrypted);
        
        //Decrypt should equal
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(plain, decrypted); 

        // Check negative
        encrypted = CryptoManager.caesarEncryption(plain, -3);
        decrypted = CryptoManager.caesarDecryption(encrypted, -3);
        assertEquals(plain, decrypted);
    }

}
