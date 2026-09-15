import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Generates the flat input files required by the project.
 */
public class GenerateInfoFiles {

    private static final String DATA_FOLDER = "data";
    private static final int SALESMAN_COUNT = 10;
    private static final int PRODUCT_COUNT = 20;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try {
            File folder = new File(DATA_FOLDER);
            if (!folder.exists() && !folder.mkdirs()) {
                throw new IOException("No fue posible crear la carpeta data.");
            }

            createProductsFile(PRODUCT_COUNT);
            createSalesManInfoFile(SALESMAN_COUNT);

            for (int i = 1; i <= SALESMAN_COUNT; i++) {
                long id = 10000000L + i;
                int randomSalesCount = 5 + RANDOM.nextInt(11);
                createSalesMenFile(randomSalesCount, "Vendedor" + i, id);
            }

            System.out.println("Archivos de entrada generados exitosamente");
        } catch (IOException e) {
            System.out.println("Error al generar los archivos de entrada: " + e.getMessage());
        }
    }

    /**
     * Creates the sales file for one salesman.
     *
     * @param randomSalesCount number of sales lines to generate
     * @param name salesman name
     * @param id salesman identification number
     * @throws IOException if the file cannot be created
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id)
            throws IOException {
        File file = new File(DATA_FOLDER, "sales_" + id + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("CC;" + id);
            writer.newLine();

            for (int i = 0; i < randomSalesCount; i++) {
                int productId = 1 + RANDOM.nextInt(PRODUCT_COUNT);
                int quantity = 1 + RANDOM.nextInt(10);
                writer.write(productId + ";" + quantity + ";");
                writer.newLine();
            }
        }
    }

    /**
     * Creates the file containing all available products.
     *
     * @param productsCount number of products to generate
     * @throws IOException if the file cannot be created
     */
    public static void createProductsFile(int productsCount) throws IOException {
        File file = new File(DATA_FOLDER, "products.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 1; i <= productsCount; i++) {
                int price = 10000 + RANDOM.nextInt(90001);
                writer.write(i + ";Producto" + i + ";" + price);
                writer.newLine();
            }
        }
    }

    /**
     * Creates the file containing the information of all salesmen.
     *
     * @param salesmanCount number of salesmen to generate
     * @throws IOException if the file cannot be created
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        String[] names = {"Daniel", "Juan", "Pedro", "Miguel", "Carlos",
                "Luis", "Andres", "Daniel", "Juan", "Sebastian"};
        String[] lastNames = {"Martinez", "Martinez", "Perez", "Lopez", "Perez",
                "Lopez", "Martinez", "Martinez", "Perez", "Torres"};

        File file = new File(DATA_FOLDER, "salesmen.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 1; i <= salesmanCount; i++) {
                long id = 10000000L + i;
                writer.write("CC;" + id + ";" + names[i - 1] + ";" + lastNames[i - 1]);
                writer.newLine();
            }
        }
    }
}
