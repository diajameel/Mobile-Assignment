package entities;

import java.util.ArrayList;

public class Meal {
    ArrayList<MealFood> eatenFood;
    String name;
    int icon;
    int totalCalories;
    int takenCalories;
    float takenCarbs;
    float takenProtein;
    float takenfat;

    public Meal(String name,int icon,int totalCalories) {
        this.name=name;
        this.icon=icon;
        this.totalCalories = totalCalories;
        eatenFood=new ArrayList<>();
        takenfat=0;
        takenProtein=0;
        takenCarbs=0;
    }
    public void calculateNutrition(){
        takenCalories=0;
        takenfat=0;
        takenCarbs=0;
        takenProtein=0;
        for (int i=0;i<eatenFood.size();i++){
            takenCalories+=eatenFood.get(i).totalCalories;
            takenfat+=eatenFood.get(i).fat;
            takenProtein+=eatenFood.get(i).protein;
            takenCarbs+=eatenFood.get(i).carbs;
        }
    }
    public void addFood(MealFood food){
        eatenFood.add(food);
        calculateNutrition();
    }
    public void removeFood(int index){
        eatenFood.remove(index);
        calculateNutrition();
    }

    public ArrayList<MealFood> getEatenFood() {
        return eatenFood;
    }

    public void setEatenFood(ArrayList<MealFood> eatenFood) {
        this.eatenFood = eatenFood;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getTakenCalories() {
        return takenCalories;
    }

    public void setTakenCalories(int takenCalories) {
        this.takenCalories = takenCalories;
    }

    public float getTakenCarbs() {
        return takenCarbs;
    }

    public void setTakenCarbs(float takenCarbs) {
        this.takenCarbs = takenCarbs;
    }

    public float getTakenProtein() {
        return takenProtein;
    }

    public void setTakenProtein(float takenProtein) {
        this.takenProtein = takenProtein;
    }

    public float getTakenfat() {
        return takenfat;
    }

    public void setTakenfat(float takenfat) {
        this.takenfat = takenfat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
