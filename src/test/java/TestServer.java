import edu.cuny.citytech.cst.retirement.service.RichClientService;

public class TestServer {

    public static void main(String[] args) {
        var rc = new RichClientService();
        var results = rc.findAll();
        var max = rc.max();
        var min = rc.min();
        results.forEach(System.out::println);

        System.out.println("max = "+max);
        System.out.println("min = "+min);

    }

}
