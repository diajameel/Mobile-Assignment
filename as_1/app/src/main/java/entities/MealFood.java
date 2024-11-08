package entities;

public class MealFood {
    FoodSrc type;
    int totalCalories;
    float fat;
    float carbs;
    float protein;
    float weight;

    public MealFood(FoodSrc type, float weight) {
        this.type = type;
        this.weight = weight;
        float percent=this.weight/100;
        this.carbs= type.carbsPer100*percent;
        this.protein=type.proteinPer100*percent;
        this.fat=type.fatPer100*percent;
        this.totalCalories= (int) (type.calloriesPer100*percent);
    }

    @Override
    public String toString() {
        return type.name+"\n"+weight+"g\n"+totalCalories+" kcal, carbs:"+Math.round(carbs*10.0)/10.0+"g," +
                " protein:"+Math.round(protein*10.0)/10.0+"g, fat:"+Math.round(fat*10.0)/10.0+"g";
    }
}
