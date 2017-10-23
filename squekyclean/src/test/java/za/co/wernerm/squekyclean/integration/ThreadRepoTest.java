package za.co.wernerm.squekyclean.integration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import za.co.wernerm.squekyclean.util.DebugProperties;
import za.co.wernerm.squekyclean.util.IntegrationTestCategory;


@Category(IntegrationTestCategory.class)
public class ThreadRepoTest {

    @BeforeClass
    public static void setUp(){
        DebugProperties.readInDebugProperties();
    }

    @Test
    public void testConnection(){

    }
}
