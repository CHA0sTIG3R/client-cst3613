package edu.cuny.citytech.cst.retirement.dao;

import edu.cuny.citytech.cst.retirement.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClientDAO {

    List<Client> clientList = new ArrayList<>();
    public  ClientDAO(){
        clientList.add(new Client("s01",5088797.96f));
        clientList.add(new Client("s02",13064937.09f));
        clientList.add(new Client("s03",1040897.59f));
        clientList.add(new Client("s04",4033596.44f));
        clientList.add(new Client("s05",10079688.29f));
        clientList.add(new Client("s06",7028576.22f));
        clientList.add(new Client("s07",12058654.15f));
        clientList.add(new Client("s08",11059446.69f));
        clientList.add(new Client("s09",9007707.99f));
        clientList.add(new Client("s10",13030908.4f));
        clientList.add(new Client("s11",12089912.66f));
        clientList.add(new Client("s12",4003128.43f));
        clientList.add(new Client("s13",1089935.07f));
        clientList.add(new Client("s14",2034397.69f));
        clientList.add(new Client("s15",1090509.26f));
        clientList.add(new Client("s16",14024000.32f));
        clientList.add(new Client("s17",6085379.63f));
    }

    public List<Client> findAll(Predicate<Client> predicate){
        var list = clientList.stream().filter(predicate)
                .toList();
        return list;
    }

    public List<Client> findAll(){
        return clientList;
    }

    public static void main(String[] args) {
        Predicate<Client> predicate = (Client client) -> client.getAmount() > 5_000_000;
        var list =  new ClientDAO().findAll(predicate);
        list.forEach(System.out::println);
        System.out.println("Size: " + list.size());
    }

}
