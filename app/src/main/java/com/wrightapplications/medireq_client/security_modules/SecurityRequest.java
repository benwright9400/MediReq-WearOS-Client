package com.wrightapplications.medireq_client.security_modules;



public class SecurityRequest {
    private String passphraseKey;

    public SecurityRequest() {
        //get passphrasekey from the database
    }

    private void addHash(String message) {
        String hash = BCrypt.hashpw(message, BCrypt.gensalt());
    }

    private void encrypt(String message) {
        try {
            String encryptedMessage = AES256.encrypt(message, passphraseKey);

            //move to data layer
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void decrypt(String cipherText) {
        try {
            String encryptedMessage = AES256.decrypt(cipherText, passphraseKey);

            //move to data layer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
