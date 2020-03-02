package lessons1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> boxList;
    public Box() {  //конструктор пустой коробки
        boxList = new ArrayList<>();

    }

    public Box(T fruit, int quantity) { //конструктор коробки с заполнением фруктами
        boxList = new ArrayList<>();
        for (int i = 0; i < quantity ; i++) {
            boxList.add(fruit);
        }
    }

    public List<T> getBoxList() {
        return boxList;
    }



    public void loadingBox(T fruit, int quantity){ //метод загрузки коробки
        for (int i = 0; i <quantity ; i++) {
            this.getBoxList().add(fruit);
        }
    }

    public void moveFruitBox(Box<T> box){ //метод пересыпки из текущего в box
        for (int i = 0; i < this.getBoxList().size(); i++) {
            box.getBoxList().add(this.getBoxList().get(i));
        }
        this.getBoxList().clear();
    }

    public boolean compare(Box<?> box){
        return Math.abs(getWeight(this) - getWeight(box)) < 0.0001;
    }

    public static  float getWeight(Box<?> box){
        if(box.getBoxList().size() != 0) return box.getBoxList().size() * box.getBoxList().get(0).getWeght();
        return 0;
    }



}
