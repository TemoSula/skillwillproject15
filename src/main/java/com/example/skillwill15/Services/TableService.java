package com.example.skillwill15.Services;

import com.example.skillwill15.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TableService {

        private final List<Product> tableList = new ArrayList<>();

        public String addTable(Product table, String productType, String price, String quantity) {
            table.setProductType(productType);
            table.setPrice(price);
            table.setQuantity(quantity);
            tableList.add(table);
            return "Table Added Successfully";
        }

        public Product getTableByType(String productType) {
            return tableList.stream()
                    .filter(table -> table.getProductType().equalsIgnoreCase(productType))
                    .findFirst()
                    .orElse(null);
        }

        public List<Product> getAllTables() {
            return tableList;
        }

        public String removeTable(String productType) {
            Product tableToRemove = getTableByType(productType);
            if (tableToRemove != null) {
                tableList.remove(tableToRemove);
                return "Table Removed Successfully";
            }
            return "Table Not Found";
        }
}
