import product.ProductController;

public class Main {
    public static void main(String[] args) {

        ProductController productApi = new ProductController();

        System.out.println("\n AQUI É O CREATE");

        try {
            System.out.println(productApi.create("teste", 1200, 10));
            System.out.println(productApi.create("teste2", 1300, 10));
            System.out.println(productApi.create("teste3", 1400, 10));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n AQUI É O READ ");
        
        System.out.println(productApi.read());

        System.out.println("\n AQUI É O READ PELO CÓDIGO");

        try {
            System.out.println(productApi.read("7"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}