
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CardRecognizer {

  private static final Scanner scanner = new Scanner(System.in);

  public void startProgram() throws IOException {
    System.out.println("Введите путь к папке:");
    String imagesPath = scanner.nextLine();
    int count = analyzeFilesInFolder(imagesPath);

    if (count == -1) {
      System.out.println("Путь неверный " + imagesPath);
    } else {
      System.out.println("\nПроверено: " + count);
    }
    scanner.nextLine();
  }

  // Функция для анализа файлов в папке
  private static int analyzeFilesInFolder(String folderPath) throws IOException {
    if (!Files.isDirectory(Paths.get(folderPath))) {
      return -1; // Возвращаем -1 в случае некорректного пути
    }

    File dir = new File(folderPath);
    File[] files = dir.listFiles();

    if (files != null) {
      Arrays.sort(files, Comparator.comparing(File::getName));
      int count = 0;

      for (File file : files) {
        if (file.getName().split("\\.").length < 3) {
          AnalyzeCard analyzer = new AnalyzeCard(file);
          analyzer.start();
          count++;
        }
      }
      return count;
    }
    return 0; // Возвращаем 0, если папка пуста
  }
}