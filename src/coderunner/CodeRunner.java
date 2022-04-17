/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coderunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Pedro
 */
public class CodeRunner {
    public void runCode(String... command) {
    ProcessBuilder processBuilder = new ProcessBuilder().command(command);
 
    try {
        Process process = processBuilder.start();
 
        //read the output
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String output = null;
        while ((output = bufferedReader.readLine()) != null) {
            System.out.println(output);
        }
 
        //wait for the process to complete
        process.waitFor();
 
        //close the resources
        bufferedReader.close();
        process.destroy();
 
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
}
