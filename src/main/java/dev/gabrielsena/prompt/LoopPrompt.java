package dev.gabrielsena.prompt;

import java.util.Scanner;

public abstract class LoopPrompt implements LoopPromptStructure {

    private final Scanner scanner;

    public LoopPrompt(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean shouldCancel(String input) {
        return input.equalsIgnoreCase("C");
    }

    public Object start() {
        Object data = null;
        printInfos();
        boolean started = false;
        while (data == null) {
            if (started) {
                this.printInfos();
            }
            started = true;
            String line = scanner.nextLine();
            if (this.shouldCancel(line)) {
                return null;
            }
            data = execute(line);
        }
        return data;
    }
}
