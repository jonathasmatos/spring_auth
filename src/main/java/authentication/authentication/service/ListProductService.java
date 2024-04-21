package authentication.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import authentication.authentication.model.Product;
import authentication.authentication.repository.ProductRepository;

@Service
public class ListProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> listAll() {
    return productRepository.findAll();
  }
}
