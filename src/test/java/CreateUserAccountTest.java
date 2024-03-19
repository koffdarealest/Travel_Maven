
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
public class CreateUserAccountTest {
    
    @Mock
    private DAO d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUserAccount_Success() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "0123456789")).thenReturn(true);
        
        final boolean expected = true;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_UsernameExisted() {

        when(d.createUserAccount("phuc123@gmail.com", "phuc", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "phuc", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_EmailExisted() {

        when(d.createUserAccount("phuc@gmail.com", "admin1", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc@gmail.com", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_EmailMissLocalPart() {

        when(d.createUserAccount("@gmail.com", "admin1", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("@gmail.com", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_EmailMissDomain() {

        when(d.createUserAccount("phuc@", "admin1", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc@", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_EmailMissAnotation() {

        when(d.createUserAccount("phucgmail.com", "admin1", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phucgmail.com", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_UsernameLessThan2Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "a", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "a", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_BoundaryUnder() {

        when(d.createUserAccount("phuc123@gmail.com", "ad", "Phuc1@", "0123456789")).thenReturn(true);
        
        final boolean expected = true;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "ad", "Phuc1@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_BoundaryUpper() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "0123456789")).thenReturn(true);
        
        final boolean expected = true;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_UsernameMoreThan12Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "phuclaadminso001", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "phuclaadminso001", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_UsernameHaveFirstCharIsNumber() {

        when(d.createUserAccount("phuc123@gmail.com", "001admin", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "001admin", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_UsernameContainSpecailChar() {

        when(d.createUserAccount("phuc123@gmail.com", "admin@@", "Phucadmin@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin@@", "Phucadmin@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PasswordLessThan6Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Ph1@", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Ph1@", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PasswordMoreThan12Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phuc@admin001", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phuc@admin001", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PasswordMissSpecialChar() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin1", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin1", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PasswordMissUpCaseChar() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "phuc@admin1", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "phuc@admin1", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PasswordMissNumberChar() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phuc@admin", "0123456789")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phuc@admin", "0123456789");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PhoneNumberLessThan10Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "012345678")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "012345678");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PhoneNumberMoreThan10Chars() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "01234567899")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "01234567899");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PhoneNumberHaveFirstCharIsNotZero() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "1234567890")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "1234567890");

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void createUserAccount_PhoneNumberNotANumberType() {

        when(d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "phuc1234")).thenReturn(false);
        
        final boolean expected = false;

        final boolean actual = d.createUserAccount("phuc123@gmail.com", "admin1", "Phucadmin@", "phuc1234");

        Assert.assertEquals(expected, actual);
    }
}
