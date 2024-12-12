package net.c4fey.perichem.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.c4fey.perichem.recipe.LabRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LabEmiRecipe implements EmiRecipe {
    private final Identifier id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;

    public LabEmiRecipe(LabRecipe recipe) {
        this.id = recipe.id();
        this.input = createInput(recipe.inputs());
        this.output = createOutput(recipe.outputs());
    }

    private List<EmiIngredient> createInput(ArrayList<Item> items) {
        ArrayList<EmiIngredient> inputs = new ArrayList<>();
        for (Item ingredient : items) {
            inputs.add(EmiIngredient.of(Ingredient.ofItems(ingredient)));
        }
        while (inputs.size() < 12) {
            inputs.add(EmiIngredient.of(Ingredient.EMPTY));
        }
        return inputs;
    }

    private List<EmiStack> createOutput(ArrayList<ItemStack> items) {
        ArrayList<EmiStack> outputs = new ArrayList<>();
        for (ItemStack result : items) {
            outputs.add(EmiStack.of(result));
        }
        while (outputs.size() < 12) {
            outputs.add(EmiStack.EMPTY);
        }
        return outputs;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return PC_EmiPlugin.LAB_RECIPE_CATEGORY;
    }

    @Override
    public @Nullable Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 167;
    }

    @Override
    public int getDisplayHeight() {
        return 59;
    }

    @Override
    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addTexture(PC_EmiPlugin.LAB_WIDGET, 0, 0, 167, 59,
                0, 0, 167, 59, 256, 256);

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                widgetHolder.addSlot(input.get(y * 4 + x),
                        x * 18 + 3, y * 18 + 3);
            }
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                widgetHolder.addSlot(output.get(y * 4 + x),
                        x * 18 + 93, y * 18 + 3).recipeContext(this);
            }
        }
    }
}
