package entities;

public class User {
    String name;
    float weight;
    float length;
    int age;
    String goal;
    String nutrition;
    String sex;
    int basalMetabolism;
    String activityLevel;
    int TDDE;
    int caloriesIntake;
    int carbsIntake;
    int proteinIntake;
    int fatIntake;

    public User(String name, float weight, float length, int age, String goal, String sex, String nutrition,String activityLevel) {
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.age = age;
        this.goal = goal;
        this.sex = sex;
        this.nutrition = nutrition;
        this.activityLevel=activityLevel;
        basalMetabolismCalculate();
        TDDECalculate();
        calorieIntakeCalculate();
        macronutrientCalculate();
    }
    public void basalMetabolismCalculate(){
        if(this.sex.equals("male")){
            this.basalMetabolism= (int) ((13.397*weight)+(4.799*length)-(5.677*age)+88.362);
        }else{
            this.basalMetabolism=(int)((9.247*weight)+(3.098*length)-(4.330*age)+447.593);
        }
    }
    public void TDDECalculate(){
        if(this.activityLevel.equals("Little or no exercise")){
            TDDE= (int) (1.2*basalMetabolism);
        } else if (this.activityLevel.equals("Light exercise")) {
            TDDE= (int) (1.375*basalMetabolism);
        } else if (this.activityLevel.equals("Moderate exercise")) {
            TDDE= (int) (1.55*basalMetabolism);
        }else if(this.activityLevel.equals("Heavy exercise")){
            TDDE= (int) (1.725*basalMetabolism);
        }else{
            TDDE= (int) (1.9*basalMetabolism);
        }
    }
    public void calorieIntakeCalculate(){
        if(this.goal.equals("Build muscles")){
            caloriesIntake= (int) (1.15*TDDE);
        }else if(this.goal.equals("Lose weight")){
            caloriesIntake=TDDE-1000;
        }else{
            caloriesIntake=TDDE;
        }
    }
    public void macronutrientCalculate(){
        if(this.nutrition.equals("Low fat")){
            fatIntake= (int) ((0.20*caloriesIntake)/9);
            proteinIntake= (int) ((0.35*caloriesIntake)/4);
            carbsIntake= (int) ((0.45*caloriesIntake)/4);
        } else if (this.nutrition.equals("Low carbs")) {
            fatIntake= (int) ((0.35*caloriesIntake)/9);
            proteinIntake= (int) ((0.45*caloriesIntake)/4);
            carbsIntake= (int) ((0.20*caloriesIntake)/4);
        }else {
            fatIntake= (int) ((0.30*caloriesIntake)/9);
            proteinIntake= (int) ((0.35*caloriesIntake)/4);
            carbsIntake= (int) ((0.35*caloriesIntake)/4);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(int basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getTDDE() {
        return TDDE;
    }

    public void setTDDE(int TDDE) {
        this.TDDE = TDDE;
    }

    public int getCaloriesIntake() {
        return caloriesIntake;
    }

    public void setCaloriesIntake(int caloriesIntake) {
        this.caloriesIntake = caloriesIntake;
    }

    public int getCarbsIntake() {
        return carbsIntake;
    }

    public void setCarbsIntake(int carbsIntake) {
        this.carbsIntake = carbsIntake;
    }

    public int getProteinIntake() {
        return proteinIntake;
    }

    public void setProteinIntake(int proteinIntake) {
        this.proteinIntake = proteinIntake;
    }

    public int getFatIntake() {
        return fatIntake;
    }

    public void setFatIntake(int fatIntake) {
        this.fatIntake = fatIntake;
    }
}
