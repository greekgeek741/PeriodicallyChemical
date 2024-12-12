package net.c4fey.perichem.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.init.PC_Blocks;
import net.c4fey.perichem.init.PC_Recipes;
import net.c4fey.perichem.recipe.LabRecipe;
import net.minecraft.util.Identifier;

public class PC_EmiPlugin implements EmiPlugin {

    public static final Identifier SPRITE_SHEET =
            Identifier.of(PeriodicallyChemical.MOD_ID, "textures/item/jug.png");
    public static final Identifier LAB_WIDGET =
            Identifier.of(PeriodicallyChemical.MOD_ID, "textures/gui/emi/lab_recipe_widget.png");
    public static final EmiStack LAB_TABLE = EmiStack.of(PC_Blocks.LAB_TABLE);
    public static final EmiRecipeCategory LAB_RECIPE_CATEGORY =
            new EmiRecipeCategory(Identifier.of(PeriodicallyChemical.MOD_ID, "lab_table"),
                    LAB_TABLE, new EmiTexture(SPRITE_SHEET, 0, 0, 16, 16));

    @Override
    public void register(EmiRegistry emiRegistry) {
        emiRegistry.addCategory(LAB_RECIPE_CATEGORY);
        emiRegistry.addWorkstation(LAB_RECIPE_CATEGORY, LAB_TABLE);
        for (LabRecipe recipe : PC_Recipes.LAB_TABLE_RECIPES) {
            emiRegistry.addRecipe(new LabEmiRecipe(recipe));
        }
    }
}
