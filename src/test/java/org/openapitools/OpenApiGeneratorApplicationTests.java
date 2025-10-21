// package org.openapitools;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class OpenApiGeneratorApplicationTests {

//     @Test
//     void contextLoads() {
//     }

// }

package org.openapitools;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OpenApiGeneratorApplication.class)
@ActiveProfiles("h2")
class OpenApiGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }
}
