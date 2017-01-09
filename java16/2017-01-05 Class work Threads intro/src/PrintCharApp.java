
public class PrintCharApp {
	// Дз игра таракань бега. Каждый сред бежит на одинаковую дистанцию 
	// Каждый сред печатает свое число и спит случайное время (мин и макс одинаковое для всех)
	// Входные данные игры - количество средов (минимальное и максимальное время спячки, количество шагов)
	// Задача определить, какой сред закончил первым
	// В конце гонке вывести победителя
	// Параметры забега задавать через консольную аппликацию
	// Все среды сделать статическими переменными (массив), чтобы не влияло на стартовые условия
	public static void main(String[] args) throws InterruptedException {
		CharPrinterThread cp1=new CharPrinterThread('*',100);
		CharPrinterThread cp2=new CharPrinterThread('0',100);
		Timer timer=new Timer();
		cp1.setPriority(Thread.MAX_PRIORITY);
		cp2.setPriority(Thread.MIN_PRIORITY);
		timer.setPriority(Thread.NORM_PRIORITY);
		timer.start();
		cp1.start();
		cp2.start();
		cp1.join();
		cp2.join();
		System.out.println("\nall printed");
		for (int i=0;i<2;i++){
			Thread.sleep(500);
			timer.interrupt();
		}
		Thread.currentThread().join(1000);
		System.out.println("the end");
	}

}
