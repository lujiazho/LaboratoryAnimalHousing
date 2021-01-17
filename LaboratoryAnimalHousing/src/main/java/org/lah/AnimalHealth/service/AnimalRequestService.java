package org.lah.AnimalHealth.service;
import org.lah.AnimalHealth.domain.Request;

import java.util.List;

public interface AnimalRequestService {
    List<Request> select();
}
