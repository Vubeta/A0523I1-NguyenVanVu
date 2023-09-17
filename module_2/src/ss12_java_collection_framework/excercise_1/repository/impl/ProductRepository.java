package ss12_java_collection_framework.excercise_1.repository.impl;

import ss12_java_collection_framework.excercise_1.model.Product;
import ss12_java_collection_framework.excercise_1.repository.IProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductRepository implements IProductRepository {
    private static ArrayList<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "MacBook Air 2020", 18990000,
                "13.3 inch MGN63SA/A (M1/8GB/SSD256GB) (Xám)"));
        listProduct.add(new Product(2, "MacBook Pro 2022", 29290000,
                "13.3 inch MNEP3SA/A (M2/ 8GB/ SSD 256GB)"));
        listProduct.add(new Product(3, "MacBook Air 2023", 40890000,
                "Apple M2/RAM 8GB/512GB SSD/ macOS"));
        listProduct.add(new Product(4, "Bút Picasso 933 RG", 880000,
                "Bút ký màu vàng Tác Phẩm Huyền Bí"));
    }

    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Product currentProduct : listProduct) {
            if (currentProduct.getId() == product.getId()) {
                currentProduct.setName(product.getName());
                currentProduct.setPrice(product.getPrice());
                currentProduct.setDetailProduct(product.getDetailProduct());
            }
        }
    }

    @Override
    public void deleteProductById(int id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                listProduct.remove(product);
            }
        }
    }

    @Override
    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    @Override
    public void findProductByName(String nameProductUser) {
        double[] ratePercent = new double[listProduct.size()];
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i) != null) {
                String nameProduct = listProduct.get(i).getName();
                double rateNum = calLevDisRatio(nameProductUser.toLowerCase(), nameProduct.toLowerCase());
                ratePercent[i] = rateNum;
            }
        }

        //print result
        double maxRate = maxRatio(ratePercent);
        for (int i = 0; i < ratePercent.length; i++) {
            if (ratePercent[i] == maxRate && listProduct.get(i) != null) {
                System.out.println(listProduct.get(i));
            }
        }
    }

    @Override
    public void sortListProductByPrice(int choiceNum) {
        if(choiceNum==1) {
            Collections.sort(listProduct,new sortProductsByPrice());
        } else {
            Collections.sort(listProduct,Collections.reverseOrder(new sortProductsByPrice()));
        }

        for(Product product : listProduct) {
            System.out.println(product);
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

class sortProductsByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        double result = o1.getPrice() - o2.getPrice();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
