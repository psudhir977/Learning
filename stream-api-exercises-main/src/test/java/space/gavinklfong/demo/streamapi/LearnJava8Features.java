package space.gavinklfong.demo.streamapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
public class LearnJava8Features {

    @Autowired
    private  ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    // Obtain list of products belongs to category books with Price

    //filter
    public List<Product> calculateAverage(){
      return  productRepo.findAll().stream().filter(p -> p.getCategory().equals("Books"))
                .filter(p-> p.getPrice()>100).collect(Collectors.toList());
    }

    //Any match
    public List<Order> getOrdersWithSpecs(){
        return orderRepo.findAll().stream().filter(o-> o.getProducts().stream().anyMatch(p-> p.getCategory().equals("Baby"))).collect(Collectors.toList());
    }

    // Example of Map
    // Theory - In simple words, the map() is used to transform one object into other by applying a function
    public List<Product> getProductWithDiscount(){
     return   productRepo.findAll().stream().filter(p-> p.getCategory().equals("Toys")).map(p-> p.withPrice(p.getPrice()*0.9)).collect(Collectors.toList());
    }

    // returns a stream consisting of the results of
    // replacing each element of this stream with the concepts
    // of a mapped stream produced by applying
    // the provided mapping function to each element
     public List<Product> getProductListFilterByCustomerSpec(){
        return     orderRepo.findAll().stream().filter(o-> o.getCustomer().getTier()==2).
                filter(o-> o.getOrderDate() .compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(o-> o.getOrderDate() .compareTo(LocalDate.of(2021,4,1)) >= 0)
                .flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());
     }

     // get the cheapest products of books category
    public Optional<Product> getProductListAsPerCheapest(){
        Optional<Product> optionalProduct = productRepo.findAll().stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product :: getPrice)).findFirst();
       log.info(optionalProduct.get().toString());
       return  optionalProduct;
    }



    public static void main(String[] args) {
        LearnJava8Features learnJava8Features = new LearnJava8Features();
        learnJava8Features.calculateAverage().forEach(p-> log.info(p.getName()+p.getCategory()));
    }
}
