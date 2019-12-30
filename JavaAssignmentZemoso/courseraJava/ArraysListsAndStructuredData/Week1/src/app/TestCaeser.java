package app;

import app.CaesarCipher;

public class TestCaeser
{
    public static void main(String[] args)
    {
        CaesarCipher cipher = new CaesarCipher();
        testEncrypt(cipher, "FIRST LEGION ATTACK EAST flank!", 23);
        testEncryptTwoKeys(cipher, "First Legion", 23, 17);
    }

    public static void testEncrypt(CaesarCipher cipher, String str, int key)
    {
        System.out.println(cipher.encrypt(str, key));
    }

    public static void testEncryptTwoKeys(CaesarCipher cipher, String str, int key1, int key2)
    {
        System.out.println(cipher.encryptTwoKeys(str, key1,key2));
    }

}