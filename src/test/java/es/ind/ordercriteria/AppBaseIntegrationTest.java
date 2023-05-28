package es.ind.ordercriteria;

import es.ind.ordercriteria.config.PersistenceConfig;
import es.ind.ordercriteria.config.common.CommonConfig;
import es.ind.ordercriteria.domain.products.ProductCriteriaRepository;
import es.ind.ordercriteria.domain.products.ProductRepository;
import jakarta.annotation.Resource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.JsonNode;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@ActiveProfiles("test")
@ContextConfiguration(classes = AppBaseIntegrationTest.TestConfig.class)
@SpringBootTest(classes = {CommonConfig.class, PersistenceConfig.class})
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class AppBaseIntegrationTest {

    @Resource
    protected MockMvc mockMvc;

    @Resource
    protected ProductCriteriaRepository productCriteriaRepository;

    @Resource
    protected ProductRepository productRepository;

    @Resource
    protected ObjectMapper objectMapper;


    @AfterEach
    protected void tearDown(){
        productCriteriaRepository.deleteAll();
        productRepository.deleteAll();

    }




    protected  <T> T mapFromJSON(String json, Class<T> destinationType)throws Exception{
        return objectMapper.readValue(json,destinationType);
    }

    protected String getFromFileJson(String fileName)throws Exception{
        File classPathFile = new ClassPathResource("json/"+fileName+".json").getFile();
        return Files.readString(classPathFile.toPath());
    }

    protected void assertJsons(String expectedJson,String json, String... ignoreFields)throws Exception{
        JSONAssert.assertEquals(expectedJson,json,false);
    }
    protected  <T> T mapDataFromJson(String fileName, Class<T> destinationType)throws Exception{
        File classPathFile = new ClassPathResource("json/"+fileName+".json").getFile();
        String str= Files.readString(classPathFile.toPath());

       return objectMapper.readValue(str,destinationType);
    }



    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class TestConfig{

        @Bean
        public ObjectMapper objectMapper(){
            return new ObjectMapper();
        }

    }
}


