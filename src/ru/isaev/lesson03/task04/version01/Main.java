package ru.isaev.lesson03.task04.version01;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //region Инициализация данных
        final byte maxValue = 100;                  // Максимально загаданное число
        final byte randomNumber;                    // Загаданное программой число, которое необходимо отгадать
        boolean gameOver = false;                   // Переменная контроля окончания игры
        boolean inGame = false;                     // Контроль что игрок вошел в игру
        byte memory = 0;                            // Последнее введеное число игроком
        Scanner input = new Scanner(System.in);     // Инициализация средства приема данных с консоли
        String inputLine;                           // Инициализация переменной входных значений с консоли
        int number;                                 // Инициализация переменной для проверки соотношения входных данных к числу
        //endregion

        {   // Генерация случайного значения от 0 до 100 в randomNumber
            Random rand = new Random();
            randomNumber = (byte) rand.nextInt(maxValue + 1);
        }   // Освобождение памяти от ненужного в дальнейшем объекта Random

        //region Приветствие игрока и правила игры
        System.out.println("Добро пожаловать в игру \"горячо\", \"холодно\".");
        System.out.println("Приложение загадало число от 0 до "+ maxValue +". Отгадайте какое число было загадано.");
        System.out.print("Чтобы выйти из игры введите \"exit\". Введите ваш ответ:");
        //endregion

        //region Логика игры
        while (!gameOver)
        {
            //Входные данные с консоли
            inputLine = input.next();

            //region Проверка введенных с консоли данных на наличие числовых значений
            try
            {
                number = Integer.parseInt(inputLine);
            }
            catch (NumberFormatException e)
            {
                number = -1;
                memory = 0;
            }
            //endregion

            //region Проверка условий игры
            if (inputLine.equals("exit") | inputLine.equals("Exit"))
            {
                System.out.println("Выход из игры");
                gameOver = true;
            }

            if (!gameOver)
            {
                if (memory == 0 & !inGame)
                {
                    memory = (byte) number;
                    inGame = true;
                }
                if (number > memory & number < randomNumber)
                {
                    System.out.println("Горячо");
                    gameOver = true;
                }
                else if (number <= memory & number < randomNumber)
                {
                    System.out.println("Холодно");
                    memory = (byte) number;
                }
                else if (number >= memory & number > randomNumber)
                {
                    System.out.println("Холодно");
                    memory = (byte) number;
                }
                else if (number < memory & number > randomNumber)
                {
                    System.out.println("Горячо");
                    gameOver = true;
                }
                else if (number == randomNumber)
                {
                    System.out.println("Горячо");
                    gameOver = true;
                }
            }
            //endregion
        }
        System.out.print("Благодарим за игру");
        //endregion
    }
}
