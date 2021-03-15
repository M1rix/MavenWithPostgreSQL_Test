package service;

import entity.Data;
import entity.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

public interface DataService {
    public boolean persist(String problem);

    public Set<String> getRandomData();

}

