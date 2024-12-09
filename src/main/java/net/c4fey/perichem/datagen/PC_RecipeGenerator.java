package net.c4fey.perichem.datagen;

import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.init.PC_Items;
import net.c4fey.perichem.item.ElementItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PC_RecipeGenerator extends FabricRecipeProvider {
    public PC_RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        Item powder;
        for (ElementItem ingot : PC_Items.METAL_ELEMENT_INGOTS) {
            powder = Registries.ITEM.get(Identifier.of(PeriodicallyChemical.MOD_ID,
                    ingot.getElement().getSymbol().toLowerCase() + "_powder"));
            RecipeProvider.offerSmelting(recipeExporter, List.of(powder), RecipeCategory.MISC,
                    ingot, 1, 200, "powder_to_ingot");
            RecipeProvider.offerBlasting(recipeExporter, List.of(powder), RecipeCategory.MISC,
                    ingot, 1, 100, "powder_to_ingot");
        }
    }
}
