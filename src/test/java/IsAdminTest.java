
import dal.DAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsAdminTest {

    @Mock
    private DAO d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isAdmin_IsAnAdmin() {

        when(d.isAdmin("admin1", "admin1")).thenReturn(true);

        final boolean expected = true;

        final boolean actual = d.isAdmin("admin1", "admin1");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAdmin_NotAnAdmin() {
        
        when(d.isAdmin("phuc", "phuc123")).thenReturn(false);

        final boolean expected = false;

        final boolean actual = d.isAdmin("phuc", "phuc123");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAdmin_AccountDoesNotExists() {
        
        when(d.isAdmin("ad", "password")).thenReturn(false);

        final boolean expected = false;

        final boolean actual = d.isAdmin("ad", "password");

        Assert.assertEquals(expected, actual);
    }
}
