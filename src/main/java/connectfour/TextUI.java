package connectfour;

import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private ConnectFour connectFour;
    private int userInputInteger;
    private char userInputCharacter;
    private String userFileNameInput;
    private final int character = 0;
    private final int integer = 1;
    private final int boardPosition = 2;
    private final int fileNameLoad = 3;
    private final int fileNameSave = 4;

    public TextUI() {
        scanner = new Scanner(System.in);
        setCharacterInput("\0");
        setFileNameInput("invalidName");
        setIntegerInput("-1");
    }

    public void getUserInput(String messageForTheUser, int typeToCheckFor) {
        do {
            printString(messageForTheUser);
            try {
                String userInputString = scanner.nextLine();

                handleExceptions(typeToCheckFor, userInputString);
                break;
            } catch (ThrowExceptionForInvalidInput incorrectInputEx) {
                printString(incorrectInputEx.getMessage() + "\n");
            } catch (ThrowExceptionWrongMoveOnBoard incorrectMoveEx) {
                printString(incorrectMoveEx.getMessage() + "\n");
            } catch (ThrowExceptionNoSuchFileExists incorrectFileName) {
                printString(incorrectFileName.getMessage() + "\n");
            }
        } while (true);
    }

    private void handleExceptions(int inputTypeToCheckFor, String inputString) 
                throws ThrowExceptionForInvalidInput, ThrowExceptionWrongMoveOnBoard, ThrowExceptionNoSuchFileExists {
        if (inputTypeToCheckFor == character) {
            connectFour.validateMove(inputTypeToCheckFor, inputString);
            setCharacterInput(inputString);
        } else if (inputTypeToCheckFor == integer) {
            connectFour.validateMove(inputTypeToCheckFor, inputString);
            setIntegerInput(inputString);
        } else if (inputTypeToCheckFor == boardPosition) {
            connectFour.validateMove(inputTypeToCheckFor, inputString);
            setIntegerInput(inputString);
        } else if (inputTypeToCheckFor == fileNameLoad) {
            connectFour.validateMove(inputTypeToCheckFor, inputString);
            setFileNameInput(inputString);
        } else if (inputTypeToCheckFor == fileNameSave) {
            connectFour.validateMove(inputTypeToCheckFor, inputString);
            setFileNameInput(inputString);
        } 
    }

    public void printString(String stringToPrint) {
        System.out.print(stringToPrint);
    }

    public void closeScanner() {
        scanner.close();
    }

    private void setIntegerInput(String userInput) {
        userInputInteger = Integer.parseInt(userInput.toString());
    }

    private void setCharacterInput(String userInput) {
        userInputCharacter = userInput.charAt(0);
    }

    public int getIntegerInput() {
        return userInputInteger;
    }

    public char getCharacterInput() {
        return userInputCharacter;
    }

    private void setFileNameInput(String userInput) {
        userFileNameInput = userInput;
    }

    public String getFileNameInput() {
        return userFileNameInput;
    }

    public void setGame(ConnectFour game) {
        connectFour = game;
    }
}