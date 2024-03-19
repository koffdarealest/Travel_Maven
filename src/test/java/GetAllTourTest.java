import dal.DAO;
import model.tour;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GetAllTourTest {

    private final DAO dao = new DAO(); // Assuming a DAO instance is created

    @Test
    public void testGetAllTour_ReturnsExpectedNumberOfTours() throws SQLException {
        // Act
        List<tour> tours = dao.getAllTour();

        // Assert
        assertEquals(19, tours.size()); // Replace 19 with the expected number of tours
    }

    @Test
    public void testGetAllTour_HandlesEmptyList() throws SQLException {
        // Act
        List<tour> tours = dao.getAllTour();

        // Assert
        assertTrue(String.valueOf(tours.stream().count()), tours.isEmpty()); // Assert that the list is empty
    }


    public void testGetAllTour_ChecksTourPosition(int index, String expectedName) throws SQLException {
        // Act
        List<tour> tours = dao.getAllTour();

        // Assert (assuming tours is not empty)
        if (!tours.isEmpty()) {
            tour tour = tours.get(index);
            assertEquals(expectedName, tour.getName());
        }
    }

    @Test(expected = SQLException.class) // Test expected exception
    public void testGetAllTour_ThrowsExceptionOnDatabaseError() throws SQLException {
        // Act
        dao.getAllTour(); // This should throw an SQLException
    }


}
