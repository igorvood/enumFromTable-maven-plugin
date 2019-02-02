package ru.vood.enumFromTable;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainConfiguration.class)
public class YourMojoTest extends AbstractPluginMojoTestCase {
    /**
     * @throws Exception
     */
    @Ignore
    public void testMojoGoal() throws Exception {
        //File testPom = new File(getBasedir(), "src/test/resources/test.xml");
        File testPom = new File(getBasedir(), "src/test/resources/pom.xml");
        //C:\_developer\java\EnumFromTablemavenplugin\src\test\resources\test.xml

        GenerateEnums mojo = (GenerateEnums) lookupMojo("yourGoal", testPom);

        assertNotNull(mojo);
    }

    @Ignore
    public void testMojoGoal1() throws Exception {
        System.out.println("+++++++++++++++++GenerateEnums++++++++++++++++++++++");
        //ctx = new AnnotationConfigApplicationContext("ru.vood.enumFromTable");
/*
        ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);

        MainRunnable mainRunnable = ctx.getBean("mainRunnable", MainRunnable.class);

        System.out.println("+++++++++++++++++MainRunnable++++++++++++++++++++++");
        System.out.println(mainRunnable);
        mainRunnable.run(prefTable);
*/


    }
}