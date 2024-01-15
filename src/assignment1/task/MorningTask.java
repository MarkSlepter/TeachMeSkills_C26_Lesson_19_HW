package assignment1.task;

public class MorningTask implements Runnable{

    private String name;

    public MorningTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " начинает свою задачу.");

        try {
            System.out.println(name + " читает новости.");
            Thread.sleep(1000);

            System.out.println(name + " готовит завтрак.");
            Thread.sleep(1000);

            System.out.println(name + " пьет кофе.");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " завершает свою задачу.");
    }
}


