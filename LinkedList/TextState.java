class TextState {
    String content;
    TextState next, prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState current;
    private int historyLimit = 10;
    private int historyCount = 0;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        historyCount++;
        maintainHistoryLimit();
    }

    private void maintainHistoryLimit() {
        while (historyCount > historyLimit) {
            TextState temp = current;
            while (temp.prev != null) {
                temp = temp.prev;
            }
            if (temp.next != null) {
                temp.next.prev = null;
            }
            historyCount--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! This is a text editor.");
        
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}

