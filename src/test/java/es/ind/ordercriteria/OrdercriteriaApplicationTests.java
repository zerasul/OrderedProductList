package es.ind.ordercriteria;

import es.ind.ordercriteria.domain.products.entity.Product;
import es.ind.ordercriteria.domain.products.entity.ProductCriteria;
import es.ind.ordercriteria.port.adapter.products.ProductsViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;


class OrdercriteriaApplicationTests extends AppBaseIntegrationTest{

	private static final String URL="/api/products/criteria/{criteria}";

	@BeforeEach
	public void Setup()throws Exception{
		ProductCriteria[] criterias = mapDataFromJson("criterias", ProductCriteria[].class);
		productCriteriaRepository.saveAll(Arrays.stream(criterias).toList());
		Product[] products = mapDataFromJson("products",Product[].class);
		Arrays.stream(products).forEach(product -> {
			product.getStock().forEach(stock -> stock.setProduct(product));
		});
		productRepository.saveAll(Arrays.stream(products).toList());
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testGetCriteriaSales()throws Exception{

		String response= mockMvc.perform(MockMvcRequestBuilders.get(URL,"sales")
		.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();

		assertJsons(getFromFileJson("GetSalesUnitProductList"),response);
	}

	@Test
	void testGetCriteriaTotalStock()throws Exception{
		String response= mockMvc.perform(MockMvcRequestBuilders.get(URL,"stocks")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertJsons(getFromFileJson("GetStockProductList"),response);
	}

}
