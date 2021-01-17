package org.lah.AnimalHealth.service;

import org.lah.AnimalHealth.domain.Animal;
import org.lah.AnimalHealth.domain.Qua;

import java.util.List;

public interface QuaService {

    void login(Qua qua);
    List<Qua> select();
    List<Qua> select2(String id);
    List<Qua> select3(String var);
}
