package com.bios21.zozmod.renderer;

import com.bios21.zozmod.model.BaseModelZoz;
import com.bios21.zozmod.model.ModelLightningRodGlobe;
import com.bios21.zozmod.model.ModelLightningRodMovingCoil;
import com.bios21.zozmod.tileentity.TileLightningRod;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Asus on 23/06/2015.
 */
public class TileEntityLightningRodRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation lightningRodTexture = new ResourceLocation("zozmod:textures/model/lightning_rod.png");
    public static BaseModelZoz modelLightningRodMovingCoil;
    public static BaseModelZoz modelLightningRodGlobe;

    public TileEntityLightningRodRenderer() {
        this.modelLightningRodGlobe = new ModelLightningRodGlobe();
        this.modelLightningRodMovingCoil = new ModelLightningRodMovingCoil();
    }

    @Override
    public void renderTileEntityAt(final TileEntity tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress) {
        if (!(tileEntity instanceof TileLightningRod)) return;

        final TileLightningRod tileLightningRod = (TileLightningRod)tileEntity;
        ((ModelLightningRodMovingCoil)this.modelLightningRodMovingCoil).setTileEntity(tileLightningRod);
        tileLightningRod.getAnimationHandler().animationsUpdate();

        try {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_CULL_FACE);
//            GL11.glTranslatef((float)relativeX, (float)relativeY, (float)relativeZ);
            GL11.glTranslatef((float)relativeX + 0.5f, (float)relativeY + 1.4F, (float)relativeZ + 6.0f / 16);
            this.bindTexture(lightningRodTexture);
            this.modelLightningRodMovingCoil.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glEnable(GL11.GL_CULL_FACE);
        } finally {
            GL11.glPopMatrix();
        }
    }
}