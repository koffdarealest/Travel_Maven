package Tung;


import dal.DAO;
import model.tour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetTourByDestTest {
    @Mock
    private DAO dao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTourByDest_Success() {
        when(dao.getTourByDes("Vietnam")).thenReturn(List.of(new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg")));
        final List<tour> expected = List.of(new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg"));
        final List<tour> actual = dao.getTourByDes("Vietnam");
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTourByDest_NoTour() {
        when(dao.getTourByDes("Vietnam")).thenReturn(List.of());
        final List<tour> expected = List.of();
        final List<tour> actual = dao.getTourByDes("Vietnam");
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTourByDest_InvalidTour() {
        when(dao.getTourByDes("Vietnam")).thenReturn(null);
        final List<tour> expected = null;
        final List<tour> actual = dao.getTourByDes("Vietnam");
        org.junit.Assert.assertEquals(expected, actual);
    }
}
