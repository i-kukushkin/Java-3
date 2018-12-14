package java3;

import java3.lesson6.CopyToNewArrayAfterLast4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestForTask1 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{1, 1, 2, 3, 4, 5, 6, 7, 4, 4}},
                {new int[]{5, 3, 7, 9, 8}, new int[]{1, 1, 3, 4, 4, 5, 3, 7, 9, 8}},
                {new int[]{1, 4}, new int[]{1, 2, 2, 4, 4, 3, 6, 7, 4, 8}},
                {new int[]{8}, new int[]{1, 1, 2, 3, 4, 5, 6, 7, 4, 8}}
        });
    }

    private CopyToNewArrayAfterLast4 task;
    private int[] a;
    private int[] b;

    public TestForTask1(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        task = new CopyToNewArrayAfterLast4();
    }

    @Test
    public void testTask() {
        Assert.assertTrue("testMsg", Arrays.equals(a, task.CopyToNewArrayAfterLast4(b)));
    }
}
