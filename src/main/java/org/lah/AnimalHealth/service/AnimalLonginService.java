package org.lah.AnimalHealth.service;
import org.lah.AnimalHealth.domain.Animal;
public interface AnimalLonginService {
    void login(Animal animal);
    void update(String id,String health);
}
