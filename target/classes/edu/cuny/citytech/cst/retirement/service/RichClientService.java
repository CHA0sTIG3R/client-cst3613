package edu.cuny.citytech.cst.retirement.service;

import edu.cuny.citytech.cst.retirement.model.Client;
import edu.cuny.citytech.cst.retirement.model.RichClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.jbbwebsolutions.http.utility.JSONGet.submitGet;

public class RichClientService {

    private List<Client> clientList = new ArrayList<>();
    private float average;

    public List<Client> findAll() {
        var url = "http://127.0.0.1:9416/clients";
        var results = submitGet( url, RichClient.class);
        clientList = results.getResults();
        average = results.getTotal() / results.getTotalCount();
        return results.getResults();
    }

    public Client max(){
        if (clientList.size() == 0) findAll();
        return Collections.max(clientList);
    }

    public Client min(){
        if (clientList.size() == 0) findAll();
        return Collections.min(clientList);
    }

    public float getAverage(){
        if (this.average == 0) findAll();
        return this.average;
    }

}
