package com.nutri.service;

import org.springframework.stereotype.Service;
import com.nutri.model.NutritionResult;
import com.nutri.model.User;
import com.nutri.repository.NutritionResultRepository;

@Service
public class NutritionService {

    private final NutritionResultRepository nutritionResultRepository;

    public NutritionService(NutritionResultRepository nutritionResultRepository) {
        this.nutritionResultRepository = nutritionResultRepository;
    }

    public NutritionResult calculateAndSave(User user) {

    // ✅ Get user input
    double weight = user.getWeight();
    double height = user.getHeight();
    int age = user.getAge();

    // ✅ BMR Calculation (Mifflin-St Jeor)
    double bmr = (10 * weight) + (6.25 * height) - (5 * age);

    // ✅ TDEE (assuming moderate activity)
    double calories = bmr * 1.55;

    // ✅ Macronutrients calculation
    double protein = weight * 1.2;              // grams
    double fats = (calories * 0.25) / 9;        // grams
    double carbs = (calories - (protein * 4 + fats * 9)) / 4; // grams

    // ✅ Save result
    NutritionResult result = new NutritionResult();
    result.setTotalCalories(calories);
    result.setProtein(protein);
    result.setCarbs(carbs);
    result.setFats(fats);
    result.setUser(user);

    return nutritionResultRepository.save(result);
}
}
