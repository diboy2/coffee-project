package com.ingredient;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ingredient.Ingredient;
import com.ingredient.IngredientRepository;
import com.ratinggroup.RatingGroup;
import com.blend.Blend;
import com.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class IngredientServiceTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private Blend blend;
    
    private Set<Ingredient> ingredientSet = new HashSet<Ingredient>();
    private Set<RatingGroup> ratingGroupSet = new HashSet<RatingGroup>();
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();    

        this.ingredientRepository.deleteAllInBatch();
        this.blend = new Blend(this.ingredientSet, this.ratingGroupSet);

        this.ingredientSet.add(this.ingredientRepository.save(new Ingredient("cherry", "image.com/1", this.blend)));
        this.ingredientSet.add(this.ingredientRepository.save(new Ingredient("coconut", "image.com/2", this.blend)));
    }

    @Test
    public void readSingleIngredient() throws Exception {
        Ingredient firstIngredient = this.ingredientSet.iterator().next();
        this.mockMvc.perform(get("/ingredients/" + firstIngredient.getIngredientId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(this.contentType))
                .andExpect(jsonPath("$.imageURL", is(firstIngredient.getImageURL())))
                .andExpect(jsonPath("$.name", is(firstIngredient.getName())));
             
    }


}