package Tung;


import dal.DAO;
import model.book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetLastBookTest {
    @Mock
    private DAO dao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLastBook_Success() {
        when(dao.getLastBook()).thenReturn(new book(10001, "The Alchemist", "PauloCoelho@gmail.com", "099299192", "2024/02/02", "T000002"));
        final book expected = new book(10001, "The Alchemist", "PauloCoelho@gmail.com", "099299192", "2024/02/02", "T000002");
        final book actual = dao.getLastBook();
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastBook_NoBook() {
        when(dao.getLastBook()).thenReturn(new book());
        final book expected = new book();
        final book actual = dao.getLastBook();
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastBook_InvalidBook() {
        when(dao.getLastBook()).thenReturn(null);
        final book expected = null;
        final book actual = dao.getLastBook();
        org.junit.Assert.assertEquals(expected, actual);
    }
}
