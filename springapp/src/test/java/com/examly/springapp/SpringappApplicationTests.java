package com.examly.springapp;

import org.springframework.http.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;




@Test 
    public void testcontrollerfolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    


    @Test 
    public void testcontrollerfile() { 
        String filePath = "src/main/java/com/examly/springapp/controller/BlogController.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testModelFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testModelFile() { 
        String filePath = "src/main/java/com/examly/springapp/model/BlogPost.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testrepositoryfolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/repository"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testrepositoryFile() { 
        String filePath = "src/main/java/com/examly/springapp/repository/BlogPostRepository.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testServiceFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testServieFile() { 
        String filePath = "src/main/java/com/examly/springapp/service/BlogService.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

  


    @Test
    public void testBlogModelHasIdField() {
        checkFieldExists("com.examly.springapp.model.BlogPost", "postId");
    }

    @Test
    public void testBlogModelHasTitleNameField() {
        checkFieldExists("com.examly.springapp.model.BlogPost", "title");
    }

    @Test
    public void testBlogModelHascontentField() {
        checkFieldExists("com.examly.springapp.model.BlogPost", "content");
    }

     @Test
    public void testBlogModelHasauthorField() {
        checkFieldExists("com.examly.springapp.model.BlogPost", "author");
    }

    @Test
    public void testBlogModelHastimeStampField() {
        checkFieldExists("com.examly.springapp.model.BlogPost", "timestamp");
    }

 @Test
public void testControllerHasRestControllerAnnotation() {
    checkAnnotationExists("com.examly.springapp.controller.BlogController", "org.springframework.web.bind.annotation.RestController");
}


 @Test
    public void testBlogPostRepoHasRepositoryAnnotation() {
        checkAnnotationExists("com.examly.springapp.repository.BlogPostRepository", "org.springframework.stereotype.Repository");
    }

@Test
    public void testBlogPostRepoExtendsJpaRepository() {
        checkClassImplementsInterface("com.examly.springapp.repository.BlogPostRepository", "org.springframework.data.jpa.repository.JpaRepository");
    }

   

    @Test
    public void testBlogPostServiceAnnotation() {
        checkAnnotationExists("com.examly.springapp.service.BlogService", "org.springframework.stereotype.Service");
    }


   




    private void checkFieldExists(String className, String fieldName) {
        try {
            Class<?> clazz = Class.forName(className);
            clazz.getDeclaredField(fieldName);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            fail("Field " + fieldName + " in class " + className + " does not exist.");
        }
    }

    private void checkClassImplementsInterface(String className, String interfaceName) {
        try {
            Class<?> clazz = Class.forName(className);
            Class<?> interfaceClazz = Class.forName(interfaceName);
            assertTrue(interfaceClazz.isAssignableFrom(clazz));
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " or interface " + interfaceName + " does not exist.");
        }
    }
	private void checkAnnotationExists(String className, String annotationName) {
		try {
			Class<?> clazz = Class.forName(className);
			ClassLoader classLoader = clazz.getClassLoader();
			Class<?> annotationClass = Class.forName(annotationName, false, classLoader);
			assertNotNull(clazz.getAnnotation((Class) annotationClass)); // Use raw type
		} catch (ClassNotFoundException | NullPointerException e) {
			fail("Class " + className + " or annotation " + annotationName + " does not exist.");
		}
	}


@Test
	public void addPost() throws Exception {
		String st = "{\"postId\":5001,\"title\": \"Cricket\",\"content\": \"true\",\"author\": \"demo1\",\"date\": \"2023-09-12\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(st)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}
	

    @Test
    public void GetPostByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/5001")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Cricket"))
                .andReturn();
    }

    @Test
    public void getAllPosts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/getall")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$").isArray())
                .andReturn();
    }



}
