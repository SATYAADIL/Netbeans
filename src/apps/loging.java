/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loging {

    static String folder = ".Loging";
    static String home = System.getProperty("user.home");
    static String pathFolder = home + File.separator + folder;

    static String logFile = "Log.txt";
    static String pathLog = pathFolder + File.separator + logFile;
    
    public static String getDateNow() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m:s z");
        return sdf.format(d);
    }

    public static void logActivity(String activity) {
        try {
            File f = new File(pathFolder);
            f.mkdir();  // Membuat folder "aktivitas" jika belum ada

            File log = new File(pathLog);
            log.createNewFile();  // Membuat file "log.txt" jika belum ada

            String logEntry = "\n[" + getDateNow() + "] " + activity;

            Files.write(
                Paths.get(pathLog),
                logEntry.getBytes(),
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error Code: 101 => " + e.getMessage());
        }
    }
}