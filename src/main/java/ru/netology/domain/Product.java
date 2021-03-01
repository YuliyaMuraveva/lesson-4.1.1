package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String name;

    public boolean matches(String search) {
        if (this.getName().equalsIgnoreCase(search)) {
            return true;
            }
            return false;
        }
}
