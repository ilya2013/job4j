package ru.job4j.io.chat;

import java.util.Scanner;

public class InputImpl implements Input {
        Scanner scanner = new Scanner(System.in);
@Override
public String listen() {
        return scanner.nextLine();
        }
        }
