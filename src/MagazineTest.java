
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class MagazineTest {
    private Magazine magazine;
    private MagazineIssue magazineIssue;

    @Before
    public void setUp() {
        magazine = new Magazine("HHHHH", 88);
        magazineIssue = new MagazineIssue("iiiii", LocalDate.now(), 99);
    }

    // Testing setter and getter for name
    @Test
    public void testSetAndGetName() {
        assertEquals("HHHHH", magazine.getName());
        magazine.setName("Ciao Ciao");
        assertEquals("Ciao Ciao", magazine.getName());
    }

    // Testing set and get Id
    @Test
    public void testSetAndGetId() {
        assertEquals(88, magazine.getId());
        magazine.setId(7);
        assertEquals(7, magazine.getId());
    }

    //Testign add and get list of issues
    @Test
    public void testAddAndGetIssues(){
        assertEquals(0, magazine.getIssues().size());
        magazine.addIssue(magazineIssue);
        assertEquals(1, magazine.getIssues().size());
        assertEquals(magazineIssue, magazine.getIssues().get(0));
    }

}
