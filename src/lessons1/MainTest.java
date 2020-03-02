package lessons1;

import java.util.ArrayList;

import static lessons1.Box.getWeight;

public class MainTest {
    public static void main(String[] args) {
        //Задание 1 ---------------------------------------------------------------------
        System.out.println("Задание 1:");
        Integer[] arr1 = {1, 2, 3, 4, 5};
        printArr(arr1);
        moveIndexArray(arr1, 0, 4);
        printArr(arr1);

        String str1 = "Мне нравиться программировать на Java!";
        String[] str2 = str1.split(" ");
        moveIndexArray(str2, 1, 2);
        System.out.println(str1);
        printArr(str2);
        //------------------------------------------------------------------------------

        //Задание 2---------------------------------------------------------------------
        System.out.println("Задание 2:");
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        printArr(arr2);
        System.out.println(arrayToArrayList(arr2));
        System.out.println(arrayToArrayList(str2));

        //Задание 3-------------------------------------------------------------------------
        System.out.println("Задание 3:");
        //создаем коробки уже с фруктами---------
        Box<Apple> boxApple1 = new Box<>(new Apple(), 15);
        Box<Apple> boxApple2 = new Box<>(new Apple(), 20);
        Box<Orange> boxOrange1 = new Box<>(new Orange(), 10);

        //создаем пустые коробки-----------------
        Box<Apple> boxApple3 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        //Взвешивание коробок--------------------
        System.out.println("Вес коробки 1 c яблоками: " + getWeight(boxApple1));
        System.out.println("Вес коробки 2 c яблоками: " + getWeight(boxApple2));
        System.out.println("Вес коробки 1 c апельсинами: " + getWeight(boxApple2));
        System.out.println("Вес коробки 3 для яблок (пустой): " + getWeight(boxApple3));
        System.out.println("Вес коробки 2 для апельсинов (пустой): " + getWeight(boxOrange2));

        //наполнение пустых коробок--------------
        boxApple3.loadingBox(new Apple(), 8);
        boxOrange2.loadingBox(new Orange(), 5);

        //сравнивание веса коробок---------------
        System.out.println(boxApple1.compare(boxOrange1));
        System.out.println(boxOrange2.compare(boxApple3));

        //пересыпание из одной коробки в другую---
        //boxApple1.moveFruitBox(boxOrange1); // ОШИБКА! так как коробки для разных фруктов
        boxApple1.moveFruitBox(boxApple2);
        System.out.println(getWeight(boxApple1));
        System.out.println(getWeight(boxApple2));

        //добавление фруктов в коробку------------
        boxApple2.loadingBox(new Apple(), 33);
        //boxApple2.loadingBox(new Orange(), 7); //ОШИБКА! Нельзя добавить апельсины к яблокам
        System.out.println(getWeight(boxApple2));

    }



    // метод который меняет два элемента массива местами (обобщенный метод)-------------
    public static <T> void moveIndexArray(T[] array, int a, int b){
        T IndexValue;
        IndexValue = array[a];
        array[a] = array[b];
        array[b] = IndexValue;
    }
    //метод вывода массива в консоль (обобщенный метод)---------------------------------
    public static <T> void printArr(T[] arr){
        for (T i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    //метод который преобразует массив в ArrayList (обобщенный метод)-------------------
    public static <T> ArrayList<T> arrayToArrayList(T[] arr){
        ArrayList<T> arrL = new ArrayList<>();
        for (T o: arr) {
            arrL.add(o);
        }
        return arrL;
    }





}
