package gestionefile;
import java.io.*;
import java.util.Scanner;

public class usercsv {
    private String username;
    private String password;

    public usercsv(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void writeToCSV(String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Scrivi username e password nel formato CSV
            dos.writeUTF(username);
            dos.writeUTF(password);

            System.out.println("Dati dell'utente scritti su file CSV con successo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static usercsv readFromCSV(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            // Leggi username e password dal formato CSV
            String username = dis.readUTF();
            String password = dis.readUTF();

            return new usercsv(username, password);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}



