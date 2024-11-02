package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderPGN {

    private File file;
    private List<String> pureMoves = new ArrayList<>();
    private Map<String, String> metadatos = new HashMap<>();
    private Pattern patron = Pattern.compile("\\[(\\w+)\\s+\"(.*)\"\\]");

    public ReaderPGN(File file){
        this.file = file;
    }


    public void Lecture() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                // Lee la línea una vez
                String linea = scanner.nextLine();

                Matcher matcher = patron.matcher(linea);
                if (matcher.find()) {
                    // Si es un metadato, guárdalo en el mapa
                    metadatos.put(matcher.group(1), matcher.group(2));
                } else {
                    // Si no es un metadato, trata la línea como movimientos
                    String[] partes = linea.split("\\s+");
                    for (String parte : partes) {
                        if (!parte.matches("\\d+\\.")) {  // Ignora números de movimiento (1., 2., etc.)
                            pureMoves.add(parte);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
    }

    public List<String> getMovements() {
        return pureMoves;
    }

    public String getMovement(int count){
        if (count >= 0 && count < pureMoves.size()) {
            return pureMoves.get(count);
        } else {
            System.out.println("Índice fuera de rango");
            return null;
        }
    }

    public void imprimirMetadatos(){
        for (Map.Entry<String, String> entrada : metadatos.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

    public void imprimirMovimientos(){
        for (String movimiento : pureMoves) {
            System.out.print(movimiento + " ");
        }
    }
}
