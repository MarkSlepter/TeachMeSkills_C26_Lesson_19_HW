package assignment1;

import assignment1.config.ThreadConfig;
import assignment1.task.MorningTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {

    public static void main(String[] args) {

        ThreadConfig[] threadConfigs = loadThreadConfigs("config.txt");

        for (ThreadConfig config : threadConfigs) {
            Thread thread = new Thread(new MorningTask(config.name), config.name);
            thread.setPriority(config.priority);
            thread.start();
        }

    }

    private static ThreadConfig[] loadThreadConfigs(String configFile) {
        ThreadConfig[] threadConfigs = new ThreadConfig[3];

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            for (int i = 0; i < 3; i++) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                String name = parts[0].trim();
                int priority = Integer.parseInt(parts[1].trim());

                threadConfigs[i] = new ThreadConfig(name, priority);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return threadConfigs;
    }

}
