import dal.DAO; // Lớp DAO chứa hàm `getHighestRateTour()`
import model.tour;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GetHighestRateTourTest {

    private final DAO dao = new DAO(); // Tạo instance DAO

    @Test
    public void testGetHighestRateTour_ReturnsNonEmptyList() throws SQLException {
        // Act
        List<tour> tours = dao.getHighestRateTour();

        // Assert
        assertNotNull(tours); // Đảm bảo danh sách không null
        assertFalse(tours.isEmpty()); // Đảm bảo danh sách không rỗng
    }

    @Test
    public void testGetHighestRateTour_ReturnsCorrectNumberOfTours() throws SQLException {
        int expectedNumberOfTours = 1; // true: 6

        // Act
        List<tour> tours = dao.getHighestRateTour();

        // Assert
        assertEquals(expectedNumberOfTours, tours.size());
    }

    @Test
    public void testGetHighestRateTour_ReturnsToursWithHighestRating() throws SQLException {
        // Lấy tour đầu tiên (giả sử là tour có xếp hạng cao nhất)
        tour tour = dao.getHighestRateTour().get(0);

        // Assert
        float highestRating = 5.0f; // Xác định xếp hạng cao nhất: 4.9
        assertEquals(highestRating, tour.getRating(), 0.0f);
    }

    @Test(expected = SQLException.class) // Test ngoại lệ dự kiến
    public void testGetHighestRateTour_ThrowsExceptionOnDatabaseError() throws SQLException {
        // Mô phỏng lỗi kết nối database
        // Act
        dao.getHighestRateTour(); // Gây ra `SQLException`
    }
}
