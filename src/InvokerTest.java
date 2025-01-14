
import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;



public class InvokerTest {
    private CommandInterface command;
    private ProcessingCentre processingCentre;
    private Advert advert;
    private SendAdvertCommand sendCommand;
    private Invoker invoker;


    @Before
    public void setUp(){
        processingCentre = new ProcessingCentre(8);
        advert = new Advert(8, LocalDate.now(), 8);
        sendCommand = new SendAdvertCommand(processingCentre, advert);
        invoker = new Invoker(); 
    }

    //Testing setCommand
    @Test
    public void testSetCommand(){
        invoker.setCommand(sendCommand);
        assertEquals(sendCommand, invoker.getCommand());
    }

    //Testing if command is processed when not null
    @Test
    public void testProcessCommand(){
        assertEquals(null, invoker.getCommand());//no command is assigned/command
        
        assertEquals(false, invoker.processCommand(command)); //command is null

        invoker.setCommand(sendCommand);
        assertEquals(sendCommand, invoker.getCommand());

        assertEquals(true, invoker.processCommand(sendCommand));


    }
}
