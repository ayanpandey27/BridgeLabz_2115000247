import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    @Override
    public String toString() {
        return meal.getMealType();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        return new Meal<>(meal);
    }

    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();
        
        mealPlans.add(generateMealPlan(new VegetarianMeal()));
        mealPlans.add(generateMealPlan(new VeganMeal()));
        mealPlans.add(generateMealPlan(new KetoMeal()));
        mealPlans.add(generateMealPlan(new HighProteinMeal()));

        System.out.println("Generated Meal Plans:");
        for (Meal<? extends MealPlan> meal : mealPlans) {
            System.out.println(meal);
        }
    }
}

