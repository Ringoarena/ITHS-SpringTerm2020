package view;

public class UIMock implements UI {
    private int addStringCallCount;     // Should equal 5 for each game.
    private int getIntCallCount;        // Should equal 1 for each game.
    private int getStringCallCount;     // Should equal 1 for each game.
    private int exitCallCount;          // Should equal 0 for each game unless getString returns "no".
    private String string = "yes";

    public void setString(String string) {      // For mocking purposes only.
        this.string = string;
    }

    @Override
    public void addString(String s) {
        addStringCallCount++;
    }

    @Override
    public int getInt() {
        getIntCallCount++;
        return 0;
    }

    @Override
    public String getString() {
        getStringCallCount++;
        return string;
    }

    @Override
    public void exit() {
        exitCallCount++;
    }

    @Override
    public void clear() {

    }

    public int getAddStringCallCount() {
        return addStringCallCount;
    }

    public int getGetIntCallCount() {
        return getIntCallCount;
    }

    public int getGetStringCallCount() {
        return getStringCallCount;
    }

    public int getExitCallCount() {
        return exitCallCount;
    }
}
