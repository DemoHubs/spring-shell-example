package com.upsoft;

import org.springframework.shell.Bootstrap;

import java.io.IOException;

/**
 * Command-line launcher for the shell.
 */
class Main {
    public static void main ( String[] args ) {
        try {
            Bootstrap.main( args );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}