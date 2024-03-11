
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
public class IsUserTest {

    @Mock
    private DAO d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void isUser_IsAUser() {

        when(d.isUser("phuc", "phuc123")).thenReturn(true);

        final boolean expected = true;

        final boolean actual = d.isUser("phuc", "phuc123");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isUser_NotAUser() {

        when(d.isUser("admin1", "admin1")).thenReturn(false);

        final boolean expected = false;

        final boolean actual = d.isUser("admin1", "admin1");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isUser_AccountDoesNotExists() {

        when(d.isAdmin("ad", "password")).thenReturn(false);

        final boolean expected = false;

        final boolean actual = d.isAdmin("ad", "password");

        Assert.assertEquals(expected, actual);
    }
}
