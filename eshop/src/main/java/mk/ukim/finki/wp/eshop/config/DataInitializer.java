package mk.ukim.finki.wp.eshop.config;

import mk.ukim.finki.wp.eshop.service.CategoryService;
import mk.ukim.finki.wp.eshop.service.ManufacturerService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CategoryService categoryService;

    private final ManufacturerService manufacturerService;

    public DataInitializer(CategoryService categoryService, ManufacturerService manufacturerService) {
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }


    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.categoryService.create("Category" + i,"Description" + i);
        }

        for (int i = 1; i < 6; i++) {
            this.manufacturerService.save("Manufacturer" + i, "Address" + i);
        }

    }
}