package com.braziltest.utils;
import java.io.*;

public class ProcessBuilderRun {

    public static void processCommand(String Runner) throws IOException {
        try {
            Runner ="Run_863912611.avi";
            String[] command = {"cmd.exe", "/c", "start", "cmd.exe", "/k", " dir && ffmpeg.exe -i F:\\evidencias\\CentralEnvidence\\"+ Runner +" -y -c:v libvpx-vp9 -crf 30 -b:v 0 -b:a 128k -c:a libopus F:\\evidencias\\CentralEnvidence\\"+ Runner.replace(".avi",".webm")};
            ProcessBuilder probuilder = new ProcessBuilder(command);
            probuilder.directory(new File("c:\\ffmpeg\\bin"));
            Process process = probuilder.start();

        }catch(Exception e){
            System .out.println(e.toString());

        }
    }

    public static void processCommand4(String Command) throws IOException {
        //Runtime.getRuntime().exec("cmd.exe /C " + Command);

        //List<String> commandList = Arrays.asList("cmd.exe","dir");
        String[] commandList = {"cmd.exe /c start dir", "ffmpeg.exe -i F:\\evidencias\\CentralEnvidence\\Run_250801220.avi -c:v libvpx-vp9 -crf 30 -b:v 0 -b:a 128k -c:a libopus F:\\evidencias\\CentralEnvidence\\Run_250801220.webm"};
        //String[] commandList = {"cmd.exe", "/C /start", "start /b cmd /c convert.bat"};

        //String[] commandList = {"cmd.exe", "/C", "dir", "whoami"};
        //String[] commandList = new String[] {"cmd.exe", "/C", "dir"};
        ProcessBuilder processBuilder = new ProcessBuilder(commandList);
        //System.out.println(commandList[2]);
        Process process = processBuilder.start();
        //process.waitFor();
        BufferedReader iReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String tempStr= "";
        StringBuffer buffer = new StringBuffer();
        while((tempStr = iReader.readLine())!=null){
            buffer.append(tempStr+System.lineSeparator());
        }
        System.out.println(buffer.toString());
        process.destroy();
        int exitValue = process.exitValue();
        System.out.println(exitValue);

    }

    public static void processCommand6(String command)throws IOException {
        try {
            String ss = null;
            Process p = Runtime.getRuntime().exec("cmd.exe /c start ");
            BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            writeer.write("dir");
            writeer.flush();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            System.out.println("Here is the standard output of the command:\n");
            while ((ss = stdInput.readLine()) != null) {
                System.out.println(ss);
            }
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((ss = stdError.readLine()) != null) {
                System.out.println(ss);
            }

        } catch (IOException e) {
            System.out.println("FROM CATCH" + e.toString());
        }
    }


    public static void processCommand2(String Command) {

        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", Command);

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
