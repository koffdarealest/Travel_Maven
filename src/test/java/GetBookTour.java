package Tung;

import dal.DAO;
import model.tour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetBookTour {
    @Mock
    private DAO dao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBookTour_Success() {
        when(dao.getBookTour("T100001")).thenReturn(new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg"));
        final tour expected = new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg");
        final tour actual = dao.getBookTour("T100001");
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBookTour_NoTour() {
        when(dao.getBookTour("T100001")).thenReturn(new tour());
        final tour expected = new tour();
        final tour actual = dao.getBookTour("T100001");
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBookTour_InvalidTour() {
        when(dao.getBookTour("T100001")).thenReturn(null);
        final tour expected = null;
        final tour actual = dao.getBookTour("T100001");
        org.junit.Assert.assertEquals(expected, actual);
    }
}
