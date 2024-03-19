import dal.DAO; // Assuming DAO class containing getfilterTour()
import model.tour;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GetFilteredTourTest {

    private final DAO dao = new DAO();

    @Test
    public void testGetfilterTour_EmptyParameters_ReturnsAllTours() throws SQLException {
        // Act
        List<tour> tours = dao.getfilterTour("", "", "", "");

        // Assert
        assertEquals(1, tours.size()); // true: 19
    }

    @Test
    public void testGetfilterTour_SingleFilter_ReturnsMatchingTours() throws SQLException {
        // Act
        List<tour> tours = dao.getfilterTour("Vietnam", "", "", "");

        // Assert
        assertEquals(1, tours.size()); // Adjust based on test data
    }

    @Test
    public void testGetfilterTour_MultipleFilters_ReturnsMatchingTours() throws SQLException {
        // Act
        List<tour> tours = dao.getfilterTour("Vietnam", "Hanoi", "2021-12-01", "2021-12-31");

        // Assert
        assertEquals(1, tours.size()); // Adjust based on test data
    }

    @Test(expected = SQLException.class) // Test expected exception
    public void testGetfilterTour_ThrowsExceptionOnDatabaseError() throws SQLException {
        // Act
        dao.getfilterTour("", "", "", ""); // This should throw an SQLException
    }
}
