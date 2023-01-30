import Task.Tasks;
import Task.TypeOfTask;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskHeading = scanner.next();

        System.out.print("Описание задачи: ");
        String taskDescription = scanner.next();

        System.out.print("Укажите тип задачи(личная - 1, рабочая - 2): ");
        TypeOfTask typeOfTask = null;

        int selectTypeOfTask = scanner.nextInt();
        if (selectTypeOfTask == 1) {
            typeOfTask = TypeOfTask.PERSONAL;
        } else if (selectTypeOfTask == 2) {
            typeOfTask = TypeOfTask.WORK;
        } else {
            System.out.println("Выберите тип задачи");
            scanner.nextInt();
        }

        System.out.println("Введите дату для задачи: ");

        LocalDate dateTask = scanner.;  // как через сканнер запросить ввод даты для задачи ?
        SimpleDateFormat a = new SimpleDateFormat("MMM dd, yyyy"); // искал готовые методы из библиотеки но никак не пойму как правильно
        LocalDateTime selectTimeTask = scanner.


    }


    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }


}



