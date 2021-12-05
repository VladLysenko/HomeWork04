package HW4;

//•	Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок должен быть именно
// ABСABСABС. Используйте wait/notify/notifyAll.
public class Threads {
    static volatile char c = 'A';
    static Object Threads = new Object();

    static class WaitNotifyClass implements Runnable {
        private char currentLetter;
        private char nextLetter;

        public WaitNotifyClass(char currentLetter, char nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (Threads) {
                    try {
                        while (c != currentLetter)
                            Threads.wait();
                        System.out.print(currentLetter);
                        c = nextLetter;
                        Threads.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Поток");
        new Thread(new WaitNotifyClass('A', 'B')).start();
        new Thread(new WaitNotifyClass('B', 'C')).start();
        new Thread(new WaitNotifyClass('C', 'A')).start();
    }
}