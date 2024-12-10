package net.c4fey.perichem.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.c4fey.perichem.PeriodicallyChemical;
import net.c4fey.perichem.network.LabButtonPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class LabScreen extends HandledScreen<LabScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(PeriodicallyChemical.MOD_ID,
            "textures/gui/lab_screen.png");

    public LabScreen(LabScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        this.addDrawableChild(new ButtonWidget.Builder(Text.of(">"),
                (button) -> ClientPlayNetworking.send(new LabButtonPayload(0)))
                .dimensions(x + 80, y + 25, 16, 16).build());
        this.addDrawableChild(new ButtonWidget.Builder(Text.of(">>"),
                (button) -> ClientPlayNetworking.send(new LabButtonPayload(1)))
                .dimensions(x + 80, y + 45, 16, 16).build());
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
