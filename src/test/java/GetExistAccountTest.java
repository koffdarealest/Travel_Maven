
import dal.DAO;
import model.account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class GetExistAccountTest {
    
    @Mock
    private DAO d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getExistAccount_AccountExistsByEmail() {

        when(d.getExistAccount("phuc@gmail.com", "admin")).thenReturn(new account(100001, "phuc@gmail.com", "phuc", "phuc123", "0123123123", 0));
        
        final account expected = new account(100001, "phuc@gmail.com", "phuc", "phuc123", "0123123123", 0);

        final account actual = d.getExistAccount("phuc@gmail.com", "admin");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void getExistAccount_AccountExistsByUsername() {

        when(d.getExistAccount("admin@gmail", "phuc")).thenReturn(new account(100001, "phuc@gmail.com", "phuc", "phuc123", "0123123123", 0));
        
        final account expected = new account(100001, "phuc@gmail.com", "phuc", "phuc123", "0123123123", 0);

        final account actual = d.getExistAccount("admin@gmail", "phuc");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void getExistAccount_AccountDoesNotExists() {

        when(d.getExistAccount("admin@gmail", "admin")).thenReturn(new account());
        
        final account expected = new account();

        final account actual = d.getExistAccount("admin@gmail", "admin");

        Assert.assertEquals(expected, actual);
    }
}
