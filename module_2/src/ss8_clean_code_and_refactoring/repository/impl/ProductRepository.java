package ss8_clean_code_and_refactoring.repository.impl;

import ss8_clean_code_and_refactoring.repository.IProductRepository;
import ss8_clean_code_and_refactoring.model.Product;

import java.util.Arrays;

public class ProductRepository implements IProductRepository {
    private static Product[] products = new Product[20];

    static {
        products[0] = new Product(1, "MacBook Air 2020", 18990000,
                "13.3 inch MGN63SA/A (M1/8GB/SSD256GB) (Xám)");
        products[1] = new Product(2, "MacBook Pro 2022", 29290000,
                "13.3 inch MNEP3SA/A (M2/ 8GB/ SSD 256GB)");
        products[2] = new Product(3, "MacBook Air 2023", 40890000,
                "Apple M2/RAM 8GB/512GB SSD/ macOS");
        products[3] = new Product(4, "Bút Picasso 933 RG", 880000,
                "Bút ký màu vàng Tác Phẩm Huyền Bí");
    }

    @Override
    public Product[] getListProduct() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = product;
                break;
            }
        }
    }

    @Override
    public void deleteProductById(int idProduct) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == idProduct) {
                products[i] = null;
            }
            break;
        }
    }

    @Override
    public void findProductByName(String nameProductUser) {
        double[] ratePercent = new double[getListProduct().length];
        for (int i = 0; i < getListProduct().length; i++) {
            if (getListProduct()[i] != null) {
                String nameProduct = getListProduct()[i].getName();
                double rateNum = calLevDisRatio(nameProductUser.toLowerCase(), nameProduct.toLowerCase());
                ratePercent[i] = rateNum;
            }
        }

        //print result
        double maxRate = maxRatio(ratePercent);
        for (int i = 0; i < ratePercent.length; i++) {
            if (ratePercent[i] == maxRate && products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }

    //calculate Levenshtein Distance Ratio
    public double calLevDisRatio(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        int[][] arrLevDis = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    arrLevDis[i][j] = j;
                } else if (j == 0) {
                    arrLevDis[i][j] = i;
                } else {
                    int cost = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1;
                    arrLevDis[i][j] = Math.min(Math.min(arrLevDis[i - 1][j] + 1, arrLevDis[i][j - 1] + 1), arrLevDis[i - 1][j - 1] + cost);
                }
            }
        }
        return 1 - (double) arrLevDis[len1][len2] / Math.max(len1, len2);
    }

    public double maxRatio(double[] arr) {
        double maxRate = 0.0f;
        for (double rate : arr) {
            if (rate > maxRate) {
                maxRate = rate;
            }
        }
        return maxRate;
    }
}