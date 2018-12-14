package java3;

import java3.lesson6.CheckForOneOrFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestForTask2 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 2, 3, 4, 5, 6}},
                {false, new int[]{2, 2, 3, 5, 5, 6}},
                {true, new int[]{2, 2, 3, 4, 5, 6}},
        });
    }

    private CheckForOneOrFour task;
    private boolean a;
    private int[] b;

    public TestForTask2(boolean a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        task = new CheckForOneOrFour();
    }

    @Test
    public void testTask() {
        Assert.assertTrue(a == task.checkForOneOrFour(b));
    }
}