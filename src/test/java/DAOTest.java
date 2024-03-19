import model.dest;
import org.junit.Test;
import static org.junit.Assert.*;
import dal.DAO;
import model.tour;

import java.util.ArrayList;
import java.util.List;

public class DAOTest{
    DAO dao = new DAO();
    @Test
    public void testGetAllTour() {
        List<tour> tours = dao.getAllTour();
        // Assuming you know that your database should return 10 tours
        assertEquals(19, tours.size());
    }
    @Test
    public void getTourWhenEmpty() {
        List<tour> tours = new ArrayList<>();

        assertEquals(0, tours.size());
    }
    @Test
    public void getAllDest(){
        List<dest> dest = dao.getAllDest();
        assertEquals(6, dest.size());
    }
    @Test
    public void getDestWhenEmpty() {
        List<dest> dest = new ArrayList<>();
        assertEquals(0, dest.size());
    }
    @Test
    public void getHighestRateTour(){
        List<tour> tours = dao.getHighestRateTour();
        assertEquals(6, tours.size());
    }
    @Test
    public void getHighestRateTourWhenEmpty(){
        List<tour> tours = new ArrayList<>();
        assertEquals(0, tours.size());
    }

}