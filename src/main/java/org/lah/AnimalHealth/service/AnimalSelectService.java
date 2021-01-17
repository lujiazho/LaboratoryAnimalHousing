package org.lah.AnimalHealth.service;
import org.lah.AnimalHealth.domain.Animal;

import java.util.List;

public interface AnimalSelectService {
    List<Animal> select();
    List<Animal> select2(String id);
    List<Animal> select3(String var);
}
