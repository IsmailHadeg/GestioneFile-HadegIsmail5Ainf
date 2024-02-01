package gestionefile;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestioneFile {

    public static void main(String[] args) throws IOException {


        Lettore lettore = new Lettore("user.json");
        lettore.start();
        Scanner scanner = new Scanner(System.in);
        System.out.print("inserisci Username");
        String Username = scanner.nextLine();
        System.out.print("inserisci Password");
        String Password = scanner.nextLine();


        Scrittore scrittore = new Scrittore("output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        String outputPath = "output.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Scrivi l'intestazione
            writer.write("Username,Password");
            writer.newLine();

            // Scrivi i dati dell'utente
            writer.write(Username + "," + Password);
            writer.newLine();

            System.out.println("Dati scritti nel file CSV con successo!");

            Path sourcePath = Paths.get("output.csv");
            Path destinationPath = Paths.get("copia.csv");


            System.out.println("File copiato con successo!");


        } catch (IOException e) {
            e.printStackTrace();

            Path sourcePath = Paths.get("output.csv");
            Path destinationPath = Paths.get("copia.csv");



            System.out.println("Contenuto copiato da output.csv a copia.csv con successo!");

        }
        usercsv usercsv = new usercsv(Username, Password);


        String csvFilePath = "user.csv";


        usercsv.writeToCSV(csvFilePath);
        System.out.println();


        usercsv readUserCSV = usercsv.readFromCSV(csvFilePath);

      
        if (readUserCSV != null) {
            System.out.println("Dati dell'utente letto da file CSV:");
            System.out.println("Username: " + readUserCSV.getUsername());
            System.out.println("Password: " + readUserCSV.getPassword());
        }
      }
    }


    

