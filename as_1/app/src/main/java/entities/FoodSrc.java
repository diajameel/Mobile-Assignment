package entities;

import java.util.ArrayList;

public class FoodSrc {
    String name;
    float carbsPer100;
    float fatPer100;
    float proteinPer100;
    int calloriesPer100;;
    public static final FoodSrc []foodlist={
            new FoodSrc("protein bar",170,10,10,20),
            new FoodSrc("protein bar1",250,20,20,10),
            new FoodSrc("protein bar2",330,30,30,10),
            new FoodSrc("protein bar3",410,40,40,10)
    };

    public FoodSrc(String name ,int calloriesPer100, float carbsPer100, float proteinPer100, float fatPer100 ) {
        this.name=name;
        this.carbsPer100 = carbsPer100;
        this.fatPer100 = fatPer100;
        this.proteinPer100 = proteinPer100;
        this.calloriesPer100 = calloriesPer100;
    }


}
