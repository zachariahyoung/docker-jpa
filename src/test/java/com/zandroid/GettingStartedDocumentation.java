package com.zandroid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GettingStartedDocumentation {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private ObjectMapper objectMapper;

    private RequestSpecification documentationSpec;

    @Before
    public void setUp() {

        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation))
                .addFilter(document("{method-name}/{step}"))
                .build();
    }

    @Test
    public void index() throws Exception {
//        this.mockMvc.perform(get("/").accept(MediaTypes.HAL_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("_links.products", is(notNullValue())))
//                .andExpect(jsonPath("_links.appointments", is(notNullValue())));

        given(this.documentationSpec)
                .accept(JSON)
        .when()
                .get("/")
        .then()
                .assertThat().statusCode(is(200));


    }


    @Test
    public void creatingAAppointment() throws Exception {
//        String noteLocation = createAppointment();
//        MvcResult note = getNote(noteLocation);
//
//        String tagLocation = createTag();
//        getTag(tagLocation);
//
//        String taggedNoteLocation = createTaggedNote(tagLocation);
//        MvcResult taggedNote = getNote(taggedNoteLocation);
//        getTags(getLink(taggedNote, "tags"));
//
//        tagExistingNote(noteLocation, tagLocation);
//        getTags(getLink(note, "tags"));
    }

    String createAppointment() throws Exception {
        Map<String, String> note = new HashMap<>();
        note.put("trackNumber", "XYZ123");

//        String noteLocation = this.mockMvc
//                .perform(
//                        post("/appointments").contentType(MediaTypes.HAL_JSON).content(
//                                objectMapper.writeValueAsString(note)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("Location", notNullValue()))
//                .andReturn().getResponse().getHeader("Location");
//        return noteLocation;

        given(this.documentationSpec)
                .accept(JSON)
          .when()
                .post("/appointments")
          .then()
                .statusCode(is(200));

        return null;
    }
//
//    MvcResult getNote(String noteLocation) throws Exception {
//        return this.mockMvc.perform(get(noteLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("title", is(notNullValue())))
//                .andExpect(jsonPath("body", is(notNullValue())))
//                .andExpect(jsonPath("_links.tags", is(notNullValue())))
//                .andReturn();
//    }
//
//    String createTag() throws Exception, JsonProcessingException {
//        Map<String, String> tag = new HashMap<String, String>();
//        tag.put("name", "getting-started");
//
//        String tagLocation = this.mockMvc
//                .perform(
//                        post("/tags").contentType(MediaTypes.HAL_JSON).content(
//                                objectMapper.writeValueAsString(tag)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("Location", notNullValue()))
//                .andReturn().getResponse().getHeader("Location");
//        return tagLocation;
//    }
//
//    void getTag(String tagLocation) throws Exception {
//        this.mockMvc.perform(get(tagLocation)).andExpect(status().isOk())
//                .andExpect(jsonPath("name", is(notNullValue())))
//                .andExpect(jsonPath("_links.notes", is(notNullValue())));
//    }
//
//    String createTaggedNote(String tag) throws Exception {
//        Map<String, Object> note = new HashMap<String, Object>();
//        note.put("title", "Tagged note creation with cURL");
//        note.put("body", "An example of how to create a tagged note using cURL");
//        note.put("tags", Arrays.asList(tag));
//
//        String noteLocation = this.mockMvc
//                .perform(
//                        post("/notes").contentType(MediaTypes.HAL_JSON).content(
//                                objectMapper.writeValueAsString(note)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("Location", notNullValue()))
//                .andReturn().getResponse().getHeader("Location");
//        return noteLocation;
//    }
//
//    void getTags(String noteTagsLocation) throws Exception {
//        this.mockMvc.perform(get(noteTagsLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("_embedded.tags", hasSize(1)));
//    }
//
//    void tagExistingNote(String noteLocation, String tagLocation) throws Exception {
//        Map<String, Object> update = new HashMap<String, Object>();
//        update.put("tags", Arrays.asList(tagLocation));
//
//        this.mockMvc.perform(
//                patch(noteLocation).contentType(MediaTypes.HAL_JSON).content(
//                        objectMapper.writeValueAsString(update)))
//                .andExpect(status().isNoContent());
//    }
//
//    MvcResult getTaggedExistingNote(String noteLocation) throws Exception {
//        return this.mockMvc.perform(get(noteLocation))
//                .andExpect(status().isOk())
//                .andReturn();
//    }
//
//    void getTagsForExistingNote(String noteTagsLocation) throws Exception {
//        this.mockMvc.perform(get(noteTagsLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("_embedded.tags", hasSize(1)));
//    }
//
//    private String getLink(MvcResult result, String rel)
//            throws UnsupportedEncodingException {
//        return JsonPath.parse(result.getResponse().getContentAsString()).read(
//                "_links." + rel + ".href");
//    }
}