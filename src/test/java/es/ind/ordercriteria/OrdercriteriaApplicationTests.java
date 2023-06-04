package es.ind.ordercriteria;

import es.ind.ordercriteria.domain.products.entity.Product;
import es.ind.ordercriteria.port.adapter.products.ProductsByCriteriaRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;


class OrdercriteriaApplicationTests extends AppBaseIntegrationTest{

	private static final String URL="/api/products/criteria/";

	@BeforeEach
	public void Setup()throws Exception{


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
	void testGetCriteriaTotalStock()throws Exception{
		String criterias = getFromFileJson("ProductByCriteriaRequestModel");

		String response= mockMvc.perform(MockMvcRequestBuilders.post(URL,"stocks")
				.contentType(MediaType.APPLICATION_JSON)
				.content(criterias))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println(response);
		assertJsons(getFromFileJson("GetStockProductList"),response);
	}

}
