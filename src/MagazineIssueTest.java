import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class MagazineIssueTest {
    Magazine magazine;
    MagazineIssue magazineIssue;

    @Before
    public void setUp() {
        magazine = new Magazine("kkkk", 5);
        magazineIssue = new MagazineIssue("eee", LocalDate.now(), 88);

    }

    // Testing setters and getters for name
    @Test
    public void testSetAndGetName() {
        assertEquals("eee", magazineIssue.getName());
        magazineIssue.setName("ttt");
        assertEquals("ttt", magazineIssue.getName());
    }

    // Testing setters and getters for date
    @Test
    public void testSetAndGetDate() {
        assertEquals(LocalDate.now(), magazineIssue.getDateIssued());
        magazineIssue.setDateIssued(LocalDate.of(2024, 12, 22));
        assertEquals(LocalDate.of(2024, 12, 22), magazineIssue.getDateIssued());
    }

    // Testing set and get issue Number
    @Test
    public void testSetAndGetIssueNumber() {
        assertEquals(88, magazineIssue.getIssueNumber());
        magazineIssue.setIssueNumber(9);
        assertEquals(9, magazineIssue.getIssueNumber());
    }

    // Testing get and set magazine
    @Test
    public void testSetAndGetMagazine() {
        assertEquals(null, magazineIssue.getMagazine());
        magazineIssue.setMagazine(magazine);
        assertEquals(magazine, magazineIssue.getMagazine());
    }

}
