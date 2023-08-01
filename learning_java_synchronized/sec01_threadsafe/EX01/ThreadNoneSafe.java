package learning_java_synchronized.sec01_threadsafe.EX01;

public class ThreadNoneSafe {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.setName("thread1");
        thread2.setName("thread2");

        thread1.start();
        thread2.start();
    }
}

class Account {
    int balance = 1000;

    /**
     * 출금: 전달된 돈이 balance 이하이면 전달된 돈만큼 balance에서 차감
     * 
     * @param money
     */
    public void withDraw(int money) {
        if (balance >= money) {
            try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " 출금 금액 ->> " + money);
                Thread.sleep(1000);
                balance -= money;
                System.out.println(thread.getName() + " balance:" + balance);
                System.out.println("========================================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        while (acc.balance > 0) {
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withDraw(money);
        }
    }
}