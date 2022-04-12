package edu.cuny.citytech.cst.retirement.service;

import edu.cuny.citytech.cst.retirement.dao.ClientDAO;
import edu.cuny.citytech.cst.retirement.model.Client;

import java.util.List;
import java.util.function.Predicate;

public class ClientService {

    private ClientDAO dao = new ClientDAO();

    public List<Client> getPercentage(Predicate<Client> predicate){
        var list = dao.findAll(predicate);
        var total = 0f;

        for (var client: list) {
            total += client.getAmount();
        }

        for (var client: list) {
            var percentage = client.getAmount() / total;
            client.setPercentage(percentage);
        }


        return list;
    }

    public static void main(String[] args) {
        var data = new ClientService().getPercentage(e -> true);
        data.forEach(System.out::println);
    }
}
