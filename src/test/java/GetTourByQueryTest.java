package Tung;

import dal.DAO;
import java.util.List;

import model.tour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetTourByQueryTest {

    @Mock
    private DAO dao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTourByQuery_Success() {
        when(dao.getTourByQuery("select * from tour where ID like 'T%' and (5 <= numOfPerson and numOfPerson <= 7)")).thenReturn(List.of(new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg")));
        final List<tour> listExpected = List.of(new tour("T100001","Ha Long Bay", "Vietnam", 7, 3, 2000, "Ha Long Trip", 4.3F, "img/HaLong.jpg"));
        final List<tour> listActual =  dao.getTourByQuery("select * from tour where ID like 'T%' and (5 <= numOfPerson and numOfPerson <= 7)");
        Assert.assertEquals(listExpected, listActual);
    }

    @Test
    public void getTourByQuery_NoTour() {
        when(dao.getTourByQuery("select * from tour where ID like 'T%' and (5 <= numOfPerson and numOfPerson <= 7)")).thenReturn(List.of());
        final List<tour> listExpected = List.of();
        final List<tour> listActual =  dao.getTourByQuery("select * from tour where ID like 'T%' and (5 <= numOfPerson and numOfPerson <= 7)");
        Assert.assertEquals(listExpected, listActual);
    }

    @Test
    public void getTourByQuery_InvalidQuery() {
        when(dao.getTourByQuery("select * from tour where ID like 'T' and (5 <= numOfPerson and numOfPerson <= 7)")).thenReturn(null);
        final List<tour> listExpected = null;
        final List<tour> listActual =  dao.getTourByQuery("select * from tour where ID like 'T' and (5 <= numOfPerson and numOfPerson <= 7)");
        Assert.assertEquals(listExpected, listActual);
    }

    @Test
    public void getTourByQuery_EmptyQuery() {
        when(dao.getTourByQuery("")).thenReturn(null);
        final List<tour> listExpected = null;
        final List<tour> listActual =  dao.getTourByQuery("");
        Assert.assertEquals(listExpected, listActual);
    }


}
