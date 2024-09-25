package com.example.skillwill15.Controllers;

import com.example.skillwill15.Models.Product;
import com.example.skillwill15.Services.TableService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;
    private final Product table;

    public TableController(TableService tableService, @Qualifier("household-items") Product table) {
        this.tableService = tableService;
        this.table = table;
    }

    @PostMapping("/add")
    public String addTable(@RequestParam String productType, @RequestParam String price, @RequestParam String quantity) {
        return tableService.addTable(table, productType, price, quantity);
    }

    @GetMapping("/{productType}")
    public Product getTable(@PathVariable String productType) {
        return tableService.getTableByType(productType);
    }

    @GetMapping("/all")
    public List<Product> getAllTables() {
        return tableService.getAllTables();
    }

    @DeleteMapping("/remove/{productType}")
    public String removeTable(@PathVariable String productType) {
        return tableService.removeTable(productType);
    }
}
