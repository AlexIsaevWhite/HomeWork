package ru.isaev.lesson03.task04.version02;

import com.sun.source.tree.TypeParameterTree;

import javax.lang.model.element.TypeElement;
import java.lang.reflect.Type;
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
        //endregion

        {   // Генерация случайного значения от 0 до maxValue в randomNumber
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

            //region Проверка условий игры
            for (byte i = 0; i <= maxValue; i++)
            {
                if (inputLine.equals(String.valueOf(i)))
                {
                    if (memory == 0 & !inGame)
                    {
                        memory = i;
                        inGame = true;
                    }
                    if (i > memory & i < randomNumber)
                    {
                        System.out.println("Горячо");
                        gameOver = true;
                    }
                    else if (i <= memory & i < randomNumber)
                    {
                        System.out.println("Холодно");
                        memory = i;
                    }
                    else if (i >= memory & i > randomNumber)
                    {
                        System.out.println("Холодно");
                        memory = i;
                    }
                    else if (i < memory & i > randomNumber)
                    {
                        System.out.println("Горячо");
                        gameOver = true;
                    }
                    else if (i == randomNumber)
                    {
                        System.out.println("Горячо");
                        gameOver = true;
                    }
                }
                else if (inputLine.equals("exit") | inputLine.equals("Exit"))
                {
                    System.out.println("Выход из игры");
                    gameOver = true;
                    break;
                }
            }
            //endregion
        }
        System.out.println("Благодарим за игру");
        //endregion
    }
}
