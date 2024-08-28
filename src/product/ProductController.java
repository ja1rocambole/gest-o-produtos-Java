package product;

import java.util.ArrayList;

import exceptions.NegativePriceException;
import exceptions.NotFounException;

public class ProductController {
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    public String create(String name, Integer priceCents, Integer stock) {
        ProductModel newProduct = new ProductModel();

        newProduct.setBarCode(String.valueOf(products.size()));
        newProduct.setName(name);
        if (priceCents > 0) {
            newProduct.setPriceCents(priceCents);
        } else {
            throw new NegativePriceException();
        }
        newProduct.setStock(stock);

        this.products.add(newProduct);

        return "Produto " + newProduct.getName() + " adicionado.";
    }

    public String read() {
        StringBuilder sb = new StringBuilder();

        products.stream().forEach(product -> {
            sb.append("Nome: ").append(product.getName())
                    .append(", Código de Barras: ").append(product.getBarCode())
                    .append(", Preço: ").append(product.getPriceCents())
                    .append(", Estoque: ").append(product.getStock())
                    .append("\n");
        });

        return sb.toString();
    }

    public String read(String barcode) {
        for (ProductModel product : products) {
            if (product.getBarCode().equals(barcode)) {
                return "Nome: " + product.getName() +
                        ", Código de Barras: " + product.getBarCode() +
                        ", Preço: " + product.getPriceCents() +
                        ", Estoque: " + product.getStock();
            }
        }
        // Lançar exceção se o produto não for encontrado
        throw new NotFounException("Produto com código de barras " + barcode + " não encontrado.");
    }
}
