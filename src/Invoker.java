/*
Student: Angela Pellillo
Stundent ID: 21499500
Module ID: CP6CS19E
Module Name: Applied Software Engineering */

public class Invoker {
    private CommandInterface command;

    public void setCommand(CommandInterface command) {
        this.command = command;
    }

    public CommandInterface getCommand(){
        return command;
    }

    // Checking if command is not null, then the method execute() is called
    public boolean processCommand(CommandInterface command) {
        if (command != null) {
            command.execute();
            return true;
        }
        return false;
    }
}
