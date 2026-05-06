package org.java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class ServerLogProcessor {

    public static void main(String[] args) {
        String fileName = "server_logs.txt"; // must be inside resources
        StringBuilder result = new StringBuilder();

        try (
                InputStream is = ServerLogProcessor.class
                        .getClassLoader()
                        .getResourceAsStream(fileName);

                BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ) {
            String line;

            while ((line = br.readLine()) != null) {

                // Ignore unwanted lines
                if (line.startsWith("SERVER") || line.startsWith("-")) {
                    continue;
                }

                // Include newline in hash
                String lineWithNewline = line + "\n";

                String md5Hash = getMD5(lineWithNewline);

                char lastChar = md5Hash.charAt(md5Hash.length() - 1);

                // Keep only if last char is digit
                if (Character.isDigit(lastChar)) {
                    if (line.length() >= 5) {
                        result.append(line.charAt(4));
                    }
                }
            }

            System.out.println("Hidden Message: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getMD5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(input.getBytes());

        StringBuilder hex = new StringBuilder();
        for (byte b : hashBytes) {
            String h = Integer.toHexString(0xff & b);
            if (h.length() == 1) hex.append('0');
            hex.append(h);
        }
        return hex.toString();
    }
}