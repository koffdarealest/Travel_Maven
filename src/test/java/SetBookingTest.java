package Tung;

import dal.DAO;
import model.book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SetBookingTest {

    @Mock
    private DAO dao;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Test case 1
    @Test
    public void setBooking_Success() throws SQLException {
        // Arrange
        String name = "John Doe";
        String email = "john@example.com";
        String phone = "123456789";
        String date = "2024-03-13";
        String selectedtour = "Tour XYZ";
        String username = "user123";

        // Mock dependencies
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        // Set up mock behavior
        when(conn.prepareStatement(any(String.class))).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);

        // Act
        dao.setBooking(name, email, phone, date, selectedtour, username);

        // Assert
        // Here you can add assertions based on your specific requirements
        // For example, you might want to verify that certain methods were called with specific arguments
        verify(conn).prepareStatement(any(String.class));
        verify(ps).setString(1, name);
        verify(ps).setString(2, email);
        verify(ps).setString(3, phone);
        verify(ps).setString(4, date);
        verify(ps).setString(5, selectedtour);
        verify(ps).setString(6, username);
        verify(ps).executeQuery();
    }

    @Test
    public void setBooking_InvalidDateFormat() throws SQLException {
        // Arrange
        String name = "John Doe";
        String email = "john@example.com";
        String phone = "123456789";
        String date = "13/03/2024"; // Invalid date format
        String selectedtour = "Tour XYZ";
        String username = "user123";

        // Mock dependencies
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        // Set up mock behavior
        when(conn.prepareStatement(any(String.class))).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);


        // Act & Assert
        // Expecting an IllegalArgumentException to be thrown due to invalid date format
    }

    @Test
    public void setBooking_EmptyInputValues() throws SQLException {
        // Arrange
        String name = "";
        String email = "";
        String phone = "";
        String date = "";
        String selectedtour = "";
        String username = "";

        // Mock dependencies
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        // Set up mock behavior
        when(conn.prepareStatement(any(String.class))).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);

        // Act
        dao.setBooking(name, email, phone, date, selectedtour, username);

        // Assert

    }


}
