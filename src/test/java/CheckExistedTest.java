
import dal.DAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class CheckExistedTest {

    @Mock
    private DAO d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkExisted_AccountExistsByEmail() {

        when(d.checkExisted("phuc@gmail.com", "admin")).thenReturn(true);

        final boolean expected = true;

        final boolean actual = d.checkExisted("phuc@gmail.com", "admin");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkExisted_AccountExistsByUsername() {

        when(d.checkExisted("admin@gmail", "phuc")).thenReturn(true);

        final boolean expected = true;

        final boolean actual = d.checkExisted("admin@gmail", "phuc");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkExisted_AccountDoesNotExists() {

        when(d.checkExisted("admin@gmail", "admin")).thenReturn(false);

        final boolean expected = false;

        final boolean actual = d.checkExisted("admin@gmail", "admin");

        Assert.assertEquals(expected, actual);
    }
}
