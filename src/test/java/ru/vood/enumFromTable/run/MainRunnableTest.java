package ru.vood.enumFromTable.run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vood.enumFromTable.MainConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainConfiguration.class)
@ActiveProfiles("application.yml")
public class MainRunnableTest {

    @Autowired
    MainRunnable mainRunnable;

    @Test
    public void run() {
        mainRunnable.run("V_BD_T");
    }
}