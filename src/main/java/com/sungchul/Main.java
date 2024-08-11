package com.sungchul;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {

    static PooledPBEStringEncryptor encryptor;
    static SimpleStringPBEConfig config;

    public static void main(String[] args) {
        initConfig();
//        String databaseIP = "192.168.0.22";
//        String encryptData =  encrypt("databaseIP",databaseIP);
//        String decryptData = decrypt("databaseIP",encryptData);
        String filePath = "dev.yaml";
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        System.out.println("file path : " + filePath);
        try{
            Map<String,Object> map = objectMapper.readValue(file, Map.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String decryptData = encrypt(entry.getKey() , entry.getValue().toString());
                //decrypt(entry.getKey() , decryptData);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void initConfig(){
        String key = "kim-sung-chul-project-properties-encrypt";
        encryptor = new PooledPBEStringEncryptor();
        config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
    }

    public static String encrypt(String field,String plainText){
        String encrypted = encryptor.encrypt(plainText);
        System.out.println(field + " : ENC(" + encrypted+")");
        return encrypted;
    }
    public static String decrypt(String field, String encryptedText){
        String decrypted = encryptor.decrypt(encryptedText);
        System.out.println(field + " : " + decrypted);
        return decrypted;
    }
}