package entities;

import com.example.as_1.R;

public class Day {
    Meal breakfast;
    Meal launch;
    Meal dinner;
    Meal snack;
    User user;
    int takenCarbs;
    int takenProtein;
    int takenFat;
    int remainingCalories;

    public Day(User user) {
        this.user = user;
        mealsInitialize();
    }
    public void mealsInitialize(){
        breakfast=new Meal("Breakfast", R.drawable.breakfast,(int) (0.3*user.caloriesIntake));
        launch=new Meal("Lunch",R.drawable.lunch,(int) (0.4*user.caloriesIntake));
        dinner=new Meal("Dinner",R.drawable.dinner,(int) (0.25* user.caloriesIntake));
        snack=new Meal("Snack",R.drawable.snack,(int) (0.05*user.caloriesIntake));

    }
    public void calculateNutrition(){
        takenCarbs= (int) (breakfast.getTakenCarbs()+dinner.getTakenCarbs()+launch.getTakenCarbs()+snack.getTakenCarbs());
        takenProtein= (int) (breakfast.getTakenProtein()+launch.getTakenProtein()+dinner.getTakenProtein()+snack.getTakenProtein());
        takenFat= (int) (breakfast.getTakenfat()+launch.getTakenfat()+dinner.getTakenfat()+snack.getTakenfat());
        remainingCalories= user.caloriesIntake-(breakfast.getTakenCalories()+launch.getTakenCalories()+dinner.getTakenCalories()+snack.getTakenCalories());
    }
    public Meal getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(Meal breakfast) {
        this.breakfast = breakfast;
    }
    public Meal getLaunch() {
        return launch;
    }
    public void setLaunch(Meal launch) {
        this.launch = launch;
    }
    public Meal getDinner() {
        return dinner;
    }
    public void setDinner(Meal dinner) {
        this.dinner = dinner;
    }
    public Meal getSnack() {
        return snack;
    }
    public void setSnack(Meal snack) {
        this.snack = snack;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getTakenCarbs() {
        return takenCarbs;
    }
    public void setTakenCarbs(int takenCarbs) {
        this.takenCarbs = takenCarbs;
    }
    public int getTakenProtein() {
        return takenProtein;
    }
    public void setTakenProtein(int takenProtein) {
        this.takenProtein = takenProtein;
    }
    public int getTakenFat() {
        return takenFat;
    }
    public void setTakenFat(int takenFat) {
        this.takenFat = takenFat;
    }
    public int getRemainingCalories() {
        return remainingCalories;
    }
    public void setRemainingCalories(int remainingCalories) {
        this.remainingCalories = remainingCalories;
    }
}
